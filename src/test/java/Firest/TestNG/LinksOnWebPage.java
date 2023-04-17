package Firest.TestNG;

import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LinksOnWebPage {
	WebDriver driver;
	@BeforeMethod
	public  void setup() throws IOException
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
		
	}
	@Test
	public void linkonpage() throws IOException
	{
		List<WebElement> links = driver.findElements(By.tagName("img"));
		System.out.println(links.size());
		
		for(int i=0;i<links.size();i++)
		{
			try
			{
				WebElement element = links.get(i);
				String link = element.getAttribute("src");
				
				URL url=new URL(link);
				HttpURLConnection httpconn=(HttpURLConnection)url.openConnection();
				httpconn.connect();
				int stcode = httpconn.getResponseCode();
				if(stcode>400)
				{
					System.out.println("links are broken.."+link);
					
				}
				else
				{
					System.out.println("links are valid.."+link);
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
		}
	}

}
