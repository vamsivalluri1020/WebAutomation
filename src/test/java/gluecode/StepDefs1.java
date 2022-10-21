package gluecode;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;

import java.util.List;

public class StepDefs1
{
	//Declare objects to Page classes and other required classes
	public HomePage hp;
	public LoginPage lp;
	public ComposePage cp;
	public LogoutPage lop;
	public WebDriverWait w;
	public Shared sh; //"Shared" class can provide other reusable classes objects
	//Constructor method
	public StepDefs1(Shared sh)
	{
		this.sh=sh;
	}
	//Operational methods of class with cucumber-java annotations
	@Given("^launch site using \"(.*)\"$")
	public void method2(String bn)
	{
		//open browser
		sh.driver=sh.tu.openBrowser(bn);
		hp=new HomePage(sh.driver);
		lp=new LoginPage(sh.driver);
		cp=new ComposePage(sh.driver);
		lop=new LogoutPage(sh.driver);	
		Integer t=Integer.parseInt((String) sh.p.get("maxtime"));
		w=new WebDriverWait(sh.driver,t);
		//launch site
		sh.tu.launchSite(sh.p.getProperty("url"));
		w.until(ExpectedConditions.visibilityOf(hp.uid));
	}
	
	@Then("^title should be \"(.*)\"$")
	public void method3(String expected) throws Exception
	{
		String actual=sh.driver.getTitle();
		if(expected.equals(actual))
		{
			sh.s.log("Gmail title test pased");
		}
		else
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES); //SWD
			sh.s.attach(b,"image/png","Gmail title test failed");  //cucumber-java
			Assert.assertTrue(false); //TestNG
		}
	}
	
	@And("^quit site$")
	@When("^close site$")
	public void method4()
	{
		sh.tu.closeSite();
	}
	
	@When("^enter userid as \"(.*)\"$")
	public void method5(String uid)
	{
		hp.uidfill(uid);
	}
	
	@And("^click userid next button$") 
	public void method6() throws Exception
	{
		hp.uidnextclick();
		Thread.sleep(5000); //wait for outcome
	}
	
	@Then("^validate outcome related to given userid criteria like \"(.*)\"$")
	public void method7(String c)
	{
		try
		{
			if(c.equals("blank") && hp.blankuiderr.isDisplayed())
			{
				sh.s.log("Blank uid test was passed");
			}
			else if(c.equals("invalid") && hp.invaliduiderr.isDisplayed())
			{
				sh.s.log("Invalid uid test was passed");
			}
			else if(c.equals("valid") && lp.pwd.isDisplayed())
			{
				sh.s.log("Valid uid test was passed");
			}
			else
			{
				byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
				sh.s.attach(b,"png","Gmail UID test failed");
				Assert.assertTrue(false);
			}
		}
		catch(Exception ex)
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(b,"png",ex.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	@And("^enter password as \"(.*)\"$")
	public void method8(String p)
	{
		lp.pwdfill(p);
	}
	
	@And("^click password next button$")
	public void method9() throws Exception
	{
		lp.pwdnextclick();
		Thread.sleep(5000); //wait for outcome
	}
	
	@Then("^validate outcome related to given password criteria like \"(.*)\"$")
	public void method10(String c)
	{
		try
		{
			if(c.equals("blank") && lp.blankpwderr.isDisplayed())
			{
				sh.s.log("Blank pwd test was passed");
			}
			else if(c.equals("invalid") && lp.invalidpwderr.isDisplayed())
			{
				sh.s.log("Invalid pwd test was passed");
			}
			else if(c.equals("valid") && cp.comp.isDisplayed())
			{
				sh.s.log("Valid pwd test was passed");
			}
			else
			{
				byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
				sh.s.attach(b,"png","Gmail PWD test failed");
				Assert.assertTrue(false);
			}
		}
		catch(Exception ex)
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(b,"png",ex.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	@And("^send mail and test$")
	public void method11(DataTable dt) throws Exception
	{
		List<List<String>> l=dt.asLists();
		//0th row(first row) in data table is having names of columns
		for(int i=1;i<l.size();i++)
		{
			cp.clickCompose();
			w.until(ExpectedConditions.visibilityOf(cp.toaddress));
			cp.fillTo(l.get(i).get(0));
			cp.fillSubject(l.get(i).get(1));
			cp.fillBody(l.get(i).get(2));
			cp.attachment(l.get(i).get(3));
			w.until(ExpectedConditions.visibilityOf(cp.uploading));
			cp.clickSend();
			try
			{
				w.until(ExpectedConditions.visibilityOf(cp.outputmsg));
				sh.s.log("Mail compose test passed");
			}
			catch(Exception ex)
			{
				byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
				sh.s.attach(b,"png","Mail compose test failed");
				Assert.assertTrue(false);
			}	
		}
	}
	
	@When("^do logout$")
	public void method12()
	{
		lop.clickProfilePic();
		w.until(ExpectedConditions.elementToBeClickable(lop.signout));
		lop.clickSignOut();
		w.until(ExpectedConditions.visibilityOf(lop.relogin));
	} 
}