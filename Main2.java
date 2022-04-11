package Merge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		MergeFiles();
		
	}
	
	public static void MergeFiles () throws IOException {
		  File dir = new File("C:\\Users\\양규희\\Desktop\\filesforpj1");
	      
	        // 합친 내용 들어갈 파일 생성 
	        PrintWriter pw = new PrintWriter("C:\\Users\\양규희\\Desktop\\filesforpj1\\realEstateTransaction.csv");
	      
	        //모든 파일들을 리스트로 String Array에 담음
	        String[] fileNames = dir.list();
	        
	         for (String fileName : fileNames) {
	            System.out.println("Reading from " + fileName);   //콘솔창에 파일 이름 출력 
	            
	             File f = new File(dir, fileName);
	             
	             //BufferedReader 객체 생성 
	             BufferedReader br = new BufferedReader(new FileReader(f));
	             //생성되는 파일 내에 구분을 위해 파일 이름 표시 (실제 파일엔 이 표시 없음/ 주석처리) 
	             //pw.println("Contents of file " + fileName);   
	             
	         String line = br.readLine();
	         int cnt = 0;

	         while ((line = br.readLine()) != null) {
	            
	            if (cnt >= 16) {
	               line = br.readLine();
	               System.out.println(line);
	               
	               try {
	                  if(line.contains("\",\"")) {
	                     line = line.replaceAll("\",\"", "|");
	                  }
	               } catch (Exception e){
	                  System.out.println("Error");
	               }
	               
	               try {
	                  if(line.contains("\"")) {
	                     line = line.replaceAll("\"", "");
	                  }
	               }catch (Exception e) {
	                  System.out.println("Error");
	               }
	               
	               
	                  pw.println(line);
	                  System.out.println(line);
	               
	               
	            }
	            cnt++;
	         } 
	         pw.flush();
	         }
	         //작업 완료시 콘솔창에 표시 
	         System.out.println("Reading from all files" +
	                   " in directory " + dir.getName() + " Completed");

	}

}
