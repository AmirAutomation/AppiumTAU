import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ClipBoard {

    AndroidDriver<WebElement> driver;
    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "Uiautomator2");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Automation");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/selendroid.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }
    @Test
    public void sendSMS() throws InterruptedException {

        System.out.println("Test");

        Thread.sleep(5000);

        String text = "Hello TAU";
        driver.setClipboardText(text);

        MobileElement nameTxt = (MobileElement) driver.findElementByAccessibilityId("my_text_fieldCD");

        nameTxt.clear();
        nameTxt.sendKeys(driver.getClipboardText());

        Assert.assertEquals(text, nameTxt.getText());
    }

    @After
    public void down(){
        if (driver!=null){
            driver.quit();
        }
    }
}
