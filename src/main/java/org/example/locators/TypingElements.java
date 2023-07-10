package org.example.locators;

import org.openqa.selenium.By;

public class TypingElements {

    public static final By COOKIE_DENY_BUTTON = By.id("CybotCookiebotDialogBodyButtonDecline");
    public static final By ACTIVE_WORD = By.className("highlight");
    public static final By INPUT_CONTROL = By.className("form-control");
    public static final By RESULT_TABLE = By.id("result-table");
    public static final By WPM_COUNT = By.xpath("(//td[1]/strong)[1]");
    public static final By ACCURACY_PERCENTAGE = By.xpath("(//td[2]/strong)[1]");
    public static final By CORRECT_WORDS_COUNT = By.xpath("(//td[2]/strong)[2]");
    public static final By WRONG_WORDS_COUNT = By.xpath("(//td[2]/strong)[3]");

}
