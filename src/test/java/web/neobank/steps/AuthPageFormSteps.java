package web.neobank.steps;

import com.codeborne.selenide.Condition;
import web.neobank.pages.AuthPageForm;

import static com.codeborne.selenide.Selenide.page;

public class AuthPageFormSteps {

    private AuthPageForm authPageForm;

    public AuthPageFormSteps() {
        authPageForm = page(AuthPageForm.class);
    }

    public AuthPageFormSteps waitForLoading() {
        authPageForm.getFormTitle().shouldBe(Condition.visible);
        authPageForm.getQrCode().shouldBe(Condition.visible);
        return this;
    }

    public String getTitleText() {
        authPageForm.getFormTitle().shouldBe(Condition.visible);
        return authPageForm.getFormTitle().getText().trim();
    }
}
