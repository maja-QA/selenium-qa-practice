import com.selenium.SeleniumSetup;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumTests {

    @BeforeMethod
    public void beforeMethod() {
        SeleniumSetup.setup();

    }

    @DataProvider(name = "validCustomerAndCarData")
    public Object[][] validCustomerAndCarData() {
        return new Object[][]{
                {
                        "Boc",
                        "012/345-6789",
                        "boc@hotmail.com",
                        "Beverly Hills",
                        "Audi",
                        "R8 Audi",
                        "2025",
                        "BO5555CE",
                        "WBA8E9G59JNU12345",
                        "40"
                },
                {
                        "Borislav",
                        "012345678",
                        "borislav@yahoo.com",
                        "Hill",
                        "Mercedes",
                        "Mercedes Benz",
                        "2019",
                        "BO2323BO",
                        "WBA8E9G59JNU67894",
                        "150"
                },
                {
                        "Blair",
                        "456998-330",
                        "blair@gmail.com",
                        "Beverly Hills",
                        "Opel",
                        "Astra",
                        "2018",
                        "BT9999AA",
                        "W0L0AHL3551234567",
                        "80"
                }
        };

    }


    @Test(dataProvider = "validCustomerAndCarData")
    public void completeNewCustomerIntake(
            String fullName,
            String phoneNumber,
            String email,
            String address,
            String make,
            String model,
            String year,
            String plate,
            String vin,
            String mileage
    ) {
        Assert.assertEquals(SeleniumSetup.navigateTo(), "https://ntorque.n-thesis.com/");

        String actualUserName = SeleniumSetup.logMeIn();
        Assert.assertEquals(actualUserName, "workshop.admin", "The displayed user name is incorrect");
        Assert.assertEquals(
                SeleniumSetup.customerIntakeFormIsOpened(),
                "Register a new customer in the system."
        );
        SeleniumSetup.customerIntakeAcceptsAllValidInput(
                fullName, phoneNumber, email, address
        );

        boolean carIconIsPresent = SeleniumSetup.userIsNavigatedOnTheCarFormPage();
        Assert.assertTrue(carIconIsPresent, "Car icon is not present");

        Assert.assertEquals(
                SeleniumSetup.carFormAcceptsValidInput(
                        make, model, year, plate, vin, mileage
                ), "Register a new customer in the system."
        );
    }


    @AfterMethod
    public void afterMethod() {
        SeleniumSetup.end();
    }

}
