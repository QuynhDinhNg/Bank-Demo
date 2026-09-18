package login;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import baseTest.baseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class loginTest extends baseTest {

    loginPage lg  ;
    @Before
    public void setUpLg (){
         lg = new loginPage(driver,wait);
    }

    @Test
    public void positiveLogin() throws IOException {

       lg.login(props.getProperty("userLogin"), props.getProperty("userPwd") );

       wait.until(ExpectedConditions.urlContains("/bank/dashboard"));
       String currentUrl = driver.getCurrentUrl();
       String sucessMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-testid='dashboard-welcome-message']"))).getText();

        Assert.assertTrue(currentUrl.contains("/bank/dashboard"));
        Assert.assertEquals(sucessMsg,"Welcome back, Admin");



    }

    @Test
    public void negativeLogin (){
        lg.login(props.getProperty("userLogin"), "22222" );
        String errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='login-error-message']"))).getText();
        Assert.assertEquals(errorMsg,"The username or password you entered is incorrect.");
    }



}
