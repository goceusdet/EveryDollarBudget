package com.everyDollarBudget.pages;

import com.everyDollarBudget.utils.AppUtil;
import com.everyDollarBudget.utils.Driver;
import com.everyDollarBudget.utils.Environment;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {


    /**
     * Method checks if sign in button is displayed and clicks on it. Then it enters username and password per set properties and
     */
    public void signIn() {
        try {
            if (getLogInPopUpMessage().isDisplayed()) {
                getLogInPopUpMessage().click();
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        if (toSignInButton.isDisplayed()) {
            toSignInButton.click();
            //AppUtil.waitForPresenceOfElement(emailSignInBox, 5);
            emailSignInBox.click();
            emailSignInBox.sendKeys(Environment.USER_NAME);
            AppUtil.waitForPresenceOfElement(passwordSignInBox, 5);
            passwordSignInBox.click();
            passwordSignInBox.sendKeys(Environment.USER_PASSWORD);
            signInButton.click();
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else {
            throw new NoSuchElementException("Sign In button is not displayed. Please go to log in page");
        }
    }


    @AndroidFindBy(id = "com.everydollar.android:id/SignInButton")
    private MobileElement toSignInButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"WebView_Container\"]/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
    private MobileElement signInButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"WebView_Container\"]/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText")
    private MobileElement emailSignInBox;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"WebView_Container\"]/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.EditText")
    private MobileElement passwordSignInBox;
}
