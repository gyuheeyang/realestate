import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		MergeFiles();
		
	}
		
	
	public static void MergeFiles() throws IOException {
		//���丮 ���� 
        File dir = new File("C:\\Users\\kopo37\\OneDrive\\���� ȭ��\\filesforpj");
		
        // ��ģ ���� �� ���� ���� 
        PrintWriter pw = new PrintWriter("C:\\Users\\kopo37\\OneDrive\\���� ȭ��\\filesforpj\\realEstateTransaction3.csv");
		
        
        //��� ���ϵ��� ����Ʈ�� String Array�� ����
        String[] fileNames = dir.list();
        
        
         for (String fileName : fileNames) {
        	 System.out.println("Reading from " + fileName);	//�ܼ�â�� ���� �̸� ��� 
        	 
        	 // create instance of file from Name of
             // the file stored in string Array
             File f = new File(dir, fileName);
             
             // create object of BufferedReader
             BufferedReader br = new BufferedReader(new FileReader(f));
             pw.println("Contents of file " + fileName);	//�����Ǵ� ���� ���� ������ ���� ���� �̸� ǥ�� (���� ���Ͽ� �� ǥ�� ����/ �ּ�ó��) 
             
             
			String line = br.readLine();
			int cnt = 0;

			while ((line = br.readLine()) != null) {
				
				if (cnt >= 13) {
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
					
					
					if ((line = br.readLine()) != null) {
						pw.println(line);
						System.out.println(line);
					}
					
				}
				cnt++;
			} 
			pw.flush();
         }
        
         //�۾� �Ϸ�� �ܼ�â�� ǥ�� 
         System.out.println("Reading from all files" +
        	        " in directory " + dir.getName() + " Completed");
	}
		
		
}


