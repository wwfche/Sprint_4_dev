package ru.yandex.uipattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage{

    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private By orderButton = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g"); //Кнопка Заказать на Главной странице в Хедере
    private By orderButtonTwo = By.cssSelector(".Home_FinishButton__1_cWm .Button_Button__ra12g"); //Кнопка Заказать на Главной странице
    private By firstNameField = By.cssSelector(".Input_InputContainer__3NykH:first-child .Input_Responsible__1jDKN"); //Поле Имя
    private By lastNameField = By.cssSelector(".Input_InputContainer__3NykH:nth-child(2) .Input_Responsible__1jDKN"); //Поле Фамилия
    private By addressField = By.cssSelector(".Input_InputContainer__3NykH:nth-child(3) .Input_Responsible__1jDKN"); //Поле адрес
    private By phoneField = By.cssSelector(".Input_InputContainer__3NykH:nth-child(5) .Input_Responsible__1jDKN"); //Поле Телефон
    private By metroDropdown = By.className("select-search__value"); //Выпадающий список Станция метро
    private By selectedStation = By.cssSelector("[data-value='2']"); //Выбранное занчение Черкизовская
    private By dateField = By.cssSelector(".Order_MixedDatePicker__3qiay .Input_Input__1iN_Z"); //Поле Дата доставки
    private By selectedDate = By.cssSelector(".react-datepicker__day--015"); //Выбор даты
    private By rentField = By.className("Dropdown-control"); //Выпадающий спикок Срок аренды
    private By selectedTerm = By.cssSelector(".Dropdown-option:nth-child(2)"); //Выбранное значение Двое суток
    private By colorCheckbox = By.id("grey"); //Чекбокс Цвет самоката (выбран Серая безысходность)
    private By commentForCourier = By.cssSelector(".Input_InputContainer__3NykH .Input_Responsible__1jDKN"); //Поле Комментарий для курьера
    private By nextButton = By.className("Button_Middle__1CSJM"); //Кнопка Далее
    private By orderButtonFin = By.cssSelector(".Button_Middle__1CSJM:nth-child(2)"); //Кнопка Заказать
    private By yesButton = By.cssSelector(".Order_Modal__YZ-d3 .Button_Middle__1CSJM:nth-child(2)"); //Кнопка Да в всплывающем окне
    private By textPopUp = By.className("Order_ModalHeader__3FDaJ"); //Текст из поп-апа об оформленном заказе


    //Нажатие кнопки Заказать в хедере
    public void clickOnOrderButton() {
        driver.findElement(orderButton).click();
    }

    //Нажатие кнопки Заказать на странице
    public void clickOnOrderButtonTwo() {
        WebElement element = driver.findElement(orderButtonTwo);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //Заполнение первой страницы, после нажатия кнопки Заказать
    public void fillingOutTheFormFirstPage(String firstName, String lastName, String address, String phone) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);

        driver.findElement(metroDropdown).click();
        driver.findElement(selectedStation).click();
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(nextButton).click();
        driver.findElement(orderButtonFin).isEnabled();

    }

    //Заполнение второй страницы, после нажатия кнопки Далее
    public void fillingOutTheFormSecondPage(String comment) {
        driver.findElement(dateField).click();
        driver.findElement(selectedDate).click();
        driver.findElement(rentField).click();
        driver.findElement(selectedTerm).click();
        driver.findElement(colorCheckbox).click();
        driver.findElement(commentForCourier).sendKeys(comment);
        driver.findElement(orderButtonFin).click();
        driver.findElement(yesButton).click();
    }

    //Получение текста после оформления заказа
    public String orderCreationCheck() {
        return driver.findElement(textPopUp).getText();
    }


}
