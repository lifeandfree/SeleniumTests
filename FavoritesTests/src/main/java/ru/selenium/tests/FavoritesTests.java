package ru.selenium.tests;

import org.junit.Assert;
import org.junit.Test;

public class FavoritesTests extends TestBase
{

    protected String titleFavorites = "22";

    @Test
    public void testValidFavoritesCanBeCreated() throws Exception
    {
        FavoritesObject validFavorites = new FavoritesObject(titleFavorites);
        LoginInApp();
        //clickAddFavoritesElements();
        createFavoritesElement(validFavorites);
        returnToFavoritiesListPage(titleFavorites);
        AdditionalUtils.waitMs(1000L);
        Assert.assertTrue(SeleniumMethod.findElementOnForm(titleFavorites));
        String elementLinkText = SeleniumMethod.getElementsText(titleFavorites);
        Assert.assertEquals("Not get the text.", titleFavorites, elementLinkText);
        AdditionalUtils.waitMs(1000L);
        //driver.findElement(By.id("gwt-debug-YES")).click();
        LogoutFromApp();
    }

    //	private void submitFavoritesCreation() {
    //		driver.findElement(By.cssSelector("#gwt-debug-apply > div > div.g-button-text")).click();
    //	}

    //	private void clickAddFavoritesElements() {
    //		driver.findElement(By.id("gwt-debug-favorite")).click();
    //	}

    //	private void clickButtonForLogin() {
    //		driver.findElement(By.cssSelector("input.submit-button")).click();
    //	}

    //	  private boolean isAlertPresent() {
    //	    try {
    //	      driver.switchTo().alert();
    //	      return true;
    //	    } catch (NoAlertPresentException e) {
    //	      return false;
    //	    }
    //	  }
    //
    //	  private String closeAlertAndGetItsText() {
    //	    try {
    //	      Alert alert = driver.switchTo().alert();
    //	      String alertText = alert.getText();
    //	      if (acceptNextAlert) {
    //	        alert.accept();
    //	      } else {
    //	        alert.dismiss();
    //	      }
    //	      return alertText;
    //	    } finally {
    //	      acceptNextAlert = true;
    //	    }
    //	  }

}
