import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainPageTest {


    private WebDriver driver;
    private MainPage mainPage;



    @Before
    public void setUp()
    {
       // System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");

       ChromeOptions options = new ChromeOptions();
       options.setHeadless(true);
       options.addArguments("--headless");
       driver = new ChromeDriver(options);

       //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://moneyman:1005@qa-delivery-ru-master.moneyman.ru?partner=mmru&utm_source=mm&utm_medium=mm&utm_campaign=mm&keyword=mm&wmid=mm&utm_term=mm&utm_content=mm");
        mainPage = new MainPage (driver);
    }

    @Test
    public void correctPromo(){
        mainPage.clickPromo();
        mainPage.sendPromo("MF");
        Assert.assertEquals("Ваша скидка 25.00%!", mainPage.getValidateText());
    }

    @Test
    public void incorrectPromo(){
        mainPage.clickPromo();
        mainPage.sendPromo("147");
        Assert.assertEquals("Введен неверный промокод", mainPage.getValidateText());
    }

    @Test
    public void cookiePromo(){

        mainPage.setCookie("promocode","MF");
        mainPage.checkpromocodeCookie();

        Assert.assertEquals("MF", mainPage.checkpromocodeCookie());
    }

    @Test
    public void checkCookies(){

        mainPage.clickGetMoney();
        mainPage.checkAllCookies("mmru","mm", "101");

        driver.get("http://moneyman:1005@qa-delivery-ru-master.moneyman.ru?partner=123");
        mainPage.clickGetMoney();
        mainPage.checkAllCookies("123","NULL", "101");
    }

    @Test
    public void defaultValue(){

        mainPage.calcValue("9000","24");
        mainPage.dragAndDrop(30,0);
        mainPage.calcValue("14000", "29");

    }


    @Test

    public void regPage(){

        mainPage.authRegistration();
        mainPage.clickGetMoney();
        Assert.assertTrue("Reqistration button is ok", driver.getCurrentUrl().contains("qa-delivery-ru-master.moneyman.ru/registration/static/step1.html"));
        driver.navigate().back();
        mainPage.clickLogin();
        Assert.assertTrue("Login button is ok", driver.getCurrentUrl().contains("qa-delivery-ru-master.moneyman.ru/secure/login"));
    }

    @Test
    public void responseCodeReg() throws IOException {

        mainPage.checkResponseCode("https://moneyman.ru", mainPage.getMoneyButton);

    }

    @Test
    public void responseCodeLogin() throws IOException {

        mainPage.checkResponseCode("https://moneyman.ru", mainPage.loginButton);
    }

    @Test
    public void responseCodeMain() throws IOException {

        mainPage.checkResponseCode("https://moneyman.ru/lp/main", mainPage.loginButton);
    }

    @Test
    public void responseCodeMain3() throws IOException {

        mainPage.checkResponseCode("https://moneyman.ru/lp/main3", mainPage.loginButton);
    }

    @Test
    public void clickMenu() throws IOException {

        mainPage.clickMenu(mainPage.about);
        mainPage.comparison("Moneyman – ваш личный финансовый помощник");

        mainPage.clickMenu(mainPage.howItWorks);
        mainPage.comparison("Как это работает");

        mainPage.clickMenu(mainPage.recieveMoney);
        mainPage.comparison("Как получить онлайн займ");

        mainPage.clickMenu(mainPage.returnCredit);
        mainPage.comparison("Как погасить заем");

        mainPage.clickMenu(mainPage.faq);
        mainPage.comparison("Вопросы и ответы");

        mainPage.clickMenu(mainPage.news);
        mainPage.comparison("Новости и акции");

        mainPage.clickMenu(mainPage.docs);
        mainPage.comparison("Документы");

        mainPage.clickMenu(mainPage.inform);
        mainPage.comparison("Раскрытие информации");

        mainPage.clickMenu(mainPage.contacts);
        mainPage.comparison("Контакты");

        mainPage.clickMenu(mainPage.spisok);
        mainPage.comparison("Список акционеров (участников) микрофинансовой компании и лиц, под контролем либо значительным влиянием которых находится микрофинансовая компания");

        mainPage.clickMenu(mainPage.scheme);
        mainPage.comparison("Схема взаимосвязей участников ООО МФК «Мани Мен» и лиц, под контролем либо значительным влиянием которых находится микрофинансовая компания");

        mainPage.clickMenu(mainPage.zhaloba);
        mainPage.comparison("Приемная омбудсмена по правам заемщика");

        mainPage.clickMenu(mainPage.invest);
        mainPage.tabs();
        mainPage.comparison("Зарабатывай вместе с MoneyMan");


    }

    @After
    public void tearDown()
    {
        mainPage.quit();

    }



}
