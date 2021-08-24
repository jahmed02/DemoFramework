package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.nio.channels.WritableByteChannel;
import java.security.Key;
import java.sql.Array;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Ebay {

    public static WebDriver driver = null;


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jisan\\IdeaProjects\\DemoProject\\BaseClass\\drives\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        type("input#gh-ac", "iPhone 8");

        // getting the container array
//        List<WebElement>  list= driver.findElements(By.xpath("//*[@id='srp-river-results']/ul/li"));
//        //getting only one element text
//        String a = list.get(2).getText();   // selecting an array element from search result
//        System.out.println(a);    // printing the info


        //getting all the review element text into a array
        //getting list into a ArrayList
        // span[class='s-item__reviews-count'] - only rating num
        //div[class='s-item__reviews']  - locator with star and rating
        //  //*[@id="srp-river-results"]/ul/li[1]/div/div[2]/div[3]/a

//        List<WebElement> allList = driver.findElements(By.cssSelector("span[class='s-item__reviews-count']"));
//        List<String> allText = new ArrayList<String>();
//         for(int i=0; i<allList.size(); i++){
//
//             // getting texts for each element into an array
//             allText.add(allList.get(i).getText());
//
//             //printing texts
//             System.out.println(allText.get(i));
//         }
        //till this the code is fine, prints all the review

        List<WebElement> allList = driver.findElements(By.cssSelector("span[class='s-item__reviews-count']"));

        //Mozart sorting loop
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


        // anayeth loop code
//        String a;
//        for(int i = 0; i< allText.size(); i++) {
//            //String a = allList.get(0).getText();
//             a = allText.get(i);
//            a = a.replaceAll("\\s.*", "");
//            Integer.parseInt(a);
//            //Integer a = Collections.max();
//            System.out.println(a);
//        }


        // trying to sort all the reviews
        //Collections.sort(allText);
        //Collections.sort(a, Collections.reverseOrder());


//        Iterator itr = lt.listIterator();
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }

//        clickLocator("//*[@id=\"srp-river-results\"]/ul/li[28]/div/div[2]/a/h3");  // rating 324
//        //clickLocator("button[aria-label='Show more product details']");
//
//         WebElement b = driver.findElement(By.xpath(""));
//         System.out.println(b.getText());




//        int [] b = new int[allList.size()];
//
//        Arrays.toString(b);
//        //Arrays.sort(b);
//
//        for(int num: b){
//            System.out.println(num);
//        }




        //driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/h3")).click();

//        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"viTabs_0_is\"]/div/table[2]/tbody/tr[4]/td[3]"));
//        for(WebElement element: list){
//            System.out.println(element.getText());
//        }

//        JavascriptExecutor js = (JavascriptExecutor) driver;     // javascript for scroll action
//        js.executeScript("window.scrollBy(0,750)");   // scrolling down

        Thread.sleep(3000);
        driver.quit();
}

    public static void clickLocator(String locator) {

        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex1) {
            driver.findElement(By.xpath(locator)).click();
        }
    }
    public static void type(String locator, String value) {

        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        }catch (Exception ex2) {
            driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
        }
    }
}
