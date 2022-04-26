package Project2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SquarePrice2 {

	static String[] locationStrings = { "���α�", "�߱�", "��걸", "������", "������", "���빮��", "�߶���", "���ϱ�", "���ϱ�", "������", "�����",
			"����", "���빮��", "������", "��õ��", "������", "���α�", "��õ��", "��������", "���۱�", "���Ǳ�", "���ʱ�", "������", "���ı�", "������" };

	public static void SquarePriceFiles() throws IOException {
		BufferedReader read = new BufferedReader(
				new FileReader("C:\\Users\\�����\\Desktop\\filesforpj1\\realEstateTransaction.csv"));
		String line;

		// ��ģ ���� �� ���� ����
		PrintWriter pw = new PrintWriter("C:\\Users\\�����\\Desktop\\filesforpj1\\squarePrice.csv");

		int date = 0;

		double size = 0; // ����
		double price = 0; // �ŷ��ݾ�
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
				date = (Integer.parseInt(cutLine[6]) / 100); // date ��
				size = (Double.parseDouble(cutLine[5])); // ����
				price = Double.parseDouble(cutLine[8]); // �ŷ��ݾ�
//				System.out.print("date : " + date + "\n");
//				System.out.print("size : " + size + "\n");
//				System.out.print("price : " + price + "\n");
					if (cutLine[0].contains("������") == true) {
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
		System.out.println("��簡��: " + square);
		
	}

}
