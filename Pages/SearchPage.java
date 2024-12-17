import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    private SelenideElement checkInDate = $("div[data-mode='checkin']");
    private SelenideElement checkOutDate = $("div[data-mode='checkout']");
    private SelenideElement firstHotel = $(".sr_property_block");
    private SelenideElement mapButton = $("a[data-testid='map-button']");
    
    // Элементы для деталей отеля
    private SelenideElement hotelName = firstHotel.$(".sr-hotel__name");
    private SelenideElement hotelStars = firstHotel.$(".bui-review-score__badge");
    private SelenideElement hotelRating = firstHotel.$(".bui-review-score__badge");
    private SelenideElement hotelReviews = firstHotel.$(".bui-review-score__text");
    private SelenideElement hotelPrice = firstHotel.$(".bui-price-display__value");

    public void selectRandomDates() {
        checkInDate.click();
        // Выбор случайных дат (например, через JavaScript или просто кликом)
        // Для примера выберем фиксированные даты
        $$(".c2-day").get(5).click(); // Пример: выбрать 5-й день
        $$(".c2-day").get(10).click(); // Пример: выбрать 10-й день
    }

    public void clickShowOnMap() {
        mapButton.click();
    }

    public String getHotelDetails() {
        String name = hotelName.getText();
        String stars = hotelStars.getText();
        String rating = hotelRating.getText();
        String reviews = hotelReviews.getText();
        String price = hotelPrice.getText();

        return String.format("Название: %s, Звезды: %s, Оценка: %s, Отзывы: %s, Цена: %s",
                name, stars, rating, reviews, price);
    }

    public void hoverOverFirstHotel() {
        firstHotel.hover();
    }

    public void clickOnMapMarker() {
        // Здесь нужно будет выбрать соответствующий маркер на карте
        $("div[data-testid='map-marker']").click(); // Замените на правильный селектор
    }

    public void verifyHotelDetails(String expectedDetails) {
        String actualDetails = getHotelDetails(); // Получаем детали отеля
        assert actualDetails.equals(expectedDetails) : "Детали отеля не совпадают!";
    }
}
