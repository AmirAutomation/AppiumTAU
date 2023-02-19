import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SendSMS {

    AndroidDriver driver;

    @Before
    public void setUpO() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "Uiautomator2");
        caps.setCapability("appium:platformVersion", "13.0");
        caps.setCapability("appium:deviceName", "Automation");
        caps.setCapability("appium:appium.appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appium:appium.appActivity", ".ui.ConversationListActivity");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void sendSMS() {

        System.out.println("Test");

        driver.sendSMS("3106278581","Hello from TAU");

    }

    @After
    public void down(){
        if (driver!=null){
            driver.quit();
        }
    }
}
