package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj.Joystick;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.Encoder;

public class DriveSubsystem extends SubsystemBase {
  
  // Left Side Motors 
  private CANSparkMax frontLeft = new CANSparkMax(0, MotorType.kBrushless);
  private CANSparkMax backLeft = new CANSparkMax(1, MotorType.kBrushless);
  // Right Side Motors 
  private CANSparkMax frontRight = new CANSparkMax(2, MotorType.kBrushless);
  private CANSparkMax backRight = new CANSparkMax(3, MotorType.kBrushless);
  // Timer - Helps Determine When To Have A Command Stop Running
  private final Timer timer = new Timer();
  // DifferentialDrive - Drive Subsystem
  public DifferentialDrive kDrive;
  // Encoders - Used For Detecting Position
  private Encoder leftEncoder = new Encoder(0, 1); // Sample Ports
  private Encoder rightEncoder = new Encoder(2, 3); // Sample Ports
  
  public DriveSubsystem() {
    frontLeft.restoreFactoryDefaults();
    backLeft.restoreFactoryDefaults();

    frontRight.restoreFactoryDefaults();
    backRight.restoreFactoryDefaults();
    
    backLeft.follow(frontLeft);

    backRight.follow(frontRight);

    frontRight.setInverted(true);
    backRight.setInverted(true);

    kDrive = new DifferentialDrive(frontLeft, frontRight);
   
  }

  @Override
  public void periodic() {}

  public void drive(double leftPercentOut, double rightPercentOut) {
    frontLeft.set(leftPercentOut); // Setting Left Side Values
    frontRight.set(rightPercentOut); // Setting Right Side Values
  }

  public CommandBase driveCommand (DoubleSupplier l, DoubleSupplier r) {
    return new RunCommand(() -> drive(l.getAsDouble(), r.getAsDouble()), this);
  }


}