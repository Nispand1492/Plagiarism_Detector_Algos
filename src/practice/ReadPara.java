package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadPara {
	public static File userFile =  new File("D:/AllFiles/Test/TestFile.txt");
	public static FileReader userfileReader =  null;
	public static BufferedReader userBufReader = null;
	
	
	
	static int paraCount = 1;
	static String line = "";
	static String matchStr = "The designer is a NIFT pass out.";

	public static void main(String args[]){
		
		
		try {
			
			userfileReader = new FileReader(userFile);
			userBufReader = new BufferedReader(userfileReader);
			
			while((line = userBufReader.readLine()) != null){
				
				System.out.println("Para new : & Length : "+line.length()+" "+line);
				
				
				for(int i=0 ; i<line.length() ; i++){
					
					
					
				}
				
				if (line.contains("") || line.contains(null)){
	                paraCount++;
	            }
				
				
				
				
				
			}
			
			
			System.out.println(paraCount);
			System.out.println("Match str : "+matchStr.length());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



}
