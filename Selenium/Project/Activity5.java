package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {

    @Test
    public void edit_user_information(){
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
        Actions a = new Actions(driver);
        WebElement myInfo = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']/b"));
        a.moveToElement(myInfo).build().perform();
        myInfo.click();
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
        firstName.clear();
        firstName.sendKeys("supriya");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
        lastName.clear();
        lastName.sendKeys("sirigineedi");
        driver.findElement(By.xpath("//input[@id='personal_optGender_2']")).click();
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
        Select options = new Select(dropdown);
        options.selectByVisibleText("Indian");
        WebElement Dob = driver.findElement(By.xpath("//input[@id='personal_DOB']"));
        Dob.clear();
        Dob.sendKeys("1998-08-11");
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        driver.close();
    }


}
