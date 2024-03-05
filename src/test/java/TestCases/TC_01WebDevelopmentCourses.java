package TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.Coursespage;
import PageObjects.WebDevelopmentSearchPage;
import factory.BaseClass;
import Utility.excel;
@Listeners(Utility.extentReports.class)
public class TC_01WebDevelopmentCourses extends BaseClass {
	
	
	
	@Test(priority=0,groups= {"sanity"})
	public void search() throws IOException
	{
		WebDevelopmentSearchPage ws=new WebDevelopmentSearchPage(driver);
		
		ws.search();
		ws.search_btn();
		screenshot("search");
		
	}
	//1. Should be for beginners level.
	//2. Courses offered in English language
	@Test(priority=1,groups= {"sanity"})
	public void filters()
	{
		WebDevelopmentSearchPage ws=new WebDevelopmentSearchPage(driver);
		ws.check();
	}


	//display all courses
	@Test(priority=2,groups= {"sanity"})
	public void courses() throws IOException 
	{
		Coursespage cp=new Coursespage(driver);
		List<WebElement>Courses=cp.courses();
		System.out.println("");
		excel.setcelldata("Sheet1", "COURSES",0 , 0);
		screenshot("Courses");
		
		for(int c=0;c<Courses.size();c++)
		{
			String course=Courses.get(c).getText();
			System.out.println(course);
			excel.setcelldata("Sheet1", course, c+1, 0);
		}
		
	}
	@Test(priority=3,groups= {"sanity"})
	public void firstcourse() 
	{
		Coursespage cp=new Coursespage(driver);
		System.out.println("");
		
		System.out.println("Course Name:"+cp.first_coursename());
		System.out.println("Rating:"+cp.first_rating());
		System.out.println("Duration:"+cp.first_duration());
		
	}
	@Test(priority=4,groups= {"sanity"})
	public void secondcourse()
	{
		Coursespage cp=new Coursespage(driver);
		System.out.println("");
		System.out.println("Course Name:"+cp.second_coursename());
		System.out.println("Rating:"+cp.second_rating());
		System.out.println("Duration:"+cp.second_duration());
		
		
		
	}

	

}
