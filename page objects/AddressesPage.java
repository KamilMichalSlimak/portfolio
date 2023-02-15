package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressesPage {

    private static WebDriver driver;

    public AddressesPage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickCreateNewAddress(){

        WebElement createNewAddressElement = driver.findElement(By.cssSelector("a[data-link-action='add-address']"));
        createNewAddressElement.click();


    }

    }

