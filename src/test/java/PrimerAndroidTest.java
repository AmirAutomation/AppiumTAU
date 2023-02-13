import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;


public class    PrimerAndroidTest {

   AppiumDriver driver;

    @Before
    public void setUpO() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "Uiautomator2");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Automation");
        caps.setCapability("app","C:\\Appium\\PrimerProyectoDemo\\apps\\ApiDemos.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void click_App(){

        System.out.println("Test**********************************");
        driver.findElement(AppiumBy.accessibilityId("App")).click();

    }

    @After
    public void down(){
        if (driver!=null){
            driver.quit();
        }
    }

}
