import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainClass {


    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User10\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        MainPage mainPage = new MainPage (driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String correctPromo = "MF";
        String incorrectPromo = "11111";

        driver.get("http://moneyman:1005@qa-delivery-ru-master.moneyman.ru?partner=mmru&utm_source=mm&utm_medium=mm&utm_campaign=mm&keyword=mm&wmid=mm&utm_term=mm&utm_content=mm");

        //mainPage.openMainPages();
        //System.out.println("Links are correct");


         // ПРОВЕРКА ДЕФОЛТНЫХ ЗНАЧЕНИЙ КАЛЬКУЛЯТОРА +
          mainPage.calcValue("9000", "24");


         //ИЗМЕНЕНИЕ ЗНАЧЕНИЙ НА СЛАЙДЕРАХ ПРИ ПОМОЩИ ПОЛЗУНКОВ +
          mainPage.dragAndDrop(30,0);
          mainPage.calcValue("14000", "29");


         //ВВОД КОРРЕКТНОГО ПРОМОКОДА +
          mainPage.clickPromo();
          mainPage.sendPromo(correctPromo);
          mainPage.printValidMessage(correctPromo);


         //ОЧИСТКА ПОЛЯ ДЛЯ ПРОМОКОДА +
          mainPage.clearPromo();


         //ВВОД НЕКОРРЕКТНОГО ПРОМОКОДА +
          mainPage.sendPromo(incorrectPromo);
          mainPage.printValidMessage(incorrectPromo);


         //Проверка проброса промокода в куки и записи в checkpromocode +
          mainPage.setCookie("promocode", correctPromo);


         //АВТОРИЗАЦИЯ НА ТЕСТОВОЙ СТРАНИЦЕ РЕГИСТРАЦИИ
          mainPage.authRegistration();

          //ПЕРЕХОД НА РЕГИСТРАЦИЮ ПО КЛИКУ НА КНОПКУ КАЛЬКУЛЯТОРА
          mainPage.clickGetMoney();

          //ПРОВЕРКА КУКИ
          System.out.print("Проброс всех параметров: ");
          mainPage.checkAllCookies("mmru","mm", "101");

          driver.get("http://moneyman:1005@qa-delivery-ru-master.moneyman.ru?partner=123");
          System.out.print("Проброс только partner: ");
          mainPage.checkAllCookies("123","NULL", "101");//проверка зануления параметров при пробросе только partner


         //ПРОВЕРКА RESPONSE CODE
         mainPage.checkResponseCode("https://moneyman.ru", mainPage.getMoneyButton);
         mainPage.checkResponseCode("https://moneyman.ru", mainPage.loginButton);


         //ЗАКРЫТИЕ БРАУЗЕРА
         mainPage.quit();

    }
    }






