package ru.selenium.tests;

import java.util.Random;

/**
 * @author isuhachev
 * Дополнительные утилиты
 */
public class AdditionalUtils
{
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rnd = new Random();

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
    
    public static String randomString( int len ) 
    {
       StringBuilder sb = new StringBuilder( len );
       for( int i = 0; i < len; i++ ) 
          sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
       return sb.toString();
    }

}
