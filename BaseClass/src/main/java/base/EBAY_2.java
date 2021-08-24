package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EBAY_2 {

    public static WebDriver driver = null;
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\jisan\\IdeaProjects\\DemoProject\\BaseClass\\drives\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("input#gh-ac")).sendKeys("iphone 8", Keys.ENTER);


        // important collection code block
        // to store list of webelements into an array and printing text and attributes

        // array for href element
        List<WebElement> href = driver.findElements(By.xpath("//*[contains(@href,'UserReviews')]"));
        List<String> b = new ArrayList<>();
        for(int i=0; i<href.size(); i++){

            // getting texts for each element into an array
            b.add(href.get(i).getAttribute("href"));

            //printing texts
            System.out.println(b.get(i));
        }


         // product rating numbers locator
        //  span[class='s-item__reviews-count']
        //   //*[contains(text(),'product rating')]
        List<WebElement> allList = driver.findElements(By.xpath("//span[contains(text(),'product ratings')]"));

        List number = new ArrayList();
        String a;
        for (int i = 0; i < allList.size(); i++) {
            //String a = list.get(0).getText();
            a = allList.get(i).getText();
            a = a.replaceAll("\\s.*", "");
            Integer.parseInt(a);
            //Integer a = Collections.max();
            for (int j = 0; j < a.length(); j++) {
                number.add(a);
            }
        }
        for (int i = 0; i < number.size(); i++) {
            System.out.println(number.get(i));
        }
        // till this point we're good
        // printing href links and product rating numbers




        //Traversing through the list and printing its text along with link address
//        for(WebElement link:href){
//            //System.out.println(link.getText() + " - " + link.getAttribute("href"));
//            System.out.println(link.getAttribute("href"));
//        }

        //String c = driver.findElements(By.xpath("//*[contains(@href,'UserReviews')]")).getAttribute("href");

//        Iterator<WebElement> itr = href.iterator();
//        while(itr.hasNext()) {
//            System.out.println(itr.next());


      // System.out.println(href);

        // ptinting href
        // //*[contains(text(),'product rating')]
        //  //tagname[starts-with(@attributename,'part_of_value')]
        //  //tagname[contains(@attributename,'part_of_value')]

//            String j = driver.findElement(By.xpath("//*[contains(@href,'UserReviews')]")).getAttribute("href");
//            System.out.println(j);


        Thread.sleep(2000);
        driver.quit();

    }
}
