package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.TalonC;

public class Arm extends SubsystemBase
{
    private TalonC arm;

    public Arm(TalonC arm)
    {
        this.arm = arm;
    }
}