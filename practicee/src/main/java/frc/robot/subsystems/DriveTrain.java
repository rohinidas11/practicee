package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase 
{
    private SpeedControllerGroup left, right;
    private DifferentialDrive drive;

    public DriveTrain(SpeedControllerGroup left, SpeedControllerGroup right, DifferentialDrive drive) 
    {
         this.left = left;
         this.right = right;
         this.drive = drive;
    }

    public void JoystickInputs(Joystick joystick)
     {
         drive.arcadeDrive(joystick.getY(), joystick.getZ());
     }

     public void moveIt(double leftSpeed, double rightSpeed)
     {
         left.set(leftSpeed);
         right.set(rightSpeed);
     }

     public void stop()
     {
         left.stopMotor();
         right.stopMotor();
     }
}