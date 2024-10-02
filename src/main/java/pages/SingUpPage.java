package pages;

import dto.UserDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SingUpPage extends BasePage{
    public SingUpPage (WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),
                this);
    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement inputName;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement inputLastName;
    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;
    // @FindBy(xpath = "//label[@class='checkbox-label terms-label']")
    // WebElement inputCheckBoox;
    @FindBy(xpath = "//label[@for='terms-of-use']")
    WebElement checkBox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSingUp;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement textPopUp_regSuccess;
    @FindBy(xpath = "//input[@id='email']/../div[@class='error']/div")
    WebElement wrongEmail;

    public SingUpPage typeRegistrationForm
            (String name,String lastName,String email,String password){
        inputName.sendKeys(name);
        inputLastName.sendKeys(lastName);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        return this;
    }
    public SingUpPage clickCheckBoox(){
        //inputCheckBoox.click();
        // checkBox.click();
        //universaln0 for difernt rasreshenie acrana
        System.out.println(checkBox.getRect().getWidth() +" X "+checkBox.getRect().getHeight()) ;
        int width= checkBox.getRect() .getWidth();
        int height = checkBox.getRect().getHeight();
        Actions actions = new Actions(driver);
        actions.moveToElement (checkBox,- width/4,-height/4). click().perform();
        pause(2);
        return this;

    }

    //ASSIRE for registration method boolean
    public boolean isTextInElementPresent_regSuccess(){
        return isTextInElementPresent(textPopUp_regSuccess, "You are logged in success");
    }



    //For pop up
    public SingUpPage clickBtnRegistrationPositiv(){
        btnSingUp.click();
        return this;
    }

    public SingUpPage typeRegistrationForm(UserDto user) {
        inputName.sendKeys(user.getName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        return this;
    }
    public boolean isTextInElementPresent_WronEmail(String text){
        return isTextInElementPresent(wrongEmail, text);
    }
}
