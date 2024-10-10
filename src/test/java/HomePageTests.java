import com.enuygun.enuyguncasestudy.BaseTest;
import com.enuygun.enuyguncasestudy.HomePage;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    @Test(description = "Check search box panel and submit button on homa page")
    public void checkSearchModule(){
        var homePage = new HomePage(driver);
        homePage.alertAccept();
        homePage.isElementPresent(homePage.searchModuleinHomePage);
        homePage.isElementPresent(homePage.submitButtoninHomePage);
    }
}
