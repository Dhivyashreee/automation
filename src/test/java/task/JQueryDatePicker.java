package task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;

public class JQueryDatePicker {
    WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void jQDatePicker() {
        WebElement iframe_element = driver.findElement(By.xpath("//iframe[@class = 'demo-frame']"));
        driver.switchTo().frame(iframe_element);
        WebElement datebox = driver.findElement(By.id("datepicker"));
        datebox.click();

        WebElement next_button = driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
        next_button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement date = driver.findElement(By.xpath("//a[@data-date = '22']"));
        date.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));

        String string = datebox.getText();
        System.out.println(string);

            driver.quit();


    }
}
