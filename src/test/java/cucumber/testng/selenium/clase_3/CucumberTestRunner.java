package cucumber.testng.selenium.clase_3;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber.testng.selenium.clase_3.steps"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
