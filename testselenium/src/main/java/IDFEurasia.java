import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public By ruLang = By.xpath("//a[text() ='RU']");
    public By kzLang = By.xpath("//a[text() ='KZ']");
    public By enLang = By.xpath("//a[text() ='EN']");
    public By privacyPolicy = By.xpath("//a[text()='Privacy Policy']");
    public By legalNotice = By.xpath("//a[text()='Legal Notice']");
    public By cookiesPolicy = By.xpath("//a[text()='Cookies Policy']");

    //страны на странице careers
    public By careerRussia = By.xpath("//span[text() = 'Россия']");
    public By careerKazahstan= By.xpath("//div[text() = 'Казахстан']");
    public By careerBelarus = By.xpath("//div[text() = 'Беларусь']");

    //пункты из списка на странице Карьера
    public By risk_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Управление рисками')]");
    public By analytics_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Аналитика')]");
    public By products_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Управление продуктом')]");
    public By dataScience_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Data science')]");
    public By verification_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Верификация')]']");
    public By legal_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Юридический департамент')]");
    public By marketing_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Маркетинг и PR')]");
    public By collection_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Взыскание просроченной задолженности')]");
    public By fin_dep = By.xpath("//a[@class='positions_item']//div[contains(normalize-space(), 'Финансы')]");


    //разделы из списка отделов
    public By department_input = By.xpath("//div[@class= 'select-styled' and text()='Все отделы']");
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
    public By firstName = By.xpath("//input[@name = 'first_name']");
    public By lastName = By.xpath("//input[@name = 'last_name']");
    public By email = By.xpath("//input[@name = 'email']");
    public By message = By.xpath("//textarea[@name = 'message']");
    public By uploadFile = By.xpath("//input[@name = 'fileuploader']");
    public By sendMessage = By.xpath("//input[@value='SEND MESSAGE']"); //кнопка SEND MESSAGE в анкете вакансии
    public By thanks = By.xpath("(//div[@class = 'subtitle'])[2]");



}
