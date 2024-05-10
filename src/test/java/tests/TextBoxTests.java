package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase{
	TextBoxPage textBoxPage = new TextBoxPage();
	@Test
	void fillFormTest() {

		textBoxPage.openPage()
				.setUserName("Svetlana")
				.setEmail("svetlana.volodina@mail.ru")
				.setCurrentAddress("some street 1")
				.setPermanentAddress("another street 1")
				.submitForm()

				//check the result is correct
				.checkResult("Name", "Svetlana")
				.checkResult("Email", "svetlana.volodina@mail.ru")
				.checkResult("Current Address", "some street 1")
				.checkResult("Permananet Address", "another street 1");
	}
}
