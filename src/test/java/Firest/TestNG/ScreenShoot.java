package Firest.TestNG;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;

public class ScreenShoot {
	WebDriver driver;
	@org.testng.annotations.Test
	public void setup() throws IOException
	{
		String path=System.getProperty("user.dir");
		String filepath=path+"\\test.properties";
		String browserpath=path+"\\chromedriver.exe";
		
		FileReader read=new FileReader(filepath);
		Properties p=new Properties();
		p.load(read);
		 String value=p.getProperty("baseurl");
		System.setProperty("webdriver.chrome.driver", browserpath);
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(value);
		
		Actions a=new Actions(driver);
		
		 WebElement actual = driver.findElement(By.xpath("(//a[@rel='noopener'])[8]"));
		 WebElement relative = driver.findElement(By.xpath("(//a[@rel='noopener'])[8]"));
		 a.scrollToElement(actual).build().perform();
		 
		 
		// Assert.assertEquals(actual, null);
		 
		 if( actual.equals(relative))
		 {
			 java.util.Date d=new java.util.Date();
			 SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
			 File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 try
			 {
				 FileUtils.copyFile(scrfile, new File("C:\\Users\\LA PC MASTER\\eclipse-workspace\\TestNG\\ScreenShoot\\"+sd.format(d)+".png"));
				 
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
		 }
		
	}

}
