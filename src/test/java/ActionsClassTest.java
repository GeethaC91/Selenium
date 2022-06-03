import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ActionsClassTest {
    WebDriver driver;

    @BeforeSuite
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GK\\Desktop\\Geetha\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
    }

    @Test(enabled = false)
    public void tc() throws InterruptedException{
        driver.manage().window().maximize();
        driver.switchTo().frame("frame1");
        Thread.sleep(3000);
    }
    @Test
    public void alertTest()
    {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='proceed']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        //alert.accept();
        alert.dismiss();

    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(9000);
        driver.quit();
    }
}
