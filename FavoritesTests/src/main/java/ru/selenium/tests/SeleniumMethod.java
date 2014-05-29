package ru.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumMethod
{

    private static final WebDriver DRIVER = TestKernel.getDriver();

    public static void clickButtonSelector(String selector)
    {
        find(By.cssSelector(selector)).click();
    }

    public static void clickToElement(String id)
    {
        find(By.id(id)).click();
    }

    public static WebElement find(By by)
    {
        return DRIVER.findElement(by);
    }

    public static boolean findElementOnForm(String name)
    {
        return isElementPresent(By.linkText(name));
    }

    public static String getElementsText(String name)
    {
        return find(By.linkText(name)).getText();
    }

    public static boolean isElementPresent(By by)
    {
        try
        {
            find(by);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public static void type(String locator, String name)
    {
        find(By.id(locator)).clear();
        find(By.id(locator)).sendKeys(name);
    }

}
