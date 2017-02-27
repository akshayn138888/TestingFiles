package com.mycompany.app;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


public class ScreenShotExampleTest {
    private static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.linkedin.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Rule
    public ScreenShotRule screenShootRule = new ScreenShotRule(driver);

    @Test
    public void linkedInRegistrationShouldFail() {
        driver.findElement(By.id("first-name")).sendKeys("Ripon");//Correct ID for First name
        //driver.findElement(By.id("last-name")).sendKeys("Al Wasim");//Correct ID for Last name
        driver.findElement(By.id("lastname")).sendKeys("Al Wasim");//Incorrect ID for Last name
        System.out.println("It should fail");
    }
}