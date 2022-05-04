package Project2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SquarePrice {

	static String[] locationStrings = { "���α�", "�߱�", "��걸", "������", "������", "���빮��", "�߶���", "���ϱ�", "���ϱ�", "������", "�����",
			"����", "���빮��", "������", "��õ��", "������", "���α�", "��õ��", "��������", "���۱�", "���Ǳ�", "���ʱ�", "������", "���ı�", "������" };

	static String[] yearCnt = {"2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", 
			"2021"};

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
		
//		double sumPrice = 0;
//		double sumSize = 0;
		double[][] squareArr = new double [locationStrings.length][yearCnt.length];
		double[][] sumPrice = new double [locationStrings.length][yearCnt.length];
		double[][] sumSize = new double [locationStrings.length][yearCnt.length];
		
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

				for (int j = 0; j <= yearCnt.length; j++) {
					if (cutLine[6].contains(yearCnt[j]) == true) {
						for (int i = 0; i < locationStrings.length; i++) {
							if (cutLine[0].contains(locationStrings[i]) == true) {
								sumPrice[i][j] += price;
								sumSize[i][j] += size;
//								squareArr[i][j] 
//								System.out.println();
								squareArr[i][j] = sumPrice[i][j] / (sumSize[i][j] / 3.3);
							}
						}
					}
//					square = sumPrice / (sumSize / 3.3);
//					System.out.print(locationStrings[i]);
//					System.out.println("�� ��簡��: " + square);
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
			cnt++;
		}
		
		
		for (int i = 0; i < yearCnt.length; i++) {
			System.out.println(yearCnt[i]);
			pw.print(yearCnt[i]+ "����\n"); 
			for (int j = 0; j < locationStrings.length; j++) {
				System.out.print(locationStrings[j]);
				System.out.println("�� ��簡��: " + squareArr[j][i]);
//				pw.print(locationStrings[j]+ "�� ��簡��," + squareArr[j][i]+"\n"); 
				pw.printf("%s, %f\n", locationStrings[j], squareArr[j][i]); 
//				System.out.println("sumPrice"+sumPrice[i] +"sumSize"+ sumSize[i]);
			}
		}
		
		pw.flush();
		pw.close();
		
		
//		System.out.println("sumPrice: " + sumPrice);
//		System.out.println("sumSize: " + sumSize);
//		square = sumPrice / (sumSize / 3.3);
//		System.out.println("��簡��: " + square);
		
	}

}
