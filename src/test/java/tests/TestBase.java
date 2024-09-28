package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {/* Всегда пишется со static. Вызывается один перед всеми тестами в этом тестовом классе*/
        Configuration.browserSize = "1920x1080";        /* Задаем разрешение браузера */
        Configuration.baseUrl = "https://demoqa.com";   /* Открывает основную страницу сайта */
        Configuration.pageLoadStrategy = "eager";       /* Не ждем, когда загрузится полностью страница, чтобы долго не ждать*/
        //Configuration.holdBrowserOpen = true;         /* Не дает закрыть тесту браузер. Нужно только для отладки */
    }

    @AfterAll
    static void afterAll() {/* Всегда пишется со static. Вызывается один после всеми тестов в этом тестовом классе*/
        WebDriverRunner.closeWebDriver();
    }
}
