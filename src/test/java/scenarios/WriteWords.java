package scenarios;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.Keys;

import static org.example.BaseMethods.*;
import static org.example.ExpectedConditionsEnum.*;
import static org.example.drivers.DriverConfig.webDriver;
import static org.example.locators.TypingElements.*;

public class WriteWords{

    public static String browser = "chrome";
    public static String url = "https://10fastfingers.com/typing-test/english";

    @Before
    public void setUp(){
        startUp(browser,url);
    }

    @Test
    public void writeWordsScenario() {

        explicitWait(COOKIE_DENY_BUTTON, VISIBLE, 15);
        getElement(COOKIE_DENY_BUTTON).click();

        explicitWait(INPUT_CONTROL, VISIBLE, 15);
        getElement(INPUT_CONTROL).click();

        explicitWait(ACTIVE_WORD, VISIBLE, 15);
        while(isDisplayedElement(ACTIVE_WORD)) {

            try {
                getElement(INPUT_CONTROL).sendKeys(Keys.SPACE);
                explicitWait(ACTIVE_WORD, VISIBLE, 10);
                getElement(INPUT_CONTROL).sendKeys(getElement(ACTIVE_WORD).getText());
            } catch (Exception e) {
                break;
            }
        }

        explicitWait(RESULT_TABLE, VISIBLE, 10);
        System.out.println("Word Per Minute: " + getElement(WPM_COUNT).getText());
        System.out.println("Accuracy: " + getElement(ACCURACY_PERCENTAGE).getText());
        System.out.println("Correct Words: " + getElement(CORRECT_WORDS_COUNT).getText());
        System.out.println("Wrong Words: " + getElement(WRONG_WORDS_COUNT).getText());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}
