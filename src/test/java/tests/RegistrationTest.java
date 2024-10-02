package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.Random;

import static utils.RondomUtils.generateString;

public class RegistrationTest extends ApplicationManager {
    @Test
    public void RegistrationPositivTest() {
        int i = new Random().nextInt(1000);
        String email = "qafred" + i + "@gmai.com";

        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnSinUpHeader()
                .typeRegistrationForm
                        ("Dan", "Gold", email, "Qa2@44Dan")
                .clickCheckBoox()
                .clickBtnRegistrationPositiv()
                .isTextInElementPresent_regSuccess())

        ;

    }

    @Test
    public void RegistrationNegativTest_WronEmail() {
        UserDto user = new UserDto(generateString(5), generateString(6),
                generateString(5), "Qa4654fdhg!");
        Assert.assertTrue(
                new HomePage(getDriver())
                        .clickBtnSinUpHeader()
                        .typeRegistrationForm(user)
                        .clickCheckBoox()
                        .clickBtnRegistrationPositiv()
                        .isTextInElementPresent_WronEmail("Wrong email format"))


        ;

    }
}
