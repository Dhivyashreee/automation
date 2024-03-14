import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

public class WebDriverExample {


        public static void main(String args[]) {



//Setting system properties of ChromeDriver
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\IdeaProjects\\guvi\\chromedriver-win64\\chromedriver.exe");

            WebDriver driver;

//Creating an object of ChromeDriver
            driver = new ChromeDriver();

//launching the specified URL
            driver.navigate().to("http://www.google.com/");

            // Click on the search text box and send value
            driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Automation testing tools", ENTER);
            driver.quit();

        }
    }


