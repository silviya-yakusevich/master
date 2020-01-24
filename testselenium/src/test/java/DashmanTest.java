import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class DashmanTest {

    private WebDriver driver;
    private MainPage dashmanPage;

    @Before
    public void setUp()
    {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.manage().window().maximize();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe") ;
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);

        driver.get("http://money-man.ru?partner=mmru&utm_source=mm&utm_medium=mm&utm_campaign=mm&keyword=mm&wmid=mm&utm_term=mm&utm_content=mm");
        dashmanPage = new MainPage (driver);
    }

    @Test
    public void checkCorrectCookie(){

        driver.findElement(By.xpath("(//a[text() ='Получить деньги'])[1]")).click();
        dashmanPage.checkAllCookies("mmru","mm", "102");

        driver.get("http://money-man.ru?partner=123");
        driver.findElement(By.xpath("(//a[text() ='Получить деньги'])[1]")).click();
        dashmanPage.checkAllCookies("123","NULL", "102");//проверка зануления параметров при пробросе только partner
    }


    @Test
    public void thereAreNoIndex(){

        Assert.assertEquals("There are noindex,nofollow", dashmanPage.checkNoIndex());

    }
    @Test
    public void checkResponseCodeRegMain() throws IOException {

        driver.findElement(By.xpath("(//a[text() ='Получить деньги'])[1]")).click();
        dashmanPage.checkResponseCode(200);

          }

    @Test
    public void checkResponseCodeRegMainMid() throws IOException {

        driver.findElement(By.xpath("(//a[text() ='Получить деньги'])[2]")).click();
        dashmanPage.checkResponseCode(200);


    }
    @Test
    public void checkResponseCodeRegMainTf() throws IOException {

        driver.findElement(By.xpath("//a[@class='rates_item']")).click();
        dashmanPage.checkResponseCode(200);

    }


    @Test
    public void checkResponseCodeLogin() throws IOException {

        driver.findElement(By.xpath("//a[@class='private-area']")).click();
        dashmanPage.checkResponseCode(200);

    }

    @After
    public void tearDown()
    {
        dashmanPage.quit();

    }

}
