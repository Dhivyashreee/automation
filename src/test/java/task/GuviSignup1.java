package task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;


public class GuviSignup1 {

    WebDriver driver;
    WebElement element;
    @BeforeClass
public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://www.guvi.in/");
        driver.manage().window().maximize();
    }
@Test
        public void newSignUp() throws InterruptedException {
    driver.findElement(By.xpath("//a[@class = 'nav-link btn btn-primary text-white px-4']")).click();
    driver.findElement(By.xpath("//input[@id='name']")).sendKeys("testuser", ENTER);
    driver.findElement(By.id("email")).sendKeys("automationtestuser2024@gmail.com", ENTER);
    driver.findElement(By.cssSelector("input[class='form-control password-err']")).sendKeys("Testuser24",ENTER);
    driver.findElement(By.cssSelector("input[class='form-control countrycode-left']")).sendKeys("8608789381",ENTER);
    driver.findElement(By.id("signup-btn")).click();
    String t = driver.getTitle();
    System.out.println(t);
    Assert.assertEquals(t, "GUVI | Sign Up");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/sign-in/']")));
    driver.findElement(By.xpath("//a[@href='/sign-in/']")).click();
    driver.findElement(By.id("email")).sendKeys("automationtestuser2024@gmail.com", ENTER);
    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    driver.findElement(By.id("password")).sendKeys("Testuser24",ENTER);
    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
    wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-btn")));
    driver.findElement(By.id("login-btn")).click();
    Thread.sleep(2000);
    String value = driver.getCurrentUrl();
    System.out.println("Current url:" + value);
    Assert.assertEquals(value, "https://www.guvi.in/courses/");

    }

@AfterClass
    public void tearDown(){
     driver.quit();
}

}
