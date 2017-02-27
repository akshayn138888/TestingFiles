package com.mycompany.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MultipleWindowsExampleTest {
    private WebDriver driver;
    private JavascriptExecutor jse;
    String windowGoogle, windowBing;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        jse = (JavascriptExecutor)driver;

    }
    /*@After
    public void tearDown() throws Exception {
        driver.quit();
    }*/
    @Test
    public void testWindowHandle() throws Exception {
        openFirstWindow();
        getNewWindow();
        System.out.println("Number of windows handle: " + driver.getWindowHandles().size());
        driver.switchTo().window(windowGoogle);
    }

    private void openFirstWindow(){
        driver.get("https://www.google.com/");
        windowGoogle = driver.getWindowHandle();
        System.out.println("First window handle: " + windowGoogle);
    }
    private void getNewWindow(){
        jse.executeScript("window.open('http://www.bing.com/');");
        windowBing = driver.getWindowHandle();
        System.out.println("Second window handle: " + windowBing);
    }
}