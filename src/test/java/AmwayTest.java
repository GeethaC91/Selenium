import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmwayTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GK\\Desktop\\Geetha\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amway.ca/en_CA/Shop/c/1");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void placeOrder() throws InterruptedException {
        driver.manage().window().maximize();
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        search.sendKeys("glow maker");
        search.sendKeys(Keys.ENTER);
        //System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//a[contains(text(),'Artistry Studio™ Glow-Tini Cocktail Booster Glow M')]")).click();
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"))));
        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
        // System.out.println(driver.getCurrentUrl());
        //Thread.sleep(1000);
       // driver.navigate().refresh();
       // driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
        //System.out.println(driver.getCurrentUrl());
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
