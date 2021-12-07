package com.splhead.conversor;

import com.splhead.conversor.util.DriverFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ConversorTest {

    private AndroidDriver<MobileElement> driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @Test
    public void testConversionTwoBRLToDollars() {
        MobileElement etReal = (MobileElement) driver.findElementById("com.splhead.conversor:id/etReal");
        etReal.sendKeys("2");
        MobileElement bConvert = (MobileElement) driver.findElementById("com.splhead.conversor:id/bConvert");
        bConvert.click();
        MobileElement tvDollar = (MobileElement) driver.findElementById("com.splhead.conversor:id/tvDollar");
        Assert.assertEquals("0.37", tvDollar.getText());
    }

    @After
    public void tearDown() {
        DriverFactory.destroyDriver();
    }
}
