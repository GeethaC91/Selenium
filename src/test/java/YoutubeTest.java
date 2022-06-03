import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class YoutubeTest {
    WebDriver driver;

    @BeforeSuite
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GK\\Desktop\\Geetha\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
    }

    @Test
    public void ytPlaySong() {
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("tom and jerry");
        driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
    }
    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(15000);
        driver.quit();
    }
}
