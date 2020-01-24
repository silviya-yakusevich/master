import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By promoField = By.xpath("//input[@id='rpromo']"); //поле для ввода промокода
    public By promoLink = By.xpath("//a[text()='У меня есть промокод']");//ссылка "У меня есть промокод"
    public By promoValidateText = By.xpath("//div[@class='result']");// поле текста валидационного сообщения
    public By calc_amount = By.xpath("(//div[@class='rcalc_item_input']//input[@type = 'text'])[1]"); // поле значения суммы
    public By calc_days = By.xpath("(//div[@class='rcalc_item_input']//input[@type = 'text'])[2]");  // поле значения дней
    public By sum_slider = By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"); //слайдер суммы
    public By days_slider = By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"); //слайдер дней
    public By getMoneyButton = By.xpath("//div[@class='rcalc_submit btn btn_red']");// кнопка "Получить деньги" на калькуляторе
    public By loginButton = By.xpath("//a[@class='header_private_link']"); // кнопка "Личный кабинет"

    public By about = By.xpath("//a[text() = 'О нас']");
    public By howItWorks = By.xpath("//a[text() = 'Как это работает']");
    public By recieveMoney = By.xpath("//a[text() = 'Как получить']");
    public By returnCredit = By.xpath("//a[text() = 'Как погасить']");
    public By faq = By.xpath("//a[text() = 'Вопросы и ответы']");
    public By news = By.xpath("//li[@id = 'menu-item-104']//a[text() = 'Новости']");
    public By docs = By.xpath("//li[@id = 'menu-item-10649']//a[text() = 'Документы']");
    public By inform = By.xpath("//li[@id = 'menu-item-5796']//a[text() = 'Раскрытие информации']");
    public By contacts = By.xpath("//li[@id = 'menu-item-109']//a[text() = 'Контакты']");
    public By spisok = By.xpath("//li[@id = 'menu-item-12018']//a[text() = 'Список участников']");
    public By scheme = By.xpath("//li[@id = 'menu-item-12019']//a[text() = 'Схема взаимосвязей участников']");
    public By zhaloba =By.xpath("//li[@id = 'menu-item-13888']//a[text() = 'Пожаловаться']");
    public By invest = By.xpath("//a[@href = 'https://investor.moneyman.ru/']");

   // String getValidateText = driver.findElement(promoValidateText).getText();

    public MainPage clickPromo()// кликнуть "У меня есть промокод"
    {
        driver.findElement(promoLink).click();//кликнуть на кнопку "У меня есть промокод" на калькуляторе
        return this;

    }

    public MainPage checkResponseCode (int expectedCode) throws IOException // получение response code
    {

        URL url = new URL(driver.getCurrentUrl());
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");

        int code = http.getResponseCode();
        Assert.assertEquals(driver.getCurrentUrl(),expectedCode, code);

        return this;
    }

    public String sendPromo(String promo) // ввести промокод
    {

        try {
            driver.findElement(promoField).sendKeys(promo); //вставить значение промокода в поле
            driver.findElement(promoField).sendKeys(Keys.TAB); //анфокус
            WebDriverWait wait = (new WebDriverWait(driver, 10));// явное ожидание
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(promoValidateText)));//условие  ожидания - пока не появится элемент с текстом о корректности/некорректности промокода
            String result = driver.findElement(promoValidateText).toString();
            return result;
        }

        catch (Exception e)
        {
            String result = e.toString();
            return result;
        }

    }

    public MainPage printValidMessage (String promo) // вывод валидационного сообщения
    {
        System.out.println("Message for " + promo + " - " + getValidateText()); // вывод текста валидационного сообщения
        return this;
    }

    public MainPage clearPromo () //очистить поле промокода
    {
        driver.findElement(promoField).clear();//очистка поля промокода
        WebDriverWait wait = (new WebDriverWait(driver,10));// явное ожидание
        wait.until (ExpectedConditions.invisibilityOf(driver.findElement(promoValidateText)));//условие  ожидания - пока не скроется валидациоонное сообщение для удаленного промокода
        driver.findElement(promoField).sendKeys(Keys.TAB);//анфокус
        return this;
    }

    public String getValidateText () //получить текст валидацинного сообщения
    {
        String text = driver.findElement(promoValidateText).getText(); //текст валидациооного сообщения
        return text;
    }

    public String promocodeCookie () //проверка создания куки checkpromocode и ее значения
    {
       String check = driver.manage().getCookieNamed("promocode").getValue(); //значение параметра promocode в куках
       return check;
    }

    public MainPage setCookie (String cookieName, String promo) //засетать куку
    {

        Cookie promocode = new Cookie(cookieName, promo);
        driver.manage().addCookie(promocode);
        driver.navigate().refresh();

        return this;
    }

    public MainPage calcValue(String expectedSum, String expectedDays)//сравнение дефолтнах знаечений суммы
    {
        String sumValue = driver.findElement(calc_amount).getAttribute("value");//значение суммы на калькуляторе
        String daysValue = driver.findElement(calc_days).getAttribute("value");//значение дней  на калькуляторе

        Assert.assertEquals(expectedSum, sumValue);
        Assert.assertEquals(expectedDays, daysValue);


        return this;
    }

    public MainPage dragAndDrop( int xOffset, int yOffset) // перетаскивание ползунка
    {
        Actions move = new Actions(driver);
        WebElement sumSlider = driver.findElement(sum_slider);
        WebElement daysSlider = driver.findElement(days_slider);
        move.dragAndDropBy(sumSlider, xOffset, yOffset).release().build().perform();
        move.dragAndDropBy(daysSlider, xOffset, yOffset).release().build().perform();
        return this;
    }

    public MainPage authRegistration () //авторизация на странице регистрации (для мастера)
    {
        driver.get("https://moneyman:1005@qa-delivery-ru-master.moneyman.ru/registration/static/step1.html");
        driver.navigate().back();
        return this;
    }

    public MainPage clickGetMoney ()// кликунть на кнопку "Получить деньги"
    {
        driver.findElement(getMoneyButton).click();//переход на регистрацию

        return this;
    }
    public MainPage clickLogin () //кликунть на кнопку логина
    {
        driver.findElement(loginButton).click();//переход на регистрацию

        return this;
    }

    public MainPage checkAllCookies (String cookiePartner, String cookieAnother, String landCodeRU) // проверка кук
    {
        String partner = driver.manage().getCookieNamed("partner").getValue();
        String source = driver.manage().getCookieNamed("partner_utm_source").getValue();
        String medium = driver.manage().getCookieNamed("partner_utm_medium").getValue();
        String campaign = driver.manage().getCookieNamed("partner_utm_campaign").getValue();
        String keyword = driver.manage().getCookieNamed("partner_keyword").getValue();
        String wmid = driver.manage().getCookieNamed("partner_wmid").getValue();
        String term = driver.manage().getCookieNamed("partner_utm_term").getValue();
        String content = driver.manage().getCookieNamed("partner_utm_content").getValue();
        String landCode =  driver.manage().getCookieNamed("partner_landing_code").getValue();

        Assert.assertEquals("partner", cookiePartner,partner);
        Assert.assertEquals("source",cookieAnother,source);
        Assert.assertEquals("medium",cookieAnother,medium);
        Assert.assertEquals("campaign",cookieAnother,campaign);
        Assert.assertEquals("keyword",cookieAnother,keyword);
        Assert.assertEquals("wmid",cookieAnother,wmid);
        Assert.assertEquals("term",cookieAnother,term);
        Assert.assertEquals("content",cookieAnother,content);
        Assert.assertEquals("landCode",landCodeRU,landCode);

        return this;
    }





    public MainPage clickMenu(By link) {
        driver.findElement(link).click();
        return this;
    }


    public MainPage comparison (String h1) {

        String getlink = driver.getCurrentUrl();
        Assert.assertEquals(getlink, h1, driver.findElement(By.xpath("//h1")).getText());

        return this;
    } // сравнение заголовка с заданным значением

    public MainPage tabs() //переключение между вкладками
    {
        for  (String windowHandle : driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }
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

    public MainPage quit()//закрытие браузера
    {
        driver.quit();
        return this;
    }



}
