package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDriveCommand extends CommandBase {

  private DriveSubsystem driveSubsystem;
  private double translateSupplier;
  private double rotationalSupplier;

  public ArcadeDriveCommand(DriveSubsystem d, double e, double f) {
    driveSubsystem = d;
    translateSupplier = e;
    rotationalSupplier = f;

    /* Using addRequirements To Delcare The Subsystem Dependencies 
      This Prevents From Another Command Running At The Same Time Of This Command */
    addRequirements(driveSubsystem);
  }


@Override
  public void initialize() {}

  @Override
  public void execute() {
    driveSubsystem.kDrive.arcadeDrive(translateSupplier, rotationalSupplier);
  }
}