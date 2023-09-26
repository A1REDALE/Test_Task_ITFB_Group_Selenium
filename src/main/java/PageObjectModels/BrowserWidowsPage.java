package PageObjectModels;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWidowsPage {
    WebDriver driver;
    public BrowserWidowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement tabButton;
    @FindBy(xpath = "//button[@id='windowButton']")
    private WebElement newWindowButton;
    @Step("Open new tab")
    public BrowserWidowsPage clickTabButton(){
        tabButton.click();
        return this;
    }
    @Step("Open new Window")
    public BrowserWidowsPage clickNewWindowButton(){
        newWindowButton.click();
        return this;
    }

    @Step("Close tab or window")
    public BrowserWidowsPage close(){
        driver.close();
        return this;
    }
}
