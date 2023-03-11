/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.cameraserver.CameraServer;
// Imports //
// wpilib imports //
import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.buttons.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public static DriveSubsystem driveSubsystem = new DriveSubsystem();
  DigitalInput limitSwitch = new DigitalInput(0);
  Timer timer;
//public LiftController liftController = new LiftController();

  public XboxController xboxController;
  public Joystick logitech;
  @Override
  public void robotInit() {
    CameraServer.startAutomaticCapture(0);
    CameraServer.startAutomaticCapture(1);
    logitech = new Joystick(RobotMap.joystickPort);
    xboxController = new XboxController(RobotMap.XboxControllerPort);
    

    timer = new Timer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    timer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

    /* A simple timer implementation for Auto, Simply 
     * add "Else If" Statements to create a set of operations during Auto
     */
    if (timer.get() < 0.5)
    {
    driveSubsystem.teleopDrive(0,-1);
    }
   /* else if (timer.get()>0.75 && timer.get()< 2)
    {
      driveSubsystem.teleopDrive(0.33,1);
    }
    */
    else if (timer.get()>4 && timer.get()<8.5)
    {
      driveSubsystem.teleopDrive(0,0.5);
    }
    
  }

  /**
   * This function is called once when teleop is enabled.
   */
  @Override
  public void teleopInit() {
   
  }

  public void drive(){
    double throttle = 1-((logitech.getThrottle()+1)/2);
    double move = logitech.getX();
    double turn = -logitech.getY();

    // removing creep //
    if (Math.abs(turn)<0.1){
      turn = 0;
    }
    if (Math.abs(move)<0.1){
      move = 0;
    }
    // Driving //
    if (throttle < 0.5)
    {
    driveSubsystem.teleopDrive(move, turn);
    }
    else
    {
      driveSubsystem.teleopDrive(move, -turn);
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    drive();

    SmartDashboard.putBoolean("Limit Switch", limitSwitch.get());
    
    // Intake System Buttons
    if (limitSwitch.get() && xboxController.getBButton()){ // Out
      intakeSubsystem.back();
    } else if (xboxController.getAButton()){ // In
      intakeSubsystem.forward();
    } else if (xboxController.getYButton()){ // Up
      intakeSubsystem.up();
    } else if (xboxController.getXButton()){ // Down
      intakeSubsystem.down();
    } else {
      intakeSubsystem.stop();
    }
  }
  
/* This function is called once when the robot is disabled.
   */

  @Override
  public void disabledInit() {
  }

  /**
   * This function is called periodically when disabled.
   */
  @Override
  public void disabledPeriodic() {
  }

  /**
   * This function is called once when test mode is enabled.
   */
  @Override
  public void testInit() {
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
