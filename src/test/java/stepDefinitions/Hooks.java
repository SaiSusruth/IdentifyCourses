package stepDefinitions;

import java.io.File;
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

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Scenario;
 
 
public class Hooks extends BaseClass {
 
	 public static WebDriver driver;
	 
	
	@BeforeAll
    public static void setup() throws IOException, InterruptedException
    {
		BaseClass.driver_setup( getProperties().getProperty("browser") );
    }


    @AfterAll
    public static void tearDown() {
       BaseClass.close_browser();
    }
    
 
 
    @AfterStep
    public void addScreenshot(Scenario scenario) {
    	// this is for cucumber junit report
            driver=BaseClass.driver;
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	
        
    }
}