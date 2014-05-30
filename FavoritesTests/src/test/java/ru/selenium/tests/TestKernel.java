package ru.selenium.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestKernel
{
    private static WebDriver driver;

    private static String baseUrl = "http://192.168.240.92:10080/sd/";

    private static StringBuffer verificationErrors = new StringBuffer();

    public static WebDriver getDriver()
    {
        return driver;
    }

    @BeforeClass
    public static void setUp() throws Exception
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        openMainLoginPage();
    }

    @AfterClass
    public static void tearDown() throws Exception
    {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString))
        {
            fail(verificationErrorString);
        }
    }

    protected static void openMainLoginPage()
    {
        driver.get(baseUrl);
    }
}
