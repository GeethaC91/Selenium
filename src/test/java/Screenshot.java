import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    WebDriver driver;

    @BeforeSuite
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GK\\Desktop\\Geetha\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.ca");
    }

    @Test
    public void screenshotPage() throws IOException, InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(2000);
        TakesScreenshot tk = (TakesScreenshot) driver;
        File src=tk.getScreenshotAs(OutputType.FILE);
        File target=new File("amazonhome.png");
        FileUtils.copyFile(src,target);
        driver.close();
    }
    @Test
    public void screenshotElement() throws IOException {
        WebElement element= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        element.sendKeys("skirts for women");
        File source = element.getScreenshotAs(OutputType.FILE);
        File target=new File("amazonsearch.png");
        FileUtils.copyFile(source,target);
        driver.close();

    }
    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(15000);
        driver.quit();
    }
}
