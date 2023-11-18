
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;


public class RobotContainer {
  DriveSubsystem arcadeDrive = new DriveSubsystem();
  public Joystick joystick = new Joystick(0);

  public RobotContainer() {
    arcadeDrive.setDefaultCommand(new ArcadeDriveCommand(arcadeDrive, joystick.getY(), joystick.getX()));
  }
  
  private void configureButtonBindings(){

  }

  public Command getAutonomousCommand(){
    return new AutonomousCommand(arcadeDrive);
  }

  }
