import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


@RunWith(Enclosed.class)
public class InvestorTest {

    public static class investor_Master {

        private WebDriver driver;
        private InvestorMM investor;

        @Before
        public void setUp() {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
//        driver = new FirefoxDriver();


            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);


            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            investor = new InvestorMM(driver);

        }




        @Test
        public void clickMenu()  {

            driver.get("http://moneyman:1005@qa-delivery-investor-ru-master.moneyman.ru/");

            investor.clickMenu(investor.toCalcYield);
            investor.comparison("Калькулятор доходности");
            driver.navigate().back();
            investor.clickMenu(investor.toInvest);
            investor.comparison("Онлайн заявка");

            investor.clickMenu(investor.about);
            Assert.assertEquals("Ключевые отличия компании", driver.findElement(By.xpath("(//h3)[1]")).getText());
            investor.waitElement(investor.mfo);
            investor.clickMenu(investor.mfo);
            investor.comparison("Рынок МФО");
            investor.clickMenu(investor.news);
            investor.comparison("Наши новости");
            investor.clickMenu(investor.management);
            investor.comparison("Наша команда");
            investor.clickMenu(investor.reviews);
            investor.comparison("Отзывы инвесторов");
            investor.clickMenu(investor.documents);
            investor.comparison("Документы");
            investor.clickMenu(investor.requisites);
            investor.comparison("Реквизиты");

            investor.clickMenu(investor.investment);
            investor.comparison("Приумножьте свои накопления с нами,");
            investor.clickMenu(investor.tariffs);
            investor.comparison("Тарифы");
            investor.clickMenu(investor.howToInvest);
            Assert.assertEquals("Как инвестировать?", driver.findElement(By.xpath("(//h2)[1]")).getText());
            investor.clickMenu(investor.faq);
            investor.comparison("Вопросы и ответы");
            investor.clickMenu(investor.calculator);
            investor.comparison("Калькулятор доходности");
            investor.clickMenu(investor.onlineRequest);
            investor.comparison("Онлайн заявка");


        }

        @After
        public void tearDown() {

            investor.quit();

        }

    }

    public static class investor_Prod {

        private WebDriver driver;
        private InvestorMM investor;

        @Before
        public void setUp() {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
//        driver = new FirefoxDriver();


            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            investor = new InvestorMM(driver);

            driver.get("https://investor.moneyman.ru/");

        }

        @Test

        public void sendRequest() {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            investor.clickMenu(investor.calculator);
            investor.chooseParams(investor.currencyUSD, investor.term12month, 2000000, investor.usd_12);
            investor.fillThForm("Test" + " " + dateFormat.format(new Date()),
                    "Test" + " " + dateFormat.format(new Date()),
                    "1(234) 56" + Math.round((investor.getRandomIntegerBetweenRange(10000, 99999))),
                    "test" + dateFormat.format(new Date()) + "@test.te");
            investor.submitTheForm();
            Assert.assertEquals("Спасибо, ваша заявка принята!\n" +
                    "Наши специалисты свяжутся с вами в ближайшее время.\n" +
                    "Благодарим вас за проявленный интерес!\n" +
                    "← Вернуться на главную", driver.findElement(investor.thanks).getText());

        }

        @Test

        public void responseCodeMain() throws IOException {

            investor.checkResponseCode(200);

        }

        @Test
        public void thereAreNoIndex() {

            Assert.assertEquals("There are no noindex,nofollow", investor.noIndex());

        }

        @After
        public void tearDown() {

            investor.quit();

        }

    }

    }




