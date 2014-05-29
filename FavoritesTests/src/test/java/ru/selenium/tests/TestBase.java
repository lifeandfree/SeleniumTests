package ru.selenium.tests;

import org.openqa.selenium.By;

public class TestBase extends TestKernel
{
    private static final String PasswordSuperUser = "n@usd40";
    private static final String PasswordUser = "123";
    private static final String LoginSuperUser = "naumen";
    private static final String LoginUser = "TCH";

    protected void LoginInAppBySuperUser() {
                    LoginFromSuperUser();
                    SeleniumMethod.clickButtonSelector("input.submit-button");
    }
    
    protected void LoginInAppByUser() {
    	enterLoginAndPassword(LoginUser, PasswordUser);
        SeleniumMethod.clickButtonSelector("input.submit-button");
}
    
    protected void LoginFromUser() {
            enterLoginAndPassword(LoginUser, PasswordUser);
            SeleniumMethod.clickButtonSelector("input.submit-button");
    }

    private void LoginFromSuperUser() {
                    enterLoginAndPassword(LoginSuperUser, PasswordSuperUser);
            }

    protected void LogoutFromApp() {
            SeleniumMethod.clickToElement("gwt-debug-logout");
    }

    public void returnToFavoritiesListPage(String text) {
            SeleniumMethod.find(By.linkText(text)).click();
    }

    protected void tabReqest() {
        SeleniumMethod.clickToElement("gwt-debug-Tab.f96e2fb5-13ad-00b5-0000-00007a056193");
        }
    
    protected void createFavoritesElement(FavoritesObject validFavorites) {
            SeleniumMethod.clickToElement("gwt-debug-favorite");
        fillAddFavoritesForm(validFavorites);
        SeleniumMethod.clickButtonSelector("#gwt-debug-apply > div > div.g-button-text");
    }

    public void fillAddFavoritesForm(FavoritesObject favoritesObject) {
            SeleniumMethod.type("gwt-debug-title-value", favoritesObject.name);
    }

    private void enterLoginAndPassword(String login, String password) {
            SeleniumMethod.type("username", login);
            SeleniumMethod.type("password", password);
    }
}
