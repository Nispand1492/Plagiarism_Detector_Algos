package practice;

import com.objectplanet.chart.*;

import java.awt.*;
public class Bar {

    	public static void main(String[] argv) {
    		
  
        	double[] values = new double[] {10,20,40,65,50};
        	Color[] c = new Color[] {new Color(0xFF7310)};
        	BarChart chart = new BarChart();

        	chart.setSampleCount(5);
        	chart.setSampleValues(0, values);
        	chart.setSampleColors(c);
        	chart.setBackground(Color.white);
        	chart.setRange(0, 70);
        	
        	Frame f = new Frame();
        	f.setSize(450,320);
        	f.add("Center", chart);
        	f.show();
        	
    	}
}