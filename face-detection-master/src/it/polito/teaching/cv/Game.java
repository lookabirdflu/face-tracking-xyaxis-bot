package it.polito.teaching.cv;


import java.io.*;

public class Game {
	public static void main(String[] args)throws IOException	{
		
		ProcessBuilder pb = new ProcessBuilder("java", "-cp", "C:\\Users\\cbond\\Desktop\\face-detection-master\\src\\it\\polito\\teaching\\cv\\MyLauncher", "MyLauncher"); 
		Process p = pb.start(); 
		InputStream is = p.getInputStream(); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(is)); 
		 
		String line; 
		while ((line = reader.readLine()) != null) { 
		    //System.out.println(line);
		    String[] coords = line.split(" ");
		    int x = Integer.parseInt(coords[0]);
		    int y = Integer.parseInt(coords[1]);
		    
		    
		} 	
			
	}
}
