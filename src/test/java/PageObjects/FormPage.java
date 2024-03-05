package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FormPage extends Basepage{

	public FormPage(WebDriver driver) {
		super(driver);
		
	}

@FindBy(id="FirstName")
WebElement fname;
@FindBy(id="LastName")
WebElement lname;
@FindBy(id="Email")
WebElement mail;
@FindBy(id="Phone")
WebElement phone;
@FindBy(id="Institution_Type__c")
WebElement Ins_type;
@FindBy(id="Company")
WebElement Ins_name;
@FindBy(id="Title")
WebElement job_role;
@FindBy(id="Department")
WebElement dept;
@FindBy(id="What_the_lead_asked_for_on_the_website__c")
WebElement desc;
@FindBy(id="Country")
WebElement country;
@FindBy(id="State")
WebElement state;
@FindBy(xpath="//button[@class='mktoButton']")
WebElement submit;
@FindBy(xpath="//*[@id='ValidMsgEmail']")
WebElement msg;

public void Firstname()
{
	fname.sendKeys("Testing");
}
public void Lastname()
{
	lname.sendKeys("Automation");
}
public void Email()
{
	mail.sendKeys("abc123");
}
public void Phone()
{
	phone.sendKeys("8686653973");
}
public void Ins_type()
{
	Select selects=new Select(Ins_type);
	selects.selectByIndex(1);
}
public void Ins_name()
{
	Ins_name.sendKeys("KL University");
}
public void Job()
{
	Select sl=new Select(job_role);
	sl.selectByVisibleText("Professor");
}
public void Dept()
{
	Select sls=new Select(dept);
	sls.selectByIndex(4);
}
public void Desc()
{
	Select s=new Select(desc);
	s.selectByVisibleText("Learner Support");
}
public void Country() 
{
	Select sel=new Select(country);
	sel.selectByVisibleText("India");
}
public void State()
{
	Select ss=new Select(state);
	ss.selectByVisibleText("Andhra Pradesh");
}
public WebElement submit()
{
	return submit;
}
public String Errormsg()
{
	return msg.getText();
}
}