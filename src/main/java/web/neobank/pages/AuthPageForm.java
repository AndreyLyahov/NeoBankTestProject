package web.neobank.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class AuthPageForm {

    @FindBy(id = "formAuthQr")
    private SelenideElement formElement;

    @FindBy(className = "auth-form-title")
    private SelenideElement formTitle;

    @FindBy(className = "auth-form--qr-code")
    private SelenideElement qrCode;

}
