package org.usfirst.frc.team279.robot.commands;

import org.usfirst.frc.team279.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DisableThing4 extends Command {

    public DisableThing4() {
    	super("DisableThing4");
    	requires(Robot.testThreads);
        this.setInterruptible(true);
        this.setRunWhenDisabled(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("EnableThing: Disabling Thing 4");
    	Robot.testThreads.getTestThread().disableObject("Thing 4");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
