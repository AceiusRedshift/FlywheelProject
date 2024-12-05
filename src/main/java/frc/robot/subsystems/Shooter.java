package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.playingwithfusion.TimeOfFlight;
import com.playingwithfusion.TimeOfFlight.RangingMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Throngler
public class Shooter extends SubsystemBase {
    private final WPI_VictorSPX flywheel1;
    private final WPI_VictorSPX flywheel2;
    private final TimeOfFlight lidar;
    private final CANSparkMax intake;

    private final MedianFilter sensorMedianFilter = new MedianFilter(5);

    /**
     * Make sure these IDs are correct - activating the wrong motor could cause harm
     * to life or property.
     * 
     * @param firstFlywheelId  The CAN ID of the 2nd flywheel motor. This motor is
     *                         a CTRE Victor SPX.
     * @param secondFlywheelId The CAN ID of the 1st flywheel motor. This motor is
     *                         a CTRE Victor SPX.
     * @param intakeId         The CAN ID of the intake motor - this motor powers
     *                         the intake wheels on the top AND bottom. This motor
     *                         is a Spark Max.
     * @param lidarId          The CAN ID of the lidar time-of-flight sensor.
     */
    public Shooter(int firstFlywheelId, int secondFlywheelId, int intakeId, int lidarId) {
        flywheel1 = new WPI_VictorSPX(firstFlywheelId);
        flywheel2 = new WPI_VictorSPX(secondFlywheelId);

        intake = new CANSparkMax(intakeId, MotorType.kBrushless);

        lidar = new TimeOfFlight(lidarId);
        lidar.setRangingMode(RangingMode.Short, 25);
    }

    /**
     * Set the speed of the motor as a percent.
     * 
     * @param speed -1.0 to 1.0.
     */
    public void setFlywheelSpeed(double speed) {
        // Why is speed negative?? motors on backward or smthing idk
        flywheel1.set(-speed);
        flywheel2.set(-speed);
    }

    /**
     * Set the speed of the motor as a percent.
     * 
     * @param speed -1.0 to 1.0.
     */
    public void setGrabberSpeed(double speed) {
        intake.set(speed);
    }

    /**
     * @return If there is a note in the intake.
     */
    public boolean hasNoteInIntake() {
        return getLidarDistance() < Units.inchesToMeters(3);
    }

    /**
     * Eject the contents of the shooter.
     */
    public void eject() {
        setGrabberSpeed(-1.0);
        setGrabberSpeed(-0.1);
    }

    /**
     * IMMEDIATELY stop all motors.
     */
    public void stop() {
        setFlywheelSpeed(0);
        setGrabberSpeed(0);

        // Brake motors
        flywheel1.stopMotor();
        flywheel2.stopMotor();
        intake.stopMotor();
    }

    private double getLidarDistance() {
        return sensorMedianFilter.calculate(lidar.getRange() / 1000);
    }
}
