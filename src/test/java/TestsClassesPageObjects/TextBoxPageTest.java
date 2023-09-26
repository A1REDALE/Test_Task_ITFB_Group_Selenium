package TestsClassesPageObjects;

import PageObjectModels.TextBoxPage;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class TextBoxPageTest extends BaseTest {

    @DisplayName("Заполнение формы, проверка отображения введенных данных")
    @Feature(value = "TextBox")
    @Test
    public void checkTextBoxForm(){
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage
                .fillForm()
                .clickSubmitButton();
        Assert.assertTrue( textBoxPage.getAddedName().endsWith(textBoxPage.getInputName()));
        Assert.assertTrue(textBoxPage.getAddedEmail().endsWith(textBoxPage.getInputEmail()));
        Assert.assertTrue(textBoxPage.getAddedCurrentAddress().endsWith(textBoxPage.getInputCurrentAddress()));
        Assert.assertTrue(textBoxPage.getAddedPermanentAddress().endsWith(textBoxPage.getInputPermanentAddress()));
    }
}
