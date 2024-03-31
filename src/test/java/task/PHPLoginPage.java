package task;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;

public class PHPLoginPage {

    WebDriver driver;
    WebElement number1, number2, element;
    @Test
    public void LoginForm() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://www.phptravels.com/demo");
        driver.manage().window().maximize();
        //String value = driver.getCurrentUrl();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("test", ENTER);
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("user", ENTER);
        driver.findElement(By.xpath("//input[@name='business_name']")).sendKeys("Food Business", ENTER);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("automationtestuser2024@gmail.com", ENTER);
        Thread.sleep(2000);
        number1 = driver.findElement(By.id("numb1"));
        number2 = driver.findElement(By.id("numb2"));
        String s = number1.getText();
        String s1 = number2.getText();
        int a = Integer.parseInt(s);
        int b = Integer.parseInt(s1);
        int sum = a + b;
        //System.out.println(sum);
        //String s3 = String.valueOf(sum);
        driver.findElement(By.xpath("//input[@id='number']")).sendKeys(String.valueOf(sum), ENTER);
        //Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id = 'demo']")));

        element = driver.findElement(By.xpath("//button[@id = 'demo']"));
        element.click();
        //Thread.sleep(2000);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='completed']")));
        TakesScreenshot screenshot = (TakesScreenshot) driver;
            try

            {
                File source = screenshot.getScreenshotAs(OutputType.FILE);
                FileHandler.copy(source, new File("D:\\screenshot\\phpscreen.png"));
            }
            catch (IOException exception)
            {
exception.printStackTrace();
            }

    }

}
