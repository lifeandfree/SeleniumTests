package ru.selenium.tests;

import org.openqa.selenium.By;

public class TestBase extends TestKernel
{

    public void fillAddFavoritesForm(FavoritesObject favoritesObject)
    {
        SeleniumMethod.type("gwt-debug-title-value", favoritesObject.name);
    }

    public void returnToFavoritiesListPage(String text)
    {
        SeleniumMethod.find(By.linkText(text)).click();
    }

    protected void createFavoritesElement(FavoritesObject validFavorites)
    {
        SeleniumMethod.clickToElement("gwt-debug-favorite");
        fillAddFavoritesForm(validFavorites);
        SeleniumMethod.clickButtonSelector("#gwt-debug-apply > div > div.g-button-text");
    }

    protected void LoginInApp()
    {
        enterLoginAndPassword();
        SeleniumMethod.clickButtonSelector("input.submit-button");
    }

    protected void LogoutFromApp()
    {
        SeleniumMethod.clickToElement("gwt-debug-logout");
    }

    private void enterLoginAndPassword()
    {
        SeleniumMethod.type("username", "naumen");
        SeleniumMethod.type("password", "n@usd40");
    }

}
