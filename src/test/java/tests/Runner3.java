package tests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//Re-testing
@CucumberOptions(
		features={"@target/realtestfailedres.txt"},
		glue={"gluecode"},
		monochrome=true,
		plugin={"pretty","html:target/retestres","rerun:target/failedretestscenarios.txt"}
		)
public class Runner3 extends AbstractTestNGCucumberTests
{
}











