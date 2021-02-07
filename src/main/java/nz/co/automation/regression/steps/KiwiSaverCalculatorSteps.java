package nz.co.automation.regression.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.automation.regression.pages.KiwiSaverCalculatorPage;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class KiwiSaverCalculatorSteps {
    private static final String EXPECTED_CURRENT_AGE_INFORMATION_MESSAGE = "This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.";
    private KiwiSaverCalculatorPage kiwiSaverCalculatorPage;

    @Autowired
    public KiwiSaverCalculatorSteps(KiwiSaverCalculatorPage kiwiSaverCalculatorPage) {
        this.kiwiSaverCalculatorPage = kiwiSaverCalculatorPage;
    }

    @Given("^user is on kiwisaver retirement calculator screen$")
    public void userIsOnKiwisaverRetirementCalculatorScreen() throws InterruptedException {
        kiwiSaverCalculatorPage.navigateToRetirementCalculator();
    }

    @When("^user clicks on information icon besides current age field$")
    public void userClicksOnInformationIconBesidesCurrentAgeField() throws InterruptedException {
        kiwiSaverCalculatorPage.clickCurrentAgeInformationIcon();
    }

    @Then("^user can see current age information message$")
    public void userCanSeeCurrentAgeInformationMessage() {
        assertThat(kiwiSaverCalculatorPage.getCurrentAgeInformationMessage().equals(EXPECTED_CURRENT_AGE_INFORMATION_MESSAGE)).isTrue();
    }

    @When("^user enters \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void userEnters(String age, String employmentType, String salary, String contributionRate, String currentBalance, String voluntaryContribution, String voluntaryContributionFrequency, String riskProfile, String savingGoals) throws InterruptedException {
        kiwiSaverCalculatorPage.enterAge(age);
        kiwiSaverCalculatorPage.selectEmploymentType(employmentType);
        kiwiSaverCalculatorPage.enterSalary(salary);
        kiwiSaverCalculatorPage.selectMemberContributionRate(contributionRate);
        kiwiSaverCalculatorPage.enterCurrentKiwiSaverBalance(employmentType, currentBalance);
        kiwiSaverCalculatorPage.enterVoluntaryContribution(employmentType, voluntaryContribution);
        kiwiSaverCalculatorPage.selectVoluntaryContributionFrequency(employmentType, voluntaryContributionFrequency);
        kiwiSaverCalculatorPage.chooseRiskProfile(riskProfile);
        kiwiSaverCalculatorPage.enterSavingGoalsRequirement(employmentType, savingGoals);
    }

    @Then("^user can see a projected balance \"([^\"]*)\" at retirement$")
    public void userCanSeeAProjectedBalanceAtRetirement(String estimate) {
        kiwiSaverCalculatorPage.clickCalculateProjectedBalance();
        assertThat((kiwiSaverCalculatorPage.getKiwiSaverEstimate()).startsWith("$")).isTrue();
        assertThat((kiwiSaverCalculatorPage.getKiwiSaverEstimate()).contains(estimate)).isTrue();
    }
}
