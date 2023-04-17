package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {
    public static void scrollToElement(WebDriver driver, WebElement scrollTo) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", scrollTo);
    }

    public static void waitVisibilityOfElement(WebDriver driver, WebElement waiting) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(waiting));
    }

    public static void waitVisibilityOfElementLocated(WebDriver driver, By waiting) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(waiting));
    }

    public static void waitTextToBePresentInElementLocated(WebDriver driver, By waiting, String changed) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.textToBePresentInElementLocated(waiting, changed));
    }

}
