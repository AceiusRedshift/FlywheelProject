package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class SpinIntake extends Command {
    public SpinIntake(Shooter shooter, double speed) {
        // Make sure to add requirements!
    }

    @Override
    public void initialize() {
        // This should be fairly obvious.
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
