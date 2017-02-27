package com.mycompany.app;



import org.junit.Rule;
import org.junit.Test;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static junit.framework.TestCase.assertTrue;


/**
 * Unit test for simple App.
 */
public class LearningBranch

{
    @Test
    public static void driverIsTheKing( String[] args)
    {
        WebDriver driver =  new HtmlUnitDriver();
        driver.get ("https://www.learningbranch.com/");


        assertTrue(driver.getTitle().startsWith("LearningBranch Inc."));
        String la;
        la = driver.getCurrentUrl();

        System.out.println(la.toString());
        driver.navigate().to("https://www.learningbranch.com/higher-ed/");

        driver.navigate().to("https://www.learningbranch.com/sign-up-for-a-free-trial/");
        System.out.println(driver.getCurrentUrl());

        assertTrue(driver.getTitle().startsWith("Sign up for a free trial | LearningBranch Inc."));
        System.out.println(driver.getPageSource());


        System.out.println("I moved forward once");
        driver.quit();





    }


}
