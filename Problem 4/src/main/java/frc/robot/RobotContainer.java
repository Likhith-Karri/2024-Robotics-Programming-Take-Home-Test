// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.RaiseElevatorCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class RobotContainer {
  DriveSubsystem driveSubsystem = new DriveSubsystem();
  ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  GyroSubsystem gyroSubsystem = new GyroSubsystem();
  public Joystick joystick = new Joystick(0);

  public RobotContainer() {
    driveSubsystem.setDefaultCommand(new ArcadeDriveCommand(driveSubsystem, joystick.getY(), joystick.getX()));
    configureBindings();
  }
  // This Is Basically The Command That Keeps On Checking The Angle Of The Robot
  private void configureBindings() {
    new Trigger(() -> Math.abs(gyroSubsystem.getAngle() - 115.0) < 5)
      .whileTrue(new RaiseElevatorCommand(elevatorSubsystem, 20.0)); // Sample Height Of 20

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
