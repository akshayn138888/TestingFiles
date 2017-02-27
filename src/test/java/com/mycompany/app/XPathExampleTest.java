package com.mycompany.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class XPathExampleTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.w3schools.com/xsl/xpath_intro.asp");
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void testXPathExample() throws Exception {
        WebElement link = driver.findElement(By.xpath(".//*[@id='main']/h1"));
        String linkText = link.getText();
        System.out.println(linkText);
    }
}