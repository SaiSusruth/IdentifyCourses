package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Coursespage extends Basepage {
	
	public Coursespage(WebDriver driver) {
		super(driver);
		
	}

@FindBy(xpath="//*[@class='cds-CommonCard-title css-1sktkql']")
List<WebElement> courses;


@FindBy(xpath="(//*[@class='cds-CommonCard-title css-1sktkql'])[1]")
WebElement first_course;

@FindBy(xpath="(//*[@class='cds-119 css-11uuo4b cds-121'])[1]")
WebElement rating1;

@FindBy(xpath="(//*[@class=' css-10r3ar9'])[1]")
WebElement duration1;

@FindBy(xpath="(//*[@class='cds-CommonCard-title css-1sktkql'])[2]")
WebElement second_course;

@FindBy(xpath="(//*[@class='cds-119 css-11uuo4b cds-121'])[2]")
WebElement rating2;

@FindBy(xpath="(//*[@class=' css-10r3ar9'])[2]")
WebElement duration2;

public List<WebElement> courses()
{
	return courses;
}
public String first_coursename()
{
	return first_course.getText();
}
public String first_rating()
{
	return rating1.getText();
}

public String first_duration()
{
	String D1=duration1.getText();
	return (D1.substring(D1.lastIndexOf("·")+1));
}

public String second_coursename()
{
	return second_course.getText();
}
public String second_rating()
{
	return rating2.getText();
}

public String second_duration()
{
	String D2=duration2.getText();
	return (D2.substring(D2.lastIndexOf("·")+1));
}
	}