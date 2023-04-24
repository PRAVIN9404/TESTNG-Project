package allseleniumpractice;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectClass {
	WebDriver driver;
	@BeforeTest
	public void setup() throws IOException
	{
		String path=System.getProperty("user.dir");
		String filepath=path+"\\test.properties";
		String browserpath=path+"\\chromedriver.exe";
		
		FileReader fread=new FileReader(filepath);
		Properties p=new Properties();
		p.load(fread);
		
		String value=p.getProperty("Selectclass");
		System.setProperty("webdriver.chrome.driver", browserpath);
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		 driver=new ChromeDriver(option);
		 driver.get(value);
	}
	
	@Test
	public void selectclass() throws InterruptedException
	{
		WebElement drop_dwon = driver.findElement(By.xpath("//select[@name='country']"));
		
		Select s=new Select(drop_dwon);
		
		s.selectByVisibleText("AMERICAN SAMOA");
	
		
		//Thread.sleep(5000);
		//s.selectByVisibleText("ANDORRA");
	}

}
