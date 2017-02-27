package com.mycompany.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectExampleTest {
    private WebDriver driver;
    List<WebElement> options;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    //For Validation
    @Test
    public void testSelect_W3Schools() throws Exception {
        navigateToSelect();
        for(WebElement option : options){
            System.out.println(option.getText());
        }
        driver.switchTo().defaultContent();
    }
    //For Navigation
    public void navigateToSelect(){
        driver.switchTo().frame("iframeResult");
        Select dropDownList = new Select(driver.findElement(By.cssSelector("select")));
        System.out.println("First selected item: " + dropDownList.getFirstSelectedOption().getText());

        options = dropDownList.getOptions();
        System.out.println("Number of items: " + options.size());
    }
}