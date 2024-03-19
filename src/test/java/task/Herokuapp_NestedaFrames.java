package task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class Herokuapp_NestedaFrames {

    WebDriver driver;

    @Test

    public void switchNestedFrame() {

        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println(title);

        WebElement element = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(element);

        List<WebElement> topframes = driver.findElements(By.tagName("frame"));
        System.out.println("Number of frames in top frame:"+ topframes.size());
        Assert.assertEquals(topframes.size(),3);
        driver.switchTo().frame("frame-left");
        WebElement element1 = driver.findElement(By.tagName("body"));
        System.out.println(element1.getText());
        Assert.assertEquals(element1.getText(),"LEFT");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement element2 = driver.findElement(By.xpath("//div[@id='content']"));
        System.out.println(element2.getText());
        Assert.assertEquals(element2.getText(),"MIDDLE");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement element3 = driver.findElement(By.tagName("body"));
        System.out.println(element3.getText());
        Assert.assertEquals(element3.getText(),"RIGHT");
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement element4 = driver.findElement(By.tagName("body"));
        System.out.println(element4.getText());
        Assert.assertEquals(element4.getText(),"BOTTOM");
        driver.switchTo().parentFrame();

    }
}
