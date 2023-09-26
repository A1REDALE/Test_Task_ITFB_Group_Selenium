package TestsClassesPageObjects;

import Config.DataProvider;
import PageObjectModels.AlertsPage;;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsTest extends BaseTest{
    @Before
    public void setUp(){
        driver.get(DataProvider.getAlertsUrl());
    }

    @DisplayName("Закрытие алерта")
    @Feature(value = "Alerts")
    @Test
    public void checkCloseAlertMessage(){
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.clickAlertButton();
        driver.switchTo().alert().accept();
    }
    @DisplayName("Закрытие алерта, появляющегося через 5 секунд")
    @Feature(value = "Alerts")
    @Test
    public void checkCloseAlertAppearAfter5Sec(){
        AlertsPage alertsPage = new AlertsPage(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        alertsPage.clickTimerAlertButton();
        wait.until(ExpectedConditions.alertIsPresent());
        alertsPage.acceptAlert();
    }
    @DisplayName("Закрытие алерта подтверждая действие на странице. Проверка появления текста выбора")
    @Feature(value = "Alerts")
    @Test
    public void checkCloseAlertConfirmBox(){
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.clickConfirmButton();
        alertsPage.acceptAlert();
        Assert.assertEquals("You selected Ok",alertsPage.getConfirmResult().getText());
    }

    @DisplayName("Открытие алерта, заполнение поля , проверка что отображается текст")
    @Feature(value = "Alerts")
    @Test
    public void checkClickPromtButtonFillTextField(){
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.clickPromtButton();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Test name");
        alertsPage.acceptAlert();
        Assert.assertEquals("You entered Test name",alertsPage.getPromtResult().getText());
    }
}