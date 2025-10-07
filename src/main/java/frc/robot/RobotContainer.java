// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.MotorSubsystem;

public class RobotContainer {
  public MotorSubsystem motorSubsystem;
  public CommandXboxController controller;

  public RobotContainer() {
    controller = new CommandXboxController(0);
    motorSubsystem = new MotorSubsystem();

    configureBindings();
  }

  private void configureBindings() {
    controller.a().onTrue(motorSubsystem.setPosition(() -> Units.degreesToRotations(0)));
    controller.b().onTrue(motorSubsystem.setPosition(() -> Units.degreesToRotations(90)));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
