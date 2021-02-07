package nz.co.automation.regression.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Browser {
    private final String baseUrl;

    @Autowired
    public Browser(
            @Value("${base.url}") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void visitBaseUrl() {
        Selenide.open(baseUrl);
    }

    public void setBrowserProperties() {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}