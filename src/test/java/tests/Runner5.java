package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"src\\test\\resources\\features\\feature1.feature"},
		glue={"gluecode"},
		monochrome=true,
		plugin={"pretty","html:target/feature1res.html","rerun:target/failedscenarios.txt"}
		)
public class Runner5 extends AbstractTestNGCucumberTests
{
}











