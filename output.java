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
      File dir = new File("C:\\Users\\kopo\\Desktop\\�� ����");
      FileWriter fw = new FileWriter("C:\\Users\\kopo\\Desktop\\�� ����\\merge.csv", true);
      
         BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\�� ����\\����Ʈ(�Ÿ�)__�ǰŷ���_2017.csv"));
   
         int count = 0;
         
         String line = br.readLine();
         while (line != null) {
            fw.write(line + "\n");      
            line = br.readLine();
   
         }
         fw.flush();
      }
   
}