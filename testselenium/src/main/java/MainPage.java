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

    public By promoField = By.className("mainCalculator__input__promo"); //поле для ввода промокода
    public By promoLink = By.xpath("//label[text()='У меня есть промокод']");//ссылка "У меня есть промокод"
    public By promoValidateText = By.xpath("//span[@class='validateText']");// поле текста валидационного сообщения
    public By calc_amount = By.xpath("//input[@id = 'money']"); // поле значения суммы
    public By calc_days = By.xpath("//input[@id = 'days']");  // поле значения дней
    public By sum_slider = By.xpath("//div[@class='mainCalculator__slider mainCalculator__sum ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[1]"); //слайдер суммы
    public By days_slider = By.xpath("//div[@class='mainCalculator__date mainCalculator__slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[1]"); //слайдер дней
    public By getMoneyButton = By.className("mainCalculator__center");// кнопка "Получить деньги" на калькуляторе
    public By loginButton = By.className("header_private_link"); // кнопка "Личный кабинет"

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
        driver.findElement(promoLink).click();//кликнуть на кнопку "Уменя есть промокод" на калькуляторе
        return this;

    }

    public MainPage sendPromo(String promo)// ввести промокод
    {
        driver.findElement(promoField).sendKeys(promo); //вставить значение промокода в поле
        driver.findElement(promoField).sendKeys(Keys.TAB); //анфокус
        WebDriverWait wait = (new WebDriverWait(driver,10));// явное ожидание
        wait.until (ExpectedConditions.visibilityOf(driver.findElement(promoValidateText)));//условие  ожидания - пока не появится элемент с текстом о корректности/некорректности промокода
        return this;
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

    public String checkpromocodeCookie () //проверка создания куки checkpromocode и ее значения
    {
       String check = driver.manage().getCookieNamed("checkpromocode").getValue(); //значение параметра checkpromocode в куках
       return check;
    }

    public MainPage setCookie (String cookieName, String promo) //засетать куку
    {

        Cookie promocode = new Cookie(cookieName, promo);
        driver.manage().addCookie(promocode);
        driver.navigate().refresh();

        return this;
    }

    public MainPage calcValue(String sum, String days)//сравнение дефолтнах знаечений суммы
    {
        String sumValue = driver.findElement(calc_amount).getAttribute("value");//значение суммы на калькуляторе
        String daysValue = driver.findElement(calc_days).getAttribute("value");//значение дней  на калькуляторе

          Assert.assertTrue("Default sum is correct", sumValue.equals(sum));
          Assert.assertTrue("Default days are correct", daysValue.equals(days));


        return this;
    }

    public MainPage dragAndDrop( int xOffset, int yOffset) // перетаскивание ползунка
    {
        Actions move = new Actions(driver);
        WebElement sumSlider = driver.findElement(sum_slider);
        WebElement daysSlider = driver.findElement(days_slider);
        move.dragAndDropBy(sumSlider, xOffset,yOffset).release().build().perform();
        move.dragAndDropBy(daysSlider, xOffset,yOffset).release().build().perform();
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


    public MainPage checkResponseCode (String link, By button) throws IOException // получение response code
    {
        driver.get(link);
        driver.findElement(button).click();//переход в ЛК
        URL url = new URL(driver.getCurrentUrl());
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");

        int code = http.getResponseCode();
        Assert.assertEquals(200, code);

        return this;
    }


    public MainPage clickMenu(By link) {
        driver.findElement(link).click();
        return this;
    }


    public MainPage comparison (String h1) {

        Assert.assertEquals(h1, driver.findElement(By.xpath("//h1")).getText());
        return this;
    } // сравнение заголовка с заданным значением

    public MainPage tabs() //переключение между вкладками
    {
        for  (String windowHandle : driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }
        return this;
    }

    public MainPage quit()//закрытие браузера
    {
        driver.quit();
        return this;
    }



}
