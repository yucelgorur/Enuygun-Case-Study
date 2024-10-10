package com.enuygun.enuyguncasestudy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FlightSearchResults {
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement alertAcceptButton;
    @FindBy(xpath = "//input[@data-testid='endesign-flight-origin-autosuggestion-input']")
    public WebElement toWhere;
    @FindBy(xpath = "//div[@data-testid='autosuggestion-custom-item-istanbul-city-country']")
    public WebElement allAirportinIST;
    @FindBy(xpath = "//input[@data-testid='endesign-flight-destination-autosuggestion-input']")
    public WebElement fromWhere;
    @FindBy(xpath = "//div[@data-testid='autosuggestion-custom-item-ankara-esenboga-havalimani-city-country']")
    public WebElement esenbogaAirport;
    @FindBy(xpath = "//label[@data-testid='enuygun-homepage-flight-departureDate-input-comp']")
    public WebElement calenderDeparture;
    @FindBy(xpath = "//button[@title='2024-10-19']")
    public WebElement dayofDeparture;
    @FindBy(xpath = "//label[@data-testid='enuygun-homepage-flight-returnDate-input-comp']")
    public WebElement calenderReturn;
    @FindBy(xpath = "//button[@title='2024-10-20']")
    public WebElement dayofReturn;
    @FindBy(xpath = "//button[@data-testid='enuygun-homepage-flight-submitButton']")
    public WebElement searchButton;
    @FindBy(xpath = "//div[@class='ctx-filter-departure-return-time card-header']")
    public WebElement departureReturnTime;
    @FindBy(xpath = "(//*[@class='custom-controls-stacked']//*[@class='rc-slider-handle rc-slider-handle-1'])[1]")
    public WebElement departureDepartureTimeSlider1;
    @FindBy(xpath = "(//*[@class='custom-controls-stacked']//*[@class='rc-slider-handle rc-slider-handle-2'])[1]")
    public WebElement departureDepartureTimeSlider2;
    @FindBy(xpath = "//div[contains(@data-flight-id, 'TK')]//div[@data-testid='departureTime']")
    public List<WebElement> TKflightdepartureTime;
    @FindBy(xpath = "//div[contains(@data-flight-id, 'TK')]//div[@data-testid='flightInfoPrice']")
    public List<WebElement> TKflightInfoPrice;
    public FlightSearchResults(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void alertAccept() {
        alertAcceptButton.click();
        System.out.println("Alert accept");
    }
    public void searchFlight() throws InterruptedException {
        toWhere.click();
        toWhere.sendKeys("İstanbul");
        Thread.sleep(300);
        allAirportinIST.click();
        fromWhere.sendKeys("Ankara");
        Thread.sleep(300);
        esenbogaAirport.click();
        calenderDeparture.click();
        dayofDeparture.click();
        calenderReturn.click();
        dayofReturn.click();
        searchButton.click();
        departureReturnTime.click();
    }
    public void checkListByFlightHours() {
        LocalTime startTime = LocalTime.of(9, 59,59);
        LocalTime endTime = LocalTime.of(18, 00,01);
        for (WebElement departureTimeElement : TKflightdepartureTime) {
            String departureTime = departureTimeElement.getText();
            LocalTime time = LocalTime.parse(departureTime);
            System.out.println("Departure Time: " + departureTime);
            if (time.isAfter(startTime) && time.isBefore(endTime)) {
                System.out.println(departureTime + " is within the range.");
            } else {
                System.out.println(departureTime + " is outside the range.");
            }
        }
    }
    List<Double> prices = new ArrayList<>();
    public void getPrice(){
        for (WebElement priceElement : TKflightInfoPrice) {
            String dataPrice = priceElement.getAttribute("data-price");
            prices.add(Double.parseDouble(dataPrice));
            System.out.println("Data Price: " + dataPrice);
        }
        }
    public void listByPrice(){
        boolean isSorted = true;
        for (int i = 1; i < prices.size(); i++) {
             if (prices.get(i) < prices.get(i - 1)) {
                 isSorted = false;
                 break;
             }
        }
        if (isSorted) {
            System.out.println("TK Flight Prices are listed from smallest to largest");
        } else {
            System.out.println("TK Flight Prices aren't listed from smallest to largest!");
        }
    }

}


