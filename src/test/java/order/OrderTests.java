package order;

import driver.UseWebDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObject.HomePageScooter;
import pageObject.OrderPageScooter;

import java.util.Objects;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OrderTests extends UseWebDriver {

    private final String button;
    private final String name;
    private final String secondName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String deliveryDate;
    private final int rentalPeriod;
    private final String color;
    private final String comment;

    public OrderTests(String button, String name, String secondName, String address, String metro, String phone, String deliveryDate, int rentalPeriod, String color, String comment) {
        this.button = button;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"TOP", "Имя", "Фамилия", "Адрес", "Черкизовская", "71111111111", "19.04.2023", 3, "Черный", "Коммент"},
                {"BOTTOM", "Имя", "Фамилия", "Адрес", "Черкизовская", "71111111111", "19.04.2023", 4, "Серый", "Коммент"},
        };
    }

    @Test
    public void checkOrder() {
        HomePageScooter objHomePageScooter = new HomePageScooter(driver);
        objHomePageScooter.clickCookieButton();
        if (Objects.equals(button, "TOP")){
            objHomePageScooter.clickOrderButtonHeading();
        }
        if (Objects.equals(button, "BOTTOM")) {
            objHomePageScooter.scrollAndClickOrderButtonRoadmap();
        }
        OrderPageScooter objOrderPageScooter = new OrderPageScooter(driver);
        objOrderPageScooter.editOrderPageOne(
                name,
                secondName,
                address,
                metro,
                phone);
        objOrderPageScooter.clickOrderButtonThen();
        objOrderPageScooter.editOrderPageTwo(
                deliveryDate,
                rentalPeriod,
                color,
                comment);
        objOrderPageScooter.checkModal();
        assertTrue(objOrderPageScooter.getOrderLabelSuccess().contains("Заказ оформлен"));
    }
}
