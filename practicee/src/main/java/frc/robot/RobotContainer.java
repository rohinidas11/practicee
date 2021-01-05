/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveIntake;
import frc.robot.commands.WithJoystick;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private SpeedController left1, left2, right1, right2;
  private SpeedControllerGroup left, right;
  private DifferentialDrive drive;
  private DriveTrain driveTrain;
  private Joystick joystick;
  private SpeedController intakeLeft, intakeRight;
  private Intake intake;

  private Button intakeIn, intakeOut;
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureButtonBindings();
    left1 = new TalonC(Constants.LEFT1_PORT, false, Constants.DRIVETRAIN_BIAS);
    left2 = new TalonC(Constants.LEFT2_PORT, false, Constants.DRIVETRAIN_BIAS);
    right1 = new TalonC(Constants.RIGHT1_PORT, false, Constants.DRIVETRAIN_BIAS);
    right2 = new TalonC(Constants.RIGHT2_PORT, false, Constants.DRIVETRAIN_BIAS);

    left = new SpeedControllerGroup(left1, left2);
    right = new SpeedControllerGroup(right1, right2);

    drive = new DifferentialDrive(left, right);
    driveTrain = new DriveTrain(left, right, drive);
    driveTrain.setDefaultCommand(new WithJoystick());

    intakeLeft = new TalonC(4, false, 1);
    intakeRight = new TalonC(5, false, 1);

    intake = new Intake(intakeLeft, intakeRight);

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    joystick = new Joystick(0);
    intakeIn = new JoystickButton(joystick, Constants.INTAKE_IN_BUTTON); //oof
    intakeOut = new JoystickButton(joystick, Constants.INTAKE_OUT_BUTTON);

    intakeIn.whileHeld(new MoveIntake(Constants.INTAKE_IN_SPEED));
    intakeOut.whileHeld(new MoveIntake(Constants.INTAKE_OUT_SPEED));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public DriveTrain getDriveTrain()
  {
    return driveTrain;
  }

  public Joystick getJoystick()
  {
    return joystick;
  }

  public Intake getIntake()
  {
    return intake;
  }
}
