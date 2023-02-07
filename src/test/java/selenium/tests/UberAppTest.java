package selenium.tests;

import org.testng.annotations.Test;
import selenium.login.Login;

public class UberAppTest extends TestBase{

    public static final String PASSENGER_USERNAME = "anita@gmail.com";
    public static final String DRIVER_USERNAME = "anja@gmail.com";
    public static final String PASSWORD = "test";

    @Test
    public void happyFlow() {
        //user login
        Login loginPassenger = new Login(chrome_driver);
        loginPassenger.loginWithPasswordAndUsername(PASSENGER_USERNAME, PASSWORD, "passenger");

        //driver login
        Login loginDriver = new Login(edge_driver);
        loginDriver.loginWithPasswordAndUsername(DRIVER_USERNAME, PASSWORD, "driver");
    }



}
