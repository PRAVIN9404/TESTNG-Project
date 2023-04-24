package GoogleMap;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.sound.sampled.spi.AudioFileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TablesOnWebPage {
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
		
		String value=p.getProperty("tableurl");
		System.setProperty("webdriver.chrome.driver", browserpath);
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		 driver=new ChromeDriver(option);
		 driver.get(value);
		
		
	}
	@Test
	public void tables()
	{
		List<WebElement> main = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]"));
		for (WebElement j:main)
		{
			String cp = j.findElement(By.xpath("td[3]")).getText();
			String cp1=j.findElement(By.xpath("td[4]")).getText();
			System.out.println(cp+"  "+cp1);
		}
	}

}
