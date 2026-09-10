import com.selenium.SeleniumSetup;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTests {

    @BeforeClass
    public void beforeClass(){
        SeleniumSetup.setup();

    }

    @Test
    public void completeNewCustomerFlowWorks(){
        Assert.assertEquals(SeleniumSetup.navigateTo(), "https://ntorque.n-thesis.com/");
        String actualUserName = SeleniumSetup.logMeIn();
        Assert.assertEquals(actualUserName, "workshop.admin", "The displayed user name is incorrect");
        Assert.assertEquals(SeleniumSetup.customerIntakeFormIsOpened(), "Register a new customer in the system.");
        SeleniumSetup.customerIntakeAcceptsAllValidInput();
        boolean carIconIsPresent = SeleniumSetup.userIsNavigatedOnTheCarFormPage();
        Assert.assertTrue(carIconIsPresent, "Car icon is not present");
        Assert.assertEquals(SeleniumSetup.carFormAcceptsValidInput(), "Register a new customer in the system.");
    }



    @AfterClass
    public void afterClass(){
        SeleniumSetup.end();
    }

}
