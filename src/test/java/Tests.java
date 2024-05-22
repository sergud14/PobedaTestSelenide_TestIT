import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.testit.annotations.Description;
import ru.testit.annotations.DisplayName;

public class Tests {

    @Test
    @Description("Проверка всплывающего окна с заголовками")
    @DisplayName("Всплывающего окна с заголовками")
    public void Test1() throws InterruptedException {
        Selenide.open("https://www.pobeda.aero/");
        StartPage startPage=new StartPage();
        Assertions.assertTrue(startPage.verifySiteIsOpen());
        startPage.moveToButtonInformation();
        InformationHoverMenu informationHoverMenu=new InformationHoverMenu();
        Assertions.assertTrue(informationHoverMenu.verifyHeaders());
    }

    @Test
    @Description("Проверка красной обводки для поля «Туда»")
    @DisplayName("Красная обводка для поля «Туда»")
    public void Test2() throws InterruptedException {
        Selenide.open("https://www.pobeda.aero/");
        StartPage startPage=new StartPage();
        Assertions.assertTrue(startPage.verifySiteIsOpen());
        TicketSearchBlock ticketSearchBlock=new TicketSearchBlock();
        Assertions.assertTrue(ticketSearchBlock.verifyInputs());
        ticketSearchBlock.scrollToSearchTicketBlock();
        ticketSearchBlock.fillInputFrom("Москва");
        ticketSearchBlock.fillInputTo("Санкт-Петербург");
        ticketSearchBlock.clickSearchButton();
        Assertions.assertTrue(ticketSearchBlock.verifyInputDateFromErrorBorderColor());
    }

    @Test
    @Description("Проверка ошибки «Заказ с указанными параметрами не найден»")
    @DisplayName("Ошибка поиска заказа")
    public void Test3() throws InterruptedException {
        Selenide.open("https://www.pobeda.aero/");
        StartPage startPage=new StartPage();
        Assertions.assertTrue(startPage.verifySiteIsOpen());
        BookingManagementBlock bookingManagementBlock=new BookingManagementBlock();
        bookingManagementBlock.scrollToBookingManagementBlock();
        Assertions.assertTrue(bookingManagementBlock.verifyInputs());
        bookingManagementBlock.fillInputClientName("Qwerty");
        bookingManagementBlock.fillInputBookingNumber("XXXXXX");
        bookingManagementBlock.clickSearchButton();
        bookingManagementBlock.switchToNewTab();
        Assertions.assertTrue(bookingManagementBlock.verifyBookingErrorMessage());
    }
}