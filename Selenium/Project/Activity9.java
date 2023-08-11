package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 {
    @Test
    public void retrieve_emergency_contacts(){
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
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.xpath("//a[contains(@href,'EmergencyContacts')]")).click();
        List<WebElement> contacts = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for(int i=0; i< contacts.size();i++){
            System.out.println(contacts.get(i).getText());
        }
        driver.close();
    }
}
