package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ColorWheelSubsystem extends SubsystemBase {
    public enum WheelColor {
        RED, YELLOW, GREEN, BLUE
    }

    public static WheelColor wheelColor;
    private TalonSRX talon;
    private ColorSensorV3 colorSensor;

    public ColorWheelSubsystem() {
        talon = new TalonSRX(Constants.COLOR_WHEEL_TALON);
        colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
    }

    @Override
    public void periodic() {
        Color detectedColor = colorSensor.getColor();

        if(detectedColor.red > 0.5 && detectedColor.green < 0.4 && detectedColor.blue < 0.3) {
            System.out.println("the color is red!");
            wheelColor = WheelColor.RED;
        } else if (detectedColor.red < 0.3 && detectedColor.green > 0.5 && detectedColor.blue < 0.3) {
            System.out.println("the color is green!");
            wheelColor = WheelColor.GREEN;
        } else if (detectedColor.red < 0.2 && detectedColor.green > 0.3 && detectedColor.blue > 0.3) {
            System.out.println("the color is blue/cyan!");
            wheelColor = WheelColor.BLUE;
        } else if(detectedColor.red > 0.3 && detectedColor.green > 0.5 && detectedColor.blue < 0.3) {
            System.out.println("the color is yellow");
            wheelColor = WheelColor.YELLOW;
        }
    }

    public void moveWheel(double power) {
        talon.set(ControlMode.PercentOutput, power);
    }
    
    public void stopWheel() {
        talon.set(ControlMode.PercentOutput, 0);
    }

    public WheelColor getColor() {
        return wheelColor;
    }
}