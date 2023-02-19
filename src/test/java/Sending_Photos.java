import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Sending_Photos {
    AndroidDriver driver;

    @Before
    public void setUpO() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "Uiautomator2");
        caps.setCapability("appium:platformVersion", "13.0");
        caps.setCapability("appium:deviceName", "Automation");
        caps.setCapability("appium:appPackage", "com.google.android.apps.photos");
        caps.setCapability("appium:appActivity", ".home.HomeActivity");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void sendSMS() {

        System.out.println("Test");

    }

    @After
    public void down(){
        if (driver!=null){
            driver.quit();
        }
    }
}
