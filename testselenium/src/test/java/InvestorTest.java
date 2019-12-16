import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class InvestorTest {

    private WebDriver driver;
    private InvestorMM investor;

    @Before
    public void setUp()
    {
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        //driver = new FirefoxDriver();


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe") ;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://moneyman:1005@http://qa-delivery-investor-ru-master.moneyman.ru/");

        investor = new InvestorMM (driver);

    }


    @Test

    public void sendRequest(){

        driver.findElement(investor.calculator);
        investor.chooseParams(investor.currencyUSD, investor.term12month,2000000, investor.usd_12);
        investor.fillThForm("Test", "Test", "1111111111", "test@test.te");
        investor.submitTheForm();
        Assert.assertEquals("Спасибо, ваша заявка принята!", driver.findElement(investor.thanks).getText());


    }
}
