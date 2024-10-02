package pages;

import dto.UserDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),
                this);
    }

    @FindBy(xpath = "//input[@id='email']")//@FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement cleckBtnYalla;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement textPopUp_LoginSucces;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement textPopUp_Loginfailed;
    //*[text()="It'snot look like email"]
    @FindBy(xpath = "//input[@id='email']/..//div[@class='error']/div")
    WebElement errorMessageInputEmail;

    //@FindBy(xpath = "//div[@class=\"error ng-star-inserted\"]")
    @FindBy(xpath = "//input[@id='password']/following::div[contains(@class,'error')]")
    WebElement emptyPassword;

    public LoginPage typeloginForm(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage typeloginForm(UserDto user) {
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        return this;
    }



    //nado ostatsy na toyje page for pop ap
    public LoginPage clickBtnLoginPositiv() {
        // pause(3);
        //cleckBtnYalla.click();
        clickWait(cleckBtnYalla,3);
        return this;
    }
    //for ASSIRT
    public boolean isTextInElementPresent_LoginSuccess(){
        return isTextInElementPresent(textPopUp_LoginSucces, "Logged in success");

    }

    public  boolean isTextInElementPresent_LoginFailed() {
        return isTextInElementPresent(textPopUp_Loginfailed, "Login or Password incorrect");
    }
    //overloiding
    public  boolean isTextInElementPresent_LoginFailed(String text) {
        return isTextInElementPresent(errorMessageInputEmail, text);
    }
    public  boolean isTextInElementPresent_LoginFailed_emptyPassword(String text) {
        return isTextInElementPresent(emptyPassword, text);
    }

    //Negative
    public LoginPage clickBtnLoginNegative(){
        cleckBtnYalla.click();
        return new LoginPage(driver);
    }

}
