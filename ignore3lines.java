package exel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

public class MakeNewFile {

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      File dir = new File("C:\\Users\\kopo37\\OneDrive\\바탕 화면\\a");
      FileWriter fw = new FileWriter("C:\\Users\\kopo37\\OneDrive\\바탕 화면\\a\\merge3.csv", true);

      BufferedReader br = new BufferedReader(
            new FileReader("C:\\Users\\kopo37\\OneDrive\\바탕 화면\\a\\아파트(매매)__실거래가_2013.csv"));
      
      //Stream<String> lines = br.lines().skip(10);
      
      
      
      
      int count = 0;

      String line = br.readLine();
      String line1 = br.readLine();
      String line2 = br.readLine();
      
      while ((line =br.readLine()) != null && (line1 =br.readLine()) != null && (line2 =br.readLine()) != null) {
         fw.write(line + "\n");
         line = br.readLine();
         line1 = br.readLine();
         line2 = br.readLine();
      }
      fw.flush();

   }



}