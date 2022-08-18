package ru.yandex.uipattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstQuestion = By.id("accordion__heading-0"); //Первый вопрос
    private By secondQuestion = By.id("accordion__heading-1"); //Второй вопрос
    private By thirdQuestion = By.id("accordion__heading-2"); //Третий вопрос
    private By fourthQuestion = By.id("accordion__heading-3"); //Четвертый вопрос
    private By fifthQuestion = By.id("accordion__heading-4"); //Пятый вопрос
    private By sixthQuestion = By.id("accordion__heading-5"); //Шестой вопрос
    private By seventhQuestion = By.id("accordion__heading-6"); //Седьмой вопрос
    private By eighththQuestion = By.id("accordion__heading-7"); //Седьмой вопрос

    private By firstResponse = By.id("accordion__panel-0"); //Первый ответ
    private By secondResponse = By.id("accordion__panel-1"); //Второй ответ
    private By thirdResponse = By.id("accordion__panel-2"); //Третий ответ
    private By fourthResponse = By.id("accordion__panel-3"); //Четвертый ответ
    private By fifthResponse = By.id("accordion__panel-4"); //Пятый ответ
    private By sixthResponse = By.id("accordion__panel-5"); //Шестой ответ
    private By seventhResponse = By.id("accordion__panel-6"); //Седьмой ответ
    private By eighthResponse = By.id("accordion__panel-7"); //Седьмой ответ

    //Скрол до нужного вопроса
    public void scrollToElement(String locator) {
        WebElement element = driver.findElement(By.id(locator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }
    //Получение текста ответа
    public String getTextFirstQuestion(){
        driver.findElement(firstQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(firstResponse));
        return driver.findElement(firstResponse).getText();
    }

    //Получение текста ответа
    public String getTextSecondQuestion(){
        driver.findElement(secondQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(secondResponse));
        return driver.findElement(secondResponse).getText();
    }

    //Получение текста ответа
    public String getTextThirdQuestion(){
        driver.findElement(thirdQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(thirdResponse));
        return driver.findElement(thirdResponse).getText();
    }

    //Получение текста ответа
    public String getTextFourthQuestion(){
        driver.findElement(fourthQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(fourthResponse));
        return driver.findElement(fourthResponse).getText();
    }

    //Получение текста ответа
    public String getTextFifthQuestion(){
        driver.findElement(fifthQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(fifthResponse));
        return driver.findElement(fifthResponse).getText();
    }

    //Получение текста ответа
    public String getTextSixthQuestion(){
        driver.findElement(sixthQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(sixthResponse));
        return driver.findElement(sixthResponse).getText();
    }

    //Получение текста ответа
    public String getTextSeventhQuestion(){
        driver.findElement(seventhQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(seventhResponse));
        return driver.findElement(seventhResponse).getText();
    }

    //Получение текста ответа
    public String getTextEighthQuestion(){
        driver.findElement(eighththQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(eighthResponse));
        return driver.findElement(eighthResponse).getText();
    }

}


