import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class set2TCskhanAcadamy {
	@Test
	public void TC2() {
		System.out.println("Executing TC2");
	}
	@BeforeTest
	public void beforeTest() throws InterruptedException, IOException {


		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName","Priyanka");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.NO_RESET, true);
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		File file= new File("C:\\Users\\PriyankaGangakhed\\Desktop\\TestDataforKhanAcadamy.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rc= sheet.getLastRowNum();
		System.out.println("total number of rows having data= "+rc);

		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();

		for(int i=1;i<=rc;i++) {


			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign up with email\")")).click();   
			Thread.sleep(3000);
			String firstname=sheet.getRow(i).getCell(0).getStringCellValue();
			String lastname=sheet.getRow(i).getCell(1).getStringCellValue();
			String birthday=sheet.getRow(i).getCell(2).getStringCellValue();
			String email=sheet.getRow(i).getCell(3).getStringCellValue();
			String password=sheet.getRow(i).getCell(4).getStringCellValue();

			System.out.println("firstname= "+firstname);
			System.out.println("lastname= "+lastname);
			System.out.println("birthday= "+birthday);
			System.out.println("email= "+email);
			System.out.println("password= "+password);

			// driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();      

			driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys(firstname);
			//driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys(lastname);
			Thread.sleep(2000);
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Last name\")")).sendKeys(lastname);

			driver.hideKeyboard();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Birthday\")")).click();
			Thread.sleep(2000);                      

			//driver.findElement(By.text("org.khanacademy.android:text/Jun")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Jun\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jun\"));"));
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Jun\")")).click();

			// driver.findElement(By.id("org.khanacademy.android:text/01")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"01\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"01\"));"));
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"01\")")).click();

			//driver.findElement(By.id("org.khanacademy.android:text/2000")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"2000\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"2000\"));"));
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"2000\")")).click();

			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"OK\")")).click();       


			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Email address\")")).sendKeys(email);   
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Password\")")).sendKeys(password);           

			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"CREATE\")")).click();

			
			try {
				String actualMsg =  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().textContains(\"Invalid password\")")).getText();
				System.out.println("ExpMsg"+actualMsg);


			}
			catch(NoSuchElementException e) {
				String actualMsg=driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().textContains(\"Sorry, we saw an unexpected error! Please try again later.\")")).getText();
				System.out.println("Error on the screen "+actualMsg);

			}


			driver.pressKey(new KeyEvent(AndroidKey.BACK));



		}
	}

	@AfterTest
	public void afterTest() {


	}

}
