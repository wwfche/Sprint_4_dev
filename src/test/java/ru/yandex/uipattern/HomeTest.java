package ru.yandex.uipattern;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.uipattern.page.HomePage;

import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class HomeTest {
    WebDriver driver;
    HomePage homePage;

    @Before
    public void setup() {
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }


    @Test
    public void firstTextComparison() {
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        homePage.scrollToElement("accordion__heading-0");
        String textFirstResponse = homePage.getTextFirstQuestion();
        assertEquals("Текст ответа не совпадает",expected, textFirstResponse);
    }

    @Test
    public void secondTextComparison() {
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        homePage.scrollToElement("accordion__heading-1");
        String textFirstResponse = homePage.getTextSecondQuestion();
        assertEquals("Текст ответа не совпадает",expected, textFirstResponse);
    }

    @Test
    public void thirdTextComparison() {
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        homePage.scrollToElement("accordion__heading-2");
        String textFirstResponse = homePage.getTextThirdQuestion();
        assertEquals("Текст ответа не совпадает",expected, textFirstResponse);
    }

    @Test
    public void fourthTextComparison() {
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        homePage.scrollToElement("accordion__heading-3");
        String textFirstResponse = homePage.getTextFourthQuestion();
        assertEquals("Текст ответа не совпадает",expected, textFirstResponse);
    }

    @Test
    public void fifthTextComparison() {
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        homePage.scrollToElement("accordion__heading-4");
        String textFirstResponse = homePage.getTextFifthQuestion();
        assertEquals("Текст ответа не совпадает",expected, textFirstResponse);
    }

    @Test
    public void sixthTextComparison() {
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        homePage.scrollToElement("accordion__heading-5");
        String textFirstResponse = homePage.getTextSixthQuestion();
        assertEquals("Текст ответа не совпадает",expected, textFirstResponse);
    }

    @Test
    public void seventhTextComparison() {
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        homePage.scrollToElement("accordion__heading-6");
        String textFirstResponse = homePage.getTextSeventhQuestion();
        assertEquals("Текст ответа не совпадает",expected, textFirstResponse);
    }

    @Test
    public void eighthTextComparison() {
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        homePage.scrollToElement("accordion__heading-7");
        String textFirstResponse = homePage.getTextEighthQuestion();
        assertEquals("Текст ответа не совпадает",expected, textFirstResponse);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
