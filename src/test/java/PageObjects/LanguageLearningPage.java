package PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageLearningPage extends Basepage {
	WebDriver driver;

	public LanguageLearningPage(WebDriver driver) {
		super(driver);
		
	}

@FindBy(xpath="//input[@placeholder='What do you want to learn?']")
WebElement l_search;


@FindBy(xpath="//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']")
WebElement btn;


@FindBy(xpath="//*[@aria-label='Show more Language options']")
WebElement show_all;


@FindBy(xpath="//div[@id='checkbox-group']//*[@class='cds-checkboxAndRadio-labelContent css-imksha']/span")
List<WebElement> languages;


@FindBy(xpath="//*[@data-testid='search-filter-group-Level']//*[@class='cds-checkboxAndRadio-labelContent css-imksha']/span")
List<WebElement> levels;

@FindBy(xpath="//*[@id=\"rendered-content\"]/div/div/span/div[1]/header/div[1]/div/div/div[1]/div[1]/div/div/div/div/div/div/a[2]")
WebElement business;

@FindBy(xpath="//a[normalize-space()='Solutions']")
WebElement sol;

@FindBy(xpath="//p[normalize-space()='Coursera for Campus']")
WebElement campus;

public void lang_learn() throws InterruptedException
{
	l_search.sendKeys(Keys.CONTROL+"a");
	l_search.sendKeys(Keys.DELETE);
	Thread.sleep(3000);
	l_search.sendKeys("language learning");
	btn.click();
	Thread.sleep(2000);
}
public WebElement show()
{

	return show_all;
}
public List<WebElement> languages()
{

	
	return languages;
}

public List<WebElement> levels()
{ 
	return levels;
}

public WebElement Enterprise() throws InterruptedException
{

	return business;
	
}
public void solutions()
{
	
	sol.click();
	campus.click();
}


}
