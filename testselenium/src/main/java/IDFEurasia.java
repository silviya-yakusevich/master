import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class IDFEurasia {
    private WebDriver driver;

    public IDFEurasia(WebDriver driver) {
        this.driver = driver;
    }

    public By about = By.xpath("//a[text()='О нас']");
    public By investors = By.xpath("//a[text()='Инвесторам']");
    public By sustainability = By.xpath("//a[text()='Устойчивое развитие']");
    public By careers = By.xpath("//a[text()='Карьера']");
    public By media = By.xpath("//a[text()='Медиа']");
    public By stock = By.xpath("//a[text()='Облигации']");
    public By loans = By.xpath("//a[text()='Инвестиционные займы']");
    public By allLang = By.xpath("//div[@class ='header_lang']");
    public By ruLang = By.xpath("//a[text() ='RU']");
    public By kzLang = By.xpath("//a[text() ='KZ']");
    public By enLang = By.xpath("//a[text() ='EN']");
    public By privacyPolicy = By.xpath("//a[text()='Privacy Policy']");
    public By legalNotice = By.xpath("//a[text()='Legal Notice']");
    public By cookiesPolicy = By.xpath("//a[text()='Cookies Policy']");

    //страны на странице careers
    public By careerRussia = By.xpath("//span[text() = 'Россия']");
    public By careerKazahstan= By.xpath("//span[text() = 'Казахстан']");
    public By careerBelarus = By.xpath("//span[text() = 'Беларусь']");

    //пункты из списка на странице Карьера
    public By risk_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Управление рисками')]");
    public By analytics_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Аналитика')]");
    public By products_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Управление продуктом')]");
    public By dataScience_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Data science')]");
    public By verification_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Верификация')]");
    public By legal_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Юридический департамент')]");
    public By marketing_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Маркетинг и PR')]");
    public By collection_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Взыскание просроченной задолженности')]");
    public By fin_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Финансы')]");


    //разделы из списка отделов
    public By department_input = By.xpath("(//div[@class= 'select-styled' ])[1]");
    public By allDep = By.xpath("//li[text()='Все отделы']");
    public By risk_menu = By.xpath("//li[text()='Управление рисками']");
    public By analytics_menu = By.xpath("//li[text()='Аналитика']");
    public By products_menu = By.xpath("//li[text()='Data science']");
    public By dataScience_menu = By.xpath("//li[text()='Верификация']");
    public By verification_menu = By.xpath("//li[text()='Юридический департамент']");
    public By legal_menu = By.xpath("//li[text()='Marketing']");
    public By marketing_menu = By.xpath("//li[text()='Маркетинг и PR']");
    public By collection_menu= By.xpath("//li[text()='Взыскание просроченной задолженности']");
    public By fin_menu= By.xpath("//li[text()='Финансы']");


    //пункты из списка стран
    public By location_input = By.xpath("//div[@class= 'select-styled' and text()='Все страны']");
    public By allLoc = By.xpath("//li[text()='Все страны']");
    public By russia_menu = By.xpath("//li[text()='Россия']");
    public By belarus_menu = By.xpath("//li[text()='Беларусь']");
    public By kazahstan_menu = By.xpath("//li[text()='Казахстан']");


    //форма заявки на вакансию

    public By plusButton = By.xpath("(//div[@class='faq_item'])[1]");

    public By applytoPosition = By.xpath("(//a[@class='apply'])[1]"); //кнопка ОТКЛИКНУТЬСЯ НА ВАКАНСИЮ на вакансиии
    public By firstName = By.xpath("(//input[@name = 'first_name'])[2]");
    public By lastName = By.xpath("(//input[@name = 'last_name'])[2]");
    public By email = By.xpath("(//input[@name = 'email'])[3]");
    public By message = By.xpath("//textarea[@name = 'message']");
    public By uploadFile = By.xpath("//input[@name = 'fileuploader']");
    public By sendMessage = By.xpath("//input[@value='Отправить']"); //кнопка SEND MESSAGE в анкете вакансии
    public By thanks = By.xpath("(//div[@class='subtitle'])[3]");



    public IDFEurasia openVacation()
    {

        driver.findElement(careers).click();
        driver.findElement(careerBelarus).click();
        //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(plusButton)));
        driver.findElement(plusButton).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated((applytoPosition))).click();

        return this;
    }

    public IDFEurasia fillTheForm() throws IOException {

        driver.findElement(firstName).sendKeys("ТЕСТ");
        driver.findElement(lastName).sendKeys("ТЕСТ");
        driver.findElement(email).sendKeys("test@test.te");
        driver.findElement(message).sendKeys("ТЕСТ");
        driver.findElement(uploadFile).sendKeys("C:\\Users\\User10\\Desktop\\111.docx");
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='droparea has-file']")))); //ожидание успешной загрузки файла

        return this;
    }

    public IDFEurasia sendTheForm() throws  IOException {
        driver.findElement(sendMessage).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='thanks-modal fancybox-content']")));//ожидание попапа после успешной отправки формы

//        //скрин экрана
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        BufferedImage fullImg = ImageIO.read(screenshot);
//        File screenshotLocation = new File("C:\\Users\\User10\\IdeaProjects\\testselenium\\yyyyy.png");
//        FileHandler.copy(screenshot, screenshotLocation);

        return this;
    }

    public IDFEurasia equalTitle (String title) {

        Assert.assertEquals(title, driver.getTitle()); // сравнение заголовка с заданным значением
        return this;
    }

    public IDFEurasia clickMenu(By link) {

        driver.findElement(link).click();
        return this;
    }

    public IDFEurasia chooseVacanciesParams (By country) {

        driver.get("http://qa-delivery-idfinance-eurasia-ru-master.moneyman.ru/career/");
        driver.findElement(country).click();

        return this;
    }

    public IDFEurasia checkCareerTitle(String titleText) {

        Assert.assertEquals(titleText, driver.findElement(By.className("positions-page_title")).getText()); //cравнение заголовка страницы при заданных параметрах департамента и страны
        return this;
    }

    public IDFEurasia checkMenuItem(String titleText) {

        Assert.assertEquals(titleText, driver.findElement(department_input ).getText()); //cравнение значения в списке департаментов с выбранным значением на странице карьеры
        return this;
    }



    public IDFEurasia checkResponseCode(String link, By lang) throws IOException {

        driver.get(link);
        driver.findElement(allLang).click();
        driver.findElement(lang).click();
        URL url = new URL(driver.getCurrentUrl());
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");

        int code = http.getResponseCode();
        Assert.assertEquals(200, code);

        return this;
    }

    public IDFEurasia moveToElement (By link) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(link)).build().perform();

        return this;
    }//наведение мышки на элемент


    public IDFEurasia chooseCareerDep (By dep_menu) throws InterruptedException {


        driver.findElement(department_input).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(dep_menu)).click();

        return this;
    }

    public IDFEurasia chooseCareerLoc (By loc_menu) {

        driver.findElement(location_input).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(loc_menu)).click();//ожидание отображения раскрывающего списка и выбор локации

        return this;
    }










    }