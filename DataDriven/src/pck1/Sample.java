package pck1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Sample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties pr = new Properties();
		FileInputStream fis = new FileInputStream("E:\\WorkSpace\\Sample\\src\\data.properties");
		pr.load(fis);
		System.out.println(pr.getProperty("browser"));
		System.out.println(pr.getProperty("url"));
		pr.setProperty("browser","Firefox");
		System.out.println(pr.getProperty("browser"));
		
		
		FileOutputStream fout = new FileOutputStream("E:\\WorkSpace\\Sample\\src\\data.properties");
		pr.store(fout, null);
	}
}
