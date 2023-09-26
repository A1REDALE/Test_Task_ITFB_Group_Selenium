package PageObjectModels;

import Config.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        driver.get(DataProvider.getBaseUrl());
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsButton;

    public ElementsPage clickElementsButton(){
        elementsButton.click();
        return new ElementsPage(driver);
    }
}
