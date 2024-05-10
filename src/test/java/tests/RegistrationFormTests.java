package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormTests extends TestBase {
	RegistrationPage registrationPage = new RegistrationPage();

	@Test
	void fillFullRegistrationFormTest() {
		registrationPage.openPage()
				.setFirstName("Svetlana")
				.setLastName("Volodina")
				.setEmail("svetlana.volodina@mail.ru")
				.setGender("Female")
				.setUserNumber("9101112233")
				.setDateOfBirth("03", "September", "1988")
				.setSubject("Computer Science")
				.setHobby("Reading")
				.setHobby("Music")
				.setUploadPicture("/home/svetun/Desktop/pics/Volodina.jpg")
				.setCurrentAddress("some street 1")
				.setUserState("Haryana")
				.setUserCity("Panipat")
				.submitForm()

				//check the result form is correct
				.checkResult("Student Name", "Svetlana Volodina")
				.checkResult("Student Email", "svetlana.volodina@mail.ru")
				.checkResult("Gender", "Female")
				.checkResult("Mobile", "9101112233")
				.checkResult("Date of Birth", "03 September,1988")
				.checkResult("Subjects", "Computer Science")
				.checkResult("Hobbies", "Reading, Music")
				.checkResult("Picture", "Volodina.jpg")
				.checkResult("Address", "some street 1")
				.checkResult("State and City", "Haryana Panipat");

	}

	@Test
	void fillRequiredRegistrationFormTest() {
		registrationPage.openPage()
				.setFirstName("Svetlana")
				.setLastName("Volodina")
				.setGender("Female")
				.setUserNumber("9101112233")
				.setDateOfBirth("03", "September", "1988")
				.submitForm()

				//check the result form is correct
				.checkResult("Student Name", "Svetlana Volodina")
				.checkResult("Gender", "Female")
				.checkResult("Mobile", "9101112233")
				.checkResult("Date of Birth", "03 September,1988");

	}
	@Test
	void incorrectEmailRegistrationFormTest() {
		registrationPage.openPage()
				.setFirstName("Svetlana")
				.setLastName("Volodina")
				.setEmail("svetlana.volodina@")
				.setGender("Female")
				.setUserNumber("9101112233")
				.setDateOfBirth("03", "September", "1988")
				.submitForm()

				//check the result form is not visible
				.checkResultFormInvisible();

	}
}