import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class InvestorTest {

    private WebDriver driver;
    private InvestorMM investor;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();


//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe") ;
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
//        options.addArguments("--window-size=1920,1080");
//        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://moneyman:1005@qa-delivery-investor-ru-master.moneyman.ru/");

        investor = new InvestorMM (driver);

    }

    @Ignore
    @Test

    public void sendRequest(){

        driver.findElement(investor.calculator);
        investor.chooseParams(investor.currencyUSD, investor.term12month,2000000, investor.usd_12);
        investor.fillThForm("Test", "Test", "1111111111", "test@test.te");
        investor.submitTheForm();
        Assert.assertEquals("Спасибо, ваша заявка принята!", driver.findElement(investor.thanks).getText());


    }

    @Test
    public void clickMenu() throws IOException {

        investor.clickMenu(investor.toCalcYield);
        investor.comparison("Калькулятор доходности");
        driver.navigate().back();
        investor.clickMenu(investor.toInvest);
        investor.comparison("Онлайн заявка");
//
//        investor.clickMenu(investor.about);
//        Assert.assertEquals("Ключевые отличия компании", driver.findElement(By.xpath("(//h3)[1]")).getText());
//        investor.clickMenu(investor.mfo);
//        investor.comparison("Рынок МФО");
//        investor.clickMenu(investor.news);
//        investor.comparison("Наши новости");
//        investor.clickMenu(investor.management);
//        investor.comparison("Наша команда");
//        investor.clickMenu(investor.reviews);
//        investor.comparison("Отзывы инвесторов");
//        investor.clickMenu(investor.documents);
//        investor.comparison("Документы");
//        investor.clickMenu(investor.requisites);
//        investor.comparison("Реквизиты");
//
//        investor.clickMenu(investor.investment);
//        investor.comparison("Приумножьте свои накопления с нами,");
//        investor.clickMenu(investor.tariffs);
//        investor.comparison("Тарифы");
//        investor.clickMenu(investor.howToInvest);
//        Assert.assertEquals("Как инвестировать?", driver.findElement(By.xpath("(//h2)[1]")).getText());
//        investor.clickMenu(investor.faq);
//        investor.comparison("Вопросы и ответы");
//        investor.clickMenu(investor.calculator);
//        investor.comparison("Калькулятор доходности");
//        investor.clickMenu(investor.onlineRequest);
//        investor.comparison("Онлайн заявка");



    }

    }




