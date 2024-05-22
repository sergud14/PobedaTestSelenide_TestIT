import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.testit.annotations.Description;
import ru.testit.annotations.Step;
import static com.codeborne.selenide.Selenide.$;

@Description("Всплывающее меню - при наведении на кноку Информация")
public class InformationHoverMenu {
    private SelenideElement headerFlight = $(By.xpath("//a[@href='/information#flight']"));
    private SelenideElement headerUseful = $(By.xpath("//a[@href='/information#useful']"));
    private SelenideElement headerCompany = $(By.xpath("//a[@href='/information#company']"));
    public InformationHoverMenu ()
    {
    }
    @Step()
    public boolean verifyHeaders() {
        if ($(headerFlight).getText().equals("Подготовка к полёту") &&
            $(headerUseful).getText().equals("Полезная информация") &&
            $(headerCompany).getText().equals("О компании"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}

