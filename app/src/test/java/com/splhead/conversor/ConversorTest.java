package com.splhead.conversor;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ConversorTest {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "0027461287");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:appPackage", "com.splhead.conversor");
        desiredCapabilities.setCapability("appium:appActivity", "com.splhead.conversor.MainActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 0);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void testConvertionTwoReaisToDollars() {
        MobileElement etReal = (MobileElement) driver.findElementById("com.splhead.conversor:id/etReal");
        etReal.sendKeys("2");
        MobileElement bConvert = (MobileElement) driver.findElementById("com.splhead.conversor:id/bConvert");
        bConvert.click();
        MobileElement tvDollar = (MobileElement) driver.findElementById("com.splhead.conversor:id/tvDollar");
        Assert.assertEquals("0.37", tvDollar.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
