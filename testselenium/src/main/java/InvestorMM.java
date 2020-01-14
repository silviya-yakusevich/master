import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvestorMM {

    private WebDriver driver;
    public InvestorMM(WebDriver driver) {
        this.driver = driver;
    }

    public By about = By.xpath("//a[text()='О компании']");
    public By mfo = By.xpath("(//a[text()='Рынок МФО'])[2]");
    public By news = By.xpath("(//a[text()='Новости'])[2]");
    public By management = By.xpath("(//a[text()='Руководство'])[2]");
    public By reviews = By.xpath("(//a[text()='Отзывы'])[2]");
    public By documents = By.xpath("(//a[text()='Документы'])[2]");
    public By requisites = By.xpath("(//a[text()='Реквизиты'])[2]");

    public By investment = By.xpath("//a[text()='Инвестиционное предложение']");
    public By tariffs = By.xpath("(//a[text()='Тарифы'])[2]");
    public By howToInvest = By.xpath("(//a[text()='Как инвестировать?'])[2]");
    public By faq = By.xpath("(//a[text()='Вопросы и ответы'])[2]");

    public By calculator = By.xpath("//a[text()='Калькулятор доходности']");
    public By onlineRequest = By.xpath("//span[text()='Онлайн заявка']");
    public By toInvest = By.xpath("//a[text()='Вложить деньги']"); //кнопка "Вложить деньги" на главной странице
    public By toCalcYield = By.xpath("//a[text()='Рассчитать доходность']"); //кнопка "Рассчитать доходность" на главной странице


    // КАЛЬКУЛЯТООР ДОХОДНОСТИ
    public By currencyRUB = By.xpath("(//span[contains(normalize-space(), 'рубли')])[3]");
    public By currencyUSD = By.xpath("(//span[contains(normalize-space(), 'доллары США')])[3]");
    public By currencyEUR = By.xpath("(//span[contains(normalize-space(), 'евро')])[3]");
    public By term6month = By.xpath("//div[@class='calc_term calc_item']//label[@for='term1']");
    public By term12month = By.xpath("//div[@class='calc_term calc_item']//label[@for='term2']");
    public By term24month = By.xpath("//div[@class='calc_term calc_item']//label[@for='term3']");
    public By amountInput = By.xpath("//input[@id= 'desktop-input']"); //инпут для ввода инвестируемой суммы

    double rub_6 = 0.11;
    double rub_12 = 0.13;
    double rub_24 = 0.14;
    double usd_6 = 0.06;
    double usd_12 = 0.09;
    double usd_24 = 0.09;
    double eur_6 = 0.05;
    double eur_12 = 0.08;
    double eur_24 = 0.08;
    public By lastName = By.xpath("//input[@name = 'lastname']");
    public By firstName = By.xpath("//input[@name = 'io']");
    public By phone = By.xpath("//input[@name = 'phone']");
    public By email = By.xpath("(//input[@name = 'email'])[1]");
    public By requestСontract = By.xpath("(//span[contains(normalize-space(), 'Запросить договор')])[1]"); // чекбокс "Запросить договор"
    public By requestFin  = By.xpath("(//span[contains(normalize-space(), 'Запросить финансовую отчетность')])[1]"); //чекбокс "Запросить финансовую отчетность"
    public By agreement  = By.xpath("(//span[contains(normalize-space(), 'Я согласен с ')])[1]"); //чекбокс "Я согласен с условиями"
    public By agreementLink  = By.xpath("//a[text()='условиями']"); //ссылка на документ с условиями
    public By submit  = By.xpath("(//input[@type = 'submit'])[1]");//кнопка "Оставить заявку"
    public By thanks = By.xpath("//div[@class='thanks_wrapper']");

    //ПОДПИСКА НА НОВОСТИ
    public By emailSubscription = By.xpath("(//input[@name = 'email'])[2]"); //поле для ввода email для подписки на рассылку
    public By submitSubscription  = By.xpath("(//input[@type = 'submit'])[2]"); // кнопка подписки на рассылку



    public String profitAmountField () //получить текст валидацинного сообщения
    {
        String profitAmount = driver.findElement(By.xpath("//div[@class='profit_value']")).getText();//сумма вложений, выводимая после выбора значения
        return profitAmount;
    }

    public String profitSumField () //получить текст валидацинного сообщения
    {
        String profitSum = driver.findElement(By.xpath("//div[@class='profit_value']")).getText();// сумма вложений + дохода от вложений за указанный срок
        return profitSum;
    }

    public InvestorMM clickOnTheLinks(By link) {
        driver.findElement(link).click();
        return this;
    }
    public InvestorMM chooseParams(By currency, By term, int amount,double percent) {
        driver.findElement(currency).click();
        driver.findElement(term).click();
        driver.findElement(amountInput).sendKeys(String.valueOf(amount));
        double sum = amount * percent;
        Assert.assertEquals(amount + " руб.", profitAmountField());
        Assert.assertEquals(Math.round(sum) + " руб.", profitSumField());
        return this;
    }
    public InvestorMM fillThForm(String lastname, String firstname, String phonenumber, String emailaddress){

        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(phone).sendKeys(phonenumber);
        driver.findElement(email).sendKeys(emailaddress);
        driver.findElement(requestСontract).click();
        driver.findElement(requestFin).click();

        return this;
    }

    public InvestorMM submitTheForm(){
        driver.findElement(submit).click();
        return this;
    }

    public InvestorMM clickMenu(By link) {
        driver.findElement(link).click();

        return this;
    }

    public InvestorMM comparison (String h1) {

        Assert.assertEquals(h1, driver.findElement(By.xpath("//h1")).getText());
        return this;
    } // сравнение заголовка с заданным значением

    public InvestorMM waitElement (By linkForWait) {

        WebDriverWait wait = (new WebDriverWait(driver,10));// явное ожидание
        wait.until (ExpectedConditions.presenceOfElementLocated(linkForWait));
        return this;
    } //



}
