import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
public class AppShould {

	
	@Test
	public void Launch() throws IOException 
	{
		String sauceUserName = "YOUR_SAUCE_USERNAME";
	    String sauceAccessKey = "YOUR_SAUCE_ACCESS_KEY";

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS 6.0");
	    capabilities.setCapability("device", "iPhone Simulator");
	    capabilities.setCapability(CapabilityType.PLATFORM, "Mac 10.8");
		capabilities.setCapability("app", "/Users/TopGunSyllabusiPhone.app");
	    WebDriver driver = driver = new RemoteWebDriver(new URL(MessageFormat.format("http://{0}:{1}@ondemand.saucelabs.com:80/wd/hub", sauceUserName, sauceAccessKey)),
	            capabilities);
	    WebDriverWait wait = new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UIPhases")));
	    WebElement phasesLink = driver.findElement(By.id("UIPhases"));
	    boolean isEnabled = phasesLink.isEnabled();
	    assertEquals(isEnabled,true);
	    driver.quit();
	}
}
