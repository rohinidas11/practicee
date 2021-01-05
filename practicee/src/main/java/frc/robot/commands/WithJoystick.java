package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class WithJoystick extends CommandBase
{
    @Override
    public void initialize()
    {
        Robot.m_robotContainer.getDriveTrain().JoystickInputs(Robot.m_robotContainer.getJoystick());

    }

    @Override
    public void execute()
    {
        Robot.m_robotContainer.getDriveTrain().JoystickInputs(Robot.m_robotContainer.getJoystick());
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }

    @Override
    public void end(boolean isFinished)
    {
        Robot.m_robotContainer.getDriveTrain().stop();
    }
}