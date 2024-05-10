package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

	private final SelenideElement userNameInput = $("#userName"),
			userEmailInput = $("#userEmail"),
			currentAddressInput = $("#currentAddress"),
			permanentAddressInput = $("#permanentAddress"),
			submitButton = $("#submit"),
			resultOutput = $("#output");

	public TextBoxPage openPage() {
		open("/text-box");

		return this;
	}
	public TextBoxPage setUserName(String value) {
		userNameInput.setValue(value);

		return this;
	}
	public TextBoxPage setEmail(String value) {
		userEmailInput.setValue(value);

		return this;
	}
	public TextBoxPage setCurrentAddress(String value) {
		currentAddressInput.setValue(value);

		return this;
	}
	public TextBoxPage setPermanentAddress(String value) {
		permanentAddressInput.setValue(value);

		return this;
	}
	public TextBoxPage submitForm() {
		submitButton.click();

		return this;
	}
	public TextBoxPage checkResult(String key, String value) {
		resultOutput.$(withText(key))
				.shouldHave(text(value));

		return this;
	}
}
