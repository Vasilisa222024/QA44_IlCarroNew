package tests;

import dto.CarDto;
import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import pages.LoginPage;
import utils.Fuel;
import utils.HeaderMenuItem;
import utils.RetryAnalyzer;
import utils.TestNGListner;
import org.slf4j.Logger;
import java.lang.reflect.Method;
import java.util.Random;
import static utils.PropertiesReader.getProperty;

import static pages.BasePage.clickButtonsOnHeader;
@Listeners(TestNGListner.class)

    public class AddNewCarTests extends ApplicationManager {
        LetTheCarWorkPage letTheCarWorkPage;
        LoginPage loginPage;

    UserDto user=new UserDto("Dan","Gold",
            getProperty("data.properties","email"),
            getProperty("data.properties","password"));
        @BeforeMethod
        public void startAddNewCar(Method method) {
            logger.info("start method-->"+method.getName() + "for user: "+user.getEmail());
            new HomePage(getDriver());
            loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);
           // loginPage.typeloginForm("qa44@gmai.com", "Qa@44Dan")
                  //  .clickBtnLoginPositiv();

            loginPage.typeloginForm(user.getEmail(), user.getPassword())
                    .clickBtnLoginPositiv();
            letTheCarWorkPage = clickButtonsOnHeader(HeaderMenuItem.LET_THE_CAR_WORK);


        }

        @Test(retryAnalyzer = RetryAnalyzer.class)
        public void addNewCarPositiveTest(Method method) {
            CarDto car = CarDto.builder()
                    .city("Haifa")
                    .manufacture("Toyota")
                    .model("Prius")
                    .year("2019")
                    .fuel(Fuel.DIESEL.getLocator())
                    .seats(5)
                    .carClass("C-class")
                    .carRegNumber("122-" + new Random().nextInt(1000))
                    .pricePerDay(1000)
                    .about("text")
                  //  .image("Mostovoy2023-30.jpg")
                    .build();
            logger.info("start -→> " + method.getName() + "with data: " + car.toString());
            letTheCarWorkPage.tipeLetTheCarWorkPageForm(car);
            letTheCarWorkPage.clickBtnSubmit();
            Assert.assertTrue(letTheCarWorkPage.validatePopUpMessage
                    //(car.getManufacture()+""+car.getModel()+" added successful"));
                            ("Toyota Prius added successful"
                            ));
        }


        @Test
        public void addNewCarNegativTestFieldManufactureIsEmpty(Method method) {
            CarDto car = CarDto.builder()
                    .city("Haifa")
                    .manufacture(" ")
                    .model("Prius")
                    .year("2019")
                    .fuel(Fuel.DIESEL.getLocator())
                    .seats(5)
                    .carClass("C-class")
                    .carRegNumber("122-" + new Random().nextInt(1000))
                    .pricePerDay(1000)
                    .about("text")
                    .image("Mostovoy2023-30.jpg")
                    .build();
            logger.info("start -→> " + method.getName() + "with data: " + car.toString());

            letTheCarWorkPage.tipeLetTheCarWorkPageForm(car);
            letTheCarWorkPage.clickBtnSubmit();
            Assert.assertTrue(

                    letTheCarWorkPage.invalidatePopUpMessage("{\"manufacture\":\"must not be blank\"}"))

            ;
        }

        @Test
        public void addNewCarNegativTestFieldModelIsEmpty(Method method) {
            CarDto car = CarDto.builder()
                    .city("Haifa")
                    .manufacture("Toyota")
                    .model("")
                    .year("2019")
                    .fuel(Fuel.DIESEL.getLocator())
                    .seats(5)
                    .carClass("C-class")
                    .carRegNumber("122-" + new Random().nextInt(1000))
                    .pricePerDay(1000)
                    .about("text")
                    .image("Mostovoy2023-30.jpg")
                    .build();
            logger.info("start -→> " + method.getName() + "with data: " + car.toString());

            letTheCarWorkPage.tipeLetTheCarWorkPageForm(car);
            Assert.assertTrue(
                    letTheCarWorkPage.urlContainsletCarWork());


        }

        @Test
        public void addNewCarNegativTestFieldYearIsEmpty(Method method) {
            CarDto car = CarDto.builder()
                    .city("Haifa")
                    .manufacture("Toyota")
                    .model("Prius")
                    .year("")
                    .fuel(Fuel.DIESEL.getLocator())
                    .seats(5)
                    .carClass("C-class")
                    .carRegNumber("122-" + new Random().nextInt(1000))
                    .pricePerDay(1000)
                    .about("text")
                    .image("Mostovoy2023-30.jpg")
                    .build();
            logger.info("start -→> " + method.getName() + "with data: " + car.toString());

            letTheCarWorkPage.tipeLetTheCarWorkPageForm(car);
            Assert.assertTrue(
                    letTheCarWorkPage.MessegeYearRequired());
        }
        @Test //не получилось думаю нужно перейти на поле  seats///////
        public void addNewCarNegativTestFieldfuelIsEmpty(Method method) {
            CarDto car = CarDto.builder()
                    .city("Haifa")
                    .manufacture("Toyota")
                    .model("Prius")
                    .year("2019")
                    .fuel("")
                    .seats(5)
                    .carClass("C-class")
                    .carRegNumber("122-" + new Random().nextInt(1000))
                    .pricePerDay(1000)
                    .about("text")
                    .image("Mostovoy2023-30.jpg")
                    .build();
            logger.info("start -→> " + method.getName() + "with data: " + car.toString());

            letTheCarWorkPage.tipeLetTheCarWorkPageForm(car)
            ;

            Assert.assertTrue(
                    letTheCarWorkPage.MessegeFuelRequired());
        }
        @Test
        public void addNewCarNegativTestFieldSeatsIsEmpty(Method method) {
            CarDto car = CarDto.builder()
                    .city("Haifa")
                    .manufacture("Toyota")
                    .model("Prius")
                    .year("2019")
                    .fuel(Fuel.DIESEL.getLocator())
                    .seats(0)
                    .carClass("C-class")
                    .carRegNumber("122-" + new Random().nextInt(1000))
                    .pricePerDay(1000)
                    .about("text")
                    .image("Mostovoy2023-30.jpg")
                    .build();
            logger.info("start -→> " + method.getName() + "with data: " + car.toString());

            letTheCarWorkPage.tipeLetTheCarWorkPageForm(car);
            Assert.assertTrue( letTheCarWorkPage.MessageCarMustHaveMin_2Seat());
            ;


        }
}
