package cucumber.testng.selenium.clase_4;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber.testng.selenium.clase_4.steps",
        plugin = {"json:target/cucumber.json"}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
