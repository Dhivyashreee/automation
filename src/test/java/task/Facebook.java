package task;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class Facebook {

    WebDriver driver;
    @Test

    public void Createnewacc() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        String value = driver.getCurrentUrl();
        Assert.assertEquals(value, "https://www.facebook.com/");
        driver.findElement(By.xpath("//a[starts-with(@id,'u_0_0_')]")).click();

        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("test", ENTER);
        driver.findElement(By.name("lastname")).sendKeys("user", ENTER);
        driver.findElement(By.name("reg_email__")).sendKeys("automationtestuser2024@gmail.com", ENTER);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("automationtestuser2024@gmail.com", ENTER);
        driver.findElement(By.name("reg_passwd__")).sendKeys("Guvi@2023", ENTER);
        Thread.sleep(1000);
       //driver.findElement(By.id("birthday_age")).sendKeys("32", ENTER);
        driver.findElement(By.xpath("//a[starts-with(@id,'age_to_birthday_link')]")).click();
        Select Days =new Select(driver.findElement(By.name("birthday_day")));
        Days.selectByValue("11");
        Thread.sleep(1000);
        Select Month =new Select(driver.findElement(By.id("month")));
        Month.selectByValue("5");
        Thread.sleep(1000);
        Select Year =new Select(driver.findElement(By.id("year")));
        Year.selectByValue("1985");
        Thread.sleep(1000);
        //WebElement radio1 = driver.findElement(By.xpath("//input[starts-with(@id,'u_2_4_']"));
        //radio1.click();
        //driver.findElement(By.xpath("//button[starts-with(@id,'u_2_s_')]")).click();



    }
}
