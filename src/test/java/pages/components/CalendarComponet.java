package pages.componets;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

        $("#dateOfBirthInput").click();    /*Клик по Дате Рождения*/
        $(".react-datepicker__month-select").$(byText(month)).click();     /*Выбирает июнь*/
        $(".react-datepicker__year-select").$(byText(year)).click();   /*Выбирает год*/
        $(".react-datepicker__day--023").click();
    }
}
