package com.mycompany.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class RadioButtonExampleTest {
    private WebDriver driver;
    List<WebElement> radioGroup;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    //For validation
    @Test
    public void testGetSelectedRadioButton() throws Exception {
        navigateToRadioButton();
        for (WebElement element : radioGroup){
            boolean isRadioSelected = element.isSelected();
            if (isRadioSelected == true){
                System.out.println("Selected Radio button: " + element.getAttribute("value"));
            }
        }
        driver.switchTo().defaultContent();
    }
    //For navigation
    public void navigateToRadioButton(){
        driver.get("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_input_radio");
        driver.switchTo().frame("iframeResult");
        radioGroup = driver.findElements(By.name("sex"));
        System.out.println("Number of Radio buttons: " + radioGroup.size());
    }
}