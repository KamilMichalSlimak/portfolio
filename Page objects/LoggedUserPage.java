package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedUserPage {
    private static WebDriver driver;

    public LoggedUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAddresses() {
        WebElement addressesTile = driver.findElement(By.id("addresses-link"));
        addressesTile.click();
    }

}
