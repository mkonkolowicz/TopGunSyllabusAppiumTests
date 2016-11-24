import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;

public class SauceLabsAppShould {

	public static final String USERNAME = "mkonkolowiczsauce";
	  public static final String ACCESS_KEY = "50956cd7-36da-4937-bb93-697a107f11c9";
	  public static final String mySauceURL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	  
	  @Test 
	  public void Launch() throws Exception {
	 
		  DesiredCapabilities caps = DesiredCapabilities.iphone();
		  caps.setCapability("appiumVersion", "1.6.0");
		  caps.setCapability("deviceName","iPhone 7 Simulator");
		  caps.setCapability("deviceOrientation", "portrait");
		  caps.setCapability("platformVersion","10.0");
		  caps.setCapability("platformName", "iOS");
		  caps.setCapability("browserName", "");
		  caps.setCapability("app","sauce-storage:TopGunSyllabusiPhone.zip");

	 
	  	WebDriver driver = new IOSDriver<WebElement>(new URL(mySauceURL),caps);
	    WebDriverWait wait = new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UIPhases")));
	    WebElement phasesLink = driver.findElement(By.id("UIPhases"));
	    boolean isEnabled = phasesLink.isEnabled();
	    assertEquals(isEnabled,true);	  
	    driver.quit();
	  }

}
