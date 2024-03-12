package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;


public class UtilityClass 
{
	static WebDriver driver;
	
	public static String ExcelSheet(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException 
	{
		String ExcelPath = System.getProperty("user.dir")+"\\Parameterization\\RS.xlsx";
		FileInputStream ExcelFile = new FileInputStream(ExcelPath);
		String ExcelSheet = WorkbookFactory.create(ExcelFile).getSheet("Sheet1").getRow(RowIndex).getCell(CellIndex).getStringCellValue();
		return ExcelSheet;
	}
	
	public static String PropertyFile(String Key) throws IOException  
	{
		Properties property = new Properties();
		String PropertyPath = System.getProperty("user.dir")+"\\Parameterization\\RS.properties";
		FileInputStream PropertyFile = new FileInputStream(PropertyPath);
		property.load(PropertyFile);
		String PropertyKey = property.getProperty(Key);
		return PropertyKey;
	}
	
	public void  CaptureScreenshot(Scenario scenario)
	{
		
		if(scenario.isFailed())
		{
			String ScenarioName = scenario.getName();
			String ScnearioNameAfter = ScenarioName.replaceAll(" ", "_");
			byte[] Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(Screenshot, "image/png", ScnearioNameAfter);
		}
	}

	
}
