package ZadaniaZaliczeniowe1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.time.Duration;


public class TestAddProducts {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Ustawienie ścieżki do pliku chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAddAddress() throws InterruptedException {

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        WebElement loginField = driver.findElement(By.name("email"));
        loginField.sendKeys("kamilslimak998@yahoo.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Sokjablkowy");

        WebElement registrationButton = driver.findElement(By.id("submit-login"));
        registrationButton.click();

        Thread.sleep(2000);

        WebElement clothesButton = driver.findElement(By.id("category-3"));
        clothesButton.click();

        Thread.sleep(2000);

        WebElement sweaterName = driver.findElement(By.cssSelector("img[src='https://mystore-testlab.coderslab.pl/img/p/2/1/21-home_default.jpg']"));
        sweaterName.click();

        WebElement sizeButton = driver.findElement(By.id("group_1"));
        sizeButton.sendKeys("M");

        Thread.sleep(2000);

        WebElement quantityButton = driver.findElement(By.id("quantity_wanted"));
        quantityButton.click();
        quantityButton.sendKeys(Keys.BACK_SPACE);

        Thread.sleep(2000);

        if (quantityButton.getTagName().equals("input")) {
            quantityButton.sendKeys("5");
        }

        Thread.sleep(2000);

        WebElement cartButton = driver.findElement(By.cssSelector("button[class ='btn btn-primary add-to-cart']"));
        cartButton.click();

        Thread.sleep(2000);

        WebElement addToCheckoutButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        addToCheckoutButton.click();

        Thread.sleep(2000);

        WebElement checkoutButton = driver.findElement(By.xpath("//a[text()='Proceed to checkout']"));
        checkoutButton.click();

        Thread.sleep(2000);

        WebElement continueButton = driver.findElement(By.cssSelector("button[class ='btn btn-primary continue float-xs-right']"));
        continueButton.click();

        Thread.sleep(2000);

        WebElement nextcontinueButton = driver.findElement(By.cssSelector("button[value='1'][name='confirmDeliveryOption']"));
        nextcontinueButton.click();

        Thread.sleep(2000);


        WebElement payByCheckRadioButton = driver.findElement(By.id("payment-option-1"));
        payByCheckRadioButton.click();

        Thread.sleep(2000);

        WebElement termsCheckbox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        termsCheckbox.click();

        Thread.sleep(2000);

        WebElement placeorderButton = driver.findElement(By.cssSelector("button[class='btn btn-primary center-block']"));
        placeorderButton.click();

        Thread.sleep(2000);

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File("screenshot.png"));

        Thread.sleep(2000);
    }
}
