package Project2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SquarePrice2 {

	static String[] locationStrings = { "종로구", "중구", "용산구", "성동구", "광진구", "동대문구", "중랑구", "성북구", "강북구", "도봉구", "노원구",
			"은평구", "서대문구", "마포구", "양천구", "강서구", "구로구", "금천구", "영등포구", "동작구", "관악구", "서초구", "강남구", "송파구", "강동구" };

	public static void SquarePriceFiles() throws IOException {
		BufferedReader read = new BufferedReader(
				new FileReader("C:\\Users\\양규희\\Desktop\\filesforpj1\\realEstateTransaction.csv"));
		String line;

		// 합친 내용 들어갈 파일 생성
		PrintWriter pw = new PrintWriter("C:\\Users\\양규희\\Desktop\\filesforpj1\\squarePrice.csv");

		int date = 0;

		double size = 0; // 면적
		double price = 0; // 거래금액
		double square = 0;
		
		double sumPrice = 0;
		double sumSize = 0;
		
		int cnt = 0; 
		while ((line = read.readLine()) != null) {
			  if(line.contains(",")) {
	                line = line.replaceAll(",","");
	            }
			String[] cutLine = line.split("\\|");
			try {
				date = (Integer.parseInt(cutLine[6]) / 100); // date 값
				size = (Double.parseDouble(cutLine[5])); // 면적
				price = Double.parseDouble(cutLine[8]); // 거래금액
//				System.out.print("date : " + date + "\n");
//				System.out.print("size : " + size + "\n");
//				System.out.print("price : " + price + "\n");
					if (cutLine[0].contains("강남구") == true) {
						if (cutLine[6].contains("2006")== true) {
							sumPrice += price;
							sumSize += size;
//							System.out.println("price" + price);
						}
					}
			} catch (Exception e) {
				// TODO: handle exception
			}
			cnt++;
		}
		System.out.println("sumPrice: " + sumPrice);
		System.out.println("sumSize: " + sumSize);
		square = sumPrice / (sumSize / 3.3);
		System.out.println("평당가격: " + square);
		
	}

}
