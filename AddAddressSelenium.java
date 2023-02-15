package ZadaniaZaliczeniowe1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddressesPage;
import pageObjects.LoggedUserPage;
import pageObjects.LoginPage;
import pageObjects.NewAddressPage;

import java.time.Duration;

public class AddAddressSelenium {

    private static WebDriver driver;

    @Before

    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void testLogin() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("kamilslimak998@yahoo.com", "Sokjablkowy");

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        loggedUserPage.goToAddresses();

        Thread.sleep(2000);

        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.clickCreateNewAddress();

        Thread.sleep(2000);

        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.createAddress("Snail", "Queens 15/20", "Las Vegas", "32-555", "333222111");

        Thread.sleep(2000);


        String successMessage = newAddressPage.getSuccessMessage();
        Assert.assertEquals("Address successfully added!", successMessage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


