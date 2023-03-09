/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class IntakeSubsystem {
  
  public VictorSP extendController;
  public VictorSP liftController;

  public IntakeSubsystem()
  {
    extendController = new VictorSP(RobotMap.extendMotor);
    liftController = new VictorSP(RobotMap.liftMotor);
  }

  public void forward(){
    extendController.set(RobotMap.extendThrottle);    
  }

  public void back(){
    extendController.set(-RobotMap.extendThrottle);
  }

  public void up(){
    liftController.set(RobotMap.liftThrottle);    
  }

  public void down(){
    liftController.set(-RobotMap.liftThrottle);
  }

  public void stop(){
    extendController.set(0);
    liftController.set(0);
  }
}