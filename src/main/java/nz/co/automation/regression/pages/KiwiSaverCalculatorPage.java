package nz.co.automation.regression.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

@Component
public class KiwiSaverCalculatorPage {

    private static final String ID_KIWISAVER_UBSER_MENU_SECTION = "ubermenu-section-link-kiwisaver-ps";
    private static final String ID_KIWISAVER_UBSER_MENU_CALCULATOR = "ubermenu-item-cta-kiwisaver-calculators-ps";
    private static final String BUTTON_TEXT = "Click here to get started.";
    private static final String CSS_CURRENT_AGE_INFORMATION_ICON = ".field-group-set-frame>div:nth-of-type(1) .field-cell.field-controls>div:nth-child(2) button";
    private static final String CSS_CURRENT_AGE_INFORMATION_MESSAGE = ".field-group-set-frame>div:nth-of-type(1) .field-cell.field-controls .field-message.message-info.ng-binding>p";
    private static final String CSS_CURRENT_AGE_FIELD = ".field-group-set-frame>div:nth-of-type(1) .field-cell.field-controls input";
    private static final String CSS_EMPLOYMMENT_TYPE = ".field-group-set-frame>div:nth-of-type(2) .field-cell.field-controls .control-well";
    private static final String CSS_EMPLOYMENT_TYPE_EXMPLOYED = ".field-group-set-frame>div:nth-of-type(2) .field-cell.field-controls .control-well +div li:nth-child(2) span";
    private static final String CSS_EMPLOYMENT_TYPE_SELF_EMPLOYED = ".field-group-set-frame>div:nth-of-type(2) .field-cell.field-controls .control-well +div li:nth-child(3) span";
    private static final String CSS_EMPLOYMENT_TYPE_NOT_EMPLOYED = ".field-group-set-frame>div:nth-of-type(2) .field-cell.field-controls .control-well +div li:nth-child(4) span";
    private static final String CSS_SALARY_FIELD = ".field-group-set-frame>div:nth-of-type(3) .field-cell.field-controls input";
    private static final String CSS_CONTRIBUTION_RATE_3 = ".field-group-set-frame>div:nth-of-type(4) .control-group>div:nth-child(1) label .input-holder";
    private static final String CSS_CONTRIBUTION_RATE_4 = ".field-group-set-frame>div:nth-of-type(4) .control-group>div:nth-child(2) label .input-holder";
    private static final String CSS_CONTRIBUTION_RATE_6 = ".field-group-set-frame>div:nth-of-type(4) .control-group>div:nth-child(3) label .input-holder";
    private static final String CSS_CONTRIBUTION_RATE_8 = ".field-group-set-frame>div:nth-of-type(4) .control-group>div:nth-child(4) label .input-holder";
    private static final String CSS_CONTRIBUTION_RATE_10 = ".field-group-set-frame>div:nth-of-type(4) .control-group>div:nth-child(5) label .input-holder";
    private static final String CSS_CURRENT_KIWISAVER_BALANCE_FIELD = ".field-group-set-frame>div:nth-of-type(3) .field-cell.field-controls input";
    private static final String CSS_CURRENT_KIWISAVER_BALANCE_FIELD_FOR_EMPLOYED_MEMBERS = ".field-group-set-frame>div:nth-of-type(5) .field-cell.field-controls input";
    private static final String CSS_VOLUNTARY_CONTRIBUTION_FIELD = ".field-group-set-frame>div:nth-of-type(4) .field-cell.field-controls input";
    private static final String CSS_VOLUNTARY_CONTRIBUTION_FIELD_FOR_EMPLOYED_MEMBERS = ".field-group-set-frame>div:nth-of-type(6) .field-cell.field-controls input";
    private static final String CSS_VOLUNTARY_CONTRIBUTION_FREQUENCY = ".field-group-set-frame>div:nth-of-type(4) .field-cell.field-controls .control-well .well-value";
    private static final String CSS_VOLUNTARY_CONTRIBUTION_FREQUENCY_FOR_EMPLOYED_MEMBERS = ".field-group-set-frame>div:nth-of-type(6) .field-cell.field-controls .control-well .well-value";
    private static final String VOLUNTARY_CONTRIBUTION_FREQUENCY_WEEKLY = "//span[contains(.,'Weekly')]";
    private static final String VOLUNTARY_CONTRIBUTION_FREQUENCY_FORTNIGHTLY = "//span[contains(.,'Fortnightly')]";
    private static final String VOLUNTARY_CONTRIBUTION_FREQUENCY_MONTHLY = "//span[contains(.,'Monthly')]";
    private static final String VOLUNTARY_CONTRIBUTION_FREQUENCY_ANNUALLY = "//span[contains(.,'Annually')]";
    private static final String RISK_PROFILE_DEFENSIVE = "//span[contains(.,'Defensive')]";
    private static final String RISK_PROFILE_CONSERVATIVE = "//span[contains(.,'Conservative')]";
    private static final String RISK_PROFILE_BALANCED = "//span[contains(.,'Balanced')]";
    private static final String RISK_PROFILE_GROWTH = "//span[contains(.,'Growth')]";
    private static final String SAVING_GOAL_REQUIREMENT_FIELD = ".field-group-set-frame>div:nth-of-type(6) .field-cell.field-controls input";
    private static final String SAVING_GOAL_REQUIREMENT_FIELD_FOR_EMPLOYED_MEMBERS = ".field-group-set-frame>div:nth-of-type(6) .field-cell.field-controls input";
    private static final String KIWISAVER_RETIREMENT_PROJECTION_BUTTON = ".btn-results-reveal";
    private static final String KIWISAVER_PROJECTED_TEXT = ".result-title.ng-binding";
    private static final String KIWISAVER_PROJECTED_AMOUNT = ".result-value.result-currency.ng-binding";


