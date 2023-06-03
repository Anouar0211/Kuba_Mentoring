package mentoring3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class AlertPractice {
    @Test

    public void Practice() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");
        WebElement JSlink = driver.findElement(By.linkText("Javascript Alerts"));
        JSlink.click();
        WebElement JSAlertButton = driver.findElement(By.xpath("//button[@class='btn btn-dark my-30 mx-10 hover:bg-lambda-900 hover:border-lambda-900']"));
        JSAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement confirmBox = driver.findElement(By.xpath("//p[contains(text(),'Confirm box:')]//button"));
        confirmBox.click();
        alert.dismiss();
        WebElement message = driver.findElement(By.cssSelector("#confirm-demo"));
        String actualMsg = message.getText().trim();
        String expectedMsg = "You pressed Cancel!";
        Assert.assertEquals(actualMsg,expectedMsg);
        WebElement promBoxButton = driver.findElement(By.xpath("//p[contains(text(),'Prompt box:')]//button"));
        promBoxButton.click();
        alert.sendKeys("anouar");
        alert.accept();
        WebElement lastMsg= driver.findElement(By.cssSelector("#prompt-demo"));
        String actual = lastMsg.getText().trim();
        String expected = "You have entered 'anouar' !";
        Assert.assertEquals(actual,expected);
        driver.navigate().back();

        WebElement sliderLink = driver.findElement(By.linkText("Drag & Drop Sliders"));
        sliderLink.click();
        List<WebElement> allSliders = driver.findElements(By.xpath("//input[@type='range']"));
        List<WebElement> outputs = driver.findElements(By.tagName("output"));
        Actions actions = new Actions(driver);

        for (int i = 0; i < allSliders.size(); i++) {

           while (!outputs.get(i).getText().equals("100")){
               if (outputs.get(i).getText().equals("100")){
                   break;
               }else
                   allSliders.get(i).sendKeys(Keys.ARROW_RIGHT);

        }



        }


    }
}