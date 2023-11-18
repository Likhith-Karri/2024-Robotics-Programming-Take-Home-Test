package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class RaiseElevatorCommand extends CommandBase {
    private final ElevatorSubsystem elevatorSubsystem;
    private final double targetHeight;

    public RaiseElevatorCommand(ElevatorSubsystem e, double t) {
      elevatorSubsystem = e;
      targetHeight = t;
      addRequirements(elevatorSubsystem);
    }

    @Override
    public void initialize() {
        elevatorSubsystem.setHeight(targetHeight); // Change the height as needed
    }

    @Override
    public boolean isFinished() {
        return Math.abs(elevatorSubsystem.getHeight() - targetHeight) <= ElevatorSubsystem.HEIGHT_TOLERANCE;
    }
}
