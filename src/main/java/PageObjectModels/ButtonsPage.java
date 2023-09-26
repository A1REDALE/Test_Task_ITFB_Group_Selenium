package PageObjectModels;

import Config.DataProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage{
    WebDriver driver;
    public ButtonsPage(WebDriver driver){
        this.driver = driver;
        driver.get(DataProvider.getButtonsUrl());
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement clickMeButton;
    @FindBy(xpath = "//button[@id='rightClickBtn']")
    private WebElement rightClickButton;
    @FindBy(css = "#doubleClickBtn")
    private WebElement doubleClickButton;
    @FindBy(xpath = "//p[@id='dynamicClickMessage']")
    private WebElement clickMeButtonMessage;
    @FindBy(xpath = "//p[@id='rightClickMessage']")
    private WebElement rightClickMessage;
    @FindBy(css = "#doubleClickMessage")
    private WebElement doubleClickMessage;

    @Step("click Click Me button")
    public ButtonsPage clickClickMeButton(){
        new Actions(driver).click(clickMeButton).perform();
        return this;
    }
    @Step("click Right Click Me button")
    public ButtonsPage clickRightClickMeButton(){
        new Actions(driver).contextClick(rightClickButton).perform();
        return this;
    }
    @Step("click Double Click Me button")
    public ButtonsPage clickDoubleClickMeButton(){
        new Actions(driver).doubleClick(doubleClickButton).perform();
        return this;
    }
    public String getMessageClickMeButton(){
        return clickMeButtonMessage.getText();}
    public String getMessageRightClickButton(){
        return rightClickMessage.getText();
    }
    public String getMessageDoubleClickButton(){
        return doubleClickMessage.getText();
    }
}