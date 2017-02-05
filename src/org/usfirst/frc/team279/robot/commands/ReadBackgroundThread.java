package org.usfirst.frc.team279.robot.commands;

import org.usfirst.frc.team279.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ReadBackgroundThread extends Command {
	private boolean started = false;
	private boolean ending = false;
	
    public ReadBackgroundThread() {
    	super("ReadBackgroundThread");
    	requires(Robot.testThreads);
        this.setInterruptible(true);
        this.setRunWhenDisabled(true);
    }

    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.testThreads.isEnabled()) {
    		System.out.println("ReadBackgroundThread: Getting current values");
	    	SmartDashboard.putNumber("Thing 1 Counter", Robot.testThreads.getTestThread().getReading("Thing 1"));
	    	SmartDashboard.putNumber("Thing 2 Counter", Robot.testThreads.getTestThread().getReading("Thing 2"));
	    	SmartDashboard.putNumber("Thing 3 Counter", Robot.testThreads.getTestThread().getReading("Thing 3"));
	    	SmartDashboard.putNumber("Thing 4 Counter", Robot.testThreads.getTestThread().getReading("Thing 4"));
    	} else {
    		System.out.println("ReadBackgroundThread: Thread is not currently enabled...");
    		SmartDashboard.putNumber("Thing 1 Counter", -1.0);
	    	SmartDashboard.putNumber("Thing 2 Counter", -1.0);
	    	SmartDashboard.putNumber("Thing 3 Counter", -1.0);
	    	SmartDashboard.putNumber("Thing 4 Counter", -1.0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
