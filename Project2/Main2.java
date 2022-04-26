package Project2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 extends Cal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Merge merge = new Merge();
		merge.MergeFiles();
		int chooseMenu = 0;
		System.out.println("Choose Menu");
		Scanner scan = new Scanner(System.in);
		chooseMenu = scan.nextInt();

		if (chooseMenu == 1) {
			Filter filter = new Filter();
			filter.filterFiles();

			Cal cal = new Cal();
			int numArr[] = cal.calFiles();

			Arrays.sort(numArr);
			divideHalf(numArr);
			printResult(numArr);

		} else if (chooseMenu == 2) {
			Filter2 filter2 = new Filter2();
			int[] date = filter2.filterFiles();
			for (int i = 0; i < date.length; i++) {
//	            	System.out.println("date" + date[i]);
			}

			Cal2 cal2 = new Cal2();
			String numArr[] = cal2.calFiles();
			for (int i = date[0]; i <= date[1]; i++) {
				System.out.print(i + "³â\n");
				calBoxplot(numArr, i);
			}

		} else if (chooseMenu == 3) {
			SquarePrice squarePrice = new SquarePrice();
			squarePrice.SquarePriceFiles();
			
		} else {
			System.out.println("Wrong choice");
		}

	}

	public static void calBoxplot(String[] numData, int year) {
		int count = 0;
		for (int i = 0; i < numData.length; i++) {
//			System.out.println("numData:" + numData[i]);
			if (numData[i] != null) {
				int yy = Integer.parseInt(numData[i].split("\\|")[1]);
//				System.out.println("yy:" + yy);
//				System.out.println("year:" + year);
				if (yy == year) {
					count++;
				}
			}
		}
//		System.out.println("count:" + count);
		int[] numArr = new int[count];
		int count2 = 0;
		for (int i = 0; i < numData.length; i++) {
			if (numData[i] != null) {
				int yy = Integer.parseInt(numData[i].split("\\|")[1]);
				if (yy == year) {
					numArr[count2] = Integer.parseInt(numData[i].split("\\|")[0]);
					count2++;
				}
			}
		}
		Arrays.sort(numArr);
		divideHalf(numArr);
		printResult(numArr);
	}
}
