package Merge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class filter {
	public static void filterFiles() throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedReader read = new BufferedReader(
				new FileReader("C:\\Users\\양규희\\Desktop\\filesforpj1\\realEstateTransaction.csv"));
		String line;

		// 합친 내용 들어갈 파일 생성
		PrintWriter pw = new PrintWriter("C:\\Users\\양규희\\Desktop\\filesforpj1\\filter.csv");

		// 입력 값 받기
		System.out.println("검색 하고 싶은 동네(ex.강남구)");
		String loc = sc.nextLine();
		System.out.println("첫번째 날짜를 입력해주세요.(ex.202003)");
		int firstDay = sc.nextInt();
		System.out.println("두번째 날짜를 입력해주세요.(ex.202004)");
		int secondDay = sc.nextInt();

		ArrayList<Integer> output = new ArrayList<Integer>();
		while ((line = read.readLine()) != null) {
		
			String[] cutLine = line.split("\\|");
			
//			System.out.println("0" + cutLine[0]);			
//			System.out.println("6" + cutLine[6]);
//			System.out.println("8" + cutLine[8]);
//			System.out.println("length" + cutLine.length);
			
//			String[] newLine = new String[14];
//			for (int i =0; i <cutLine.length; i++) {
//				newLine[i] = cutLine[]
//			}
			int date=0;
			try {
				date = Integer.parseInt(cutLine[6]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			

			if (cutLine[0].contains(loc) == true) {
				if (date >= firstDay && date <= secondDay) {

					try {
						pw.println(cutLine[8]);
						pw.flush();
					} catch (Exception e) {
					}
				}
			} else {

			}
		}

	}

}
