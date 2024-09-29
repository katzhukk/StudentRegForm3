import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class StudentRegFormPageObjectTests extends TestBase {
    private final RegistrationPage registrationPage = new RegistrationPage();

    String  firstName = RandomUtils.getRandomFirstName(),
            lastName = RandomUtils.getRandomLastName(),
            userEmail = RandomUtils.getRandomEmail(),
            gender = RandomUtils.getRandomGender(),
            userNumber = RandomUtils.getRandomNumber(),
            yearOfBirth = RandomUtils.getRandomYearOfBirth(),
            monthOfBirth = RandomUtils.getRandomMonthOfBirth(),
            dayOfBirth = RandomUtils.getRandomDayOfBirth(monthOfBirth, yearOfBirth),
            subjects = RandomUtils.getRandomSubject(),
            hobbies = RandomUtils.getRandomHobbies(),
            picture = RandomUtils.getRandomPicture(),
            currentAddress = RandomUtils.getRandomCurrentAddress(),
            state = RandomUtils.getRandomState(),
            city = RandomUtils.getRandomCity(state);

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage() /*Открытие сайта регистрации*/
                /*Заполнение формы студента:*/
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserNumber(userNumber)
                .setGenderWrapper(gender)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbiesWrapper(hobbies)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        /*Проверка результатов*/
        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void unuccessfulRegistrationTest() {
        registrationPage.openPage() /*Открытие сайта регистрации*/
                .clickSubmit();

        /*Проверка результатов*/
        registrationPage.unsuccessfulRegistration();
    }
}