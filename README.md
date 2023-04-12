# face-tracking-xyaxis-bot
Using sample code from OpenCV, OpenCV/jSerialComm/javafx libraries, and an arduino controlling a x and y axis servo robot, i've created a face-following robot relative to your computer's main camera. Reference/source code at: https://github.com/opencv-java/face-detection


I DO NOT CLAIM ANY LEGAL OWNERSHIP OF THE ORIGINAL CODE USED BY OPENCV, REFERENCED OPENCV LIBRARIES OR ANY OF THE OTHER REFERENCED LIBRARIES


Use the Java code while connected by USB to the arduino, make sure the arduino code is uploaded. Run the MyLauncher.java with the edited JRE.

This is more if I forget how/what to do:
In order to set up the libraries (jSerialComm, javafx, OpenCV), you'll have to edit the CLASSPATH in order for them to be referenced as libraries (there's probably an easier way, I just got it to work this way using eclipse). Also, I had to use the javafx jar files in order to create an edited JRE that would run the program; at one point I knew why or how to do this, but I don't now. Good luck !! 
