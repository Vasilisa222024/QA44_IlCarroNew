package pages;

import dto.CarDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;

import static pages.BasePage.setDriver;

public class LetTheCarWorkPage extends BasePage{
    public LetTheCarWorkPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),
                this);
    }

    @FindBy(xpath = "//input[@id='pickUpPlace']")
    WebElement inputLocation;//sity
    @FindBy(xpath = "//input[@id='make']")
    WebElement inputManufacture;
    @FindBy(xpath = "//input[@id='model']")
    WebElement inputModel;
    @FindBy(xpath = "//input[@id='year']")
    WebElement inputYear;
    @FindBy(xpath = "//select[@id='fuel']")
    WebElement inputFuel;
    @FindBy(xpath = "//input[@id='seats']")
    WebElement inputSeats;
    @FindBy(xpath = "//input[@id='class']")
    WebElement inputCarclass;
    @FindBy(xpath = "//input[@id='serialNumber']")
    WebElement inputRegNamber;
    @FindBy(xpath = "//input[@id='price']")
    WebElement inputPrice;
    @FindBy(xpath = "//textarea[@id='about']")
    WebElement inputAbout;
    @FindBy(xpath = "//input[@id='photos']")
    WebElement inputAddPhotos;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;
    @FindBy(xpath = "//button[@class='negative-button ng-star-inserted']")
    WebElement btnAddAnotherCar;
    @FindBy(xpath = "//button[@class='neutral-button ng-star-inserted']")
    WebElement btnSearchCar;
    @FindBy(xpath = "//button[@class='positive-button ng-star-inserted']")
    WebElement btnSShowCar;
    @FindBy(xpath ="//div[@class='dialog-container']/h1")
    WebElement masegeCarAdded;
    @FindBy(xpath ="//div[@class='dialog-container']/h2") //text
    WebElement messageSuccessAddCar;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement carAddingFailed;
    @FindBy(xpath = "//div[@class='error']")
    WebElement  yearRequired;
    @FindBy(xpath = "//div[@class='error']")
    WebElement  fuelRequired;
    @FindBy(xpath = "//div[@class=\"error\"]/div")
    WebElement messageSeats;

    //    public LetTheCarWorkPage tipeLetTheCarWorkPageForm(String sity, String manufacture,
//                                                       String model, String year, String fuel, String sets, String carClass, String regNamber, String price, String about,
//                                                       String addPhotos) {
//        inputLocation.sendKeys(sity);
//        inputManufacture.sendKeys(manufacture);
//        inputModel.sendKeys(model);
//        inputYear.sendKeys(year);
//        inputFuel.sendKeys(fuel);
//        inputSeats.sendKeys(sets);
//        inputCarclass.sendieys(carClass);
//        inputRegNamber.sendKeys(regNamber)
//        inputPrice.sendKeys(price);
//        inputAbout.sendKeys(about);
//        inputAddPhotos.sendKeys(addPhotos);
//
//return this;
    public LetTheCarWorkPage tipeLetTheCarWorkPageForm (CarDto carDto){

        inputLocation.sendKeys(carDto.getCity());
        //pause(2);
        //  driver.findElement(By.xpath("//div[@class='pac-item']")).click();
        clickWait(By.xpath("//div[@class='pac-item']"),10);
        inputManufacture.sendKeys(carDto.getManufacture());
        inputModel.sendKeys(carDto.getModel());
        inputYear.sendKeys(carDto.getYear());
        //-----------------------------
        inputFuel.click();
        clickWait(By.xpath(carDto.getFuel()), 3);
        //-----------------------------
        inputSeats.sendKeys(carDto.getSeats()+"");
        inputCarclass.sendKeys(carDto.getCarClass());
        inputRegNamber.sendKeys(carDto.getCarRegNumber());
        inputPrice.sendKeys(Double.toString(carDto.getPricePerDay()));
        inputAbout.sendKeys(carDto.getAbout());
        //-----------------------------
        File file = new File("src/test/resources/"+carDto.getImage());
        //System.out.println(file.getAbsolutePath());

//inputAddPhotos.sendKeys("/Users/vasilisa/Documents/QA44Aleksy/QA44IlCarro/src/test/resources/Mostovoy2023-30.jpg"+carDto.getImage());
      //  inputAddPhotos.sendKeys(file.getAbsolutePath());


        return this;
    }

    public void clickBtnSubmit() {

        clickWait(btnSubmit,3);
    }
    public boolean validatePopUpMessage(String text){
        return isTextInElementPresent(messageSuccessAddCar, text);

    }
    public  boolean invalidatePopUpMessage (String text){
        return  isTextInElementPresent(carAddingFailed,text);
    }


    public boolean urlContainsletCarWork() {
        return urlContains("let-car-work",3) ;
    }
    public boolean MessegeFuelRequired(){
        return isTextInElementPresent(fuelRequired," Fuel is required ");
    }
    public boolean MessegeYearRequired(){
        return isTextInElementPresent(yearRequired,"Year required");
    }
    public  boolean MessageCarMustHaveMin_2Seat(){
        return  isTextInElementPresent(messageSeats,"Car must have min 2 seat");
    }
}
