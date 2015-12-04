import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ArrayUtils;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;



public class Main {

	public static File folder = new File("D:/AllFiles/Corpos");
	public static File testFile =  new File("D:/AllFiles/Test/TestFile.txt");
	public FileInputStream fis = null;
	static String temp = "";

	static long lcssRunTime = 0;
	static long naiveRunTime = 0;
	static long kmpRunTime = 0;
	static long boyerRunTime = 0;
	
	public static void main(String[] args) {


		System.out.println("************* Plagarism Detection Tool *************");

		while(true){
			System.out.println("********************** MENU ************************");
			System.out.println("Please select the below options");
			System.out.println("\n 1. LCSS \n 2. Naive Search \n 3. KMP \n 4. Boyer Moore \n 5. Running Time Analysis");
			System.out.println("Enter your choice : ");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch(choice){

				case 1: LCSS lc = new LCSS();
						System.out.println("************ Output using LCSS ************");
						long lcssStart = System.nanoTime();
						lc.AlgoLCSS(folder,testFile);
						long lcssEnd= System.nanoTime();
						lcssRunTime =  TimeUnit.MICROSECONDS.convert((lcssEnd-lcssStart), TimeUnit.NANOSECONDS);
						System.out.println("Running time for LCSS : "+TimeUnit.MICROSECONDS.convert((lcssEnd-lcssStart), TimeUnit.NANOSECONDS) + " microseconds");
						break;
				case 2: NaiveSearch naive = new NaiveSearch();
						System.out.println("************ Output using Naive Search Algo ************");
						long naiveStart = System.nanoTime();
						naive.naiveSerach(folder, testFile);
						long naiveEnd = System.nanoTime();
						naiveRunTime = TimeUnit.MICROSECONDS.convert((naiveEnd-naiveStart), TimeUnit.NANOSECONDS);
						System.out.println("Running time for Naive : "+TimeUnit.MICROSECONDS.convert((naiveEnd-naiveStart), TimeUnit.NANOSECONDS) + " microseconds");
						break;
				case 3: KMPAlgo kmp = new KMPAlgo();
						System.out.println("************ Output using KMP ************");
						long kmpStart = System.nanoTime();
						kmp.kmpSearch(folder,testFile);
						long kmpEnd  = System.nanoTime();
						kmpRunTime = TimeUnit.MICROSECONDS.convert((kmpEnd-kmpStart), TimeUnit.NANOSECONDS);
						System.out.println("Running time for Naive : "+TimeUnit.MICROSECONDS.convert((kmpEnd-kmpStart), TimeUnit.NANOSECONDS) + " microseconds");
				case 4: 
						
						break;
				case 5: runningTimeAnalysis(lcssRunTime, naiveRunTime, kmpRunTime);
						break;
				case 6: System.exit(0);
						break;
				default: System.out.println("Please enter correct choice");
						break;
			}

		}

	}


	private static void runningTimeAnalysis(long lcssRunTime2, long naiveRunTime2, long kmpRunTime2) {
		
		System.out.println("Main.runningTimeAnalysis()");
		
		BarChart chart = new BarChart();
    	chart.setSampleCount(4);
    	double[] values = new double[] {lcssRunTime2,naiveRunTime2,kmpRunTime2};
    	List b = Arrays.asList(ArrayUtils.toObject(values));
    	double maxRange = Collections.max(b);
    	maxRange = maxRange+1000;
    	String[] sampleLabels = new String[] {"LCSS", "Naive", "KMP", "Moore"};
    	String[] barLabels = new String[] {"LCSS", "Naive", "KMP", "Moore"};
    	Color[] c = new Color[] {new Color(0xFF7310)};
    	chart.setSampleValues(0, values);
    	chart.setSampleColor(0, new Color(0xFFA000));
    	chart.setRange(0, maxRange);
    	chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 13));
    	chart.setSampleLabels(sampleLabels);
    	chart.setSampleLabelsOn(true);
    	chart.setSampleLabelStyle(Chart.OUTSIDE);
    	chart.setSampleLabelSelectionColor(Color.red);
    	chart.setFont("sampleLabelFont", new Font("Arial", Font.BOLD, 12));
    	chart.setBarLabels(barLabels);
    	chart.setBarLabelsOn(true);
    	chart.setLabelAngle("barLabelAngle", 270);
    	chart.setSampleColors(c);
    	chart.setValueLabelsOn(true);
    	chart.setValueLabelStyle(Chart.INSIDE);
    	chart.setFont("valueLabelFont", new Font("Arial", Font.PLAIN, 14));
    	chart.setValueLinesOn(true);
    	chart.setMaxValueLineCount(10);
    	chart.setFont("floatingLabelFont", new Font("Arial", Font.BOLD, 11));
    	chart.setBarWidth(0.5);
    	chart.setBackground(Color.white);

    	Frame f = new Frame();
    	f.setSize(450,320);
    	f.add("Center", chart);
    	f.show();
		
	}


	private static void printOutput(ArrayList<String> plagarized) {
		for (String str : plagarized) {
			if(str != null){
				System.out.println(str);
			}
		}

	}



}


