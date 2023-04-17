package Firest.TestNG;

import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GitDemo {
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
		String value = p.getProperty("baseurl");
		System.setProperty("wedriver.chrome.driver", browserpath);
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		 driver=new ChromeDriver(option);
		driver.get(value);
	}
	@Test
	public void links() throws IOException
	{
		List<WebElement> image = driver.findElements(By.tagName("img"));
		System.out.println(image.size());
		
		for(int i=0;i<image.size();i++)
		{
			try
			{

				WebElement element = image.get(i);
				String images = element.getAttribute("src");
				
				URL url=new URL(images);
				HttpURLConnection urlconn=(HttpURLConnection)url.openConnection();
				urlconn.connect();
				int rescode = urlconn.getResponseCode();
				if(rescode>400)
				{
					System.out.println("images are broken.."+images);
				}
				else
				{
					System.out.println("images are valid.."+images);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
