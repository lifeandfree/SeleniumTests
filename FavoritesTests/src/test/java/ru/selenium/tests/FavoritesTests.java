package ru.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Тестирование функциональности избранного
 * @author isuhachev
 * @since 28.05.2014
 */
public class FavoritesTests extends TestBase
{
//    @Before
//    public void setUp() throws Exception
//    {
//    	
//    }
     /**
     * Тестирование добавления элемента функциональности избранного.
     * <br>
     * <ol>
     * <b>Подготовка.</b>
     * <br>
     * <b>Выполнение действия</b>
     * <li>Заходим в режиме оператора</li>
     * <li>Нажимаем кнопку Добавить избранное</li>
     * <li>На форме добавления заполнить поле: название</li>
     * <li>Нажать Сохранить</li>
     * <br>
     * <b>Проверки</b>
     * <li>Проверяем наличие давленной вкладки избранное</li>
     * <li>Проверяем название соотвествует введенному при добавлении</li>
     * </ol>
     */
    @Test
    public void testValidFavoritesCanBeCreatedTest() throws Exception
    {
    	String titleFavorites = AdditionalUtils.randomString(1000);
    	FavoritesObject validFavorites = new FavoritesObject(titleFavorites);
        LoginInAppBySuperUser();
        createFavoritesElement(validFavorites);
        returnToFavoritiesListPage(titleFavorites);
        AdditionalUtils.waitMs(3000L);
        Assert.assertTrue(SeleniumMethod.findElementOnForm(titleFavorites));
        String elementLinkText = SeleniumMethod.getElementsText(titleFavorites);
        Assert.assertEquals("Not get the text.", titleFavorites, elementLinkText);
        AdditionalUtils.waitMs(1000L);
        LogoutFromApp();
    }
    
    @Test
    public void testValidFavoritesCanBeChecked() throws Exception
    {
    	String titleFavorites = AdditionalUtils.randomString(1000);
    	FavoritesObject validFavorites = new FavoritesObject(titleFavorites);
        LoginInAppBySuperUser();
        tabReqest();
        createFavoritesElement(validFavorites);
        returnToFavoritiesListPage(titleFavorites);
        AdditionalUtils.waitMs(3000L);
        LogoutFromApp();
        LoginInAppBySuperUser();
        returnToFavoritiesListPage(titleFavorites);
        Assert.assertTrue(SeleniumMethod.findElementOnForm(titleFavorites));
        AdditionalUtils.waitMs(1000L);
        LogoutFromApp();
    }

}
