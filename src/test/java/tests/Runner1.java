package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//Smoke testing
@CucumberOptions(
		features={"src\\test\\resources\\features"},
		glue={"gluecode"},
		tags="@smoketest",
		monochrome=true,
		plugin={"pretty","html:target/smoketestres","rerun:target/failedsmoke.txt"}
		)
public class Runner1 extends AbstractTestNGCucumberTests
{
}











