package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true; //браузер во весь экран при выполнении теста.
    }

    @Test
    void dataAppearsInOutputBlockTest() {
        //arrange = given = подготовка
        open("https://demoqa.com/text-box");
        $(".main-header").shouldHave(text("Text Box"));// проверяем, что страница открылась (class ="main-header")

        //act = when = действие
        $("#userName").setValue("Jul"); //id="userName"
        $("#userEmail").setValue("jul@jul.ru");
        $("#currentAddress").setValue("currentAddress here");
        $("#permanentAddress").setValue("permanentAddress there");
        $("#submit").click();

        // assert = then = проверка
        $("#output").shouldHave(text("Jul"), text("jul@jul.ru"));
    }
}
