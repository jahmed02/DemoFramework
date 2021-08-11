package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.nio.file.WatchEvent;
import java.sql.Driver;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class YouTube {
    public static WebDriver driver = null;

    public static void click(String locator){
        driver.findElement(By.xpath(locator)).click();
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\jisan\\IdeaProjects\\DemoProject\\BaseClass\\drives\\chromedriver.exe");
          driver = new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver","C:\\Users\\jisan\\IdeaProjects\\DemoProject\\BaseClass\\drives\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();

        //dynamic waits
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();

//        // using firefox
//        driver.findElement(By.xpath("//div[@slot='search-input]")).click();

        driver.findElement(By.xpath("//input[@name='search_query']")).click();
        driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("music", Keys.ENTER);

        List<WebElement> listOfElements = driver.findElements(By.cssSelector("ytd-video-renderer.style-scope.ytd-item-section-renderer"));
        listOfElements.get(2).click();

        Thread.sleep(15000);
        driver.quit();






// complicated locators for search bar
//        driver.findElement(By.xpath("//div[@id='search-input' and @class='ytd-searchbox-spt']")).click();
//        driver.findElement(By.xpath("//div[@id='search-input' and @class='ytd-searchbox-spt']//input[@id='search']")).sendKeys("Music",Keys.ENTER);


//        driver.findElement(By.xpath("//a[@title='TOP 40 Songs of 2020 2021 (Best Hit Music Playlist) on Spotify']")).click();
//
//        driver.findElement(By.xpath("//button[@aria-label='Theater mode (t)']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[@aria-label='Theater mode (t)']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[@title='Full screen (f)']")).click();
//        Thread.sleep(2000);


//        click("//button[@aria-label='Theater mode (t)']");
//        Thread.sleep(2000);
//        click("//button[@aria-label='Theater mode (t)']");
//        Thread.sleep(2000);
//        click("//button[@title='Full screen (f)']");
//        Thread.sleep(2000);



    }
}
