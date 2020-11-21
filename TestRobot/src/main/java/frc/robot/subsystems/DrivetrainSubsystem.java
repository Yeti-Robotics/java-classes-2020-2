package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {
    private TalonSRX leftTalon, rightTalon;
    private VictorSPX leftVictor1, leftVictor2, rightVictor1, rightVictor2;

    public DrivetrainSubsystem() {
        leftTalon = new TalonSRX(Constants.LEFT_TALON);
        leftVictor1 = new VictorSPX(Constants.LEFT_VICTOR_1);
        leftVictor2 = new VictorSPX(Constants.LEFT_VICTOR_2);
        rightTalon = new TalonSRX(Constants.RIGHT_TALON);
        rightVictor1 = new VictorSPX(Constants.RIGHT_VICTOR_1);
        rightVictor2 = new VictorSPX(Constants.RIGHT_VICTOR_2);

        leftTalon.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
        rightTalon.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);

        leftTalon.setNeutralMode(NeutralMode.Brake);
        leftVictor1.setNeutralMode(NeutralMode.Brake);
        leftVictor2.setNeutralMode(NeutralMode.Brake);
        rightTalon.setNeutralMode(NeutralMode.Brake);
        rightVictor1.setNeutralMode(NeutralMode.Brake);
        rightVictor2.setNeutralMode(NeutralMode.Brake);

        rightTalon.setInverted(true);
        rightVictor1.setInverted(true);
        rightVictor2.setInverted(true);
    }

    public void drive(double leftPower, double rightPower){
        leftTalon.set(ControlMode.PercentOutput, leftPower);
        leftVictor1.set(ControlMode.PercentOutput, leftPower);
        leftVictor2.set(ControlMode.PercentOutput, leftPower);
        rightTalon.set(ControlMode.PercentOutput, rightPower);
        rightVictor1.set(ControlMode.PercentOutput, rightPower);
        rightVictor2.set(ControlMode.PercentOutput, rightPower);
    }

    public void stopDrive() {
        leftTalon.set(ControlMode.PercentOutput, 0);
        leftVictor1.set(ControlMode.PercentOutput, 0);
        leftVictor2.set(ControlMode.PercentOutput, 0);
        rightTalon.set(ControlMode.PercentOutput, 0);
        rightVictor1.set(ControlMode.PercentOutput, 0);
        rightVictor2.set(ControlMode.PercentOutput, 0);
    }
}