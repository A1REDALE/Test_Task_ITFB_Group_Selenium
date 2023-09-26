package TestsClassesPageObjects;

import PageObjectModels.BrowserWidowsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import java.util.Set;

public class BrowserWindowsPageTest extends BaseTest{
    @DisplayName("Закрытие открытой вкладки")
    @Feature(value = "BrowserWindows")
    @Test
    public void checkCloseNewTab() {
        BrowserWidowsPage browserWidowsPage = new BrowserWidowsPage(driver);
        browserWidowsPage.clickTabButton();
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
    }
    @DisplayName("Закрытие открытого окна")
    @Feature(value = "BrowserWindows")
    @Test
    public void checkCloseNewWindow(){
        BrowserWidowsPage browserWidowsPage = new BrowserWidowsPage(driver);
        browserWidowsPage.clickNewWindowButton();
        String currentWindow = driver.getWindowHandle();
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
    }
}