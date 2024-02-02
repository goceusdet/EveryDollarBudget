package com.everyDollarBudget.stepDefinitions;

import com.everyDollarBudget.pages.BudgetPage;
import com.everyDollarBudget.pages.LoginPage;
import com.everyDollarBudget.pages.ProfilePage;
import com.everyDollarBudget.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestStepdefs {


    LoginPage loginPage = new LoginPage();
    BudgetPage budgetPage = new BudgetPage();
    ProfilePage profilePage = new ProfilePage();


    @Given("user is logged in")
    public void user_is_logged_in() {
        loginPage.signIn();
    }

    @When("user is directed to {string} module")
    public void user_is_directed_to_budget_module(String navigationMenuName) {
        budgetPage.getNavigationMenu(navigationMenuName).click();
        Assertions.assertTrue(budgetPage.getSummaryLabelView().isDisplayed());// verifying if user is on the Budget module.
    }

    @When("user enters income-fields values")
    public void user_enters_income_fields_values(Map<String, String> fields) {
        budgetPage.fillOutFields(fields);
    }

    @Then("total amount left to plan is {int}")
    public void total_money_left_to_plan_is(int expectedAmount) {
        int actualAmount = budgetPage.getLeftToBudgetAmount();
        Assertions.assertEquals(expectedAmount,actualAmount);
    }

    @Then("user clears income-fields values")
    public void user_clears_income_fields_values(Map<String, String> fields) {
        budgetPage.clearOutFields(fields);
    }

    @Then("user logs out")
    public void user_logs_out() {
        profilePage.logOut();
    }

//    Unit test for logging out.
//    @Test
//    public void unitTest() throws InterruptedException {
//        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Driver.getDriver();
//        loginPage.signIn();
//            Thread.sleep(2);
//
//        profilePage.logOut();
//        Driver.closeDriver();
//    }
}

