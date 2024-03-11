package task;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Snapdeal {

    WebDriver driver;
    WebElement element;


    @Test
    public void ChromeDriver() throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.snapdeal.com/");
        String value = driver.getCurrentUrl();
        System.out.println("Current url:" + value);
        Assert.assertEquals(value, "https://www.snapdeal.com/");
        element = driver.findElement(By.xpath("//div[@class='accountInner']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        driver.findElement(By.linkText("LOGIN")).click();
        Thread.sleep(2000);
        driver.switchTo().frame("loginIframe");
        driver.findElement(By.id("userName")).sendKeys("dhivyashree10.91@gmail.com", Keys.ENTER);
        driver.switchTo().defaultContent();


    }
}
