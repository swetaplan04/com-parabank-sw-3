package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm\n";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    // verifying that signing up page is displayed
    public void verifyThatSigningUpPageDisplay() {
        //clicking on the register link
        clickOnElement(By.linkText("Register"));
        //verifying the text message
        verifyElements("Signing message not displayed", "Signing up is easy!", By.xpath("//h1[normalize-space()='Signing up is easy!']"));
    }

    @Test
    // Verifying that user can register the account successfully
    public void userShouldRegisterAccountSuccessfully() {

        clickOnElement(By.xpath("//div[@id = 'leftPanel']/descendant::a[2]"));
        sendTextToElement(By.xpath("//form[@id = 'customerForm']/child::table/child::tbody/child::tr/child::td[2]/child::input[1]"),"TestUser");
        sendTextToElement(By.xpath("//form[@id = 'customerForm']/descendant::td[5]/child::input"),"TestPassword");
        sendTextToElement(By.xpath("//form[@id = 'customerForm']/descendant::input[3]"),"High Street");
        sendTextToElement(By.xpath("//form[@id = 'customerForm']/descendant::input[@id = 'customer.address.city']"),"London");
        sendTextToElement(By.xpath("//form[@id = 'customerForm']/descendant::input[@name = 'customer.address.state']"),"London");
        sendTextToElement(By.xpath("//tr[7]//preceding-sibling::tr[1]/descendant::input"),"EC117QP");
        sendTextToElement(By.xpath("//tr[1]/following-sibling::tr[6]/child::td[2]/child::*"),"0208123456");
        sendTextToElement(By.xpath("//tr[1]/following-sibling::tr[7]/child::td[2]/child::input"),"123456");
        sendTextToElement(By.xpath("//input[@id = 'customer.username']"),"TempUser7000");
        sendTextToElement(By.xpath("//input[@name = 'customer.password']"),"Password700");
        sendTextToElement(By.xpath("//tr[12]/child::td[2]/child::input[@name= 'repeatedPassword']"),"Password700");
        clickOnElement(By.xpath("//tr[13]/child::td[2]/child::input"));
        verifyElements("Account not created successfully","Your account was created successfully. You are now logged in.",By.xpath("//div[@id='bodyPanel']/child::div[2]/child::p"));
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}












