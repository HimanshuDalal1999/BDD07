package ExecutableClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.DriverFactory;
import Pages.PomClass;
import Pages.UtilityClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition 
{
	WebDriver driver;//2
	PomClass pom = new PomClass(driver);//3

//----------------------------------------------------------------------------
	@Given("User should be at Home Page")
	public void UsershouldbeatHomePage() throws EncryptedDocumentException, IOException
	{
		 driver = DriverFactory.GetDriver();//1
		 driver.get(UtilityClass.ExcelSheet(0, 0));
	}
	@Then("User is able to see the Logo of the Application")
	public void UserisabletoseetheLogooftheApplication()
	{
		boolean Logo = pom.VerifyLogo();
		Assert.assertFalse(Logo);
	}
//-----------------------------------------------------------------------------
	@When("User clicks on Practice button")
	public void UserclicksonPracticebutton()
	{
		pom.VerifyPracticeButton();
	}
	@Then("Login page should get displayed")
	public void Loginpageshouldgetdisplayed()
	{
		boolean Window = pom.VerifyLoginWindow();
		Assert.assertTrue(Window);
	}
}
