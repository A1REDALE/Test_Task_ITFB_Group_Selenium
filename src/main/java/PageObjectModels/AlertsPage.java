package PageObjectModels;

import Config.DataProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
    WebDriver driver;
    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        driver.get(DataProvider.getAlertsUrl());
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "#alertButton")
    private WebElement alertButton;
    @FindBy(css = "#timerAlertButton")
    private WebElement timerAlertButton;
    @FindBy(css = "#confirmButton")
    private WebElement confirmButton;
    @FindBy(css = "#promtButton")
    private WebElement promtButton;
    @FindBy(xpath = "//span[@id='confirmResult']")
    private WebElement confirmResult;
    @FindBy(xpath = "//span[@id='promptResult']")
    private WebElement promtResult;

    @Step("click Button to see alert")
    public AlertsPage clickAlertButton(){
        alertButton.click();
        return this;
    }
    @Step("on button click, alert will appear after 5 seconds")
    public AlertsPage clickTimerAlertButton(){
        timerAlertButton.click();
        return this;
    }
    @Step("on button click, confirm box will appear")
    public AlertsPage clickConfirmButton(){
        confirmButton.click();
        return this;
    }
    @Step("on button click, prompt box will appear")
    public AlertsPage clickPromtButton(){
        promtButton.click();
        return this;
    }
    @Step("accept alert")
    public AlertsPage acceptAlert(){
        driver.switchTo().alert().accept();
        return this;
    }
    public WebElement getConfirmResult() {
        return confirmResult;
    }
    public WebElement getPromtResult() {
        return promtResult;
    }
}
