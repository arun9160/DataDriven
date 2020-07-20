package pck1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class New {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\WorkSpace\\Sample\\Libs\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
		
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		//           driver.findElement(By.cssSelector("select[name='state']")).click();
		for(int i =0; i<=10;i++) {
		Select s = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		
		s.selectByIndex(i);
		
		//s.deselectByIndex(i);
		}
		
	}

}
