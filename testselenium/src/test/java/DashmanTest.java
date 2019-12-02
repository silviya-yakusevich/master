import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DashmanTest {

    private WebDriver driver;
    private MainPage dashmanPage;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe") ;


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://money-man.ru?partner=mmru&utm_source=mm&utm_medium=mm&utm_campaign=mm&keyword=mm&wmid=mm&utm_term=mm&utm_content=mm");
        dashmanPage = new MainPage (driver);
    }

    @Test
    public void correctCookie(){

        driver.findElement(By.xpath("//span[@id='getmoney']")).click();
        dashmanPage.checkAllCookies("mmru","mm", "102");

        driver.get("http://money-man.ru?partner=123");
        driver.findElement(By.xpath("//span[@id='getmoney']")).click();
        dashmanPage.checkAllCookies("123","NULL", "102");//проверка зануления параметров при пробросе только partner
    }

    @Test
    public void responseCodeRegMain() throws IOException {
        dashmanPage.checkResponseCode("https://money-man.ru", By.xpath("//span[@id='getmoney']"));

    }

    @Test
    public void responseCodeRegMainMid() throws IOException {
        dashmanPage.checkResponseCode("https://money-man.ru", By.xpath("//a[@class='btn discountBanner__btn']"));

    }
    @Test
    public void responseCodeRegMainTf() throws IOException {
        dashmanPage.checkResponseCode("https://money-man.ru", By.xpath("//a[@class='rates_link']"));

    }


    @Test
    public void responseCodeLogin() throws IOException {
        dashmanPage.checkResponseCode("https://money-man.ru", By.xpath("//a[@class='headerPrivate__link']"));

    }

    @After
    public void tearDown()
    {
        dashmanPage.quit();

    }

}