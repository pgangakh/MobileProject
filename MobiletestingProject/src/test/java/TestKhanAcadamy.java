import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class TestKhanAcadamy {
	 			
  @Test
  public void TC1() {
	  System.out.println("Running test TC1");
		  	  
  }

@BeforeTest
  public void beforeTest() throws MalformedURLException, InterruptedException {
	
	DesiredCapabilities capability = new DesiredCapabilities();
	capability.setCapability("deviceName","Priyanka");
	capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	capability.setCapability(MobileCapabilityType.NO_RESET, true);
	capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
	capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
	AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	driver.findElementByAccessibilityId("Search tab").click();
    Thread.sleep(5000);
    driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Partner content\")")).click();
    driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Breakthrough Junior Challenge\")")).click();
  }

  @AfterTest
  public void afterTest() {
  }

}
