package TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.LanguageLearningPage;
import factory.BaseClass;
import Utility.excel;
@Listeners(Utility.extentReports.class)
public class TC_02LanguageLearning extends BaseClass {
	
	LanguageLearningPage lp;
	
	
	@Test(priority=5,groups= {"regression"})
	public void lang_learn() throws InterruptedException
	{
		 lp=new LanguageLearningPage(driver);
		 lp.lang_learn();
		
		
	}
	   
	//Extract all the languages and different levels with its total count & display them

	@Test(priority=6,groups= {"regression"})
	public void levels() throws IOException
	{
		lp=new LanguageLearningPage(driver);
		List<WebElement>Levels=lp.levels();
		int c=Levels.size();
		System.out.println("");
		System.out.println("Total number of levels:"+c);
		excel.setcelldata("Sheet1", "LEVELS",0 , 1);
		
		for(int i=0;i<c;i++)
		{
			String level=Levels.get(i).getText();
			System.out.println(level);
			excel.setcelldata("Sheet1", level,i+1, 1);
		}
		screenshot("levels");
		
	}

	@Test(priority=7,groups= {"regression"})
	public void languages() throws IOException
	{
		lp=new LanguageLearningPage(driver);
		WebElement show_all=lp.show();
		JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", show_all);
		List<WebElement>langs=lp.languages();
		int count=langs.size();
		System.out.println("");
		System.out.println("The total count of languages:"+count);
		excel.setcelldata("Sheet1", "LANGUAGES",0 , 2);
		screenshot("language");
		
		for(int i=0;i<count;i++)
		{
			String lang=langs.get(i).getText();
			System.out.println(lang);
			excel.setcelldata("Sheet1", lang,i+1 , 2);
		}
		
		
		
	}

	//go to "For Enterprise"; Look into Courses for Campus under Product; Fill the  "Ready to transform" form with any one input invalid (example: email); Capture the error message & display
	@Test(priority=8,groups= {"sanity","regression"})
	public void enterprise() throws InterruptedException, IOException
	{
		lp=new LanguageLearningPage(driver);
		WebElement business=lp.Enterprise();
		JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", business);
		Thread.sleep(2000);
		screenshot("Enterprise");
		lp.solutions();
		screenshot("coursera for campus");
		Thread.sleep(3000);
		
	}

}
