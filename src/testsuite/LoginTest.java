package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before

    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    // Verifying that user should be able to log in with valid credentials

    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.xpath("//div/parent::div[1]/child::div[3]//child::div/child::div/child::form/child::div/child::input"),"TempUser3000");
        sendTextToElement(By.xpath("//input[@name = 'password']/self::input"),"Password100");
        clickOnElement(By.xpath("//div[3][@class = 'login']/child::input"));
        verifyElements("Accounts Overview not displayed","Accounts Overview",By.linkText("Accounts Overview"));
    }
    @Test
    // Verifying that user can not log in with invalid credentials
    public void verifyTheErrorMessage() {
        sendTextToElement(By.xpath("//div/parent::div[1]/child::div[3]//child::div/child::div/child::form/child::div/child::input"),"1515100");
        sendTextToElement(By.xpath("//input[@name = 'password']/self::input"),"Abcdefghi100");
        clickOnElement(By.xpath("//div[3][@class = 'login']/child::input"));
        verifyElements("error message","The username and password could not be verified.",By.xpath("//div[@id = 'rightPanel']/child::p"));
    }
    @Test
    // Verify that user should be able to log out successfully
    public void userShouldLogOutSuccessfully(){
       // This is from requirement
        sendTextToElement(By.xpath("//div/parent::div[1]/child::div[3]//child::div/child::div/child::form/child::div/child::input"),"1515100");
        sendTextToElement(By.xpath("//input[@name = 'password']/self::input"),"Abcdefghi100");
        clickOnElement(By.xpath("//div[3][@class = 'login']/child::input"));
        clickOnElement(By.linkText("Log Out"));
        verifyElements("can not see the login message","Customer Login",By.xpath("//div[@id = 'bodyPanel']/descendant::h2"));
    }
    @After
    public void tearDown(){
          closeBrowser();
    }
}

