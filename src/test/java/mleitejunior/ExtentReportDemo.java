package mleitejunior;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports extent;

    @BeforeTest
    public void config() {
//        ExtentReports
//        ExtentSparkReporter
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Marcelo Leite Junior");
    }

    @Test
    public void initialDemo() {
        ExtentTest test = extent.createTest("Website Name Rahul Shetty Academya");

        System.setProperty("webdriver.chrome.driver", "D:\\MeusProgramas\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com");

        String websiteNameExpectation = "Rahul Shetty Academya";
        String websiteName = driver.getTitle();

        if (websiteName.equals(websiteNameExpectation)) {
            test.pass("Website Name Matches: " + websiteNameExpectation);
        } else {
            test.fail("Website Name does not match " + websiteNameExpectation + ", got: " + websiteName);
        }

        driver.close();
        extent.flush();
    }

    @Test
    public void initialDemo2() {
        ExtentTest test = extent.createTest("WebSite Name Rahul Shetty Academy");

        System.setProperty("webdriver.chrome.driver", "D:\\MeusProgramas\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com");

        String websiteNameExpectation = "Rahul Shetty Academy";
        String websiteName = driver.getTitle();

        if (websiteName.equals(websiteNameExpectation)) {
            test.pass("Website Name Matches: " + websiteNameExpectation);
        } else {
            test.fail("Website Name does not match " + websiteNameExpectation + ", got: " + websiteName);
        }

        driver.close();
        extent.flush();
    }
}
