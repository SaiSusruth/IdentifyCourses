package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjects.LanguageLearningPage;
import factory.BaseClass;
import Utility.excel;
import io.cucumber.java.en.*;

public class LanguageLearning extends BaseClass {
	LanguageLearningPage lp;

	
	@Given("the user is navigated to Language learning page")
	public void the_user_is_navigated_to_language_learning_page() throws InterruptedException {
		 lp=new LanguageLearningPage(driver);
		 lp.lang_learn();
	}

	@Then("the user should print all the levels with its count")
	public void the_user_should_print_all_the_levels_with_its_count() throws IOException {
		lp=new LanguageLearningPage(driver);
		List<WebElement>Levels=lp.levels();
		int c=Levels.size();
		System.out.println("");
		System.out.println("Total number of levels:"+c);
		excel.setcelldata("Sheet2", "LEVELS",0 , 1);
		
		for(int i=0;i<c;i++)
		{
			String level=Levels.get(i).getText();
			System.out.println(level);
			excel.setcelldata("Sheet2", level,i+1, 1);
		}
		
	}

	@Then("user clicks on show all button in language section,it should display all the languages.")
	public void user_clicks_on_show_all_button_in_language_section_it_should_display_all_the_languages() {
		lp=new LanguageLearningPage(driver);
		WebElement show_all=lp.show();
		JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", show_all);
	}

	@Then("the user should print all the languages with its count in the console.")
	public void the_user_should_print_all_the_languages_with_its_count_in_the_console() throws IOException {
		lp=new LanguageLearningPage(driver);
		List<WebElement>langs=lp.languages();
		int count=langs.size();
		System.out.println("");
		System.out.println("The total count of languages:"+count);
		excel.setcelldata("Sheet2", "LANGUAGES",0 , 2);
		
		for(int i=0;i<count;i++)
		{
			String lang=langs.get(i).getText();
			System.out.println(lang);
			excel.setcelldata("Sheet2", lang,i+1 , 2);
		}
		
	}



}
