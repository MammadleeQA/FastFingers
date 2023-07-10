package org.example.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverConfig {

    public static WebDriver webDriver;
    public static ChromeOptions chromeOptions;
    public static FirefoxOptions firefoxOptions;


    public static ChromeOptions chromeOptions(){

        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("start-maximized");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.merge(capabilities);

        return chromeOptions;
    }

    public static FirefoxOptions firefoxOptions(){

        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--incognito");
        firefoxOptions.addArguments("start-maximized");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, firefoxOptions);
        firefoxOptions.merge(capabilities);

        return firefoxOptions;
    }

    public static WebDriver getWebDriver(String browser){

        if("chrome".equals(browser)){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            webDriver = new ChromeDriver(chromeOptions());
        } else if("firefox".equals(browser)){
            System.setProperty("webdriver.firefox.driver", "drivers/firefoxdriver.exe");
            webDriver = new FirefoxDriver(firefoxOptions());
        }

        return webDriver;
    }





}
