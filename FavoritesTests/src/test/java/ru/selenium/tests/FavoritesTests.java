package ru.selenium.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тестирование функциональности избранного
 * @author isuhachev
 * @since 28.05.2014
 */
public class FavoritesTests extends TestBase
{
    @After
    public void afterTest() throws Exception
    {
    	LogoutFromApp();
    }
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
     * <li>Проверяем наличие добавленной вкладки в избранное</li>
     * <li>Проверяем название соотвествует введенному при добавлении</li>
     * </ol>
     */
    @Test
    public void testValidFavoritesCanBeCreatedTest() throws Exception
    {
    	String titleFavorites = AdditionalUtils.randomString(10);
    	FavoritesObject validFavorites = new FavoritesObject(titleFavorites);
    	LoginInAppByUser();
        TransitionToOperatorMode();
        createFavoritesElement(validFavorites);
        returnToFavoritiesListPage(titleFavorites);
        AdditionalUtils.waitMs(3000L);
        Assert.assertTrue(SeleniumMethod.findElementLinkOnForm(titleFavorites));
        String elementLinkText = SeleniumMethod.getElementsLinkText(titleFavorites);
        Assert.assertEquals("Not get the text.", titleFavorites, elementLinkText);
    }
    
    /**
    * Тестирование добавления элемента функциональности избранного с перелогином.
    * <br>
    * <ol>
    * <b>Подготовка.</b>
    * <br>
    * <b>Выполнение действия</b>
    * <li>Заходим в режиме оператора</li>
    * <li>Нажимаем кнопку Добавить избранное</li>
    * <li>На форме добавления заполнить поле: название</li>
    * <li>Нажать Сохранить</li>
    * <li>Разлогиниваемся</li>
    * <li>Залогиниваемся</li>
    * <li>Заходим в режиме оператора</li>
    * <br>
    * <b>Проверки</b>
    * <li>Проверяем наличие добавленной вкладки в избранное</li>
    * </ol>
    */
    @Test
    public void testValidFavoritesCanBeChecked() throws Exception
    {
    	String titleFavorites = AdditionalUtils.randomString(10);
    	FavoritesObject validFavorites = new FavoritesObject(titleFavorites);
    	LoginInAppByUser();
        TransitionToOperatorMode();
        tabReqest();
        createFavoritesElement(validFavorites);
        returnToFavoritiesListPage(titleFavorites);
        AdditionalUtils.waitMs(3000L);
        LogoutFromApp();
        LoginInAppByUser();
        TransitionToOperatorMode();
        returnToFavoritiesListPage(titleFavorites);
        Assert.assertTrue(SeleniumMethod.findElementLinkOnForm(titleFavorites));
    }
    
    /**
    * Тестирование нахождение кнопки добавить в избранное.
    * <br>
    * <ol>
    * <b>Подготовка.</b>
    * <br>
    * <b>Выполнение действия</b>
    * <li>Заходим в режиме оператора</li>
    * <br>
    * <b>Проверки</b>
    * <li>Проверяем наличие кнопки Добавить в избранное</li>
    * </ol>
    */
    @Test
    public void testValidFavoritesButton() throws Exception
    {
    	LoginInAppByUser();
        TransitionToOperatorMode();
        Assert.assertTrue(SeleniumMethod.findElementButtonOnForm(Constants.GWT_DEBUG_FAVORITE));
    }
    
    /**
    * Тестирование добавления элемента функциональности избранного с перелогином.
    * <br>
    * <ol>
    * <b>Подготовка.</b>
    * <br>
    * <b>Выполнение действия</b>
    * <li>Заходим в режиме оператора</li>
    * <br>
    * <b>Проверки</b>
    * <li>Проверяем зоголовок в названии формы добавления избранного</li>
    * </ol>
    */
    @Test
    public void testFormToAddToFavorites() throws Exception
    {
    	LoginInAppByUser();
        TransitionToOperatorMode();
        SeleniumMethod.clickToElement(Constants.GWT_DEBUG_FAVORITE);
        assertEquals(Constants.ADD_FOVORITES_TEXT, SeleniumMethod.getElementsText(Constants.GWT_DEBUG_PROPERTY_DIALOG_BOX_CAPTION));
    }
    
	/**
     * Тестирование добавления элемента функциональности избранного.
     * <br>
     * <ol>
     * <b>Подготовка.</b>
     * <br>
     * <b>Выполнение действия</b>
     * <li>Заходим в режиме оператора</li>
     * <li>Добавляем в избранное</li>
     * <li>Разлогиваемся</li>
     * <li>Залогиниваемся под другим пользователем</li>
     * <br>
     * <b>Проверки</b>
     * <li>Проверяем, что данной вкладки нет</li>
     * </ol>
     */
    @Test
    public void testValidFavoritesNotFoundbyOtherUser() throws Exception
    {
    	String titleFavorites = AdditionalUtils.randomString(10);
    	FavoritesObject validFavorites = new FavoritesObject(titleFavorites);
    	LoginInAppByUser();
        TransitionToOperatorMode();
        createFavoritesElement(validFavorites);
        AdditionalUtils.waitMs(3000L);
        Assert.assertTrue(SeleniumMethod.findElementLinkOnForm(titleFavorites));
        AdditionalUtils.waitMs(1000L);
        LogoutFromApp();
        LoginInAppBySuperUser();
        TransitionToOperatorMode();
        AdditionalUtils.waitMs(3000L);
        Assert.assertFalse(SeleniumMethod.findElementLinkOnForm(titleFavorites));
    }
}
