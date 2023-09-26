import Config.DataProvider;
import PageObjectModels.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class OneBigTest{
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(DataProvider.getBaseUrl());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @DisplayName("Автоматизированный тест")
    @Feature(value = "OneBigTest")
    @Test
    public void oneBigTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickElementsButton();
        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.clickElementsMenuButton()
        .clickTextBoxButton();
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage
                .fillForm()
                .clickSubmitButton();
        Assert.assertTrue( textBoxPage.getAddedName().endsWith(textBoxPage.getInputName()));
        Assert.assertTrue(textBoxPage.getAddedEmail().endsWith(textBoxPage.getInputEmail()));
        Assert.assertTrue(textBoxPage.getAddedCurrentAddress().endsWith(textBoxPage.getInputCurrentAddress()));
        Assert.assertTrue(textBoxPage.getAddedPermanentAddress().endsWith(textBoxPage.getInputPermanentAddress()));
        elementsPage.clickElementsMenuButton()
                .clickButtonsButton();
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickClickMeButton();
        Assert.assertEquals("You have done a dynamic click",buttonsPage.getMessageClickMeButton());
        buttonsPage.clickRightClickMeButton();
        Assert.assertEquals("You have done a right click",buttonsPage.getMessageRightClickButton());
        buttonsPage.clickDoubleClickMeButton();
        Assert.assertEquals("You have done a double click", buttonsPage.getMessageDoubleClickButton());
        WebElement element = driver.findElement(By.xpath("//div[@class='header-text' and text()='Alerts, Frame & Windows']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        elementsPage.clickAlertsFrameWindowsButton();
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(elementsPage.getBrowserWindowsButton()));
        elementsPage.clickBrowserWindowsButton();
        BrowserWidowsPage browserWidowsPage = new BrowserWidowsPage(driver);
        String currentTab = driver.getWindowHandle();
        browserWidowsPage.clickTabButton();
        Set<String> tabs = driver.getWindowHandles();
        String newTab = null;
        for (String tab : tabs) {
            if (!tab.equals(currentTab)) {
                newTab = tab;
                break;
            }
        }
        driver.switchTo().window(newTab);
        browserWidowsPage.close();
        driver.switchTo().window(currentTab);
        String currentWindow = driver.getWindowHandle();
        browserWidowsPage.clickNewWindowButton();
        Set<String> Windows = driver.getWindowHandles();
        String newWindow = null;
        for (String window : Windows) {
            if (!window.equals(currentWindow)) {
                newWindow = window;
                break;
            }
        }
        driver.switchTo().window(newWindow);
        browserWidowsPage.close();
        driver.switchTo().window(currentWindow);
        elementsPage.clickAlertsButton();
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage
                .clickAlertButton()
                .acceptAlert();
        alertsPage.clickTimerAlertButton();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        alertsPage
                .acceptAlert()
                .clickConfirmButton()
                .acceptAlert();
        Assert.assertEquals("You selected Ok",alertsPage.getConfirmResult().getText());
        alertsPage.clickPromtButton();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Test name");
        alert.accept();
        Assert.assertEquals("You entered Test name",alertsPage.getPromtResult().getText());
    }
}
