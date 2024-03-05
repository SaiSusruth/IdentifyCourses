package factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;



public class BaseClass{
	
	
	public static WebDriver driver;
	static Properties p;
	
	
	@Parameters({"browser"})
	
   @BeforeTest(groups= {"sanity","regression"})
	public static WebDriver driver_setup(String br) throws InterruptedException, IOException {
		if(br.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("No matching browser");
	        driver=null;
		}
	    driver.get(getProperties().getProperty("appURL"));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.manage().window().maximize();
		return driver;
	}
	
	
	
	
	
	@AfterTest(groups= {"sanity","regression"})
	public static void close_browser() {
		
		driver.quit();
	}
	
	public static Properties getProperties() throws IOException
	{		 
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
        p=new Properties();
		p.load(file);
		return p;
	}
	
	
	public static String screenshot(String ssnum) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String name="C:\\Users\\2304117\\OneDrive - Cognizant\\Desktop\\IdentifyCourses\\src\\test\\java\\Screenshots\\ss_"+ssnum+".png";
		File trg=new File(name);
		FileUtils.copyFile(src, trg);
		return name;
	}
	
	
	

}