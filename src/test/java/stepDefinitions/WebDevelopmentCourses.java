package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjects.Coursespage;
import PageObjects.WebDevelopmentSearchPage;
import factory.BaseClass;
import Utility.excel;
import io.cucumber.java.en.*;

public class WebDevelopmentCourses extends BaseClass {
	
	
@Given("the user is navigated to coursera home page")
public void the_user_is_navigated_to_coursera_home_page() throws InterruptedException, IOException {
	 WebElement logo=driver.findElement(By.xpath("//img[@alt='Coursera']"));
	 Assert.assertTrue(logo.isDisplayed());
    
}

@When("user searches for webdevelopment courses,it should display all the web development courses")
public void user_searches_for_webdevelopment_courses_it_should_display_all_the_web_development_courses() {
	WebDevelopmentSearchPage ws=new WebDevelopmentSearchPage(driver);
	
	ws.search();
	ws.search_btn();
}

@Then("the user clicks on English and Beginner checkbox,it should display the courses according to the filters.")
public void the_user_clicks_on_english_and_beginner_checkbox_it_should_display_the_courses_according_to_the_filters() throws IOException {
	WebDevelopmentSearchPage ws=new WebDevelopmentSearchPage(driver);
	ws.check();
	Coursespage cp=new Coursespage(driver);
	List<WebElement>Courses=cp.courses();
	System.out.println("");
	excel.setcelldata("Sheet2", "COURSES",0 , 0);
	for(int c=0;c<Courses.size();c++)
	{
		String course=Courses.get(c).getText();
		System.out.println(course);
		excel.setcelldata("Sheet2", course, c+1, 0);
	}
}

@Then("the user should extract the details of first two courses.")
public void the_user_should_extract_the_details_of_first_two_courses() {
	Coursespage cp=new Coursespage(driver);
	System.out.println("");

	System.out.println("Course Name:"+cp.first_coursename());
	System.out.println("Rating:"+cp.first_rating());
	System.out.println("Duration:"+cp.first_duration());
	
	System.out.println("");
	
	System.out.println("Course Name:"+cp.second_coursename());
	System.out.println("Rating:"+cp.second_rating());
	System.out.println("Duration:"+cp.second_duration());
	
}




}
