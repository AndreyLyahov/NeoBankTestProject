package web.neobank.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class AuthLoginPage {

    @FindBy(tagName = "title")
    private SelenideElement tabTitle;

    @FindBy(id = "login")
    private SelenideElement phoneNumberField;

    @FindBy(id = "btnNext")
    private SelenideElement continueButton;

}
