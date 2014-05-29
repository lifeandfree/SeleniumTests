package ru.selenium.tests;

public class AdditionalUtils
{

    public static void waitMs(long ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

}
