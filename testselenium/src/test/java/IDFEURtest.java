import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class IDFEURtest {
    private WebDriver driver;
    private IDFEurasia idfEurasia;

    @Before
    public void setUp()
    {
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        //driver = new FirefoxDriver();


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe") ;
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://moneyman:1005@qa-delivery-idfinance-eurasia-ru-master.moneyman.ru/");

        idfEurasia = new IDFEurasia (driver);

    }

}
