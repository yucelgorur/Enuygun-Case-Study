package com.enuygun.enuyguncasestudy;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
public class BaseTest {
    public WebDriver driver;
    public FlightSearchResults mainPage;
    public Actions actions;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*",
                        "--remote-allow-origins=*",
                        "--ignore-certificate-errors",
                        "--allow-insecure-localhost",
                        "--acceptInsecureCerts",
                        "--disable-infobars",
                        "--no-sandbox",
                        "--disable-gpu",
                        "--disable-popup-blocking",
                        "--disable-notifications",
                        "--disable-extensions",
                        "--disable-dev-shm-usage",
                        "--force-device-scale-factor=1",
                        "--dns-prefetch-disable",
                        "--incognito",
                        "--disable-browser-side-navigation");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.enuygun.com/");

        mainPage = new FlightSearchResults(driver);
        actions = new Actions(driver);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
