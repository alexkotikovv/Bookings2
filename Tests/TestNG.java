import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class BookingTest {

    @Test
    @Description("Тест на поиск отелей и проверку деталей отеля")
    public void testBooking() {
        Homepage homepage = new Homepage();
        SearchPage searchPage = new SearchPage();

        homepage.openHomepage();
        
        homepage.enterCity("Анталья");
        
        homepage.clickSearch();
        
        searchPage.selectRandomDates();
        
        searchPage.clickShowOnMap();
        
        searchPage.hoverOverFirstHotel();
        String hotelDetails = searchPage.getHotelDetails();
        
        searchPage.clickOnMapMarker();
        
        searchPage.verifyHotelDetails(hotelDetails);
    }
}
