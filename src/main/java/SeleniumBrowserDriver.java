import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

public class SeleniumBrowserDriver {

    public static void main(String args[]) {

        WebDriver driver = new ChromeDriver();
        
        driver.get("http://www.google.com/");

        // Click on the search text box and send value
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Selenium browser driver", ENTER);
        driver.quit();

    }
}
