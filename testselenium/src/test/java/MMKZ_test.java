import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MMKZ_test {

    private WebDriver driver;
    private MMKZ mmkz;

    @Before
    public void setUp() {


//         System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
//         driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//        driver.manage().window().maximize();


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);

        driver.get("https://moneyman:1005@qa-delivery-kz-master.moneyman.ru?partner=adw&utm_source=mm&utm_medium=cpc&utm_campaign=mm&keyword=mm&wmid=manimen&utm_term=manimen&utm_content=mm");

        mmkz = new MMKZ(driver);
    }
    @Ignore
    @Test
    public void checkCookies() {

        mmkz.clickGetMoneyButton();
        mmkz.checkAllCookies("mmkz", "mm");

        driver.get("http://moneyman:1005@qa-delivery-kz-master.moneyman.ru?partner=123");

        mmkz.clickGetMoneyButton();
        mmkz.checkAllCookies("123", "NULL");
    }

    @Test
    public void clickAllLinks (){

        mmkz.clickLinks(mmkz.about);
        mmkz.comparison("О Moneyman");

        mmkz.clickLinks(mmkz.howToTakeMoney);
        mmkz.comparison("Как взять онлайн-заем");

        mmkz.clickLinks(mmkz.howToGetMoney);
        mmkz.comparison("Как получить деньги");

        mmkz.clickLinks(mmkz.howToTakeMoney);
        mmkz.comparison("Как взять онлайн-заем");

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
        Assert.assertEquals( driver.getCurrentUrl(), "IDFinance Kazakhstan", driver.findElement(By.xpath("(//a[@class='hrTbp R8zArc'])[1]")).getText());


        mmkz.clickLinks(mmkz.contact);
        mmkz.comparison("Контакты");
        mmkz.clickLinks(mmkz.contact);
        mmkz.comparison("Контакты");
        mmkz.clickLinks(mmkz.contact);
        mmkz.comparison("Контакты");

    }



}
