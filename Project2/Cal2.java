package Project2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;import java.time.Year;
import java.util.Arrays;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Cal2 {
	static double percentile;
	static int quart1, half, quart3, full;
	static int[] lowerHalf, upperHalf;
	int[] arr;
	static String [] inputYear = {"2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"};
	
	public static  String[] calFiles() throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\양규희\\Desktop\\filesforpj1\\filter.csv"));
		String line = br.readLine();
		 int cnt = 0;
		 int num = 0;
		 Path path = Paths.get("C:\\Users\\양규희\\Desktop\\filesforpj1\\filter.csv");
		 int lineCount = (int) Files.lines(path).count();
		 String[] lines = new String[lineCount];
		 
		 int [] numArr = new int[lineCount];
		 int [] numYear = new int[lineCount];
		 while ((line = br.readLine()) != null) {
            if(line.contains(",")) {
                line = line.replaceAll(",","");
            }
                lines[cnt] = line;
                cnt++;
   		 }
		 
	     return lines;
  }
	
	public static void divideHalf(int[] arr) {

		if (arr.length % 2 == 0) {
			lowerHalf = Arrays.copyOfRange(arr, 0, (arr.length / 2));
			upperHalf = Arrays.copyOfRange(arr, (arr.length / 2), (arr.length));

		} else if (arr.length % 2 == 1) {
			lowerHalf = Arrays.copyOfRange(arr, 0, (arr.length / 2));
			upperHalf = Arrays.copyOfRange(arr, (arr.length / 2) + 1, (arr.length));
		}

		quart1 = median(lowerHalf);
		half = median(arr);
		quart3 = median(upperHalf);
		full = arr[arr.length - 1];

	}

	public static int median(int[] arr) {
		int arrLength = arr.length;
		if (arrLength % 2 == 1) {
			return arr[arrLength / 2];
		} else {
			return (arr[arrLength / 2 - 1] + arr[arrLength / 2]) / 2;
		}
	}

	public static void printResult(int[] arr) {

		System.out.println("1분위값 : " + quart1);
		System.out.println("2분위값 : " + half);
		System.out.println("3분위값 : " + quart3);
		System.out.println("4분위값 : " + full);

	}

}
