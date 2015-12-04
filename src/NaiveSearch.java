import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class NaiveSearch {
	public static FileReader fileReader =  null;
	public static BufferedReader bufReader = null;
	public static BufferedReader readCorpos = null;
	public static FileReader corposReader = null;
	static int totalTextinFile = 0;
	static String line = "";
	
	
	static HashMap plagarism = new HashMap();
	public static void naiveSerach(File allFileFolder, File testFile){
		
		ArrayList output = null;
		try {
			
			fileReader = new FileReader(testFile);
			bufReader = new BufferedReader(fileReader);
			ArrayList<String> pattern = new ArrayList<String>();
			
			while((line = bufReader.readLine()) != null){
				
				System.out.println(line+" "+totalTextinFile);
				pattern.add(line);
			}
			
			
			String[] testAllParaArray = new String[pattern.size()];
			testAllParaArray = pattern.toArray(testAllParaArray);
			ArrayList<String> finalMatches = new ArrayList<String>();
			
			output = new ArrayList();
			if(allFileFolder.isDirectory()){
				
				File[] allFiles = allFileFolder.listFiles();
				for(File f: allFiles){
					
					readCorpos = new BufferedReader(new FileReader(f));
					ArrayList<String> corposPattern = new ArrayList<String>();
					String str = "";
					String finalString = "";
					while((str = readCorpos.readLine()) != null){
						//System.out.println(str);
						finalString = finalString + str;
					}
					corposPattern.add(finalString);
					String[] corposAllParaArray = new String[corposPattern.size()];
					corposAllParaArray =  corposPattern.toArray(corposAllParaArray);
					int k = 0;
					for(String para: testAllParaArray){
						
						finalMatches = findMatchingPattern(para,corposAllParaArray, f.getName());
						for(String match:finalMatches){
							
							System.out.println(match);
							
						}
						
						
					}
									
				}
			}
			
			
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	private static ArrayList<String> findMatchingPattern(String para, String corposPara[], String fileName) {
		
		int paraLen = para.length();
		int corposLen = corposPara[0].length();
		ArrayList<String> matchingPatterns = new ArrayList<String>();
		String matchStr = "";
		
		char[] paraChar = para.toCharArray();
		char[] corposChar = corposPara[0].toCharArray();
		
		for(int i=0; i<corposLen-paraLen ; i++){
			
			int j = 0;
			for (j = 0; j < paraLen; j++)
	            if (corposChar[i+j] != paraChar[j])
	                break;
	 
	        if (j == paraLen){  // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
	          //System.out.println(para+" Pattern found at "+i);
	          matchStr = para+" Pattern found at "+i + " in "+fileName;
	          matchingPatterns.add(matchStr);
	        }
			
		}
		
		
		return matchingPatterns;
	}
	
}
