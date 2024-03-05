package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.FormPage;
import factory.BaseClass;
@Listeners(Utility.extentReports.class)
public class TC_03FillingForm extends BaseClass{

	
	@Test(priority=9,groups= {"sanity"})
	public void form() throws IOException
	{
		FormPage fp=new FormPage(driver);
		fp.Firstname();
		fp.Lastname();
		fp.Email();
		fp.Phone();
		fp.Ins_type();
		fp.Ins_name();
		fp.Job();
		fp.Dept();
		fp.Desc();
		fp.Country();
		fp.State();
		screenshot("form");
		//fp.submit();
		WebElement Submit=fp.submit();
		JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", Submit);
		
		
	}
	@Test(priority=10,groups= {"sanity"})
	public void error_msg() throws IOException
	{
		FormPage fp=new FormPage(driver);
		String Error=fp.Errormsg();
		screenshot("error_msg");
		System.out.println("");
		System.out.println(Error);
	}


	}

