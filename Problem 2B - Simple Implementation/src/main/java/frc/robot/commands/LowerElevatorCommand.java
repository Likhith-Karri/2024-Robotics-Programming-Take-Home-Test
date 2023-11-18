package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class LowerElevatorCommand extends CommandBase {
    private final ElevatorSubsystem elevatorSubsystem;

    public LowerElevatorCommand(ElevatorSubsystem e) {
        elevatorSubsystem = e;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void initialize() {}

  public void execute () {
    elevatorSubsystem.setMotor(-0.5);
  }

    @Override
    public boolean isFinished() {
        return false; 
    }
}
