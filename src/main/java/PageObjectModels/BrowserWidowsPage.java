package PageObjectModels;

import Config.DataProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWidowsPage {
    WebDriver driver;
    public BrowserWidowsPage(WebDriver driver) {
        this.driver = driver;
        driver.get(DataProvider.getBrowserWindowsUrl());
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement tabButton;
    @FindBy(xpath = "//button[@id='windowButton']")
    private WebElement newWindowButton;
    @Step("open new tab")
    public BrowserWidowsPage clickTabButton(){
        tabButton.click();
        return this;
    }
    @Step("open new Window")
    public BrowserWidowsPage clickNewWindowButton(){
        newWindowButton.click();
        return this;
    }
    @Step("close tab or window")
    public BrowserWidowsPage close(){
        driver.close();
        return this;
    }
}
