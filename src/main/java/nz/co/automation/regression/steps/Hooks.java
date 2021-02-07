package nz.co.automation.regression.steps;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.masterthought.cucumber.ReportBuilder;
import nz.co.automation.regression.AutomationConfiguration;
import nz.co.automation.regression.annotations.AfterAll;
import nz.co.automation.regression.annotations.BeforeAll;
import nz.co.automation.regression.pages.Browser;
import org.apache.commons.lang3.StringUtils;
import org.junit.runner.RunWith;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.openqa.selenium.OutputType.BYTES;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AutomationConfiguration.class)
@SpringBootTest
public class Hooks {

    private final Environment environment;
    private final ReportBuilder reportBuilder;
    private final Browser browser;
    public static final String SCENARIO_TAG_API_TEST = "@api-test";

    @Autowired
    public Hooks(Environment environment,
                 ReportBuilder reportBuilder, Browser browser) {
        this.environment = environment;
        this.reportBuilder = reportBuilder;
        this.browser = browser;
    }

    @BeforeAll
    public void beforeAllScenarios() {
        System.out.println("-------------- executing BeforeAll hook ----------------\n");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        boolean isApiTest = scenario.getSourceTagNames().contains(SCENARIO_TAG_API_TEST);
        if (isApiTest) {
            return;
        }
        browser.visitBaseUrl();
        browser.setBrowserProperties();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            final TakesScreenshot takesScreenshot = (TakesScreenshot) WebDriverRunner.getWebDriver();
            final byte[] screenshot = takesScreenshot.getScreenshotAs(BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

    @AfterAll
    public void afterAllScenarios() {
        System.out.println("-------------- executing AfterAll hook ----------------\n");
        reportBuilder.generateReports();
        WebDriverRunner.closeWebDriver();
    }
}
