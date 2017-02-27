package com.mycompany.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class WaitForComponentExampleTest {
    private WebDriver driver;
    private String googleBaseURL;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        googleBaseURL = "https://www.google.com/";
        driver.get(googleBaseURL + "?gws_rd=cr,ssl&ei=b8VNVu2uFMm6uATkl63YDw&fg=1");
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void testWaitForComponent() throws Exception {
        shouldWaitForPageToLoad3();
        assertEquals(driver.getTitle(), "Selenium WebDriver - Google Search");
    }
    public void navigateToGoogleSearchPage(){
        driver.findElement(By.id("lst-ib")).sendKeys("Selenium WebDriver");
        driver.findElement(By.name("btnG")).click();
    }
    public void shouldWaitForPageToLoad1(){
        navigateToGoogleSearchPage();
    }
    public void shouldWaitForPageToLoad2(){
        navigateToGoogleSearchPage();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.getMessage();
        }
    }
    public void shouldWaitForPageToLoad3(){
        navigateToGoogleSearchPage();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
    }
}