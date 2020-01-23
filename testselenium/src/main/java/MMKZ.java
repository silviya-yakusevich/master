import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.text.StringContent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MMKZ {

    private WebDriver driver;
    public MMKZ (WebDriver driver) {
        this.driver = driver;
    }


    public By about = By.xpath("//a[text()='О нас']");
    public By howToTakeMoney = By.xpath("//a[text()='Как взять онлайн заем']");
    public By howToGetMoney = By.xpath("//a[text()='Как получить деньги']");
    public By howReturnMoney = By.xpath("//a[text()='Как погасить заем']");
    public By faq = By.xpath("//a[text()='Вопросы и ответы']");
    public By news = By.xpath("(//a[text()='Новости'])[2]");
    public By aboutMicro = By.xpath("(//a[text()='О микрозаймах'])[2]");
    public By articles = By.xpath("(//a[text()='Статьи'])[2]");
    public By contact = By.xpath("(//a[text()='Контакты'])[2]");
    public By app = By.xpath("//a[@title='Приложение MoneyMan']");
    public By ruLang = By.xpath("(//a[@lang='ru-RU'])[1]");
    public By kzLang = By.xpath("(//a[@lang='kk'])[1]");

    public By getMoneyButton = By.xpath("//div[@id='getloan-btn']");// кнопка "Получить деньги" вверху страницы
    public By redMoneyButton = By.xpath("//a[@class='btn btn_red']"); // кнопка "Получить займ онлайн" посередине страницы
    public By loginButton = By.xpath("//a[@class='header_private_link']");// кнопка "Личный кабинет" вверху страницы
    public By greenMoneyButton = By.xpath("//a[@class='btn btn_green']"); //зеленая кнопка "Получить деньги" на внутренних страницах




    public MMKZ checkAllCookies (String cookiePartner, String cookieAnother, String cookieWmid) // проверка кук
    {
        String partner = driver.manage().getCookieNamed("partner").getValue();
        String source = driver.manage().getCookieNamed("partner_utm_source").getValue();
        String medium = driver.manage().getCookieNamed("partner_utm_medium").getValue();
        String campaign = driver.manage().getCookieNamed("partner_utm_campaign").getValue();
        String wmid = driver.manage().getCookieNamed("partner_wmid").getValue();
        String term = driver.manage().getCookieNamed("partner_utm_term").getValue();
        String content = driver.manage().getCookieNamed("partner_utm_content").getValue();

        Assert.assertEquals("partner", cookiePartner,partner);
        Assert.assertEquals("source",cookieAnother,source);
        Assert.assertEquals("medium",cookieAnother,medium);
        Assert.assertEquals("campaign",cookieAnother,campaign);
        Assert.assertEquals("wmid",cookieWmid,wmid);
        Assert.assertEquals("term",cookieAnother,term);
        Assert.assertEquals("content",cookieAnother,content);

        return this;
    }

    public MMKZ clickGetMoneyButton (){

        driver.findElement(getMoneyButton).click();

        return this;
    }

    public MMKZ clickLinks(By link) {

        driver.findElement(link).click();
        return this;
    }

    public MMKZ comparison (String h1){

        String getlink = driver.getCurrentUrl();
        Assert.assertEquals(getlink, h1, driver.findElement(By.xpath("//h1")).getText());

        return this;
    }

    public MMKZ tabs() //переключение между вкладками
    {
        for  (String windowHandle : driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }
        return this;
    }

    public MMKZ checkResponseCode (int expectedCode) throws IOException // получение response code
    {

        URL url = new URL(driver.getCurrentUrl());//вытаскиваем урл и передаем в URL
        HttpURLConnection http = (HttpURLConnection) url.openConnection();// устанавливаем соединение
        http.setRequestMethod("GET");//задаем метод
        int code = http.getResponseCode();//получаем код ответа

        Assert.assertEquals(driver.getCurrentUrl(),expectedCode, code); //сравниваем

        return this;
    }

    public String  noIndex() {

        try {

            WebElement element = driver.findElement(By.xpath("//meta[@content='noindex, nofollow']"));

            String result = "There are noindex,nofollow";
            return result;

        } catch (NoSuchElementException e) {

            String result = "There are no noindex,nofollow";
            return result;

        }
    }


        public MMKZ quit(){

            driver.quit();
            return this;
        }

    }









