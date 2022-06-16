package testscripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import page.BaseClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseClass.getValue("url"));
    }


    @AfterClass
    public void teardown(){
        BaseClass.waitForElement(5000);
        driver.quit();
    }
}
