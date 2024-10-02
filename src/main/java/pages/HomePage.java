package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static pages.BasePage.setDriver;

public class HomePage  extends BasePage{
    public HomePage(WebDriver driver){
        setDriver(driver);
        driver.get("https://ilcarro.web.app/search");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),
                this);
    }
    @FindBy(xpath = "//a[text()='Sign up']")
    WebElement btnSinUp;
    @FindBy(xpath = "//a[text()='Log in']")
    WebElement btnLogin;
    @FindBy(xpath = "//a[@href='search']")
    WebElement search;
    public SingUpPage clickBtnSinUpHeader(){
        btnSinUp.click();
        return new SingUpPage(driver);
    }
    public LoginPage clickBtnLoginHeader(){
        btnLogin.click();
        return new LoginPage(driver);
    }
}
