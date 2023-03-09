/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
/**
 * Add your docs here.
 */
public class RobotMap {

    
    // Controllers //
    public static int joystickPort = 0;
    public Joystick logitech = new Joystick(RobotMap.joystickPort);
    //Xbox Controller, GuessworkCurrently
    public static int XboxControllerPort = 1;

    public XboxController xboxcontroller = new XboxController(RobotMap.XboxControllerPort);
   
    // Motors //
    
    // Drive Train //
    public static int leftFrontMotor = 4;
    public static int leftRearMotor = 3;
    public static int rightFrontMotor = 1;
    public static int rightRearMotor = 2;
       
    // Throttle Setting //
    public static double maxThrottle = 0.7;

    // Climber //
    //public static int ClimbMotor_L1 = 5; //5
   // public static int ClimbMotor_L2 = 6; //6
    //public static int ClimbMotor_R1 = 7; //7
    //public static int ClimbMotor_R2 = 8; //8

    //public static double climbThrottle = 0.5;
    

    //Intake//
    public static int extendMotor = 0; // pwm port 0, extend motor; changed from intake to extend
    public static double extendThrottle = 0.5;

    public static int liftMotor = 1; // pwm port 1, added lift motor
    public static double liftThrottle = 0.5;


        //public static int WPI_TalonSRX = 0; //5
    

//climberwinch//
//public static int ClimberWinch = 1; //5
//public static double winchThrottle = 0.5; //5
}
