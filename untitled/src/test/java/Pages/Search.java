package Pages;

import PageComponents.Helper;
import org.openqa.selenium.By;

public class Search extends Helper {
    By searchBox = By.id("navbar-search-input");
    By searchBtn = By.cssSelector("button.search__button");
    By resultText = By.id("suggestionSearchİtem");

    //--------------------------------------------------------------//

    public void searchProduct(String product) {
        sendKeys(searchBox, product);
        click(searchBtn);
    }

    public String getResultText() {
        return find(resultText).getText();
    }
}
