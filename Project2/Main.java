package Project2;

import java.io.IOException;
import java.util.Arrays;

public class Main  extends Cal{

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		Merge merge = new Merge();
		merge.MergeFiles();
		
		
			Filter filter = new Filter();
			filter.filterFiles();
			
			Cal cal = new Cal();
			int numArr[] = cal.calFiles();
			
	     	Arrays.sort(numArr);
			divideHalf(numArr);		
			printResult(numArr);
		

		
	}

}
