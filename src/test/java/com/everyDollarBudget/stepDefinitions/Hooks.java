package com.everyDollarBudget.stepDefinitions;

import com.everyDollarBudget.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;


public class Hooks {
    /**
     * @Before will be executed automatically before EVERY scenario in the project.
     */
    @Before("@ui")
    public void setupMethod(){
        System.out.println("this is coming from BEFORE");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver();
    }

    /**
     * @param scenario
     * @After will be executed automatically after EVERY scenario in the project.
     */
    @After("@ui")
    public void teardownMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
