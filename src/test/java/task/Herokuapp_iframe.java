package task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Herokuapp_iframe {

    WebDriver driver;
    @Test
    public void addText() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        String value = driver.getCurrentUrl();
        Assert.assertEquals(value, "https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");
        WebElement element = driver.findElement(By.tagName("p"));
        element.clear();
        element.sendKeys("Hello people");
        driver.close();

    }
}
