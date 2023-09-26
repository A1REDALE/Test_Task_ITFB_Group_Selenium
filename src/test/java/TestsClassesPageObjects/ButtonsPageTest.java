package TestsClassesPageObjects;

import Config.DataProvider;
import PageObjectModels.ButtonsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ButtonsPageTest extends BaseTest{
    @Before
    public void setUp(){
        driver.get(DataProvider.getButtonsUrl());
    }

    @DisplayName("Нажатие на кнопку Click Me, проверка что отображается текст")
    @Feature(value = "Buttons")
    @Test
    public void checkClickMeButtonMessage(){
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickClickMeButton();
        Assert.assertEquals("You have done a dynamic click",buttonsPage.getMessageClickMeButton());
    }
    @DisplayName("Нажатие на кнопку Right Click Me, проверка что отображается текст")
    @Feature(value = "Buttons")
    @Test
    public void checkRightClickButtonMessage(){
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickRightClickMeButton();
        Assert.assertEquals("You have done a right click",buttonsPage.getMessageRightClickButton());
    }
    @Test
    @DisplayName("Нажатие на кнопку Double Click Me, проверка что отображается текст")
    @Feature(value = "Buttons")
    public void checkDoubleClickMessage(){
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickDoubleClickMeButton();
        Assert.assertEquals("You have done a double click", buttonsPage.getMessageDoubleClickButton());
    }
}
