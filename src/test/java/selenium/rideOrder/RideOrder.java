package selenium.rideOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.helper.Helper;

import java.util.concurrent.TimeUnit;

public class RideOrder {
    WebElement startBtn, acceptBtn, endBtn, logout;
    public RideOrder() {
    }
    public void passengerMakesOrder(WebDriver chrome_driver, String fromLocation, String toLocation){
        //from
        chrome_driver.findElement(By.id("fromLocation")).clear();
        chrome_driver.findElement(By.id("fromLocation")).sendKeys(fromLocation);

        //to
        chrome_driver.findElement(By.id("toLocation")).clear();
        chrome_driver.findElement(By.id("toLocation")).sendKeys(toLocation);

        //petTransport
        chrome_driver.findElement(By.id("petTransport")).click();

        //babyTransport
        chrome_driver.findElement(By.id("babyTransport")).click();

        Helper.takeScreenshoot(chrome_driver,"order");

        chrome_driver.findElement(By.id("bookBtn")).click();

        chrome_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(chrome_driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchingForRide")));
        Helper.takeScreenshoot(chrome_driver,"searching_for_driver");

    }

    public void driverStartedRide(WebDriver edge_driver){

        WebDriverWait wait = new WebDriverWait(edge_driver, 30);
        acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("acceptBtn")));
        Helper.takeScreenshoot(edge_driver,"ask_driver_for_accept");
        edge_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        acceptBtn.click();

        WebDriverWait wait2 = new WebDriverWait(edge_driver, 30);
        startBtn = wait2.until(ExpectedConditions.elementToBeClickable(By.id("startBtn")));
        Helper.takeScreenshoot(edge_driver,"ask_driver_for_start");
        edge_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        startBtn.click();

    }
}
