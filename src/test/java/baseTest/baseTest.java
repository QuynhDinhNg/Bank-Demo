package baseTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class baseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties props;


    @Before
    public void setUp() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        props = new Properties();
        props.load(new FileInputStream("src/test/resources/config.properties"));
        driver.get("https://qaplayground.com/bank/login");

    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
