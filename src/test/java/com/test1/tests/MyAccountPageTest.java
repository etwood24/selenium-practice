package com.test1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by evan on 17/10/16.
 */
public class MyAccountPageTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testSuccessfulLogin() throws InterruptedException
    {

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys("etwood@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("test123");
        driver.findElement(By.id("SubmitLogin")).click();

        Assert.assertTrue(
                driver.findElement(By.cssSelector("#center_column > h1")).getText().contains("MY ACCOUNT")
        );
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }
}
