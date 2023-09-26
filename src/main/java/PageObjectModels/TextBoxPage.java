package PageObjectModels;

import Config.User;
import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {
    WebDriver driver;
    public TextBoxPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#userName")
    private WebElement nameField;
    @FindBy(css = "#userEmail")
    private WebElement emailField;
    @FindBy(css = "#currentAddress")
    private WebElement currentAddressField;
    @FindBy(css = "#permanentAddress")
    private WebElement permanentAddressField;
    @FindBy(css = "#submit")
    private WebElement submitButton;
    @FindBy(xpath = "//p[@id='name']")
    private WebElement addedName;
    @FindBy(xpath = "//p[@id='email']")
    private WebElement addedEmail;
    @FindBy(xpath = "//p[@id='currentAddress']")
    private WebElement addedCurrentAddress;
    @FindBy(xpath = "//p[@id='permanentAddress']")
    private WebElement addedPermanentAddress;

    public TextBoxPage fillNameField(String name){
        nameField.sendKeys(name);
        return this;
    }
    public TextBoxPage fillEmailField(String email){
       emailField.sendKeys(email);
       return this;
    }
    public TextBoxPage fillCurrentAddressField(String currentAddress){
        currentAddressField.sendKeys(currentAddress);
        return this;
    }
    public TextBoxPage fillPermanentAddressField(String permanentAddress){
        permanentAddressField.sendKeys(permanentAddress);
        return this;
    }
    public TextBoxPage clickSubmitButton(){
        submitButton.click();
        return this;
    }

    public TextBoxPage fillForm(){
        fillNameField(User.getRandomUser().getName()).
        fillEmailField(User.getRandomUser().getEmail()).
        fillCurrentAddressField(User.getRandomUser().getCurrentAddress()).
        fillPermanentAddressField(User.getRandomUser().getPermanentAddress());
        return this;
    }

    public String getInputName(){
        return nameField.getAttribute("value");
    }
    public String getInputEmail(){
        return emailField.getAttribute("value");
    }
    public String getInputCurrentAddress(){return currentAddressField.getAttribute("value");}
    public String getInputPermanentAddress(){return permanentAddressField.getAttribute("value");
    }
    public String getAddedName(){return addedName.getText();}
    public String getAddedEmail(){
       return addedEmail.getText();
    }
    public String getAddedCurrentAddress(){
        return addedCurrentAddress.getText();
    }
    public String getAddedPermanentAddress(){
       return addedPermanentAddress.getText();
    }
}
