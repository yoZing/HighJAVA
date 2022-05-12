package exercise;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class F {
	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fis = new FileInputStream("d:/D_Other/Tulips.jpg");
			 
		FileOutputStream fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");
			
		int c;
			 
		while((c=fis.read()) != -1) {
			 fos.write(c);
		}
			 
			fis.close();
			fos.close();
	
	
	
	}
	
}
