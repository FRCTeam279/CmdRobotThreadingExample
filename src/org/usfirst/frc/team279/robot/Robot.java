
package org.usfirst.frc.team279.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team279.robot.commands.*;
import org.usfirst.frc.team279.robot.subsystems.TestThreads;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final TestThreads testThreads = new TestThreads();


	
	public void robotInit() {
		Robot.testThreads.init();
		
		SmartDashboard.putData("Start Background Threads",new StartBackgroundThread());
		SmartDashboard.putData("Read Background Threads",new ReadBackgroundThread());
		SmartDashboard.putData("Stop Background Threads",new StopBackgroundThread());
		
		SmartDashboard.putData("Enable Thing 1", new EnableThing1());
		SmartDashboard.putData("Enable Thing 2", new EnableThing2());
		SmartDashboard.putData("Enable Thing 3", new EnableThing3());
		SmartDashboard.putData("Enable Thing 4", new EnableThing4());
		
		SmartDashboard.putData("Disable Thing 1", new DisableThing1());
		SmartDashboard.putData("Disable Thing 2", new DisableThing2());
		SmartDashboard.putData("Disable Thing 3", new DisableThing3());
		SmartDashboard.putData("Disable Thing 4", new DisableThing4());

	}

	public void robotPeriodic() {
	}
	
	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
	}

	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
	}

	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	
	public void testPeriodic() {
		LiveWindow.run();
	}
}
