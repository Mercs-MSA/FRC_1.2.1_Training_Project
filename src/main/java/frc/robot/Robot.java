// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

  /**
   * This program demonstrates a basic time-based robot employing a joystick and a single NEO motor.
   */

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

// We add this line to enable us to call and use a Joystick
import edu.wpi.first.wpilibj.Joystick;

// We add this line to enable us to call and use a REV Robotics Spark Max motor controller using the REV Robotics library
import com.revrobotics.CANSparkMax;
// We add this line to enable us to call and new data type corresponding to the motor we are using
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Robot extends TimedRobot {

  // We add this line to create a new instance of a joystick object connected to USB port 0
  Joystick my_joystick = new Joystick(0);

  // We add this line to create a new instance of a motor controller object connected to CAN bus port 20 and using a brushless type motor (aka Neo)
  CANSparkMax my_motor_controller = new CANSparkMax(20, MotorType.kBrushless);

  // We add this line to create a new instance of a "double" variable and set its value to 0
  double motor_control_input = 0.0;

  @Override
  public void robotInit() {
    // This is a good idea; it "resets" the Spark Max to factory default settings
    my_motor_controller.restoreFactoryDefaults();
  }

  @Override
  public void robotPeriodic() {
    // Get the current value of my joysticks left controller Y axis and set my motor_control_input variable to it
    motor_control_input = 12.0 * my_joystick.getRawAxis(1); // multiple by 12 to get number to be -12.0 to +12.0
  }

  @Override
  public void teleopPeriodic() {
    // set the motor controller input to the value of motor_control_input
    my_motor_controller.setVoltage(motor_control_input);
  }
}