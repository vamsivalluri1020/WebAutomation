package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	//Properties for locating elements
	public RemoteWebDriver driver;
	
	@FindBy(how=How.XPATH,using="//*[text()='Create account']")
	public WebElement signup;
	
	@FindBy(how=How.XPATH,using="//*[text()='For myself']")
	public WebElement myself;
	
	@FindBy(how=How.NAME,using="identifier")
	public WebElement uid;
	
	@FindBy(how=How.XPATH,using="//*[text()='Next']/parent::*")
	public WebElement uidnext;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Enter an email')]")
	public WebElement blankuiderr;
	
	@FindBy(how=How.XPATH,using=
		"//div[contains(text(),'find your Google Account') or contains(text(),'Enter a valid email')]")
	public WebElement invaliduiderr;
	
	//Constructor method for connecting runner classes
	public HomePage(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Operational methods to operate elements
	public void signupclick()
	{
		signup.click();
	}
	
	public void myselfclick()
	{
		myself.click();
	}
	
	public void uidfill(String x)
	{
		uid.sendKeys(x);
	}
	
	public void uidnextclick()
	{
		uidnext.click();
	}
}



