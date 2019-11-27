import com.sun.deploy.security.SelectableSecurityManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.reflect.misc.FieldUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class IDFinance {

    private WebDriver driver;

    public IDFinance(WebDriver driver) {
        this.driver = driver;
    }



    public By about = By.xpath("//a[text()='About']");
    public By investors = By.xpath("//a[text()='Investors']");
    public By sustainability = By.xpath("//a[text()='Sustainability']");
    public By careers = By.xpath("//a[text()='Careers']");
    public By media = By.xpath("//a[text()='Media']");
    public By technology = By.xpath("//a[text()='Technology']");
    public By lab = By.xpath("//a[text()='Lab']");
    public By enLang = By.xpath("//a[@lang ='en-US']");
    public By esLang = By.xpath("//a[@lang='es-ES']");
    public By privacyPolicy = By.xpath("//a[text()='Privacy Policy']");
    public By legalNotice = By.xpath("//a[text()='Legal Notice']");
    public By cookiesPolicy = By.xpath("//a[text()='Cookies Policy']");

//    // Пункты меню в key figures
//    public By keyFigures = By.className("select-styled");
//    public By revenue = By.xpath("//ul[@class = 'select-options']/li[text()='Revenue, $m']");
//    public By loansIssued = By.xpath("//ul[@class = 'select-options']/li[text()='Loans issued, $m']");
//    public By portfolio = By.xpath("//ul[@class = 'select-options']/li[text()='Portfolio, $m']");

    //страны на странице careers
    public By careersSpain = By.xpath("//div[text() = 'Spain']");
    public By careersBrazil = By.xpath("//div[text() = 'Brazil']");
    public By careersMexico = By.xpath("//div[text() = 'Mexico']");
    public By careersBelarus = By.xpath("//div[text() = 'Belarus']");

    public By plusButton = By.xpath("(//div[@class='btn'])[1]");


    //пункты из списка location
    public By location = By.xpath("//div[@class= 'select-styled' and text()='All locations']");
    public By allLoc = By.xpath("//option[text()='All locations']");
    public By spain_menu = By.xpath("//li[text()='Barcelona, Spain']");
    public By belarus_menu = By.xpath("//li[text()='Minsk, Belarus']");
    public By brazil_menu = By.xpath("//li[text()='São Paulo, Brazil']");
    public By mexico_menu = By.xpath("//li[text()='Mexico, Mexico']");

    //пункты из списка department
    public By department = By.xpath("//div[@class= 'select-styled' and text()='All departments']");
    public By allDep = By.xpath("//option[text()='All departments");
    public By findep_menu = By.xpath("//li[text()='Finance & Banking']");
    public By itdep_menu = By.xpath("//li[text()='IT Development and Maintenance']");
    public By customerSup_menu = By.xpath("//li[text()='Customer Support']");
    public By riskManagement_menu = By.xpath("//li[text()='Risk Management']");
    public By dataScience_menu = By.xpath("//li[text()='Data Science']");
    public By marketingDep_menu = By.xpath("//li[text()='Marketing']");
    public By operationDep_menu = By.xpath("//li[text()='Operations']");
    public By legalDep_menu = By.xpath("//li[text()='Legal']");

    // разделы на  странице careers

    public By findep = By.xpath("//div[@class='cell']//span[contains(normalize-space(), 'Finance & Banking')]");
    public By itdep = By.xpath("//div[@class='cell']//span[contains(normalize-space(), 'IT Development and Maintenance')]");
    public By customerSup = By.xpath("//div[@class='cell']//span[contains(normalize-space(), 'Customer Support')]");
    public By riskManagement = By.xpath("//div[@class='cell']//span[contains(normalize-space(), 'Risk Management')]");
    public By dataScience = By.xpath("//div[@class='cell']//span[contains(normalize-space(), 'Data Science')]");
    public By marketingDep = By.xpath("//div[@class='cell']//span[contains(normalize-space(), 'Marketing')]");
    public By operationDep = By.xpath("//div[@class='cell']//span[contains(normalize-space(), 'Operations')]");
    public By legalDep = By.xpath("//div[@class='cell']//span[contains(normalize-space(), 'Legal')]");



    //форма заявки на вакансию

    public By applytoPosition = By.xpath("(//div[@class='filter_item open']//a[@class='apply'])[1]"); //кнопка APPLY TO POSITION на вакансиии
    public By firstName = By.xpath("//input[@name = 'first_name']");
    public By lastName = By.xpath("//input[@name = 'last_name']");
    public By email = By.xpath("//input[@name = 'email']");
    public By message = By.xpath("//textarea[@name = 'message']");
    public By uploadFile = By.xpath("//input[@name = 'fileuploader']");
    public By sendMessage = By.xpath("//input[@value='SEND MESSAGE']"); //кнопка SEND MESSAGE в анкете вакансии
    public By thanks = By.xpath("(//div[@class = 'subtitle'])[2]");







    public IDFinance openVacation()
    {

        driver.findElement(careers).click();
        driver.findElement(careersBelarus).click();
        //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(plusButton)));
        driver.findElement(plusButton).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated((applytoPosition))).click();

        return this;
    }


    public IDFinance fillTheForm() throws IOException
    {
       // WebElement droparea =(By.xpath("//div[@class='droparea has-file']"))); //droparea has-file

        driver.findElement(firstName).sendKeys("ТЕСТ");
        driver.findElement(lastName).sendKeys("ТЕСТ");
        driver.findElement(email).sendKeys("test@test.te");
        driver.findElement(message).sendKeys("ТЕСТ");
        driver.findElement(uploadFile).sendKeys("C:\\Users\\User10\\Desktop\\111.docx");
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='droparea has-file']")))); //ожидание успешной загрузки файла

        return this;

    }

    public IDFinance sendTheForm() throws InterruptedException, AWTException, IOException {
        driver.findElement(sendMessage).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='thanks-modal fancybox-content']")));//ожидание попапа после успешной отправки формы

