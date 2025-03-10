package frc.robot.Commands.Elevator;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ElevatorConstants;
import frc.robot.Subsystems.Elevator;


public class MoveUp extends Command {
    Elevator m_elevator;
    double m_limit = ElevatorConstants.kMaxHeight;

    public MoveUp(Elevator elevator) {
        m_elevator = elevator;
        addRequirements(m_elevator);
    }
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_elevator.DisablePID();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (m_limit > m_elevator.getPosition()) {
            m_elevator.MoveUp();
            }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_elevator.ElevatorStop();
        m_elevator.setheight(m_elevator.getPosition()); 
        m_elevator.EnablePID();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}