package com.everyDollarBudget.pages;

import com.everyDollarBudget.utils.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    /**
     * Method takes a navigation menu name as a parameter, and returns a navigation menu option as a MobileElement.
     *
     * @param navigationMenuName
     * @return
     */
    public MobileElement getNavigationMenu(String navigationMenuName) {
        return Driver.getDriver().findElementByXPath("//android.widget.FrameLayout[@content-desc=\"" + navigationMenuName + "\"]");
    }

    /**
     * Method returns loginPopUpMessage as a MobileElement.
     *
     * @return
     */
    public MobileElement getLogInPopUpMessage() {
        return logInPopUpMessage;
    }


    @AndroidFindBy(id = "com.everydollar.android:id/com_braze_inappmessage_modal_header_text")
    private MobileElement logInPopUpMessage;
}