//        //скрин экрана
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        BufferedImage fullImg = ImageIO.read(screenshot);
//        File screenshotLocation = new File("C:\\Users\\User10\\IdeaProjects\\testselenium\\yyyyy.png");
//        FileHandler.copy(screenshot, screenshotLocation);

        return this;

    }

    public IDFinance clickMenu(By link) {

        driver.findElement(link).click();
        return this;
    }


    public IDFinance equalTitle (String title) {

        Assert.assertEquals(title, driver.getTitle()); // сравнение заголовка с заданным значением
        return this;
    } // сравнение заголовка с заданным значением


    public IDFinance chooseVacanciesParams (By country) {

        driver.get("http://qa-delivery-idfinance-ru-master.moneyman.ru/careers/");
        driver.findElement(country).click();

        return this;
    }

    public IDFinance checkCareerTitle(String titleText) {

        Assert.assertEquals(titleText, driver.findElement(By.className("filter_title")).getText()); //cравнение заголовка страницы при заданных параметрах департаментра и страны
        return this;

    }

    public IDFinance chooseCareerDep (By dep_menu) throws InterruptedException {


        driver.findElement(By.xpath("//div[@class='select-styled' and text()='All departments']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(dep_menu)).click();

        return this;
    }

    public IDFinance chooseCareerLoc (By loc_menu) {

        driver.findElement(By.xpath("//div[@class='select-styled' and text()='All locations']")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(loc_menu)).click();//ожидание отображения раскрывающего списка и выбор локации

        return this;
    }


    public String titleVacancyResult() {
      String depat = driver.findElement(By.xpath("(//div[@class='select-styled'])[1]")).getText();
      String locat = driver.findElement(By.xpath("(//div[@class='select-styled'])[2]")).getText();
      String result = depat + ", " + locat;

        return result;

    }

    public IDFinance checkResponseCode(String link, By lang) throws IOException {

        driver.get(link);
        driver.findElement(esLang).click();//переход в ЛК
        URL url = new URL(driver.getCurrentUrl());
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");

        int code = http.getResponseCode();
        Assert.assertEquals(200, code);

        return this;
    }




























}
