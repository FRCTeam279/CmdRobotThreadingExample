# Project Name

This is an example command based robot project for FIRST Robotics which illustrates creating a thread to process a queue of objects in the background


The heart of the project is the TestThread class, which has three primary elements
* The public TestThread class
	* This holds a hash table of the TestObjects to iterate over in background thread, along with methods to add, remove, enable, and disable the objects - and to get a reading from a given object
	* This is implemented as a Singleton object, so use the getInstance() method to instantiate it rather than "new TestThread()" (singleton design is used to only allow one thread to process the objects at a time and avoid conflicts
	* This is also where the methods to create and start the background thread, and to stop and destroy the background thread are
* The AnActualThread private class
	* Extends the thread class
	* Provides an Enabled variable to allow requesting the thread to stop processing
* The TestObject class
	* Represents the actual object we want to work with in the background, such as a sensor....
	* The Enabled flag is important, as it allows the AnActualThread class to skip processing of specific objects at will
	

A subsystem is provided to hold references to the TestThread objects, and commands to interact with the class
The subsystem creates the TestThread objects, and instanticates for example TestObjects, which are referred to as follows (Keys on the hashtable)
* Thing 1
* Thing 2
* Thing 3
* Thing 4

THe Commands will allow:
* Starting the background thread (Creates a new thread via the AnActualThread class, and starts processing)
* Stopping the background thread (resets the counters as well on the TestObjects)
* Reading the values of the counters on the TestObjects
* Enabling and Disabling each individual TestObject


While running, each method will output status to the console so that you can observe the flow. 




## Installation

Deploy to the robot from Eclipse on a system with the usual wpilib installed.. See the FIRST Java Programming documentation for more information


## Usage

The commands will all work while the robot is disabled. No need to enable

1. Deploy the code
2. Open the driver station and Java SmartDashboard
3. Open the large console, and view +print
	* Arrange so that you can see the console output and the smartdashboard
3. Click the button to start the background thread
4. Click the button to read the counters a few times
5. Click the button to stop the background thread
6. Start the background thread, and disable/enable the things
7. Read the counters again while some objects are disabled
8. Note the console output... 
9. Party like it's 1999



## History

2016-02-05 - Michael Lehman - Annoyed by the existing ultrasonics class, i set out to make a more flexible version....

## Credits

Michael Lehman

## License

No restrictions.. use as you will