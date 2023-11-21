package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email or password.’
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp() {

        openBrowser();
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[contains(text(), 'Sign In')]")).click();
        Thread.sleep(2000);
        //Verify the text ‘Welcome Back!’
        String expectedResult = "Welcome Back!";
        String actualResult = driver.findElement(By.className("page__heading")).getText();
        Assert.assertEquals("Incorrect Text Message", expectedResult, actualResult);
    }

    @Test
    public void verifyTheErrorMessage() throws InterruptedException {
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[contains(text(), 'Sign In')]")).click();

        // Enter invalid username
        Thread.sleep(2000);
        driver.findElement(By.id("user[email]")).sendKeys("xyz@gamil.com");

        // Enter invalid password
        Thread.sleep(2000);
        driver.findElement(By.id("user[password]")).sendKeys("123*/k@l");

        // Click on Login button
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button [@type='submit'])")).click();

        // Verify the error message ‘Invalid email or password.’
        Thread.sleep(2000);
        String expectedOutput = "Invalid email or password.";
        Thread.sleep(2000);
        String actualOutput = driver.findElement(By.xpath("//div[@id= 'notice']//ul//li")).getText();
        //String actualOutput = driver.findElement(By.xpath("//*[@id=\"notice\"]/ul/li")).getText();
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
