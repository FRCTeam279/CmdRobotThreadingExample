package org.usfirst.frc.team279.robot.commands;

import org.usfirst.frc.team279.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopBackgroundThread extends Command {

    public StopBackgroundThread() {
    	super("StopBackgroundThread");
    	requires(Robot.testThreads);
        this.setInterruptible(true);
        this.setRunWhenDisabled(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//stopTestThread will not attempt to stop the thread if it is already dead
    	// safe to call repeatedly
    	System.out.println("StopBackgroundThread: Calling StopTestThreads()");
    	Robot.testThreads.stopTestThread();
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
