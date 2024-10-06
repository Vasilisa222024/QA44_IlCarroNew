package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.HeaderMenuItem;

import java.time.Duration;

public class BasePage {
    static WebDriver driver;
    static Logger logger = LoggerFactory.getLogger(BasePage.class);
    public  static void  setDriver(WebDriver wd){
        driver=wd;
    }

    //PAUSA
    public  void pause(int time){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean  isTextInElementPresent(WebElement element, String text){
        return element.getText().contains(text);

    }
    public static <T extends BasePage>T clickButtonsOnHeader(HeaderMenuItem headerMenuItem){
        WebElement element  = driver.findElement(By.xpath(headerMenuItem.getLocator()));
        element.click();
        switch (headerMenuItem){
            case LOGIN:
                return (T) new LoginPage(driver);
            case SIGN_UP:
                return (T) new SingUpPage(driver);
            case SEARCH:
                return (T) new HomePage(driver);
            case TERMS_OF_USE:
                return (T) new TermsPage(driver);
            case LET_THE_CAR_WORK:
                return (T) new LetTheCarWorkPage(driver);
            default:
                throw new IllegalArgumentException("invalid parametr headerMenuItem");
        }

    }
    public void clickWait(WebElement element,int time){
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.elementToBeClickable(element)).click();


    }
//Locator

    public void clickWait(By locator,int time){
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.elementToBeClickable(locator)).click();


    }
    public boolean urlContains(String urlPart,int time){
        return new WebDriverWait(driver,Duration.ofSeconds(time))
                .until(ExpectedConditions.urlContains(urlPart))   ;
    }

}





