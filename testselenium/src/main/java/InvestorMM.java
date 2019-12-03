import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvestorMM {

    private WebDriver driver;
    public InvestorMM(WebDriver driver) {
        this.driver = driver;
    }

    public By about = By.xpath("//a[text()='О компании']");
    public By mfo = By.xpath("//a[text()='Рынок МФО']");
    public By news = By.xpath("//a[text()='Новости']");
    public By management = By.xpath("//a[text()='Руководство']");
    public By reviews = By.xpath("//a[text()='Отзывы']");
    public By documents = By.xpath("//a[text()='Документы']");
    public By requisites = By.xpath("//a[text()='Реквизиты']");

    public By investment = By.xpath("//a[text()='Инвестиционное предложение']");
    public By tariffs = By.xpath("//a[text()='Тарифы']");
    public By howToInvest = By.xpath("//a[text()='Как инвестировать?']");
    public By faq = By.xpath("//a[text()='Вопросы и ответы']");

    public By calculator = By.xpath("//a[text()='Калькулятор доходности']");
    public By onlineRequest = By.xpath("//a[text()='Онлайн заявка']");
    public By toInvest = By.xpath("//a[text()='Вложить деньги']"); //кнопка "Вложить деньги" на главной странице
    public By toCalcYield = By.xpath("//a[text()='Рассчитать доходность']"); //кнопка "Рассчитать доходность" на главной странице


    // КАЛЬКУЛЯТООР ДОХОДНОСТИ
    public By currencyRUB = By.xpath("(//span[contains(normalize-space(), 'рубли')])[3]");
    public By currencyUSD = By.xpath("(//span[contains(normalize-space(), 'доллары США')])[3]");
    public By currencyEUR = By.xpath("(//span[contains(normalize-space(), 'евро')])[3]");
    public By term6month = By.xpath("//div[@class='calc_term calc_item']//label[@for='term1']");
    public By term12month = By.xpath("//div[@class='calc_term calc_item']//label[@for='term2']");
    public By term24month = By.xpath("//div[@class='calc_term calc_item']//label[@for='term3']");
    public By amountInput = By.xpath("//input[@id= 'desktop-input']"); //инпут для воода инвестируемой суммы
    String profitAmount = driver.findElement(By.xpath("//div[@class='profit_value']")).getText();//сумма вложений, выводимая после выбора значения
    String profitSum = driver.findElement(By.xpath("//div[@class='profit_sum']")).getText(); // сумма вложений + дохода от вложений за указанный срок
    public By lastName = By.xpath("//input[@name = 'lastname']");
    public By firstName = By.xpath("//input[@name = 'io']");
    public By phone = By.xpath("//input[@name = 'phone']");
    public By email = By.xpath("(//input[@name = 'email'])[1]");
    public By requestСontract = By.xpath("(//span[contains(normalize-space(), 'Запросить договор')])[1]"); // чекбокс "Запросить договор"
    public By requestFin  = By.xpath("(//span[contains(normalize-space(), 'Запросить финансовую отчетность')])[1]"); //чекбокс "Запросить финансовую отчетность"
    public By agreement  = By.xpath("(//span[contains(normalize-space(), 'Я согласен с ')])[1]"); //чекбокс "Я согласен с условиями"
    public By agreementLink  = By.xpath("//a[text()='условиями']"); //ссылка на документ с условиями
    public By submit  = By.xpath("(//input[@type = 'submit'])[1]");//кнопка "Оставить заявку"


    //ПОДПИСКА НА НОВОСТИ
    public By emailSubscription = By.xpath("(//input[@name = 'email'])[2]"); //поле для ввода email для подписки на рассылку
    public By submitSubscription  = By.xpath("(//input[@type = 'submit'])[2]"); // кнопка подписки на рассылку

}
