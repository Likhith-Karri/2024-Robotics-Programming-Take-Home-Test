// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.LowerElevatorCommand;
import frc.robot.commands.RaiseElevatorCommand;
import frc.robot.commands.StopElevatorCommand;
import frc.robot.subsystems.ElevatorSubsystem;

public class RobotContainer {
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  public Joystick controller = new Joystick(0);
  private final JoystickButton raiseButton = new JoystickButton(controller, XboxController.Button.kA.value);
  private final JoystickButton lowerButton = new JoystickButton(controller, XboxController.Button.kB.value);
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
  raiseButton.whileHeld(new RaiseElevatorCommand(elevatorSubsystem));

  lowerButton.whileHeld(new LowerElevatorCommand(elevatorSubsystem));
    
  elevatorSubsystem.setDefaultCommand(new StopElevatorCommand(elevatorSubsystem));
}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
