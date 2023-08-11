package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
    @Test
    public void adding_qualifications()

    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        WebElement login = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        login.click();
        driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']/b")).click();
        driver.findElement(By.xpath("//ul[@id='sidenav']/li/a[text()='Qualifications']")).click();
        driver.findElement(By.xpath("//input[@id='addWorkExperience']")).click();
        driver.findElement(By.xpath("//input[@id='experience_employer']")).sendKeys("IBM");
        driver.findElement(By.xpath("//input[@id='experience_jobtitle']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@id='btnWorkExpSave']")).click();
        driver.close();

    }
}
