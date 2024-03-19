package task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Herokuapp_windows {
    WebDriver driver;
    @Test

    public void switchWindow(){

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        // Get the handle of the current window
        String currentWindowHandle = driver.getWindowHandle();

// Get the handles of all open windows
        Set<String> windowHandles = driver.getWindowHandles();

// Remove the handle of the current window from the set of handles
        windowHandles.remove(currentWindowHandle);

// Switch to the new window
        driver.switchTo().window(windowHandles.iterator().next());

        WebElement element = driver.findElement(By.tagName("h3"));
        String newwindowtext = element.getText();
        System.out.println(newwindowtext);
        Assert.assertEquals(newwindowtext,"New Window");
        driver.close();

        driver.switchTo().window(currentWindowHandle);
        String value = driver.getCurrentUrl();
        Assert.assertEquals(value, "https://the-internet.herokuapp.com/windows");

    }
}
