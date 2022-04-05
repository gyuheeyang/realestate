package project2;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class output {

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      // merge2 marge2 = new merge2;
      File dir = new File("C:\\Users\\kopo\\Desktop\\새 폴더");
      FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\새 폴더\\merge.csv", true);
      
         BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\새 폴더\\아파트(매매)__실거래가_2017.csv"));
   
         int count = 0;
         
         String line = br.readLine();
         while (line != null) {
            fw.write(line + "\n");      
            line = br.readLine();
   
         }
         fw.flush();
      }
   
}