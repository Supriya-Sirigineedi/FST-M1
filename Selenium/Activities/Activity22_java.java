package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity22 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/popups");
        System.out.println("Home page title: "+driver.getTitle());
        WebElement button = driver.findElement(By.xpath("//button[@onclick='openModal()']"));
        Actions action = new Actions(driver);
        action.moveToElement(button).build().perform();
        String tooltip = button.getAttribute("data-tooltip");
        System.out.println(tooltip);
        button.click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String msg = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: "+msg);
        driver.close();
    }
}
