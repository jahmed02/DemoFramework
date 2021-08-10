package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoClass {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\jisan\\IdeaProjects\\DemoProject\\BaseClass\\drives\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(9,TimeUnit.SECONDS);

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        //driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys("Chetan", Keys.ENTER);

        driver.findElement(By.cssSelector(".gLFyf.gsfi")).click();
        Thread.sleep(3000);

        driver.quit();

        //driver.findElement(By.xpath("//img[@alt='Google']"));

    }
}
