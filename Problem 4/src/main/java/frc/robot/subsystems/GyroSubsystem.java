package frc.robot.subsystems;

import com.ctre.phoenix.sensors.Pigeon2;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase{

// Creating A Gyro Which Will Later Measure The Robot's Angle 
private Pigeon2 gyro = new Pigeon2(0); // AHRS Is A Sample Gyro Type

    public double getAngle() {
        return gyro.getYaw();
      }
      public void zeroGyro() {
        gyro.setYaw(0);
      
    }

    @Override
    public void periodic() {
       SmartDashboard.getBoolean("Is Gyro In Range", Math.abs(getAngle() - 115.0) < 5);
    }
    
}

