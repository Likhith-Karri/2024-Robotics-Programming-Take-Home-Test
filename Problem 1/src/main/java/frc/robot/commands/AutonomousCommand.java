package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

public class AutonomousCommand extends SequentialCommandGroup {
  public AutonomousCommand(DriveSubsystem drivetrain) {
    addRequirements(drivetrain);
    addCommands(
      new InstantCommand(() -> drivetrain.resetGyro()),
      new ArcadeDriveCommand(drivetrain, 0.5, 0.0).withTimeout(10.0),
      new ArcadeDriveCommand(drivetrain, 0.0, 0.5).until(() -> drivetrain.getHeading() > 90)
    );
  }
}

