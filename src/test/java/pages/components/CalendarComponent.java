package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
	public void setDate(String day, String month, String year) {
		$("[id=dateOfBirthInput]").click();
		$(".react-datepicker__year-select").selectOption(year);
		$(".react-datepicker__month-select").selectOption(month);
		$(".react-datepicker__month .react-datepicker__day--003").click();

	}
}
