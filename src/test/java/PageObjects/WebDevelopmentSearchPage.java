package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebDevelopmentSearchPage extends Basepage {
	
		public WebDevelopmentSearchPage(WebDriver driver) {
		      super(driver);
	
		}
		
@FindBy(xpath="//input[@placeholder='What do you want to learn?']")
WebElement search;

@FindBy(xpath="//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']")
WebElement btn;

@FindBy(xpath="//span[@class='cds-checkboxAndRadio-labelContent css-imksha']//*[contains(text(),'English')]")
WebElement eng;
	

@FindBy(xpath="//span[@class='cds-checkboxAndRadio-labelContent css-imksha']//*[contains(text(),'Beginner')]")
WebElement beg;

public void search()
{
	search.sendKeys("web development courses");
}

public void search_btn()
{
	btn.click();
}
public void check()
{
	eng.click();
	beg.click();
}
}
