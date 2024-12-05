package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Throngler
public class Shooter extends SubsystemBase {
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
        //
    }

    /**
     * Set the speed of the motor as a percent.
     * 
     * @param speed -1.0 to 1.0.
     */
    public void setFlywheelSpeed(double speed) {
        //
    }

    /**
     * Set the speed of the motor as a percent.
     * 
     * @param speed -1.0 to 1.0.
     */
    public void setGrabberSpeed(double speed) {
        //
    }

    /**
     * @return If there is a note in the intake.
     */
    public boolean hasNoteInIntake() {
        return false;
    }

    /**
     * Eject the contents of the shooter.
     */
    public void eject() {
        //
    }

    /**
     * IMMEDIATELY stop all motors.
     */
    public void stop() {
        //
    }
}
