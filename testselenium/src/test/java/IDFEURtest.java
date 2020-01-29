import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RunWith(Enclosed.class)
public class IDFEURtest {


    public static class IDFEUR_Master {
        private WebDriver driver;
        private IDFEurasia idfEurasia;

        @Before
        public void setUp() {
            //System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
            //driver = new FirefoxDriver();


            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);


            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://moneyman:1005@qa-delivery-idfinance-eurasia-ru-master.moneyman.ru/");

            idfEurasia = new IDFEurasia(driver);

        }

        @Test //проверка отправки формы заявки на вакансию
        public void sendCV() throws IOException {
           idfEurasia.openVacation("http://qa-delivery-idfinance-eurasia-ru-master.moneyman.ru/career/positions/?department=all&location=all");
           idfEurasia.fillTheForm("ТЕСТ", "ТЕСТ", "test@test.te", "ТЕСТ", "C:\\Users\\User10\\Desktop\\test.docx");
           idfEurasia.sendTheForm();
           Assert.assertEquals("Ваше сообщение отправлено. Мы свяжемся с Вами в ближайшее время.", driver.findElement(idfEurasia.thanks).getText());
           idfEurasia.openTheMailbox();
           idfEurasia.checkTheMail("test@test.te");

        }


        @Test//прокликивание основных страниц, сопоставление title
        public void clickLinks() throws IOException {
            idfEurasia.clickMenu(idfEurasia.allLang);
            idfEurasia.clickMenu(idfEurasia.kzLang);
            idfEurasia.equalTitle("IDF Eurasia – ақылды қаржылық шешімдер");

            idfEurasia.clickMenu(idfEurasia.allLang);
            idfEurasia.clickMenu(idfEurasia.enLang);
            idfEurasia.equalTitle("IDF Eurasia – smart financial solutions");

            idfEurasia.clickMenu(idfEurasia.allLang);
            idfEurasia.clickMenu(idfEurasia.ruLang);
            idfEurasia.equalTitle("IDF Eurasia – умные финансовые решения");

            idfEurasia.clickMenu(idfEurasia.about);
            idfEurasia.equalTitle("О нас - IDF Eurasia");

            idfEurasia.clickMenu(idfEurasia.investors);
            idfEurasia.equalTitle("Инвесторам - IDF Eurasia");

            idfEurasia.clickMenu(idfEurasia.sustainability);
            idfEurasia.equalTitle("Устойчивое развитие - IDF Eurasia");

            idfEurasia.clickMenu(idfEurasia.media);
            idfEurasia.equalTitle("Медиа - IDF Eurasia");

            idfEurasia.moveToElement(idfEurasia.investors);
            idfEurasia.clickMenu(idfEurasia.stock);
            idfEurasia.equalTitle("Облигации - IDF Eurasia");

            idfEurasia.moveToElement(idfEurasia.investors);
            idfEurasia.clickMenu(idfEurasia.loans);
            idfEurasia.equalTitle("Инвестиционные займы - IDF Eurasia");

            idfEurasia.clickMenu(idfEurasia.privacyPolicy);
            idfEurasia.equalTitle("Privacy Policy - IDF Eurasia");

            idfEurasia.clickMenu(idfEurasia.legalNotice);
            idfEurasia.equalTitle("Legal Notice - IDF Eurasia");

            idfEurasia.clickMenu(idfEurasia.cookiesPolicy);
            idfEurasia.equalTitle("Cookies Policy - IDF Eurasia");

        }


        @Test//проверка фильтра на странице "Карьера"
        public void clickPositionsParams() throws IOException {
            idfEurasia.chooseVacanciesParams(idfEurasia.careerRussia);
            idfEurasia.checkCareerTitle("Вакансии в России");
            driver.navigate().back();

            idfEurasia.chooseVacanciesParams(idfEurasia.careerKazahstan);
            idfEurasia.checkCareerTitle("Вакансии в Казахстане");
            driver.navigate().back();

            idfEurasia.chooseVacanciesParams(idfEurasia.careerBelarus);
            idfEurasia.checkCareerTitle("Вакансии в Беларуси");
            driver.navigate().back();

            idfEurasia.chooseVacanciesParams(idfEurasia.risk_dep);
            idfEurasia.checkMenuItem("Управление рисками");
            driver.navigate().back();

            idfEurasia.chooseVacanciesParams(idfEurasia.analytics_dep);
            idfEurasia.checkMenuItem("Аналитика");
            driver.navigate().back();

            idfEurasia.chooseVacanciesParams(idfEurasia.products_dep);
            idfEurasia.checkMenuItem("Управление продуктом");
            driver.navigate().back();

            idfEurasia.chooseVacanciesParams(idfEurasia.dataScience_dep);
            idfEurasia.checkMenuItem("Data science");
            driver.navigate().back();

            idfEurasia.chooseVacanciesParams(idfEurasia.verification_dep);
            idfEurasia.checkMenuItem("Верификация");
            driver.navigate().back();

            idfEurasia.chooseVacanciesParams(idfEurasia.legal_dep);
            idfEurasia.checkMenuItem("Юридический департамент");
            driver.navigate().back();

            idfEurasia.chooseVacanciesParams(idfEurasia.marketing_dep);
            idfEurasia.checkMenuItem("Маркетинг и PR");
            driver.navigate().back();

            idfEurasia.chooseVacanciesParams(idfEurasia.collection_dep);
            idfEurasia.checkMenuItem("Взыскание просроченной за...");
            driver.navigate().back();

            idfEurasia.chooseVacanciesParams(idfEurasia.fin_dep);
            idfEurasia.checkMenuItem("Финансы");
            driver.navigate().back();

        }

        @After
        public void tearDown() {

            idfEurasia.quit();

        }

    }

    public static class IDFEUR_Prod {

        private WebDriver driver;
        private IDFEurasia idfEurasia;

        @Before
        public void setUp() {
            //System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
            //driver = new FirefoxDriver();


            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);


            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://idfeurasia.com/");

            idfEurasia = new IDFEurasia(driver);
        }


        @Test
        public void checkResponseCodeAll() throws IOException {
            idfEurasia.checkResponseCode(200, idfEurasia.ruLang);
            idfEurasia.checkResponseCode(200, idfEurasia.kzLang);
            idfEurasia.checkResponseCode(200, idfEurasia.enLang);
        }

        @Test
        public void thereAreNoIndex() {

            Assert.assertEquals("There are no noindex,nofollow", idfEurasia.noIndex());

        }

        @After
        public void tearDown() {

            idfEurasia.quit();

        }


    }
}