package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {


	@BeforeAll
	static void beforeAll() {
		Configuration.browserSize = "1920x1080";
		Configuration.baseUrl = "https://demoqa.com";
		Configuration.pageLoadStrategy = "eager";
		Configuration.holdBrowserOpen = true;
		Configuration.timeout = 5000; //default 4000
	}

	@Test
	void fillFormTest() {
		open("/text-box");
		$("#userName").setValue("Svetlana");
		$("#userEmail").setValue("svetlana.volod@mail.ru");
		$("#currentAddress").setValue("some street 1");
		$("#permanentAddress").setValue("another street 1");
		$("#submit").click();

		$("#output #name").shouldHave(text("Svetlana"));
		$("#output #email").shouldHave(text("svetlana.volod@mail.ru"));
		$("#output #currentAddress").shouldHave(text("some street 1"));
		$("#output #permanentAddress").shouldHave(text("another street 1"));
	}
}
