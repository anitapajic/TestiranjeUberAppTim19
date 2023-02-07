package selenium.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.helper.Helper;

public class Login {
    private WebDriver web_driver;
    private static final String PAGE_URL="http://localhost:4200/login";
    public Login(WebDriver driver)  {
        this.web_driver = driver;
        this.web_driver.get(PAGE_URL);

        PageFactory.initElements(driver, this);
    }
    public void loginWithPasswordAndUsername(String username, String password,String role){

        web_driver.findElement(By.id("emailAddress")).clear();
        web_driver.findElement(By.id("emailAddress")).sendKeys(username);

        web_driver.findElement(By.id("password")).clear();
        web_driver.findElement(By.id("password")).sendKeys(password);

        if (role == "passenger"){
            Helper.takeScreenshoot(web_driver,"login-form-passenger");
        }else{
            Helper.takeScreenshoot(web_driver,"login-form-driver");
        }
        web_driver.findElement(By.className("btn-lg")).click();

    }

}
