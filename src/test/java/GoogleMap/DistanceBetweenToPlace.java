package GoogleMap;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DistanceBetweenToPlace {
	WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		DistanceBetweenToPlace d=new DistanceBetweenToPlace();
		d.Setup();
		d.map();

	}
	public void Setup() throws IOException
	{
		String path=System.getProperty("user.dir");
		String filepath=path+"\\Java.properties";
		String browserpath=path+"\\chromedriver.exe";
		
		FileReader fread=new FileReader(filepath);
		Properties p=new Properties();
		p.load(fread);
		String value = p.getProperty("baseurl");
		System.setProperty("webdriver.chrome.driver", browserpath);
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		 driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(value);
		
	}
	public void map() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@aria-label='Directions']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@class='tactile-searchbox-input'])[4]")).sendKeys("Mahabaleshwar, Maharashtra 412806");
		driver.findElement(By.xpath("(//input[@autocomplete='off'])[5]")).sendKeys("Kameri, 2746+V8F, Kameri, Maharashtra 415403");
	    driver.findElement(By.xpath("(//button[@data-tooltip='Search'])[2]")).click();
	    Thread.sleep(5000);
	    WebElement result = driver.findElement(By.xpath("(//div[@class='Fk3sm fontHeadlineSmall delay-light'])"));
	    System.out.println(result.getText());
	    WebElement result2 = driver.findElement(By.xpath("(//div[@class='XdKEzd'])[1]"));
	    System.out.println(result2.getText());
	}

}
