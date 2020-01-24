import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

@RunWith(Enclosed.class)
public class MainPageTest {


    public static class MMRUmain {

    private WebDriver driver;
    private MainPage mainPage;



        @Before
        public void setUp() {

//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//
          System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
          ChromeOptions options = new ChromeOptions();
          options.setHeadless(true);
          options.addArguments("--window-size=1920,1080");
          driver = new ChromeDriver(options);


          driver.get("http://moneyman:1005@qa-delivery-ru-master.moneyman.ru?partner=mmru&utm_source=mm&utm_medium=mm&utm_campaign=mm&keyword=mm&wmid=mm&utm_term=mm&utm_content=mm");
          mainPage = new MainPage(driver);
        }

        @Test
        public void correctPromo() {
            mainPage.clickPromo();
            String resultMessage = mainPage.sendPromo("MF");
            Assert.assertEquals("Ваша скидка 90%", resultMessage);
        }

        @Test
        public void incorrectPromo() {
            mainPage.clickPromo();
            String resultMessage = mainPage.sendPromo("147");
            Assert.assertEquals("Введен неверный промокод", resultMessage);
        }

        @Test
        public void cookiePromo() {

            mainPage.setCookie("promocode", "MF");
            mainPage.promocodeCookie();

            Assert.assertEquals("MF", mainPage.promocodeCookie());
        }

        @Test
        public void checkCookies() {

            mainPage.clickGetMoney();
            mainPage.checkAllCookies("mmru", "mm", "101");

            driver.get("http://moneyman:1005@qa-delivery-ru-master.moneyman.ru?partner=123");
            mainPage.clickGetMoney();
            mainPage.checkAllCookies("123", "NULL", "101");
        }

        @Test
        public void defaultValue() {

            mainPage.checkCalcValue("9000", "24");
            mainPage.dragAndDrop(15, 0);
            mainPage.checkCalcValue("11500", "25");

        }


        @Test

        public void regPage() {

            mainPage.authRegistration();
            mainPage.clickGetMoney();
            Assert.assertTrue("Reqistration button", driver.getCurrentUrl().contains("qa-delivery-ru-master.moneyman.ru/registration/static/step1.html"));
            driver.navigate().back();
            mainPage.clickLogin();
            Assert.assertTrue("Login button", driver.getCurrentUrl().contains("qa-delivery-ru-master.moneyman.ru/secure/login"));
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
        public void tearDown() {
            mainPage.quit();

        }
    }

    public static class lpmain_values {


        private WebDriver driver;
        private MainPage mainPage;

        @Before
        public void setUp2() {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            //options.setHeadless(true);
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
            mainPage = new MainPage(driver);
        }

        @Test
        public void defaultValue_lpmain() {

           driver.get("http://moneyman:1005@qa-delivery-ru-master.moneyman.ru/lp/main");
            mainPage.checkLpMainCalcValues();

        }

        @Test
        public void defaultValue_lpmain3() {

            driver.get("http://moneyman:1005@qa-delivery-ru-master.moneyman.ru/lp/main3");

            mainPage.checkCalcValue("12000", "15");
            mainPage.dragAndDrop(15, 0);
            mainPage.checkCalcValue("14500", "16");

        }

//        @After
//        public void tearDown() {
//            mainPage.quit();
//
//        }



    }

    public static class MMRU_prod {

        private WebDriver driver;
        private MainPage mainPage;

        @Before
        public void setUp3() {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
            mainPage = new MainPage(driver);
        }

        @Test
        public void thereAreNoIndex(){

            driver.get("http://moneyman.ru/");
            Assert.assertEquals("There are no noindex,nofollow", mainPage.noIndex());

        }

        @Test
        public void responseCodeReg() throws IOException {

            driver.get("http://moneyman.ru/");
            driver.findElement(mainPage.getMoneyButton).click();
            mainPage.checkResponseCode(200);

        }

        @Test
        public void responseCodeLogin() throws IOException {


            driver.get("http://moneyman.ru/");
            driver.findElement(mainPage.loginButton).click();
            mainPage.checkResponseCode(200);
        }

        @Test
        public void responseCodeLPMain() throws IOException {

            driver.get("http://moneyman.ru/lp/main");
            mainPage.checkResponseCode(200);
        }

        @Test
        public void responseCodeLPMain3() throws IOException {

            driver.get("http://moneyman.ru/lp/main3");
            mainPage.checkResponseCode(200);
        }

        @After
        public void tearDown() {
            mainPage.quit();

        }

    }

    }





