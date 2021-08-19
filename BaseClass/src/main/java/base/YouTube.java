package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.nio.file.WatchEvent;
import java.sql.Driver;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class YouTube {
    public static WebDriver driver = null;

    public static void clickOnLocators(String locator){

        driver.findElement(By.xpath(locator)).click();
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\jisan\\IdeaProjects\\DemoProject\\BaseClass\\drives\\chromedriver.exe");
          driver = new ChromeDriver();

        //dynamic waits
        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.youtube.com/");   // getting url
        driver.manage().window().maximize();

        clickOnLocators("//input[@name='search_query']");     // search bar
        driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("cats", Keys.ENTER);    // sendkeys into search bar

        List<WebElement> listOfElements = driver.findElements(By.cssSelector("ytd-video-renderer.style-scope.ytd-item-section-renderer"));
        listOfElements.get(2).click();    // most important - getting the 3rd locator from array of container

        List<WebElement> list2 = driver.findElements(By.cssSelector("ytd-compact-video-renderer.style-scope ytd-item-section-renderer"));
        list2.get(2).click();


        clickOnLocators("//button[@title='Theater mode (t)']");    // theatre button
        Thread.sleep(2000);
        clickOnLocators("//button[@title='Default view (t)']");     //  going back to default view
        Thread.sleep(2000);
        //clickOnLocators("//button[@title='Mute (m)']");
       // clickOnLocators("//button[@title='Full screen (f)']");   //full screen button

        clickOnLocators("//*[@id=\"more\"]/yt-formatted-string");   // show more button
        clickOnLocators("//*[@id=\"less\"]/yt-formatted-string");   // show less button

        JavascriptExecutor js = (JavascriptExecutor) driver;     // javascript for scroll action
        js.executeScript("window.scrollBy(0,750)");   // scrolling down

        Thread.sleep(3000);
        driver.quit();





        // locator for pop up 1 month trial - /html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/ytd-mealbar-promo-renderer
        //complex xpath
        //driver.findElement(By.xpath("//tp-yt-paper-button[@id='more']//yt-formatted-string[contains(text(),'Show more')]")).click();
        //driver.findElement(By.xpath("//tp-yt-paper-button[@id='less']//yt-formatted-string[contains(text(),'Show less')]")).click();

        // complicated locators for search bar
//        driver.findElement(By.xpath("//div[@id='search-input' and @class='ytd-searchbox-spt']")).click();
//        driver.findElement(By.xpath("//div[@id='search-input' and @class='ytd-searchbox-spt']//input[@id='search']")).sendKeys("Music",Keys.ENTER);
    }
}
