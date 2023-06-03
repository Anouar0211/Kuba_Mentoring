package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Test1 {

    @Test

    public void enter_info(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        WebElement linkInput = driver.findElement(By.xpath("//a[.='Input Form Submit']"));
        linkInput.click();

        WebElement name = driver.findElement(By.cssSelector("#name"));
        name.sendKeys("Anouar");

        WebElement email = driver.findElement(By.cssSelector("#inputEmail4"));
        email.sendKeys("anouar@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("#inputPassword4"));
        password.sendKeys("1234");

        WebElement company = driver.findElement(By.cssSelector("#company"));
        company.sendKeys("java");

        WebElement web = driver.findElement(By.cssSelector("#websitename"));
        web.sendKeys("mamababa");

        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        country.sendKeys("United States");

        WebElement city = driver.findElement(By.cssSelector("#inputCity"));
        city.sendKeys("Chicago");

        WebElement address = driver.findElement(By.cssSelector("#inputAddress1"));
        address.sendKeys("4567 Camplell");

        WebElement adress2 = driver.findElement(By.cssSelector("#inputAddress2"));
        adress2.sendKeys("2234");

        WebElement state = driver.findElement(By.cssSelector("#inputState"));
        state.sendKeys("IL");

        WebElement zip = driver.findElement(By.cssSelector("#inputZip"));
        zip.sendKeys("60650");

        WebElement submit = driver.findElement(By.xpath("//button[.='Submit']"));
        submit.click();

        WebElement succes = driver.findElement(By.xpath("//p[@class='success-msg hidden']"));

        String actualMessage = succes.getText().trim();
        String expectedMessage = "Thanks for contacting us, we will get back to you shortly.";
        Assert.assertEquals(actualMessage,expectedMessage);



    }

}
