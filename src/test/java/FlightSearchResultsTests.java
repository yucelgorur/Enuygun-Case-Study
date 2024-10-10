import com.enuygun.enuyguncasestudy.BaseTest;
import com.enuygun.enuyguncasestudy.FlightSearchResults;
import org.testng.annotations.Test;

public class FlightSearchResultsTests extends BaseTest {

    @Test(description = "Check between given hours")
    public void checkBetweenGivenHours() throws InterruptedException {
        var pageFunc = new FlightSearchResults(driver);
        pageFunc.alertAccept();
        pageFunc.searchFlight();
        actions.dragAndDropBy(pageFunc.departureDepartureTimeSlider1, 100, 0).build().perform();
        Thread.sleep(1000);
        actions.dragAndDropBy(pageFunc.departureDepartureTimeSlider2, -60, 0).build().perform();
        Thread.sleep(1000);
        pageFunc.checkListByFlightHours();
    }
    @Test(description = "Check list by TK flight price")
    public void checkListByPrice() throws InterruptedException {
        var pageFunc = new FlightSearchResults(driver);
        pageFunc.alertAccept();
        pageFunc.searchFlight();
        actions.dragAndDropBy(pageFunc.departureDepartureTimeSlider1,100,0).build().perform();
        Thread.sleep(1000);
        actions.dragAndDropBy(pageFunc.departureDepartureTimeSlider2, -60, 0).build().perform();
        Thread.sleep(1000);
        pageFunc.getPrice();
        pageFunc.listByPrice();
    }
}
