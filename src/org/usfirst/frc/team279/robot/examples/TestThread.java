package org.usfirst.frc.team279.robot.examples;

import java.util.Hashtable;
import edu.wpi.first.wpilibj.Timer;



public class TestThread {
		//Singleton Design pattern, Lazy Loading
		private static TestThread  instance;
		private TestThread (){}
		public static TestThread  getInstance(){
			if(instance == null){
				instance = new TestThread();
			}
			return instance;
		}
		
		
		
		private Hashtable<String, TestObject> testObjectList = new Hashtable<String, TestObject>();
		
		public void addObject(String name) {
			testObjectList.put(name, new TestObject(name));
		}
		
		public void remObject(String name){
			if(testObjectList.containsKey(name)){
				testObjectList.remove(name);
			}
		}
		
		public void enableObject(String name){
			if(testObjectList.containsKey(name)){
				testObjectList.get(name).enabled = true;
			}
		}
		public void disableObject(String name){
			if(testObjectList.containsKey(name)){
				testObjectList.get(name).enabled = false;
			}
		}
		
		public int getReading(String name){
			if(testObjectList.containsKey(name)){
				return testObjectList.get(name).counter;
			} else {
				return -99;
			}
		}
		
		
		
		private AnActualTestThread t;
		public void startReading(){
			if(t != null && t.isAlive() ) {
				return;
			}
			if(testObjectList.isEmpty()){
				return;
			}
			
			t = new AnActualTestThread();
			t.start();
			System.out.println("TestThread: Starting Reading...");
		}
		public void stopReading(){
			t.enabled = false;
			System.out.println("TestThread: Requesting Thread to Stop");
			try {
				t.join();
			} catch(Exception e) {
				System.out.println("TestThread: Exception caught waiting for thread to stop - " + e.getMessage());
			}
			
			System.out.println("TestThread: Thread Stopped");
			for(TestObject t : testObjectList.values()) {
				t.counter = 0;
			}
			System.out.println("TestThread: Counters Reset");
		}
		
		
		
		private class AnActualTestThread extends Thread{
			public boolean enabled = true;
			
			public synchronized void run() {
				if(!testObjectList.isEmpty()) {
					while (!Thread.currentThread().isInterrupted() && enabled) {
						try {
							for(TestObject t : testObjectList.values()) {
								if(t.enabled){
									t.doSomething();
								} else {
									System.out.println("AnActualTestThread: Skipping Testobject, not enabled: " + t.label);
								}
							}
							Timer.delay(1);
						} catch (Exception e) {
							enabled = false;
							return;
						}
					}
				}
				
				System.out.println("AnActualTestThread: Exiting Run()...");
			}
			
		}
		
		
		
		private class TestObject {
			public boolean enabled = true;
			public String label;
			public int counter;
			
			public TestObject(String name) {
				label = name;
			}
			
			public void doSomething(){
				counter++;
				System.out.println("TestObject: DoSomething Called for " + label);
			}
		
		}
	
}
