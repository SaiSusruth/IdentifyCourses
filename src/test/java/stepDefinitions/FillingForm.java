package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjects.FormPage;
import PageObjects.LanguageLearningPage;
import factory.BaseClass;
import io.cucumber.java.en.*;

public class FillingForm extends BaseClass {
		LanguageLearningPage lp;

@Given("the user is navigated to enterprises page")
public void the_user_is_navigated_to_enterprises_page() throws InterruptedException, IOException {
	lp=new LanguageLearningPage(driver);
	WebElement business=lp.Enterprise();
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", business);
	Thread.sleep(2000);
	
}

@Then("the user clicks on the solutions and click on course era for campus.")
public void the_user_clicks_on_the_solutions_and_click_on_course_era_for_campus() throws InterruptedException {
	lp.solutions();
	Thread.sleep(3000);
}

@Then("the user should fill the form with valid details except for mail.")
public void the_user_should_fill_the_form_with_valid_details_except_for_mail() throws IOException {
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
	WebElement Submit=fp.submit();
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", Submit);
	
}

@Then("an error msg will be displayed for the mail and user have to capture that msg and display it")
public void an_error_msg_will_be_displayed_for_the_mail_and_user_have_to_capture_that_msg_and_display_it() throws IOException {
	FormPage fp=new FormPage(driver);
	String Error=fp.Errormsg();
	System.out.println("");
	System.out.println(Error);
}



}
