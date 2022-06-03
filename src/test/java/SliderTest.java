import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SliderTest {
    WebDriver driver;

    @BeforeSuite
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GK\\Desktop\\Geetha\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/resources/demos/slider/range.html");
    }

    @Test
    public void tcSliderTest() {
        WebElement min_slider=driver.findElement(By.xpath("//span[1]"));
        System.out.println("LOcation"+" "+min_slider.getLocation());
        System.out.println("Size"+" "+min_slider.getSize());
        //drag and drop
        Actions act= new Actions(driver);
       act.dragAndDropBy(min_slider,-152,47).perform();
        System.out.println("LOcation"+" "+min_slider.getLocation());
        System.out.println("Size"+" "+min_slider.getSize());
        WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
        System.out.println("LOcation"+" "+max_slider.getLocation()+"Size"+" "+max_slider.getSize());
        Actions act1= new Actions(driver);
        act.dragAndDropBy(max_slider,-100,47).perform();
        System.out.println("LOcation"+" "+max_slider.getLocation()+"Size"+" "+max_slider.getSize());

    }
    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
