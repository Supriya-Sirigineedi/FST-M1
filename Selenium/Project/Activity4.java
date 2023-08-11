package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity4 {

   @Test
    public void add_A_New_Employee(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        WebElement login  = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        login.click();
        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b")).click();
        driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
        driver.findElement(By.id("firstName")).sendKeys("supriya");
        driver.findElement(By.id("lastName")).sendKeys("Sirigineedi");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("supriya");
        driver.findElement(By.id("searchBtn")).click();
        String name = driver.findElement(By.xpath("//tr/td[3]")).getText();
        Assert.assertEquals(name,"supriya");
        driver.close();

    }

}
