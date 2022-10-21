package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//add @regression tag to required scenarios or outlines 
//in feature files, which are passed previously.
//Regression testing
@CucumberOptions(
		features={"src\\test\\resources\\features"},
		glue={"gluecode"},
		tags="@regression",
		monochrome=true,
		plugin={"pretty","html:target/regressiontestres","rerun:target/failedregressionres.txt"}
		)
public class Runner4 extends AbstractTestNGCucumberTests
{
}











