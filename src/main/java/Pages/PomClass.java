package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomClass 
{
	WebDriver driver;
	
	@FindBy (xpath = "//div[@class='pull-left logo-outer']") private WebElement validatingLogo;
	@FindBy (xpath = "//a[text()='Practice']") private WebElement validatingButton;
	@FindBy (xpath = "//div[@class='contact-form']") private WebElement LoginWindow;
	
	public PomClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//----------------1st TC-----------------------------------------	
	public boolean VerifyLogo()
	{
		boolean Logo = validatingLogo.isDisplayed();
		return Logo;
	}
//------------------2nd TC---------------------------------------
	public void VerifyPracticeButton()
	{
		validatingButton.click();
	}
	public boolean VerifyLoginWindow()
	{
		boolean Window = LoginWindow.isDisplayed();
		return Window;
	}
	
	
}
