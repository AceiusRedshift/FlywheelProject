package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class SpinFlywheel extends Command {
    private final Shooter shooter;
    private final double speed;

    public SpinFlywheel(Shooter shooter, double speed) {
        this.shooter = shooter;
        this.speed = speed;

        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.setFlywheelSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
