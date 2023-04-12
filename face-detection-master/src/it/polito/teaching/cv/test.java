package it.polito.teaching.cv;


import java.io.PrintWriter;

import com.fazecast.jSerialComm.*;
import java.util.*;
import java.time.Duration;
import java.time.Instant;

public class test {
	//static SerialPort chosenPort;


	public static void main(String[] args)throws Exception {
		/*
		FaceDetection.main(args);
		ProcessBuilder pb = new ProcessBuilder("java", "-cp", "C:\\Users\\cbond\\Desktop\\face-detection-master\\src\\it\\polito\\teaching\\cv\\MyLauncher", "MyLauncher"); 
		Process p = pb.start(); 
		InputStream is = p.getInputStream(); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		*/
	}
		
		public static void hitData(String data) {
			SerialPort chosenPort;
					// attempt to connect to the serial port
					chosenPort = SerialPort.getCommPort("COM3");
					chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
					if(chosenPort.openPort()) {
						// create a new thread for sending data to the arduino
						Thread thread = new Thread(){
							@Override public void run() {
								// wait after connecting, so the bootloader can finish
								try {Thread.sleep(100); } catch(Exception e) {}

								// enter an infinite loop that sends text to the arduino
								PrintWriter output = new PrintWriter(chosenPort.getOutputStream());
								//while(true) {
									/*
									String line = "";
									try {
										line = reader.readLine();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									*/
									//System.out.println("womp");
									output.print(data);
									output.flush();
									try {Thread.sleep(100); } catch(Exception e) {}
								//}
							}
						};
						thread.start();
					}
				     else {
					// disconnect from the serial port
					chosenPort.closePort();
					}
		 
	}
	public static void sendData(String text) {
	    SerialPort serialPort;

		serialPort = SerialPort.getCommPort("COM3");
        serialPort.setComPortParameters(9600,8,1,0);
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING,0,0);
        serialPort.openPort(20);

        PrintWriter out = new PrintWriter(serialPort.getOutputStream(),true);
        //System.out.println("works");
        out.println("your mom");
        out.flush();
        out.close();
        
		
	}
	public static void thereData(String text) {
		  Scanner console = new Scanner(System.in);
		  System.out.println("List COM ports");
		  SerialPort comPorts[] = SerialPort.getCommPorts();
		  for (int i = 0; i < comPorts.length; i++)   
		          System.out.println("comPorts[" + i + "] = " + comPorts[i].getDescriptivePortName());
		  int port = 1;     // array index to select COM port
		  comPorts[port].openPort();
		  System.out.println("open port comPorts[" + port + "]  " + comPorts[port].getDescriptivePortName());
		  comPorts[port].setBaudRate(9600);
		  try {
		    while (true)
		    {
		      // if keyboard token entered read it
		      if(System.in.available() > 0)
		           {
		           //System.out.println("enter chars ");
		           String s = console.nextLine() + "\n";                // read token
		           byte[] writeBuffer=s.getBytes() ;
		           comPorts[port].writeBytes(writeBuffer, writeBuffer.length);
		           //System.out.println("write " + writeBuffer.length);
		          }
		     // read serial port  and display data
		      while (comPorts[port].bytesAvailable() > 0)
		          {
		          byte[] readBuffer = new byte[comPorts[port].bytesAvailable()];
		          int numRead = comPorts[port].readBytes(readBuffer, readBuffer.length);
		          //System.out.print("Read " + numRead + " bytes from COM port: ");
		          for (int i = 0; i < readBuffer.length; i++)   
		             System.out.print((char)readBuffer[i]);
		          //System.out.println();
		          }
		     }
		  } catch (Exception e) { e.printStackTrace(); }
		  comPorts[port].closePort();
		  console.close();
	}
	public static void wompData(String text) {
		// Find all available ports
        SerialPort[] computerPorts = SerialPort.getCommPorts();

        // Select COM3
        SerialPort selectedPort = null;

        for (SerialPort p : computerPorts) {
            if (p.getSystemPortName().equals("COM3")) {
                selectedPort = p;
            }
        }

        // Try to open port, terminate execution if not possible
        if (selectedPort == null) {
            return;

        } else if (selectedPort.openPort()) {
            System.out.println(selectedPort.getSystemPortName() + " successfully opened.");

        } else {
            System.out.println(selectedPort.getSystemPortName() + " failed to open.");
            return;
        }

        // Set port to scanner mode
        selectedPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);

        // Read from port and display
        try (PrintWriter output = new PrintWriter(selectedPort.getOutputStream())) {
            // Wait for 100 ms
            Instant start = Instant.now();
            while (Duration.between(start, Instant.now()).toMillis() < 100) {}

            try {
                output.print("womp");
                output.flush();
                System.out.println("Sent");

            } catch (Exception e) {
                System.out.println("Failed to send");
            }
        }

        selectedPort.closePort();

        System.out.println("--- Main finished ---");
	}
	
}
		