import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Swipe {
    AppiumDriver driver;
    AndroidTouchAction action;

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "Uiautomator2");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Automation");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/ApiDemos.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void scrollTest(){
        System.out.println("Test");
        AndroidElement views = (AndroidElement) driver.findElementByAccessibilityId("Views");

        action = new AndroidTouchAction(driver);
        action.tap(ElementOption.element(views)).perform();

        AndroidElement gallery = (AndroidElement) driver.findElementByAccessibilityId("Gallery");
        action.tap(ElementOption.element(gallery)).perform();

        AndroidElement photo = (AndroidElement) driver.findElementByAccessibilityId("1. Photos");
        action.tap(ElementOption.element(photo)).perform();

        AndroidElement pinture1 = (AndroidElement) driver.findElements(By.className("android.widget.ImageView")).get(0);
        action.press(ElementOption.element(pinture1))
                .waitAction().moveTo(PointOption.point(-1000, 810))
                .release()
                .perform();


    }

    @After
    public void down(){
        if (driver!=null){
            driver.quit();
        }
    }
}
