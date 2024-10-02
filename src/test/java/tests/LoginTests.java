package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.HeaderMenuItem;

import static pages.BasePage.clickButtonsOnHeader;
import static utils.RondomUtils.generateEmail;
import static utils.RondomUtils.generateString;

public class LoginTests extends ApplicationManager {
    @Test
    public void loginPositiveTest() {
        Assert.assertTrue(
                new HomePage(getDriver())
                        .clickBtnLoginHeader()
                        .typeloginForm("qa44@gmai.com", "Qa@44Dan")
                        .clickBtnLoginPositiv()
                        .isTextInElementPresent_LoginSuccess())
        ;

    }

    @Test
    public void loginNegativeTest_wronePassword_UnregisretUser() {
        Assert.assertTrue(
                new HomePage(getDriver())
                        .clickBtnLoginHeader()
                        .typeloginForm("qa44@gmai.com", "Qa@44Dan333")
                        .clickBtnLoginNegative()
                        .isTextInElementPresent_LoginFailed())

        ;

    }

    //ne korektniy Email WO@,.,
    @Test
    public void loginNegativeTest_wroneEmailWOAt() {

        UserDto user = new UserDto(generateString(5), generateString(6),
                generateString(9), "Qa4654fdhg!");
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLoginHeader()
                .typeloginForm(user)
                .clickBtnLoginNegative()
                .isTextInElementPresent_LoginFailed("It'snot look like email"))


        ;


    }

    @Test
    public void loginNegativeTest_wroneEmailWOAt_Enam() {

        UserDto user = new UserDto(generateString(5), generateString(6),
                generateString(9), "Qa4654fdhg!");
        new  HomePage(getDriver());
        LoginPage loginPage=clickButtonsOnHeader(HeaderMenuItem.LOGIN);
        loginPage.typeloginForm(user)
                .clickBtnLoginNegative()
                .isTextInElementPresent_LoginFailed("It'snot look like email")


        ;


    }
    @Test
    public void loginNegativeTest_validEmail_emptyPassword() {
        Assert.assertTrue(
                new HomePage(getDriver())
                        .clickBtnLoginHeader()
                        .typeloginForm(generateEmail(10), "")
                        .clickBtnLoginNegative()
                        .isTextInElementPresent_LoginFailed_emptyPassword("Password is required"))


        ;

    }
}
