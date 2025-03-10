// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorConstants;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.MAXMotionConfig.MAXMotionPositionMode;

public class Elevator extends SubsystemBase {

  SparkMax m_elevator = new SparkMax(ElevatorConstants.kElevatorID, MotorType.kBrushless);

  SparkMaxConfig m_elevatorConfig = new SparkMaxConfig();

  SparkClosedLoopController m_elevatorPID = m_elevator.getClosedLoopController();

  ShuffleboardTab m_tab = Shuffleboard.getTab("Main");

  double m_setPoint;
  double m_position = m_elevator.getEncoder().getPosition();
  boolean m_isEnabled = false;

  /** Creates a new Elevator. */
  public Elevator() {

    m_elevatorConfig.inverted(true);
    m_elevatorConfig.idleMode(IdleMode.kBrake);
    
    m_elevatorConfig.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder);
    m_elevatorConfig.closedLoop.pid(ElevatorConstants.kP, ElevatorConstants.kI, ElevatorConstants.kD);

    m_elevatorConfig.closedLoop.maxMotion.maxAcceleration(ElevatorConstants.kMaxAcceleration);
    m_elevatorConfig.closedLoop.maxMotion.maxVelocity(ElevatorConstants.kMaxVelocity);
    m_elevatorConfig.closedLoop.maxMotion.allowedClosedLoopError(ElevatorConstants.kMaxError);
    m_elevatorConfig.closedLoop.maxMotion.positionMode(MAXMotionPositionMode.kMAXMotionTrapezoidal);

    m_elevatorConfig.encoder.positionConversionFactor(ElevatorConstants.kConvertionFactor);

    m_elevator.configure(m_elevatorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    m_elevator.getEncoder().setPosition(0);
  }

  @Override
  public void periodic() {
    if (m_isEnabled) {
      m_elevatorPID.setReference(m_setPoint, ControlType.kPosition);
    }
    m_position = m_elevator.getEncoder().getPosition();
    // m_tab.add("Height of Elevator", m_setPoint);
    SmartDashboard.putNumber("Elevator Height", m_position);
    // This method will be called once per scheduler run
    // System.out.println("Elevator position " + m_position);
  }

  public void setheight(double height) {
    m_setPoint = height;
    m_elevatorPID.setReference(height, ControlType.kMAXMotionPositionControl);
    System.out.println("function seen, " + height);
  }

  public void MoveUp() {
    m_elevator.set(0.3);
  }

  public void MoveDown() {
    m_elevator.set(-0.3);
  }

  public void EnablePID() {
    m_isEnabled = true;
  }

  public void DisablePID() {
    m_isEnabled = false;
  }

  public void ElevatorStop() {
    m_elevator.stopMotor();
  }

  public double getPosition() {
    return m_position;
  }

}
