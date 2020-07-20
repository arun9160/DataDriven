package pck1;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.Format;
import java.util.Formatter;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataDriven {

	static WebDriver driver;
	static WebDriverWait wait;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFCell cell;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\WorkSpace\\Sample\\Libs\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");

		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, 30);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Import excel sheet.

		File src = new File("E:\\WorkSpace\\Sample\\testDATA.xlsx");

		// Load the file.

		FileInputStream finput = new FileInputStream(src);

		// Load the workbook.

		workbook = new XSSFWorkbook(finput);

		// Load the sheet in which data is stored.

		sheet = workbook.getSheetAt(0);
		
		

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@name='first_name']")).clear();

			// Import data for firstname.

			cell = sheet.getRow(i).getCell(0);

			// cell.setCellType(Cell);

			driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(cell.getStringCellValue());

			// Import data for password.
			
			driver.findElement(By.xpath("//input[@name='last_name']")).clear();
			cell = sheet.getRow(i).getCell(1);
			driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(cell.getStringCellValue());
			
			driver.findElement(By.xpath("//input[@name='email']")).clear();
			cell = sheet.getRow(i).getCell(2);
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(cell.getStringCellValue());
			
			/*driver.findElement(By.xpath("//input[@name='phone]")).clear();
			cell = sheet.getRow(i).getCell(3);
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(cell.getStringCellValue());*/
			
			driver.findElement(By.xpath("//input[@name='address']")).clear();
			cell = sheet.getRow(i).getCell(4);
			driver.findElement(By.xpath("//input[@name='address']")).sendKeys(cell.getStringCellValue());
			
			driver.findElement(By.xpath("//input[@name='city']")).clear();
			cell = sheet.getRow(i).getCell(5);
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys(cell.getStringCellValue());
			
			
			
			Select s = new Select(driver.findElement(By.xpath("//select[@name='state']")));
			
			s.selectByIndex(i);
			
			
			
			
			driver.findElement(By.xpath("//input[@name='zip']")).clear();
			cell = sheet.getRow(i).getCell(7);
			DataFormatter df = new DataFormatter();
			String value = df.formatCellValue(cell);
			driver.findElement(By.xpath("//input[@name='zip']")).sendKeys(value);
			
			
			
			driver.findElement(By.xpath("//input[@name='website']")).clear();
			cell = sheet.getRow(i).getCell(8);
			driver.findElement(By.xpath("//input[@name='website']")).sendKeys(cell.getStringCellValue());
			
			driver.findElement(By.xpath("//textarea[@placeholder='Project Description']")).clear();
			cell = sheet.getRow(i).getCell(9);
			driver.findElement(By.xpath("//textarea[@placeholder='Project Description']")).sendKeys(cell.getStringCellValue());

		}
			driver.close();
	}

}
