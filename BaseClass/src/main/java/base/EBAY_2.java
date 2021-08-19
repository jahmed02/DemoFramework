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

        // array for href element
       List<WebElement> href = driver.findElements(By.xpath("//*[contains(@href,'UserReviews')]"));
        List<String> b = new ArrayList<>();
        for(int i=0; i<href.size(); i++){

            // getting texts for each element into an array
            b.add(href.get(i).getAttribute("href"));

            //printing texts
            System.out.println(b.get(i));
        }
        // till this point we're good



        //String c = driver.findElements(By.xpath("//*[contains(@href,'UserReviews')]")).getAttribute("href");

//        Iterator<WebElement> itr = href.iterator();
//        while(itr.hasNext()) {
//            System.out.println(itr.next());


//        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
//
//        //Traversing through the list and printing its text along with link address
//        for(WebElement link:allLinks){
//            System.out.println(link.getText() + " - " + link.getAttribute("href"));
//        }



      // System.out.println(href);


//       List<String> b = new ArrayList<>();
//       for(String c: b){
//           System.out.println(c.);
//       }

//        List<String> b = new ArrayList<String>();


        // ptinting href
        // //*[contains(text(),'product rating')]
        //  //tagname[starts-with(@attributename,'part_of_value')]
        //  //tagname[contains(@attributename,'part_of_value')]

//            String j = driver.findElement(By.xpath("//*[contains(@href,'UserReviews')]")).getAttribute("href");
//            System.out.println(j);

//        String a;
//        String c;
//
//        for(int i = 0; i< href.size(); i++) {
//            //String a = allList.get(0).getText();
//             a = href.get(i).getText();
//             c= b.get(i);
//            a = a.replaceAll("\\s.*", "");
//            c = b.remove()
//            Integer.parseInt(a);
//            //Integer a = Collections.max();
//            System.out.println(a);
//        }




//        HashMap<String, List<WebElement>>  list = new HashMap<String, List<WebElement>>();
//        list.put("a",new ArrayList<WebElement>());
//        for(int i=0; i< list.size();i++) {
//            list.get("a").add()
//        }


        Thread.sleep(2000);
        driver.quit();

    }
}
