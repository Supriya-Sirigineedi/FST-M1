package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity6 {

    @Test
    public void verify_that_the_Directory_menu_item_is_visible_and_clickable(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        WebElement login  = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        login.click();
        List<WebElement> menu = driver.findElements(By.xpath("//div[@class='menu']/ul/li"));
        for(WebElement menuItem : menu){
            if(menuItem.getText().equals("Directory")){
                Assert.assertTrue(menuItem.isDisplayed() && menuItem.isEnabled());
                menuItem.click();
            }
        }
        String heading = driver.findElement(By.xpath("//div[@class='head']/h1")).getText();
        Assert.assertEquals(heading,"Search Directory");
        driver.close();
    }
}
