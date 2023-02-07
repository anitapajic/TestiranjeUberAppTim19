package selenium.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public static WebDriver chrome_driver;
    public static WebDriver edge_driver;

    @BeforeSuite
    public void initializeWebDriver() {

        int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowWidth = screenWidth / 2;
        int windowHeight = screenHeight;

        //Chrome driver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        chrome_driver = new ChromeDriver();
        chrome_driver.manage().window().setSize(new Dimension(windowWidth,windowHeight));

        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        edge_driver = new EdgeDriver();
        edge_driver.manage().window().setSize(new Dimension(windowWidth,windowHeight));
    }

    @AfterSuite
    public void quitDriver() {
        chrome_driver.manage().deleteAllCookies();
        chrome_driver.quit();
        edge_driver.quit();
    }}