    public void navigateToRetirementCalculator() {
        $(By.id(ID_KIWISAVER_UBSER_MENU_SECTION)).waitUntil(Condition.visible, 5).hover();
        $(By.id(ID_KIWISAVER_UBSER_MENU_CALCULATOR)).waitUntil(Condition.visible, 3).click();
        $(By.linkText(BUTTON_TEXT)).click();
        switchToiFrame();
    }

    public void clickCurrentAgeInformationIcon() {
        $(By.cssSelector(CSS_CURRENT_AGE_INFORMATION_ICON)).waitUntil(Condition.visible, 5).click();
    }

    public String getCurrentAgeInformationMessage() {
        return $(By.cssSelector(CSS_CURRENT_AGE_INFORMATION_MESSAGE)).waitUntil(Condition.visible, 5).getText();
    }

    public void enterAge(String age) {
        $(By.cssSelector(CSS_CURRENT_AGE_FIELD)).waitUntil(Condition.visible, 10).sendKeys(age);
    }

    private void switchToiFrame() {
        SelenideElement iframe = $("body #calculator-embed>iframe");
        switchTo().frame(iframe);
    }

    public void selectEmploymentType(String employmentType) {
        $(By.cssSelector(CSS_EMPLOYMMENT_TYPE)).click();
        if (employmentType.equals("employed")) {
            $(By.cssSelector(CSS_EMPLOYMENT_TYPE_EXMPLOYED)).click();
        } else if (employmentType.equals("self-employed")) {
            $(By.cssSelector(CSS_EMPLOYMENT_TYPE_SELF_EMPLOYED)).click();
        } else {
            $(By.cssSelector(CSS_EMPLOYMENT_TYPE_NOT_EMPLOYED)).click();
        }
    }

    public void enterSalary(String salary) {
        $(By.cssSelector(CSS_SALARY_FIELD)).waitUntil(Condition.visible, 5).sendKeys(salary);
    }

    public void selectMemberContributionRate(String contributionRate) {
        if (contributionRate.equals("3")) {
            $(By.cssSelector(CSS_CONTRIBUTION_RATE_3)).click();
        } else if (contributionRate.equals("4")) {
            $(By.cssSelector(CSS_CONTRIBUTION_RATE_4)).click();
        } else if (contributionRate.equals("6")) {
            $(By.cssSelector(CSS_CONTRIBUTION_RATE_6)).click();
        } else if (contributionRate.equals("8")) {
            $(By.cssSelector(CSS_CONTRIBUTION_RATE_8)).click();
        } else if (contributionRate.equals("10")) {
            $(By.cssSelector(CSS_CONTRIBUTION_RATE_10)).click();
        }
    }

