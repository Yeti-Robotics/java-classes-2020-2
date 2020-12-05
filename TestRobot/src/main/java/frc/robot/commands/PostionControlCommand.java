package frc.robot.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem.WheelColor;

public class PostionControlCommand extends CommandBase{
    private final ColorWheelSubsystem colorWheelSubsystem;
    private String gameData;
    private WheelColor finalColor;

    public PostionControlCommand(ColorWheelSubsystem colorWheelSubsystem) {
        this.colorWheelSubsystem = colorWheelSubsystem;
        addRequirements(colorWheelSubsystem);
    }

    @Override
    public void initialize(){
        gameData = DriverStation.getInstance().getGameSpecificMessage();

        if(gameData.charAt(0) == 'Y') {
            finalColor = WheelColor.YELLOW;
        } else if(gameData.charAt(0) == 'G') {
            finalColor = WheelColor.GREEN;
        } else if(gameData.charAt(0) == 'B') {
            finalColor = WheelColor.BLUE;
        } else if(gameData.charAt(0) == 'R') {
            finalColor = WheelColor.RED;
        }
    }

    @Override
    public void execute() {
        colorWheelSubsystem.moveWheel(0.4);
        System.out.println("Wanted color: " + finalColor + ". Current color: " + colorWheelSubsystem.getColor());
    }

    @Override
    public boolean isFinished() {
        return colorWheelSubsystem.getColor() == finalColor;
    }

    @Override
    public void end(final boolean interrupted){
        colorWheelSubsystem.stopWheel();
    }
}