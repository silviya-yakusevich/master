import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class IDFtest {


    private WebDriver driver;
    private IDFinance idFinance;

    @Before
    public void setUp()
    {
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe") ;


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
       // options.addArguments("--screenshot");
        driver = new ChromeDriver(options);

        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://moneyman:1005@qa-delivery-idfinance-ru-master.moneyman.ru");

        idFinance = new IDFinance (driver);

    }


    @Test
    public void sendCV() throws InterruptedException, IOException, AWTException {
        idFinance.openVacation();
        idFinance.fillTheForm();
        idFinance.sendTheForm();
        Assert.assertEquals("Thank you for your message. It has been sent.", driver.findElement(idFinance.thanks).getText());
    }


    @Test
    public void clickLinks() throws IOException
    {
        idFinance.clickMenu(idFinance.esLang);
        idFinance.equalTitle("Fintech de Rápido Crecimiento en Europa y Latam \uD83E\uDD47 | IDFinance");

        idFinance.clickMenu(idFinance.enLang);
        idFinance.equalTitle("Fast Growing Fintech in Europe and Latam | IDFinance");

        idFinance.clickMenu(idFinance.about);
        idFinance.equalTitle("About | ID Finance");

        idFinance.clickMenu(idFinance.investors);
        idFinance.equalTitle("All the information for investors | IDFinance");

        idFinance.clickMenu(idFinance.sustainability);
        idFinance.equalTitle("Sustainability | ID Finance");

        idFinance.clickMenu(idFinance.media);
        idFinance.equalTitle("Media | ID Finance");

        idFinance.clickMenu(idFinance.lab);
        idFinance.equalTitle("Lab | ID Finance");

        idFinance.clickMenu(idFinance.technology);
        idFinance.equalTitle("Technology | ID Finance");

        idFinance.clickMenu(idFinance.privacyPolicy);
        idFinance.equalTitle("Privacy Policy | ID Finance");

        idFinance.clickMenu(idFinance.legalNotice);
        idFinance.equalTitle("Legal Notice | ID Finance");

        idFinance.clickMenu(idFinance.cookiesPolicy);
        idFinance.equalTitle("Cookies Policy | ID Finance");

    }


    @Test
    public void clickPositionsParams() throws IOException
    {
        idFinance.chooseVacanciesParams(idFinance.careersSpain);
        idFinance.checkCareerTitle("Barcelona, Spain");
        driver.navigate().back();

        idFinance.chooseVacanciesParams(idFinance.careersBrazil);
        idFinance.checkCareerTitle("São Paulo, Brazil");
        driver.navigate().back();

        idFinance.chooseVacanciesParams(idFinance.careersMexico);
        idFinance.checkCareerTitle("Mexico, Mexico");
        driver.navigate().back();

        idFinance.chooseVacanciesParams(idFinance.careersBelarus);
        idFinance.checkCareerTitle("Minsk, Belarus");
        driver.navigate().back();

        idFinance.chooseVacanciesParams(idFinance.findep);
        idFinance.checkCareerTitle("Finance & Banking");
        driver.navigate().back();

        idFinance.chooseVacanciesParams(idFinance.itdep);
        idFinance.checkCareerTitle("IT Development and Maintenance");
        driver.navigate().back();

        idFinance.chooseVacanciesParams(idFinance.customerSup);
        idFinance.checkCareerTitle("Customer Support");
        driver.navigate().back();

        idFinance.chooseVacanciesParams(idFinance.riskManagement);
        idFinance.checkCareerTitle("Risk Management");
        driver.navigate().back();

        idFinance.chooseVacanciesParams(idFinance.dataScience);
        idFinance.checkCareerTitle("Data Science");
        driver.navigate().back();

        idFinance.chooseVacanciesParams(idFinance.marketingDep);
        idFinance.checkCareerTitle("Marketing");
        driver.navigate().back();

        idFinance.chooseVacanciesParams(idFinance.operationDep);
        idFinance.checkCareerTitle("Operations");
        driver.navigate().back();

        idFinance.chooseVacanciesParams(idFinance.legalDep);
        idFinance.checkCareerTitle("Legal");
        driver.navigate().back();

    }


    @Test
     public void checkVariations() throws IOException, InterruptedException {
        driver.get("http://qa-delivery-idfinance-ru-master.moneyman.ru/careers/positions/?department=all&location=all");
        idFinance.chooseCareerDep(idFinance.itdep_menu);
        idFinance.chooseCareerLoc(idFinance.belarus_menu);
        idFinance.checkCareerTitle(idFinance.titleVacancyResult());
      }


     @Test
     public void checkResponseCodeEN () throws IOException {
         idFinance.checkResponseCode("https://idfinance.com/", idFinance.enLang);
      }


      @Test
      public void checkResponseCodeES () throws IOException {
          idFinance.checkResponseCode("https://idfinance.com/", idFinance.esLang);
      }


}
