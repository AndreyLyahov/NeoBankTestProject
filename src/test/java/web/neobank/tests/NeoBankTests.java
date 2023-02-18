package web.neobank.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import web.neobank.BaseConfig;
import web.neobank.steps.AuthLoginPageSteps;
import web.neobank.steps.AuthPageFormSteps;

public class NeoBankTests extends BaseConfig {

    private AuthLoginPageSteps loginPageSteps;
    private AuthPageFormSteps authPageFormSteps;
    private final String PAGE_TITLE = "NEOBANK для бізнесу";
    private final String PHONE_NUMBER = "682936751";
    private final String AUTH_FORM_TEXT = "Відкриття бізнес-рахунку можливе тільки через додаток NEOBANK для бізнесу";

    @Test
    public void verifyTabTitle() {
        loginPageSteps = new AuthLoginPageSteps();
        loginPageSteps
                .openPage()
                .waitForLoading();
        Assertions.assertThat(loginPageSteps.getTabTitle())
                .as(String.format("Page title should be %s", PAGE_TITLE))
                .isEqualTo(PAGE_TITLE);
    }

    @Test(priority = 1)
    public void verifyText() {
        loginPageSteps.enterPhoneNumber(PHONE_NUMBER);
        loginPageSteps.clickContinueBtn();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        authPageFormSteps = new AuthPageFormSteps();
        authPageFormSteps.waitForLoading();
        Assertions.assertThat(authPageFormSteps.getTitleText())
                .as(String.format("Auth form title text should be %s", AUTH_FORM_TEXT))
                .isEqualTo(AUTH_FORM_TEXT);
    }
}
