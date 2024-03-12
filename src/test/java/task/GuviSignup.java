package task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.openqa.selenium.Keys.ENTER;



public class GuviSignup {

    WebDriver driver;
@Test
    public void SignUp() throws InterruptedException {

    driver = new ChromeDriver();
    driver.get("https://www.guvi.in/register");
    driver.manage().window().maximize();
    driver.findElement(By.xpath("//input[@id='name']")).sendKeys("testuser", ENTER);
    driver.findElement(By.id("email")).sendKeys("automationtestuser2024@gmail.com", ENTER);
    driver.findElement(By.cssSelector("input[class='form-control password-err']")).sendKeys("Testuser24",ENTER);
    driver.findElement(By.cssSelector("input[class='form-control countrycode-left']")).sendKeys("8608789381",ENTER);
    driver.findElement(By.id("signup-btn")).click();


}
}
