import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HomeTest {
    WebDriver driver;

    @BeforeSuite
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GK\\Desktop\\Geetha\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://zoom.us");
    }

    @Test
    public void tc() {
        WebElement element = driver.findElement(By.cssSelector("#btnJoinMeeting"));
        element.click();
        System.out.println(driver.getCurrentUrl());
        String str = driver.getTitle();
        System.out.println(str);
        Assert.assertEquals(str, "Join Meeting - Zoom");
        if (str.equalsIgnoreCase("Join Meeting - Zoom")) {
            System.out.println("The same title");
        }
        //WebElement element1=driver.findElement(By.cssSelector("input[id=\"join-confno\"]"));
        // element1.sendKeys("84694039304");
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
