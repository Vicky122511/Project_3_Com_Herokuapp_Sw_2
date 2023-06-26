package testsuite;

import browsefactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest
{
    String baseurl = "http://the-internet.herokuapp.com/login";
    String expectedText,actualText;

    @Before
    public void setUp()
    {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        //Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class='radius']")).click();

        //Verify the text “Secure Area”
        expectedText="Secure Area";
        actualText=driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText();
        Assert.assertEquals("Both Text are Not Equal",expectedText,actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage()
    {
        //Enter “tomsmith1” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");

        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class='radius']")).click();

        //Verify the error message “Your username is invalid!”
        expectedText="Your username is invalid!";
        actualText=driver.findElement(By.xpath("//div[@id='flash' and a[text()='×']]")).getText();
        Assert.assertEquals("Both Text are Not Equal",expectedText,actualText);


    }

    @Test
    public void verifyThePasswordErrorMessage()
    {
        //Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

        //Enter “SuperSecretPassword” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class='radius']")).click();

        //Verify the error message “Your password is invalid!”
        expectedText="Your password is invalid!";
        actualText=driver.findElement(By.xpath("//div[@id='flash' and a[text()='×']]")).getText();
        Assert.assertEquals("Both Text are Not Equal",expectedText,actualText);

    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }

}
