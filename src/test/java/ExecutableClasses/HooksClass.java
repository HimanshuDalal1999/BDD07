package ExecutableClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Pages.DriverFactory;
import Pages.UtilityClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class HooksClass 
{
	static WebDriver driver;
	static DriverFactory DF;
	
	@BeforeAll
	public static void OpenBrowser() throws IOException
	{
		 DF = new DriverFactory();
		driver = DF.InitializeBrowser(UtilityClass.PropertyFile("Browser"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@After
	public void CaptureScreenshot(Scenario scenario)
	{
		
		
		if(scenario.isFailed())
		{
			String ScenarioName = scenario.getName();
			String ScenarioNameAfter = ScenarioName.replaceAll(" ", "_");
			byte[] Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(Screenshot, "image/png", ScenarioNameAfter);
		}
	}
	
	
	@AfterAll
	public static void CloseBrowser()
	{
		driver.close();
	}
	
	
	

}
