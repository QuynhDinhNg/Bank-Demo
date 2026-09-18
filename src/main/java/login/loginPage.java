package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;


public class loginPage {
    protected WebDriver driver;
    protected WebDriverWait wait;


public loginPage (WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait= wait;

}




//locator By
    private By txtUsername = By.id("login-username");
    private By textPwd = By.id("login-password");
    private By signInBtn = By.xpath("//button[@data-testid='login-submit-btn']");

    public void login(String userLogin, String userPwd){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtUsername)).sendKeys(userLogin);
        wait.until(ExpectedConditions.visibilityOfElementLocated(textPwd)).sendKeys(userPwd);
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn)).click();

    }

}

