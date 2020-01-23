import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

@RunWith(Enclosed.class)
public class MMKZ_test {


    public static class MMKZ_master {

        private WebDriver driver;
        private MMKZ mmkz;


        @Before
        public void setUp() {


//           System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
//           driver = new FirefoxDriver();
//           driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//           driver.manage().window().maximize();


            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);

            driver.get("https://moneyman:1005@qa-delivery-kz-master.moneyman.ru?partner=mmkz&utm_source=mm&utm_medium=mm&utm_campaign=mm&wmid=123&utm_term=mm&utm_content=mm");

            mmkz = new MMKZ(driver);
        }


        @Test
        public void checkCookies() {

            mmkz.clickGetMoneyButton();
            mmkz.checkAllCookies("mmkz", "mm","123");

            driver.get("http://moneyman:1005@qa-delivery-kz-master.moneyman.ru?partner=123");

            mmkz.clickGetMoneyButton();
            mmkz.checkAllCookies("123", "NULL", "undefined");
        }

        @Test
        public void clickAllLinks() {

            mmkz.clickLinks(mmkz.kzLang);
            mmkz.comparison("Қазақстандағы ОНЛАЙН несиелер");

            mmkz.clickLinks(mmkz.ruLang);
            mmkz.comparison("Займы онлайн в Казахстане до 200 000 тенге");

            mmkz.clickLinks(mmkz.about);
            mmkz.comparison("О Moneyman");

            mmkz.clickLinks(mmkz.howToTakeMoney);
            mmkz.comparison("Как взять онлайн-заем");

            mmkz.clickLinks(mmkz.howToGetMoney);
            mmkz.comparison("Как получить деньги");

            mmkz.clickLinks(mmkz.howReturnMoney);
            mmkz.comparison("Как погасить заем");

            mmkz.clickLinks(mmkz.faq);
            mmkz.comparison("Вопросы и ответы");

            mmkz.clickLinks(mmkz.news);
            mmkz.comparison("Новости");

            mmkz.clickLinks(mmkz.aboutMicro);
            mmkz.comparison("Преимущества микрозаймов");

            mmkz.clickLinks(mmkz.articles);
            mmkz.comparison("Статьи");

            mmkz.clickLinks(mmkz.contact);
            mmkz.comparison("Контакты");

            mmkz.clickLinks(mmkz.app);
            mmkz.tabs();
            Assert.assertEquals(driver.getCurrentUrl(), "IDFinance Kazakhstan", driver.findElement(By.xpath("(//a[@class='hrTbp R8zArc'])[1]")).getText());



        }

        @After
        public void tearDown() {

            mmkz.quit();

        }

    }


        public static class MMKZ_prod {

            private WebDriver driver;
            private MMKZ mmkz;

            @Before
            public void setUp() {


//              System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
//              driver = new FirefoxDriver();
//              driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//              driver.manage().window().maximize();

                System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                options.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(options);

                driver.get("http://moneyman.kz/");

                mmkz = new MMKZ(driver);
            }

            @Test
            public void responseCodeMain() throws IOException {

                mmkz.checkResponseCode(200);

            }


            @Test
            public void responseCodeReg() throws IOException {

               mmkz.clickLinks(mmkz.getMoneyButton);
               mmkz.checkResponseCode(200);

            }

            @Test
            public void responseCodeRegMiddle() throws IOException {

                mmkz.clickLinks(mmkz.redMoneyButton);
                mmkz.checkResponseCode(200);

            }

            @Test
            public void responseCodeLogin() throws IOException {

                mmkz.clickLinks(mmkz.loginButton);
                mmkz.checkResponseCode(200);

            }

            @Test
            public void responseCodeRegGreen() throws IOException {

                mmkz.clickLinks(mmkz.about);
                mmkz.clickLinks(mmkz.greenMoneyButton);
                mmkz.checkResponseCode(200);

            }

            @Test
            public void thereAreNoIndex(){

                Assert.assertEquals("There are no noindex,nofollow", mmkz.noIndex());

            }

            @After
            public void tearDown() {

                mmkz.quit();

            }

        }

    }




