import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ZoomTest {
    WebDriver driver;

    @BeforeSuite
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GK\\Desktop\\Geetha\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.cn.ca/en/");
       // driver.get("https://zoom.us");
      //  System.out.println(driver.getWindowHandle());
    }

    @Test
    public void tc1()
    {
        WebElement service = driver.findElement(By.xpath("//a[contains(@id,'_repMainNav_topLevelLink_1')]"));
        WebElement trucking = driver.findElement(By.xpath("//a[contains(@id,'_repMainNav_repSecondLevel_1_secondLevelLink_2')]"));
        WebElement express = driver.findElement(By.xpath("//a[contains(@id,'_repMainNav_repSecondLevel_1_repThirdLevel_2_thirdLevelLink_1')]"));
        WebElement jobaid = driver.findElement(By.xpath("//a[contains(@id,'_repMainNav_repSecondLevel_1_repThirdLevel_2_repFourthLevel_1_fourthLevelLink_0')]"));
        Actions action = new Actions(driver);
        action.moveToElement(service).pause(2000).moveToElement(trucking).pause(2000).moveToElement(express).pause(2000)
                .moveToElement(jobaid).click().build().perform();
    }
    @Test(enabled = false)
    public void tcAlertTest() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("alert('Hi')");
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(5000);
        alert.dismiss();
    }
    @Test(enabled = false)
    public void tcWindowTest() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("#btnJoinMeeting"));
        element.click();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        driver.manage().window().minimize();
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(900,800));
        Thread.sleep(2000);
    }

    @Test(enabled = false)
    public void tcWindowHandleTest() throws InterruptedException {
      WebElement element= driver.findElement(By.cssSelector("#btnJoinMeeting"));
      WebElement element1=driver.findElement(By.linkText("Contact Sales"));
       new Actions(driver).keyDown(Keys.CONTROL).click(element1).build().perform();
       //new Actions(driver).keyDown(Keys.CONTROL).click(element).build().perform();
       // Thread.sleep(5000);
        //String currentWindow=driver.getWindowHandle();
       // System.out.println(currentWindow);
        Set<String> windowHandles = new LinkedHashSet<String>();
        windowHandles= driver.getWindowHandles();
        System.out.println(windowHandles);
        //String newWindow = "";
       // Thread.sleep(5000);
        for(String window: windowHandles)
        {
            //if(!window.equals(currentWindow))
              //  newWindow=window;
            System.out.println(window);
            System.out.println(driver.getCurrentUrl());
                driver.switchTo().window(window);
            System.out.println(driver.getCurrentUrl());
                Thread.sleep(5000);
        }
    }
    @Test(enabled = false)
    public void tcNavigate() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("#btnJoinMeeting"));
        element.click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.navigate().to(new URL("https://zoom.us"));
    }
    @Test(enabled = false)
    public void tcCookieTest() throws Exception {
        //Webpage Inspect>>Application>>Cookies
        driver.manage().deleteCookieNamed("_zm_currency");
        driver.manage().addCookie(new Cookie("_zm_currency","USD"));
        Thread.sleep(3000);
        driver.navigate().refresh();
    }
    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
