package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

	@BeforeAll
	static void beforeAll() {
		Configuration.browserSize = "1920x1080";
		Configuration.baseUrl = "https://demoqa.com";
		Configuration.pageLoadStrategy = "eager";
	}
	@AfterEach
	void afterEach() {
		Selenide.closeWebDriver();
	}

	@Test
	void fillPracticeFormTest() {
		open("/automation-practice-form");
		$("#firstName").setValue("Svetlana");
		$("#lastName").setValue("Volodina");
		$("#userEmail").setValue("svetlana.volodina@mail.ru");
		$("#userNumber").setValue("9101112233");
		$("label[for='gender-radio-2']").click();
		$("[id=dateOfBirthInput]").click();
		$("[class=react-datepicker__year-select]>[value='1988']").click();
		$("[class=react-datepicker__month-select]>[value='8']").click();
		$(".react-datepicker__month .react-datepicker__day--003").click();
		$("#subjectsContainer").click();
		$("#subjectsInput").setValue("Computer Science").pressEnter();
		$("label[for='hobbies-checkbox-2']").click();
		$("label[for='hobbies-checkbox-3']").click();
		$("#uploadPicture").setValue("/home/svetun/Desktop/pics/Volodina.jpg");
		$("#currentAddress").setValue("some street 1");
		$("#state").click();
		$(byText("Haryana")).click();
		$("#city").click(); //
		$(byText("Panipat")).click();
		$("#submit").click();

		//Проверка корректности введенных данных
		$(".table-responsive").shouldHave(text("Svetlana Volodina"));
		$(".table-responsive").shouldHave(text("svetlana.volodina@mail.ru"));
		$(".table-responsive").shouldHave(text("Female"));
		$(".table-responsive").shouldHave(text("9101112233"));
		$(".table-responsive").shouldHave(text("03 September,1988"));
		$(".table-responsive").shouldHave(text("Computer Science"));
		$(".table-responsive").shouldHave(text("Reading, Music"));
		$(".table-responsive").shouldHave(text("Volodina.jpg"));
		$(".table-responsive").shouldHave(text("some street 1"));
		$(".table-responsive").shouldHave(text("Haryana Panipat"));
	}
}