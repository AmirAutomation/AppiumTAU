import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Android_Calculator {

    AppiumDriver driver;

    @Before
    public void setUpO() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "Uiautomator2");
        caps.setCapability("appium:platformVersion", "13.0");
        caps.setCapability("appium:deviceName", "Automation");
        caps.setCapability("appium:appium.appPackage", "com.android.calculator2");
        caps.setCapability("appium:appium.appActivity", ".Calculator");

        //com.google.android.calculator

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void sumaCalculator(){

        System.out.println("Test");
        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();

        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();

        driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();

        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

        Assert.assertEquals(result,"16");

    }

    @After
    public void down(){
        if (driver!=null){
            driver.quit();
        }
    }
}
