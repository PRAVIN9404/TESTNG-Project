package Firest.TestNG;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitDemo {
	WebDriver driver;
	public void setup() throws IOException
	{
		String path=System.getProperty("user.dir");
		String filepath=path+"\\test.properties";
		String browserpath=path+"\\chromedriver.exe";
		
		FileReader fread=new FileReader(filepath);
		Properties p=new Properties();
		p.load(fread);
		String value = p.getProperty("baseurl");
		System.setProperty("wedriver.chrome.driver", browserpath);
		 driver=new ChromeDriver();
		driver.get(value);
	}
	public void links()
	{
		driver.FindElements
	}

}
