package Merge;

import java.io.IOException;
import java.util.Arrays;

public class FinalMain2 extends cal2{
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		merge merge = new merge();
		merge.MergeFiles();
		
		filter filter = new filter();
		filter.filterFiles();
		
		cal2 cal2 = new cal2();
		int numArr[] = cal2.calFiles();
     	Arrays.sort(numArr);
		divideHalf(numArr);		
		printResult(numArr);
	}

}
