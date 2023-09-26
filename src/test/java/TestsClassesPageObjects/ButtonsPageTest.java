package TestsClassesPageObjects;

import PageObjectModels.ButtonsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ButtonsPageTest extends BaseTest{

    @DisplayName("Click Me button check message")
    @Feature(value = "Buttons")
    @Test
    public void checkClickMeButtonMessage(){
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickClickMeButton();
        Assert.assertEquals("You have done a dynamic click",buttonsPage.getMessageClickMeButton());
    }
    @DisplayName("Right Click Me button check message")
    @Feature(value = "Buttons")
    @Test
    public void checkRightClickButtonMessage(){
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickRightClickMeButton();
        Assert.assertEquals("You have done a right click",buttonsPage.getMessageRightClickButton());
    }
    @Test
    @DisplayName("Double Click Me button check message")
    @Feature(value = "Buttons")
    public void checkDoubleClickMessage(){
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickDoubleClickMeButton();
        Assert.assertEquals("You have done a double click", buttonsPage.getMessageDoubleClickButton());
    }
}
