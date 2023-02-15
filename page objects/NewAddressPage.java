package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewAddressPage {
    private static WebDriver driver;

    public NewAddressPage(WebDriver driver) {

        this.driver = driver;
    }


    public void createAddress(String alias, String address, String city, String zip, String phone) {

        WebElement aliasInput = driver.findElement(By.id("field-alias"));
        aliasInput.click();
        aliasInput.sendKeys(alias);

        WebElement addressInput = driver.findElement(By.id("field-address1"));
        addressInput.click();
        addressInput.sendKeys(address);

        WebElement cityInput = driver.findElement(By.id("field-city"));
        cityInput.click();
        cityInput.sendKeys(city);

        WebElement zipInput = driver.findElement(By.id("field-postcode"));
        zipInput.click();
        zipInput.sendKeys(zip);

        WebElement phoneInput = driver.findElement(By.id("field-phone"));
        phoneInput.click();
        phoneInput.sendKeys(phone);

        WebElement saveButton = driver.findElement(By.cssSelector("button[class='btn btn-primary form-control-submit float-xs-right']"));
        saveButton.click();
    }

        public String getSuccessMessage(){
            WebElement successMessage = driver.findElement(By.className("alert-success"));
            return successMessage.getText();

        }
    }
