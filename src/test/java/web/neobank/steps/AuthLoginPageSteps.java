package web.neobank.steps;

import com.codeborne.selenide.Condition;
import com.google.inject.Inject;
import web.neobank.pages.AuthLoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class AuthLoginPageSteps {

    private AuthLoginPage loginPage;

    public AuthLoginPageSteps() {
        loginPage = page(AuthLoginPage.class);
    }

    public AuthLoginPageSteps openPage() {
        open("https://web.neobank.one/");
        return this;
    }

    public AuthLoginPageSteps waitForLoading() {
        loginPage.getPhoneNumberField().shouldBe(Condition.visible);
        loginPage.getContinueButton().shouldBe(Condition.visible);
        return this;
    }

    public AuthLoginPageSteps enterPhoneNumber(String phoneNumber) {
        loginPage.getPhoneNumberField().shouldBe(Condition.visible, Condition.enabled);
        loginPage.getPhoneNumberField().sendKeys(phoneNumber);
        return this;
    }

    public String getTabTitle() {
        return loginPage.getTabTitle().getOwnText();
    }

    public AuthLoginPageSteps clickContinueBtn() {
        loginPage.getContinueButton().shouldBe(Condition.enabled);
        loginPage.getContinueButton().click();
        return this;
    }
}
