package PageObjectModels;

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

    public WebElement getButtonsButton() {
        return buttonsButton;
    }

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

    public ElementsPage clickElementsMenuButton(){
        elementsMenuButton.click();
        return this;
    }
    public TextBoxPage clickTextBoxButton(){
        textBoxButton.click();
        return new TextBoxPage(driver);
    }
    public ButtonsPage clickButtonsButton(){
        buttonsButton.click();
        return new ButtonsPage(driver);
    }
    public ElementsPage clickAlertsFrameWindowsButton(){
        alertsFrameWindowsButton.click();
        return this;
    }
    public BrowserWidowsPage clickBrowserWindowsButton(){
        browserWindowsButton.click();
        return new BrowserWidowsPage(driver);
    }
    public AlertsPage clickAlertsButton(){
        alertsButton.click();
        return new AlertsPage(driver);
    }
}
