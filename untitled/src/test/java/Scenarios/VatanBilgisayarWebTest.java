package Scenarios;

import TestComponents.BaseTest;
import TestComponents.ConfigReader;
import org.testng.annotations.Test;

import static TestComponents.DriverSetup.driver;
import static org.testng.Assert.*;

public class VatanBilgisayarWebTest extends BaseTest {

    @Test(priority = 1)
    void verifyUrl() {
        assertEquals(driver.getCurrentUrl(), "https://www.vatanbilgisayar.com/");
    }

    @Test(priority = 2)
    void verifySuccessfulLogin() {
        account.goToLoginPage();
        account.login(ConfigReader.properties.getProperty("email"), ConfigReader.properties.getProperty("password"));
        assertEquals(account.accountText().toLowerCase(), "Hesabım".toLowerCase());
    }

    @Test(dependsOnMethods = "verifySuccessfulLogin")
    void verifySuccessfulProductSearch() {
        search.searchProduct(ConfigReader.properties.getProperty("product"));
        assertTrue(search.getResultText().toLowerCase().contains(ConfigReader.properties.getProperty("product").toLowerCase()));
    }

    @Test(dependsOnMethods = "verifySuccessfulProductSearch")
    void verifyProductPrice() {
        product.selectProduct();
        product.goToCart();
        adress.newAddress();
    }
}
