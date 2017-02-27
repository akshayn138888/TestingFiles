package com.mycompany.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


public class CheckboxesExampleTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.w3schools.com/html/html_form_input_types.asp");
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void testCheckboxes_W3Schools() throws Exception {
        WebElement checkbox1 = driver.findElement(By.name("vehicle1"));
        WebElement checkbox2 = driver.findElement(By.name("vehicle2"));
        boolean isFirstSelected = checkbox1.isSelected();
        assertFalse(isFirstSelected);
        boolean isSecondSelected = checkbox2.isSelected();
        assertFalse(isSecondSelected);

        System.out.println(checkbox1.getAttribute("value") + ": " + isFirstSelected);
        System.out.println(checkbox2.getAttribute("value") + ": " + isSecondSelected);
    }
}