    public void enterCurrentKiwiSaverBalance(String employmentType, String currentBalance) {
        if (employmentType.equals("employed")) {
            $(By.cssSelector(CSS_CURRENT_KIWISAVER_BALANCE_FIELD_FOR_EMPLOYED_MEMBERS)).waitUntil(Condition.visible, 5).sendKeys(currentBalance);
        } else {
            $(By.cssSelector(CSS_CURRENT_KIWISAVER_BALANCE_FIELD)).waitUntil(Condition.visible, 5).sendKeys(currentBalance);
        }
    }

    public void enterVoluntaryContribution(String employmentType, String volantaryContribution) {
        if (employmentType.equals("employed")) {
            $(By.cssSelector(CSS_VOLUNTARY_CONTRIBUTION_FIELD_FOR_EMPLOYED_MEMBERS)).waitUntil(Condition.visible, 5).sendKeys(volantaryContribution);
        } else {
            $(By.cssSelector(CSS_VOLUNTARY_CONTRIBUTION_FIELD)).waitUntil(Condition.visible, 5).sendKeys(volantaryContribution);
        }
    }

    public void selectVoluntaryContributionFrequency(String employmentType, String voluntaryContributionFrequency) {
        if (employmentType.equals("employed")) {
            $(By.cssSelector(CSS_VOLUNTARY_CONTRIBUTION_FREQUENCY_FOR_EMPLOYED_MEMBERS)).click();
        } else {
            $(By.cssSelector(CSS_VOLUNTARY_CONTRIBUTION_FREQUENCY)).click();
        }
        if (voluntaryContributionFrequency.equals("weekly")) {
            $(By.xpath(VOLUNTARY_CONTRIBUTION_FREQUENCY_WEEKLY)).click();
        } else if (voluntaryContributionFrequency.equals("fortnightly")) {
            $(By.xpath(VOLUNTARY_CONTRIBUTION_FREQUENCY_FORTNIGHTLY)).click();
        } else if (voluntaryContributionFrequency.equals("monthly")) {
            $(By.xpath(VOLUNTARY_CONTRIBUTION_FREQUENCY_MONTHLY)).click();
        } else if (voluntaryContributionFrequency.equals("annually")) {
            $(By.xpath(VOLUNTARY_CONTRIBUTION_FREQUENCY_ANNUALLY)).click();
        }
    }

    public void chooseRiskProfile(String riskProfile) {
        if (riskProfile.equals("Defensive")) {
            $(By.xpath(RISK_PROFILE_DEFENSIVE)).click();
        } else if (riskProfile.equals("Conservative")) {
            $(By.xpath(RISK_PROFILE_CONSERVATIVE)).click();
        } else if (riskProfile.equals("Balanced")) {
            $(By.xpath(RISK_PROFILE_BALANCED)).click();
        } else {
            $(By.xpath(RISK_PROFILE_GROWTH)).click();
        }
    }

    public void enterSavingGoalsRequirement(String employmentType, String savingGoals) {
        if (employmentType.equals("employed")) {
            $(By.cssSelector(SAVING_GOAL_REQUIREMENT_FIELD_FOR_EMPLOYED_MEMBERS)).sendKeys(savingGoals);
        } else {
            $(By.cssSelector(SAVING_GOAL_REQUIREMENT_FIELD)).sendKeys(savingGoals);
        }
    }

    public void clickCalculateProjectedBalance() {
        $(By.cssSelector(KIWISAVER_RETIREMENT_PROJECTION_BUTTON)).click();
    }

    public String getKiwiSaverEstimate() {
        $(By.cssSelector(KIWISAVER_PROJECTED_TEXT)).getText().equals("At age 65, your KiwiSaver balance is estimated to be:");
        return $(By.cssSelector(KIWISAVER_PROJECTED_AMOUNT)).getText();
    }
}