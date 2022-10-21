package gluecode;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.ComposePage;
import pages.HomePage;
import pages.RegistrationPage;

import java.io.FileReader;

public class StepDefs2 
{
	//Declare objects to Page classes and other required classes
	public HomePage hp;
	public ComposePage cp;
	public RegistrationPage rp;
	public WebDriverWait wait;
	public Shared sh;
	//Constructor method
	public StepDefs2(Shared sh)
	{
		this.sh=sh;
	}
	//Operational methods of class with cucumber-java annotations
	@And("^send mail and test by taking data from excel$")
	public void method13() throws Exception
	{
		cp=new ComposePage(sh.driver);
		//Open excel file in read mode
		String projectpath=System.getProperty("user.dir");
		FileReader fr=new FileReader(projectpath+
								"\\src\\test\\resources\\properties\\Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fr);
		Sheet sheet=wb.getSheet("Sheet1");
		int nour=sheet.getPhysicalNumberOfRows();		
		//0th row(first row) in excel file sheet is having names of columns
		for(int i=1;i<nour;i++)
		{
			DataFormatter df=new DataFormatter();
			String to=df.formatCellValue(sheet.getRow(i).getCell(0));
			String subj=df.formatCellValue(sheet.getRow(i).getCell(1));
			String body=df.formatCellValue(sheet.getRow(i).getCell(2));
			String attachfile=df.formatCellValue(sheet.getRow(i).getCell(3));
			cp.clickCompose();
			wait.until(ExpectedConditions.visibilityOf(cp.toaddress));
			cp.fillTo(to);
			cp.fillSubject(subj);
			cp.fillBody(body);
			cp.attachment(attachfile);
			wait.until(ExpectedConditions.visibilityOf(cp.uploading));
			cp.clickSend();
			try
			{
				wait.until(ExpectedConditions.visibilityOf(cp.outputmsg));
				sh.s.log("Mail compose test passed");
			}
			catch(Exception ex)
			{
				byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
				sh.s.attach(b,"image/png","Mail compose test failed");
				Assert.assertTrue(false);
			}	
		}
		//Close excel file
		wb.close();
		fr.close();
	}
	
	@When("^click on create account$")
	public void method14() throws Exception
	{
		wait=new WebDriverWait(sh.driver,20);
		hp=new HomePage(sh.driver);
		wait.until(ExpectedConditions.elementToBeClickable(hp.signup));
		hp.signupclick();
		Thread.sleep(5000);
	}
	
	@And("^click on for myself$")
	public void method15()
	{
		wait.until(ExpectedConditions.elementToBeClickable(hp.myself));
		hp.myselfclick();
	}
	
	@And("^fill fields with \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\" and click next$")
	public void method16(String x, String y, String u, String p)
	{
		rp=new RegistrationPage(sh.driver);
		wait.until(ExpectedConditions.elementToBeClickable(rp.fname));
		rp.fillFirstName(x);
		rp.fillLastName(y);
		rp.fillUserName(u);
		rp.fillpwd(p);
		rp.fillRetypepwd(p);
		rp.nextclick();
	}
	
	@And("^do otp verification if required for \"(.*)\" with \"(.*)\"$")
	public void method17(String x, String y) throws Exception
	{
		wait.until(ExpectedConditions.elementToBeClickable(rp.mbno));
		try
		{
			String z=rp.mbno.getAttribute("aria-label");
			if(z.contains("optional"))
			{
				//fill fields
				rp.selectCountry(x);
				rp.fillmbno(y);
			}
			else
			{
				//OTP verification
				rp.otpVerficaion();
			}
		}
		catch(Exception ex)
		{
			//OTP verification
			rp.otpVerficaion();
		}
	}
	
	@And(
	 "^fill fields with \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\" and click final next$")
	public void method18(String x, String y, String z, String w,String v)
	{
		wait.until(ExpectedConditions.elementToBeClickable(rp.recoveryemail));
		rp.fillRecoveryEmail(x);
		rp.selectMonth(y);
		rp.fillday(z);
		rp.fillyear(w);
		rp.selectGender(v);
		rp.lastNextclick();
	}
	
	@Then("^validate output message$")
	public void method19()
	{
		try
		{
	 if(sh.driver.findElement(By.xpath("//*[text()='Something went wrong']")).isDisplayed())
			{
				byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
				sh.s.attach(b,"image/png","Registration Test failed");
				Assert.assertTrue(false);
			}
		}
		catch(Exception ex)
		{
			sh.s.log("Registration Test passed");
		}
	}
}





