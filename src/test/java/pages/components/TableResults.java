package pages.componets;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResults {
    public TableResults checkTableResults(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;

    }

    public void unsuccessfulRegistration(){
        $(".modal-content").shouldNotBe(exist);
    }
}