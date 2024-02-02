package com.everyDollarBudget.pages;

import com.everyDollarBudget.utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.awt.*;

public class ProfilePage extends BasePage {


    /**
     * Method goes to Profile module and signs out by clicking the Sign Out button.
     */
    public void logOut(){
        getNavigationMenu("Profile").click();
        Driver.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"" + "com.everydollar.android:id/SignOutButton" + "\"))"));
         //textContains(\"" + "Sign Out" + "\"))")
        if (getSignOutButton().isDisplayed()) {
            /*TouchAction touchAction = new TouchAction<>(Driver.getDriver());
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(getSignOutButton()))).perform();*/
            getSignOutButton().click();
        }
    }

    /**
     * Method returns sign out button.
     * @return
     */
    public MobileElement getSignOutButton() {
        return signOutButton;
    }

    public MobileElement getEmailLabel() {
        return emailLabel;
    }

    @AndroidFindBy(id = "com.everydollar.android:id/SignOutButton")
    private MobileElement signOutButton;

    @AndroidFindBy(id = "com.everydollar.android:id/EmailLabel")
    private MobileElement emailLabel;

}
