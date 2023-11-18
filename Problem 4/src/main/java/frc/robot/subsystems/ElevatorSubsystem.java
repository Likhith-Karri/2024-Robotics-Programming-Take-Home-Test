package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
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

  SparkMaxPIDController pidController = leader.getPIDController();
  
  // Adjust Based On HardWare / Elevator Size
  private static final double GEAR_RATIO = 5.0;
  public static final double HEIGHT_TOLERANCE = .5;
  
  

  public ElevatorSubsystem() {
    leader.restoreFactoryDefaults();
    follower.restoreFactoryDefaults();

    follower.follow(leader);

    pidController.setP(1.0);
    pidController.setP(1.0);

    leader.burnFlash();
  }

  public void setHeight(double inches) {
      pidController.setReference(inches * GEAR_RATIO, ControlType.kPosition);
  }

  public double getHeight() {
    return leader.getEncoder().getPosition() / GEAR_RATIO; 
}




  @Override
  public void periodic() {}
  
}