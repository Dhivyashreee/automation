package task;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JQuery {
    WebDriver driver;

    @Test

    public void DragandDrop() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        String value = driver.getCurrentUrl();
        Assert.assertEquals(value, "https://jqueryui.com/droppable/");

       WebElement source = driver.findElement(By.xpath("//div[starts-with@id,'draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[starts-with@id='droppable']"));
       Actions actions = new Actions(driver);
       actions.dragAndDrop(source, target).build().perform();



    }
}
