package ExecutableClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features = {"src\\test\\resources\\FeatureFile\\RahulSheety.feature"},
		
		glue = {"ExecutableClasses"},
		
		publish = true

)

public class RunnerClass extends AbstractTestNGCucumberTests
{

}
