package login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import baseTest.baseTest;
import java.io.IOException;

public class loginSucess extends baseTest {


    @Test
    public void login() throws IOException {

        driver.get("https://qaplayground.com/bank/login");
//        wait.until(ExpectedCondition)
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(props.getProperty("userLogin"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(props.getProperty("userPwd"));
        driver.findElement(By.id("submit")).click();
        String sucessMsg = driver.findElement(By.xpath("//h1[@data-testid='dashboard-welcome-message']")).getText();
        Assert.assertEquals(sucessMsg,"Welcome back, Admin");

    }




}
