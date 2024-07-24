package cucumber.testng.selenium.clase_4.steps;

import com.aventstack.extentreports.Status;
import cucumber.testng.selenium.clase_4.utils.ExtentReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class BaseSteps {

    public static WebDriver driver;
    public static String browser = System.getProperty("browser", "chrome");

    @Before
    public void setUp(Scenario scenario) {

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        ExtentReportManager.createTest(scenario.getName(), scenario.getId());
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            // Crear el directorio si no existe
            File screenshotDirectory = new File("target/screenshots");
            if (!screenshotDirectory.exists()) {
                screenshotDirectory.mkdirs();
            }

            // Tomar la captura de pantalla
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "target/screenshots/" + scenario.getName().replaceAll(" ", "_") + ".png";
            FileHandler.copy(screenshot, new File(screenshotPath));

            // Añadir la captura de pantalla al reporte de Extent Reports
            ExtentReportManager.getTest().addScreenCaptureFromPath("../" + screenshotPath);
            if (scenario.isFailed()) {
                ExtentReportManager.getTest().log(Status.FAIL, "Scenario Failed");
            } else {
                ExtentReportManager.getTest().log(Status.PASS, "Scenario Passed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (driver != null) {
            driver.quit();
        }
        ExtentReportManager.flush();
    }

}
