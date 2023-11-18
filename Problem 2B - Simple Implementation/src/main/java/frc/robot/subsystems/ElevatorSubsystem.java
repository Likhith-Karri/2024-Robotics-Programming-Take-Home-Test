package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class ElevatorSubsystem extends SubsystemBase {

  // Left Side Motors 
  private CANSparkMax leader = new CANSparkMax(0, MotorType.kBrushless);
  private CANSparkMax follower = new CANSparkMax(1, MotorType.kBrushless);
  
  

  public ElevatorSubsystem() {
     leader.restoreFactoryDefaults();
    follower.restoreFactoryDefaults();

    follower.follow(leader);
  }

  public void setMotor(double speed) {
      leader.set(speed);
  }

  @Override
  public void periodic() {}
  
}