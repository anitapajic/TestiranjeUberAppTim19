package selenium.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import selenium.login.Login;
import selenium.rideOrder.RideOrder;

public class UberAppTest extends TestBase{

    public static final String PASSENGER_USERNAME = "anita@gmail.com";
    public static final String DRIVER_USERNAME = "anja@gmail.com";
    public static final String PASSWORD = "test";
    public static final String FROM_LOC = "Strumicka 6, Novi Sad";
    public static final String TO_LOC = "Strazilovska 16, Novi Sad";
    RideOrder rideOrder = new RideOrder();

    @Test
    public void happyFlow() throws InterruptedException {
        //user login
        Login loginPassenger = new Login(chrome_driver);
        loginPassenger.loginWithPasswordAndUsername(PASSENGER_USERNAME, PASSWORD, "passenger");

        //driver login
        Login loginDriver = new Login(edge_driver);
        loginDriver.loginWithPasswordAndUsername(DRIVER_USERNAME, PASSWORD, "driver");
        Thread.sleep(2000);
        rideOrder.passengerMakesOrder(chrome_driver, FROM_LOC, TO_LOC);
        rideOrder.driverStartedRide(edge_driver);
        rideOrder.driverEndRide(edge_driver, chrome_driver);
    }
    @Test(priority = 3, testName = "3.Panic end ride by passenger")
    public void panicByPasssenger() {
        Login loginPassenger = new Login(chrome_driver);
        loginPassenger.loginWithPasswordAndUsername(PASSENGER_USERNAME,PASSWORD,"passenger");

        rideOrder.passengerMakesOrder(chrome_driver, FROM_LOC, TO_LOC);
        rideOrder.driverStartedRide(edge_driver);
        rideOrder.panicByPassenger(chrome_driver);
    }

    @Test
    public void noAvailableDriver() throws InterruptedException {
        Login loginPassenger = new Login(chrome_driver);
        loginPassenger.loginWithPasswordAndUsername(PASSENGER_USERNAME,PASSWORD,"passenger");
        Thread.sleep(2000);
        rideOrder.passengerMakesOrder(chrome_driver, FROM_LOC, TO_LOC);

        WebDriverWait alert = new WebDriverWait(chrome_driver, 40);
        alert.until(ExpectedConditions.alertIsPresent()).accept();
    }

}
