package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helper.Helper.scrollToElement;
import static helper.Helper.waitVisibilityOfElement;

public class HomePageScooter {
    private WebDriver driver;
    // Аккордион
    private final By accordionBlock = By.xpath(".//*[@data-accordion-component = 'Accordion']");
    // Выпадающий текст
    private final By accordionPanel = By.xpath(".//*[@data-accordion-component = 'AccordionItemPanel']/p");

    // Кнопка "Заказать" #1
    private final By orderButtonUp = By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[text() = 'Заказать']");

    // Кнопка "Заказать" #2
    private final By orderButtonDown = By.xpath(".//div[@class = 'Home_RoadMap__2tal_']//button[text() = 'Заказать']");
    // Кнопка куки
    private final By cookieButton = By.className("App_CookieButton__3cvqF");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void clickOrderButtonHeading() {
        driver.findElement(orderButtonUp).click();
    }

    public void scrollAndClickOrderButtonRoadmap() {
        WebElement element = driver.findElement(orderButtonDown);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }


    private WebElement getAccordionBlock() {
        return driver.findElement(accordionBlock);
    }
    private WebElement getAccordionItem(String questionHeader) {
        String accordionItemPath = ".//div[.//div[text() = '" + questionHeader + "'] and @data-accordion-component = 'AccordionItem']";
        return getAccordionBlock().findElement(By.xpath(accordionItemPath));
    }
    private WebElement getAccordionPanel(String questionHeader) {
        return getAccordionItem(questionHeader).findElement(accordionPanel);
    }
    public String getAccordionText(String questionHeader) {
        WebElement wElemI = getAccordionItem(questionHeader);

        scrollToElement(driver, wElemI);
        waitVisibilityOfElement(driver, wElemI);

        wElemI.click();
        WebElement wElemP = getAccordionPanel(questionHeader);
        waitVisibilityOfElement(driver, wElemP);
        return wElemP.getText();
    }

}
