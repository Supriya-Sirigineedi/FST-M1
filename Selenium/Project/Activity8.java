package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
    @Test
    public void applying_for_a_leave() {
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
        driver.findElement(By.xpath("//div[@class='quickLaunge']/a[contains(@href,'applyLeave')]")).click();
        WebElement options = driver.findElement(By.id("applyleave_txtLeaveType"));
        Select leaveType = new Select(options);
        leaveType.selectByVisibleText("DayOff");
        WebElement fromDate = driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']"));
        fromDate.clear();
        fromDate.sendKeys("2023-08-08");
        WebElement toDate =driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']"));
        toDate.clear();
        toDate.sendKeys("2023-08-11");
        driver.findElement(By.xpath("//input[@id='applyBtn']")).click();
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//*[@id='menu_leave_viewLeaveModule']"))).build().perform();
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        String status = driver.findElement(By.xpath("//a[contains(text(),'Pending')]")).getText();
        System.out.println(status);
        driver.close();
    }
}
