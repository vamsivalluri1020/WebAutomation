package pages;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationPage
{
	//Properties for locating elements
	public RemoteWebDriver driver;
	
	@FindBy(how=How.NAME,using="firstName")
	public WebElement fname;
	
	@FindBy(how=How.NAME,using="lastName")
	public WebElement lname;
	
	@FindBy(how=How.NAME,using="Username")
	public WebElement uname;
	
	@FindBy(how=How.NAME,using="Passwd")
	public WebElement pwd;
	
	@FindBy(how=How.NAME,using="ConfirmPasswd")
	public WebElement repwd;
	
	@FindBy(how=How.ID,using="accountDetailsNext")
	public WebElement next;
	
	@FindBy(how=How.ID,using="countryList")
	public WebElement country;
	
	@FindBy(how=How.ID,using="phoneNumberId")
	public WebElement mbno;
	
	@FindBy(how=How.NAME,using="recoveryEmail")
	public WebElement recoveryemail;
	
	@FindBy(how=How.ID,using="month")
	public WebElement month;
	
	@FindBy(how=How.ID,using="day")
	public WebElement day;
	
	@FindBy(how=How.ID,using="year")
	public WebElement year;
	
	@FindBy(how=How.ID,using="gender")
	public WebElement gender;
	
	@FindBy(how=How.XPATH,using="//span[text()='Next']/parent::button")
	public WebElement regnext;
	
	//Constructor method for connecting runner classes
	public RegistrationPage(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		
	//Operational methods to operate elements
	public void fillFirstName(String x)
	{
		fname.sendKeys(x);
	}
	
	public void fillLastName(String x)
	{
		lname.sendKeys(x);
	}
	
	public void fillUserName(String x)
	{
		uname.sendKeys(x);
	}
	
	public void fillpwd(String x)
	{
		pwd.sendKeys(x);
	}
	
	public void fillRetypepwd(String x)
	{
		repwd.sendKeys(x);
	}
	
	public void nextclick()
	{
		next.click();
	}
	
	public void fillmbno(String x)
	{
		mbno.sendKeys(x);  //virtual contact
	}
	
	public void fillRecoveryEmail(String x)
	{
		recoveryemail.sendKeys(x);
	}
	
	public void fillday(String x)
	{
		day.sendKeys(x);
	}
	
	public void fillyear(String x)
	{
		year.sendKeys(x);
	}
	
	public void selectCountry(String x)
	{
		//take country full name or ISD code as argument
		country.click(); //to open drop-down
		//select country
		country.findElement(By.xpath(
		"child::div[2]/div[@aria-selected='false']/descendant::*[contains(text(),'"+x+"')]"))
																					.click();
	}
	
	public void selectMonth(String x)
	{
		Select s=new Select(month);
		s.selectByVisibleText(x);
	}
	
	public void selectGender(String x)
	{
		Select s=new Select(gender);
		s.selectByVisibleText(x);
	}
	
	public void lastNextclick()
	{
		regnext.click();
	}
	
	public void otpVerficaion() throws Exception
	{
		selectCountry("United States");
		fillmbno("8104075295"); //virtual contact
		lastNextclick();
		Thread.sleep(5000);
		//Connect to cloud
		String ACCOUNT_SID="AC6765f161784b18a200fa3d2b9791e55c";
		String AUTH_TOKEN="7bab23d9d50c42304ac77d4168be0b03";
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN); //connect to twilio cloud
		//Get latest SMS body text
        ResourceSet<Message> ms=Message.reader().read();
        String temp=ms.iterator().next().getBody(); 
        //Identify 6 digit code in that SMS
        Pattern p=Pattern.compile("[0-9]{6}");
        Matcher m=p.matcher(temp);
        m.find(); //to go to first matched value
        driver.findElement(By.name("code")).sendKeys(m.group());
        driver.findElement(By.xpath("//*[text()='Verify']/parent::*")).click();   
	}
}



