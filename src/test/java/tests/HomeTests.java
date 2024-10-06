package tests;

import manager.ApplicationManager;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

import utils.TestNGListner;
import static utils.TakeScreenShot.takeScreenShot;
@Listeners(TestNGListner.class)
public class HomeTests extends ApplicationManager {
    @Test
    public void firstTest(){
        HomePage homePage=new HomePage(getDriver());
        takeScreenShot((TakesScreenshot) getDriver());
    }
}
