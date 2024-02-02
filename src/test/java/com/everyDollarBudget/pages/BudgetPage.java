package com.everyDollarBudget.pages;


import com.everyDollarBudget.utils.Driver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Map;

public class BudgetPage extends BasePage {


    /**
     * Getter method for budgetHeader MobileElement
     *
     * @return
     */
    public MobileElement getBudgetHeader() {
        return budgetHeader;
    }

    /**
     * Method assigns planned value to corresponding income.
     *
     * @param fields
     */
    public void fillOutFields(Map<String, String> fields) {

        for (int i = 1; i <= getBudgetItems().size(); i++) {

            MobileElement budgetItem = Driver.getDriver().findElementByXPath("(//android.view.ViewGroup[@content-desc=\"BudgetItem\"])[" + i + "]/android.widget.TextView[1]");
            MobileElement budgetAmount = Driver.getDriver().findElementByXPath("(//android.view.ViewGroup[@content-desc=\"BudgetItem\"])[" + i + "]/android.widget.TextView[2]");

            if(!budgetItem.isEnabled()){
                Driver.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + budgetItem.getText() + "\"))"));
            }

            if (!budgetAmount.getText().equals("$0.00")) {
                clearOutFields(fields);
            }

            if (fields.containsKey(budgetItem.getText())) {
                budgetAmount.click();
                budgetAmountEntry.sendKeys(fields.get(budgetItem.getText()));
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
            }
        }
    }

    /**
     * Method takes paramters in key-value format and clears budget amount fields.
     *
     * @param fields
     */
    public void clearOutFields(Map<String, String> fields) {

        for (int i = 1; i <= getBudgetItems().size(); i++) {

            MobileElement budgetItem = Driver.getDriver().findElementByXPath("(//android.view.ViewGroup[@content-desc=\"BudgetItem\"])[" + i + "]/android.widget.TextView[1]");
            MobileElement budgetAmount = Driver.getDriver().findElementByXPath("(//android.view.ViewGroup[@content-desc=\"BudgetItem\"])[" + i + "]/android.widget.TextView[2]");

            if(!budgetItem.isEnabled()){
                Driver.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + budgetItem.getText() + "\"))"));
            }

            if (fields.containsKey(budgetItem.getText())) {
                budgetAmount.click();
                budgetAmountEntry.clear();
                ((AndroidDriver) Driver.getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
            }
        }
    }


    /**
     * Method returns the total amount of Income planned values.
     *
     * @return
     */
    public int getIncomeSum() {
        int total = 0;
        for (int i = 1; i < getBudgetItems().size(); i++) {
            MobileElement budgetItem = Driver.getDriver().findElementByXPath("(//android.view.ViewGroup[@content-desc=\"BudgetItem\"])[" + i + "]/android.widget.TextView[1]");
            MobileElement budgetAmount = Driver.getDriver().findElementByXPath("(//android.view.ViewGroup[@content-desc=\"BudgetItem\"])[" + i + "]/android.widget.TextView[2]");
            if (budgetItem.getText().equals("Paycheck " + i)) {
                String incomeField = budgetAmount.getText().replace(",", "");
                total += Integer.parseInt(incomeField.substring(1, incomeField.indexOf('.')));
            }
        }
        return total;
    }

    /**
     * Method returns the sum of all planned values except for planned Income.
     *
     * @return
     */
    public int getSumOfPlannedValues() {
        int total = 0;
        for (int i = 1; i < getBudgetItems().size(); i++) {
            MobileElement budgetItem = Driver.getDriver().findElementByXPath("(//android.view.ViewGroup[@content-desc=\"BudgetItem\"])[" + i + "]/android.widget.TextView[1]");
            MobileElement budgetAmount = Driver.getDriver().findElementByXPath("(//android.view.ViewGroup[@content-desc=\"BudgetItem\"])[" + i + "]/android.widget.TextView[2]");
            if (!budgetItem.getText().equals("Paycheck " + i)) {
                String plannedSum = budgetAmount.getText().replace(",", "");
                total += Integer.parseInt(plannedSum.substring(1, plannedSum.indexOf('.')));
            }
        }
        return total;
    }

    /**
     * Method returns int value of amount left to budget.
     *
     * @return
     */
    public int getLeftToBudgetAmount() {
        return getIncomeSum() - getSumOfPlannedValues();
    }

    /**
     * Method returns a list of budget items as a list of Mobile elements.
     *
     * @return
     */
    public List<MobileElement> getBudgetItems() {
        return Driver.getDriver().findElements(By.xpath("(//android.view.ViewGroup[@content-desc=\"BudgetItem\"])"));
    }

    /**
     * Method returns a mobile element type of the summary label view in Budget module.
     *
     * @return
     */
    public MobileElement getSummaryLabelView() {
        return summaryLabelView;
    }

    @AndroidFindBy(id = "com.everydollar.android:id/ItsAnEveryDollarBudgetLabel")
    private MobileElement budgetHeader;

    @AndroidFindBy(id = "com.everydollar.android:id/BudgetItemAmountEntry")
    private MobileElement budgetAmountEntry;

    @AndroidFindBy(accessibility = "TotalLeftToBudget")
    private MobileElement leftToBudget;

    @AndroidFindBy(accessibility = "SummaryLabelView")
    private MobileElement summaryLabelView;

}
