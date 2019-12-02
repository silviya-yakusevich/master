import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SolvaRuTest {

    private WebDriver driver;
    private MainPage solvaruPage;

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
        driver.get("http://moneyman:1005@qa-delivery-solva-ru-master.moneyman.ru?partner=mmru&utm_source=mm&utm_medium=mm&utm_campaign=mm&keyword=mm&wmid=mm&utm_term=mm&utm_content=mm");
        solvaruPage = new MainPage (driver);
    }

    @Test
    public void correctCookie(){
        driver.findElement(By.xpath("//a[@class='header_section__link']")).click();// переход на регистрацию по верхней кнопке "Получить первый заем под 0%"

        solvaruPage.checkAllCookies("mmru","mm","404");
        driver.get("http://moneyman:1005@qa-delivery-solva-ru-master.moneyman.ru?partner=123");
        driver.findElement(By.xpath("//a[@class='header_section__link']")).click();// переход на регистрацию по верхней кнопке "Получить первый заем под 0%"
        solvaruPage.checkAllCookies("123","NULL", "404");//проверка зануления параметров при пробросе только partner

    }

    @Test
    public void responseCodeReg() throws IOException {
        solvaruPage.checkResponseCode("http://solva.ru",By.xpath("//a[@class='header_section__link']"));

    }

    @Test
    public void responseCodeLogin() throws IOException {

        solvaruPage.checkResponseCode("http://solva.ru",By.className("footer__login-button"));
    }

    @After
    public void tearDown()
    {
        solvaruPage.quit();

    }



}