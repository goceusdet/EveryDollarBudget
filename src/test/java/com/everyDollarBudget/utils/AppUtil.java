package com.everyDollarBudget.utils;

import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppUtil {

    /**
     *  checks that an element is present on the DOM of a page. This does not
     *    * necessarily mean that the element is visible.
     * @param element
     * @param time
     */
    public static void waitForPresenceOfElement(MobileElement element, long time) {
        new WebDriverWait(Driver.getDriver(), time).until(ExpectedConditions.visibilityOf(element));
    }


}
