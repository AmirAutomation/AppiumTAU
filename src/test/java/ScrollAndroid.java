import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ScrollAndroid {

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

    private void ScrollDown(){

        Dimension dimension= driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight()*0.8);
        int scrollEnd = (int) (dimension.getHeight()*0.1);

        action = new AndroidTouchAction(driver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0,scrollEnd))
                .release()
                .perform();
    }

    @Test
    public void scrollTest(){
        System.out.println("Test");

        AndroidElement views = (AndroidElement) driver.findElementByAccessibilityId("Views");

        //tap
        action = new AndroidTouchAction(driver);
        action.tap(ElementOption.element(views)).perform();
        //action.tap(ElementOption.element(views)).perform();

        //Scroll
        ScrollDown();
        AndroidElement lists = (AndroidElement) driver.findElementByAccessibilityId("Lists");
        action.tap(ElementOption.element(lists)).perform();

    }



    @After
    public void down(){
        if (driver!=null){
            driver.quit();
        }
    }
}
