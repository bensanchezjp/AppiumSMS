package jp.bensanchez.appium.sms;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

//Test Case: Automatically send an SMS message to  8675309 with message "Hi Jenny!"
public class SendingSMS {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		//sets desired capabilities for Android Virtual Device
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, 8.1);
		
		dc.setCapability("appPackage", "com.google.android.apps.messaging");
		dc.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		
		//Sets Appium's url address
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,dc);
		Thread.sleep(5000);
		
		//identifies elements in Android Virtual Device and performs actions
		driver.findElementById("com.google.android.apps.messaging:id/start_new_conversation_button").click();
		driver.findElementById("com.google.android.apps.messaging:id/recipient_text_view").sendKeys("8675309");
		driver.findElementById("com.google.android.apps.messaging:id/contact_picker_create_group").click();
		driver.findElementById("com.google.android.apps.messaging:id/compose_message_text").sendKeys("Hi Jenny!");
		driver.findElementById("com.google.android.apps.messaging:id/send_message_button_icon").click();
		Thread.sleep(5000);
		
		driver.quit();
	}
}
