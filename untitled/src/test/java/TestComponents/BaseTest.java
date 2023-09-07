package TestComponents;

import Pages.Account;
import Pages.Adress;
import Pages.Product;
import Pages.Search;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static TestComponents.ConfigReader.properties;
import static TestComponents.DriverSetup.driver;

public class BaseTest {

    public Account account;
    public Search search;
    public Product product;
    public Adress adress;

    @BeforeTest
    public void setUp() {
        properties = ConfigReader.initializeProperties();
        driver = DriverSetup.initializeDriver(properties.getProperty("browser"));
        driver.get(properties.getProperty("url"));
        account = new Account();
        search = new Search();
        product = new Product();
        adress = new Adress();
    }

    @AfterTest
    public void driverClose() {
        driver.quit();
    }
}
