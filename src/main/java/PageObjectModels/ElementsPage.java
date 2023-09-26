package PageObjectModels;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {
    WebDriver driver;
    public ElementsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='header-text' and text()='Elements']")
    private WebElement elementsMenuButton;
    @FindBy(xpath = "//span[text()='Text Box']")
    private WebElement textBoxButton;
    @FindBy(xpath = "//span[text()='Buttons']")
    private WebElement buttonsButton;
    @FindBy(xpath = "//div[@class='header-text' and text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindowsButton;

    public WebElement getBrowserWindowsButton() {
        return browserWindowsButton;
    }
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindowsButton;
    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsButton;

    @Step("click ElementsMenu button")
    public ElementsPage clickElementsMenuButton(){
        elementsMenuButton.click();
        return this;
    }
    @Step("click TextBox button")
    public TextBoxPage clickTextBoxButton(){
        textBoxButton.click();
        return new TextBoxPage(driver);
    }
    @Step("click Buttons button")
    public ButtonsPage clickButtonsButton(){
        buttonsButton.click();
        return new ButtonsPage(driver);
    }
    @Step("click AlertsFrameWindows button")
    public ElementsPage clickAlertsFrameWindowsButton(){
        alertsFrameWindowsButton.click();
        return this;
    }
    @Step("click BrowserWindows button")
    public BrowserWidowsPage clickBrowserWindowsButton(){
        browserWindowsButton.click();
        return new BrowserWidowsPage(driver);
    }
    @Step("click Alerts button")
    public AlertsPage clickAlertsButton(){
        alertsButton.click();
        return new AlertsPage(driver);
    }
}
