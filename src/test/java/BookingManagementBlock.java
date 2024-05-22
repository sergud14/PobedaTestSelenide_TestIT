import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.*;
import ru.testit.annotations.Description;
import ru.testit.annotations.Step;
import java.util.ArrayList;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Description("Блок управления бронированием")
public class BookingManagementBlock {
    private SelenideElement tabBookingManagement = $(By.xpath("(//div[text()='Управление бронированием']//parent::button)[1]"));
    private SelenideElement inputClientName = $(By.xpath("(//input[@placeholder='Фамилия клиента'])[1]"));
    private SelenideElement inputBookingNumber = $(By.xpath("(//input[@placeholder='Номер бронирования или билета'])[1]"));
    private SelenideElement buttonSearch = $(By.xpath("//button[text()='Поиск']//parent::div"));
    private SelenideElement bookingErrorMessage = $(By.xpath("//div[@ng-if='vm.errorMessage'][text()='Заказ с указанными параметрами не найден']"));

    public BookingManagementBlock ()
    {
    }
    @Step()
    public boolean verifyInputs() {
        if ($(inputClientName).isDisplayed()&&
                $(inputBookingNumber).isDisplayed()&&
                $(buttonSearch).isDisplayed()
        )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @Step()
    public void scrollToBookingManagementBlock() {
        $(tabBookingManagement).scrollIntoView(true).click();
    }
    @Step()
    public void fillInputClientName(String name) {
        $(inputClientName).setValue(name);
    }

    @Step()
    public void fillInputBookingNumber(String number) {
        $(inputBookingNumber).setValue(number);
    }
    @Step()
    public void clickSearchButton() {
        $(buttonSearch).click();
    }

    @Step()
    public void switchToNewTab(){
        ArrayList<String> newTab = new ArrayList<String>(getWebDriver().getWindowHandles());
        Selenide.switchTo().window(newTab.get(1));
    }
    @Step()
    public boolean verifyBookingErrorMessage() {
        if($(bookingErrorMessage).isDisplayed())
        {
            return true;
        }
        else {
            return false;
        }
    }
}