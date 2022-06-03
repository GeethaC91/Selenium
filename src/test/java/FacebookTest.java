import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class FacebookTest {
    WebDriver driver;
    WebDriverWait wait;
    static final String id="sweety.geetha13@gmail.com";
    static final String pwd="Saibaba1713";

    @BeforeSuite
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GK\\Desktop\\Geetha\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test(enabled=false)
        public void fbLogin1() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys(id);
        driver.findElement(By.id("pass")).sendKeys(pwd);
        driver.findElement(By.className("_6ltg")).click();
        //*[name()='path' and contains(@d,'M10 14a1 1')]
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@aria-label='Your profile']"))));
        driver.findElement(By.xpath("//div[@aria-label='Your profile' and @role='button']")).click();
        driver.manage().window().maximize();
        Actions act = new Actions(driver);
        for(int i=0;i<6;i++)
        {
            act.sendKeys(Keys.TAB).perform();
        }
        act.sendKeys(Keys.ENTER).perform();
    }
    @Test(enabled = true)
    public void fbLogin() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys(id);
        driver.findElement(By.id("pass")).sendKeys(pwd);
        driver.findElement(By.className("_6ltg")).click();
        driver.findElement(By.xpath("//div[@aria-label='Your profile' and @role='button']")).click();
        driver.manage().window().maximize();
        Actions act = new Actions(driver);
        for(int i=0;i<7;i++)
        {
            act.sendKeys(Keys.TAB).perform();
            Thread.sleep(1000);
        }
        act.sendKeys(Keys.ENTER).perform();
    }
    @Test(enabled = false)
    public void loginTestWithKeys() throws InterruptedException {
        WebElement email =driver.findElement(By.id("email"));
        email.sendKeys("sweety.geetha13@gmail.com");
        Actions act = new Actions(driver);
        //Ctrl+A
        act.keyDown(Keys.CONTROL);
        act.sendKeys("a");
        act.keyUp(Keys.CONTROL);
        act.perform();
        //Ctrl+C
        act.keyDown(Keys.CONTROL);
        act.sendKeys("c");
        act.keyUp(Keys.CONTROL);
        act.perform();
        //Go to pwd tab
        act.sendKeys(Keys.TAB);
        //Ctrl+v
        act.keyDown(Keys.CONTROL);
        act.sendKeys("V");
        act.keyUp(Keys.CONTROL);
        act.perform();
        Thread.sleep(3000);
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(20000);
        driver.quit();
    }
}
