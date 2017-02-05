package org.usfirst.frc.team279.robot.subsystems;

import org.usfirst.frc.team279.robot.examples.TestThread;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TestThreads extends Subsystem {
	private TestThread tt = TestThread.getInstance();
	public TestThread getTestThread(){
		return tt;
	}

	private boolean enabled = false;
	public boolean isEnabled(){
		return enabled;
	}

    public void initDefaultCommand() {
    }
    
    public void init(){
    	System.out.println("TT: TestThreads Init Starting");
		
    	tt.addObject("Thing 1");
    	tt.addObject("Thing 2");
    	tt.addObject("Thing 3");
    	tt.addObject("Thing 4");
		
		System.out.println("TT: TestThreads Init Complete");	
    }
    
    

	public void startTestThread(){
		if(enabled){
			return;
		}
		tt.startReading();
		System.out.println("TT: Enabled background thread");
		enabled = true;
		
		
	}
	
	public void stopTestThread(){
		if(!enabled){
			return;
		}
		tt.stopReading();
		System.out.println("TT: Disabled background thread");
		enabled = false;
	}
	
	
	
}

