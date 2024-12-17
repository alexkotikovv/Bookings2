import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class Homepage {

    private SelenideElement searchInput = $("input[name='ss']");
    private SelenideElement searchButton = $("button[type='submit']");

    public void openHomepage() {
        open("https://www.booking.com/");
    }

    public void enterCity(String city) {
        searchInput.setValue(city);
    }

    public void clickSearch() {
        searchButton.click();
    }
}
