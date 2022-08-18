package ru.yandex.uipattern;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.hamcrest.MatcherAssert;
import ru.yandex.uipattern.page.OrderPage;

import static org.hamcrest.core.StringContains.containsString;
import java.time.Duration;

public class OrderTest {
    WebDriver driver;
    OrderPage orderPage;

    String[] firstSet = {"Ольга", "Бакланова", "г. Москва, пер. Столешников, д. 11", "89504990976", "Хорошего дня!"};
    String[] secondSet = {"Хельга", "Лапунова", "г. Москва, ул. Леонова, д.56", "89534567698", "Держитесь там!"};

    @Before
    public void setup() {
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        orderPage = new OrderPage(driver);
    }

    @Test
    public void testingTheFirstButtonOrder() {
        String expected = "Заказ оформлен";
        orderPage.clickOnOrderButton();
        orderPage.fillingOutTheFormFirstPage(firstSet[0], firstSet[1], firstSet[2],firstSet[3]);
        orderPage.fillingOutTheFormSecondPage(firstSet[4]);
        String orderFin = orderPage.orderCreationCheck();
        MatcherAssert.assertThat("Заказ не оформлен",orderFin, containsString(expected));

    }

    @Test
    public void testingTheSecondButtonOrder() {
        String expected = "Заказ оформлен";
        orderPage.clickOnOrderButtonTwo();
        orderPage.fillingOutTheFormFirstPage(secondSet[0], secondSet[1], secondSet[2],secondSet[3]);
        orderPage.fillingOutTheFormSecondPage(secondSet[4]);
        String orderFin = orderPage.orderCreationCheck();
        MatcherAssert.assertThat("Заказ не оформлен", orderFin, containsString(expected));

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
