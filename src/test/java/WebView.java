import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class WebView {

    public static By chromeBtn = MobileBy.AccessibilityId("buttonStartWebviewCD");
    public static By gotoHomeBtn = By.id("io.selendroid.testapp:id/goBack");

    AppiumDriver driver;
    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "Uiautomator2");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Automation");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/selendroid.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    public void switchToWebView() {

        Set<String> contexts = driver.getContextHandles();
        for(String context: contexts){

            if(context.contains("WebView")){
                driver.context(context);
                break;
            }
        }
    }
    @Test
    public void sendSMS() throws InterruptedException {

        System.out.println("Test");
        Thread.sleep(4000);

        //Espera del drive
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Espera que se localice el elemento y le da click
        wait.until(ExpectedConditions.presenceOfElementLocated(chromeBtn)).click();

        //Cambia de contexto a WebView
        switchToWebView();

        WebElement nameInput = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[4]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.EditText"));
        nameInput.clear();

        nameInput.sendKeys("Amir alexander");

        driver.context("NATIVE_APP");
        driver.findElement(gotoHomeBtn).click();

    }

    @After
    public void down(){
        if (driver!=null){
            driver.quit();
        }
    }
}
