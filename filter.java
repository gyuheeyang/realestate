package Merge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class filter{ 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedReader read = new BufferedReader(
				new FileReader("C:\\Users\\�����\\Desktop\\filesforpj1\\realEstateTransaction.csv"));
		String line;
		
		// ��ģ ���� �� ���� ���� 
        PrintWriter pw = new PrintWriter("C:\\Users\\�����\\Desktop\\filesforpj1\\filter.csv");
		
		// �Է� �� �ޱ�
		System.out.println("�˻� �ϰ� ���� ����(ex.������)");
		String loc = sc.next();
		System.out.println("ù��° ��¥�� �Է����ּ���.(ex.202003)");
		int firstDay = sc.nextInt();
		System.out.println("�ι�° ��¥�� �Է����ּ���.(ex.202004)");
		int secondDay = sc.nextInt();

		ArrayList<Integer> output = new ArrayList<Integer>();
		while ((line = read.readLine()) != null) {
			String[] cutLine = line.split("\\|");
			int date = Integer.parseInt(cutLine[6]);
			if (cutLine[0].contains(loc)) {
				if (date >= firstDay && date <= secondDay) {

					try {
						 pw.println(cutLine[8]);
						System.out.println(cutLine[8]);
						pw.flush();
					} catch (Exception e) {
					}
				}
			}
		}
	}
	
}