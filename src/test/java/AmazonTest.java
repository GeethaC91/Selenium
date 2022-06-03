import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AmazonTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GK\\Desktop\\Geetha\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.ca");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.get("https://www.amazon.com/Fisher-Price-Infant-Toddler-Rocker-Portable/dp/B07WRSSSRJ/?_encoding=UTF8&pf_rd_p=0f185419-5eda-46ce-8658-4e251c4fa1c4&pd_rd_wg=xvH8T&pf_rd_r=4GXENBMRNJ0133GFXM8H&pd_rd_w=su7db&pd_rd_r=fcc3be02-a828-420b-a392-c6c40b3b43ba&ref_=pd_gw_exports_top_sellers_unrec&th=1");
    }

    @Test(enabled = false)
    public void searchTc() {
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("skirts for women");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        driver.findElement(By.partialLinkText("isermeo Women")).click();
    }

    @Test(enabled = false)
    public void dropDownTest() throws Exception {
        WebElement drpOptionele = driver.findElement(By.id("searchDropdownBox"));
        Select drpOption = new Select(drpOptionele);
        List<WebElement> options = drpOption.getOptions();
       /* for(WebElement option:options)
        {
            //System.out.println(option.getText());
            if(option.getText().equals("Amazon Devices"))
            {
                drpOptionele.click();
                Thread.sleep(2000);
                break;
            }
        }*/
        drpOption.selectByVisibleText("Amazon Devices");
        Thread.sleep(2000);
        JavascriptExecutor ale = (JavascriptExecutor) driver;
        ale.executeScript("alert('selected Amazon devices')");
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss();
        TakesScreenshot tk = (TakesScreenshot) driver;
        File source = tk.getScreenshotAs(OutputType.FILE);
        File target = new File("alertscreenshot.png");
        FileUtils.copyFile(source, target);
        // drpOption.selectByValue("baby-products-intl-ship");
        //Thread.sleep(2000);
        drpOption.selectByIndex(4);
        Thread.sleep(2000);
    }

    @Test()
    public void carouselSelectTest() throws InterruptedException {
        driver.manage().window().fullscreen();
         WebElement carousel1 = driver.findElement(By.xpath("//div[@class='a-begin a-carousel-container a-carousel-display-single a-carousel-transition-slideCircular gw-desktop-herotator a-carousel-initialized']//i[@class='a-icon a-icon-next-rounded']"));
        // wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@id='anonCarousel1']//ol//li[@class='a-carousel-card']"))));
        List<WebElement> webElementList = new LinkedList<>();
        webElementList = driver.findElements(By.xpath("//div[@id='anonCarousel1']//ol//li[@class='a-carousel-card']"));
        //Thread.sleep(4000);
        System.out.println(webElementList.size());
        int i = 0;
        for (WebElement carousel2 : webElementList) {
            i++;
            System.out.println("aria setsize of element" + i + " " + carousel2.getAttribute("aria-setsize"));
            System.out.println("posinset of element" + i + " " + carousel2.getAttribute("aria-posinset"));
            System.out.println(carousel2.getTagName());
        }
        for (int j = 1; j < webElementList.size(); j++) {
            carousel1.click();
            Thread.sleep(1000);
        }
    }
    @Test(enabled=false)
    public void carouselElementsCount()
    {
        driver.manage().window().fullscreen();
        List carElements = driver.findElements(By.xpath("//div[@id='anonCarousel1']/ol/li[@class='a-carousel-card'"));
        System.out.println(carElements);
    }

    @Test(enabled=false)
    public void getAllTags()
    {
        System.out.println("Number of links"+" "+ driver.findElements(By.tagName("a")).size());
        List<WebElement> links=driver.findElements(By.tagName("a"));
        for(WebElement link:links)
        {
            System.out.println(link.getText());
        }
    }
    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
