package Pages;

import PageComponents.Helper;
import org.openqa.selenium.By;

public class Account extends Helper {
    By myAccountBtn = By.id("btnMyAccount");
    By loginBtnFromDropDownMenu = By.cssSelector("ul.login li:first-child");
    By email = By.id("email");
    By password = By.id("pass");
    By loginBtn = By.id("login-button");
    By AccountText = By.cssSelector("#btnMyAccount span[id]");
    By logoutBtnFromDropDownMenu = By.cssSelector(".account li:nth-of-type(6)");

    //--------------------------------------------------------------------------------//

    public void goToLoginPage() {
        click(myAccountBtn);
        click(loginBtnFromDropDownMenu);
    }

    public void login(String email, String password) {
        sendKeys(this.email, email);
        sendKeys(this.password, password);
        click(loginBtn);
    }

    public void logout() {
        click(myAccountBtn);
        click(logoutBtnFromDropDownMenu);
    }

    public String accountText() {
        return find(AccountText).getText();
    }
}




