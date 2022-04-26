package Project2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Filter2 {

	public static int[] filterFiles() throws IOException {
		// TODO Auto-generated method stub
		int[] ret = new int[2];
		Scanner sc = new Scanner(System.in);
		BufferedReader read = new BufferedReader(
				new FileReader("C:\\Users\\양규희\\Desktop\\filesforpj1\\realEstateTransaction.csv"));
		String line;

		// 합친 내용 들어갈 파일 생성
		PrintWriter pw = new PrintWriter("C:\\Users\\양규희\\Desktop\\filesforpj1\\filter.csv");

		// 입력 값 받기
		System.out.println("Input district for search (ex.강남구, 서초구, 송파구)");
	      String loc = sc.nextLine();
	      String[] locArr = loc.split(",");
	      
	      for (int i =0; i < locArr.length; i++) {
	    	  System.out.println(locArr[i]);
	      }
	      
	      System.out.println();
	      System.out.println("From year (ex.2006)");
	      int fromYear = sc.nextInt();
	      ret[0] = fromYear;
	      System.out.println();
	      System.out.println("To year (ex.2021)");
	      int toYear = sc.nextInt();      
	      ret[1] = toYear;

	      while ((line = read.readLine()) != null) {

	         String[] cutLine = line.split("\\|");
	         int date = 0;
	         try {
	            date = (Integer.parseInt(cutLine[6]) / 100);
	         } catch (Exception e) {
					// TODO: handle exception
				}

				for (int j = fromYear; j <= toYear; j++) {
					for (int i = 0; i < locArr.length; i++) {
						if (cutLine[0].contains(locArr[i]) == true) {
							if (date >= fromYear && date <= toYear) {
								try {
									pw.print(cutLine[8] + "|");
									pw.println(date);
									pw.flush();
								} catch (Exception e) {
								}
							}
						}
					}
				}
			}

			return ret;
		}

	}
