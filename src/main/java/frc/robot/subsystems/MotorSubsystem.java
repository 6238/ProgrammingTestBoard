package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {
    private TalonFX motor;

    private final PositionVoltage positionRequest = new PositionVoltage(0);

    public MotorSubsystem() {
        motor = new TalonFX(10);

        TalonFXConfiguration configuration = new TalonFXConfiguration();
        configuration.Slot0.kP = 1.0;
        configuration.Slot0.kI = 0.01;
        configuration.Slot0.kD = 0.01;

        motor.getConfigurator().apply(configuration);
    }

    public Command setPosition(DoubleSupplier position) {
        return runOnce(() -> {
            motor.setControl(positionRequest.withPosition(position.getAsDouble()));
        });
    }
}
