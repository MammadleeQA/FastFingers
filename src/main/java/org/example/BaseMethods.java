package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.example.drivers.DriverConfig.*;

public class BaseMethods {

    public static void startUp(String browser, String url){

        WebDriver driver = getWebDriver(browser);

        driver.get(url);
    }

    public static void waitSeconds(int seconds){

        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public static WebElement getElement(By locator){

        return webDriver.findElement(locator);
    }

    public static boolean isDisplayedElement(By locator){

        try {
            return getElement(locator).isDisplayed();
        }
        catch(NoSuchElementException ex) {
            System.out.println("No Such Element Exception");
            return false;
        }
    }


    public static void explicitWait(By locator, ExpectedConditionsEnum expectedConditionsEnum, int seconds) {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));

        switch (expectedConditionsEnum){
            case VISIBLE: wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            case INVISIBLE: wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
                break;
            case CLICKABLE: wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            case PRESENCE: wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                break;
            default:
                System.err.println("Enter right Enum for ExpectedConditions");
        }
    }
}
