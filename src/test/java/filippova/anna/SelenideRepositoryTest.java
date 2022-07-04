package filippova.anna;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositoryTest {

    @Test
    void checkSampleCodeForJunit(){

        // open github.com
        open("https://github.com");

        // enter in the search box "selenide" and press Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();

        // click on the first found link
        $$("ul.repo-list li").first().$("a").click();

        // check if there is a header "selenide/selenide"
        $(".f3").shouldHave(text("selenide / selenide"));

        // go to wiki-tab
        $("#wiki-tab").click();

        // find a partition "Soft assertions" and click on it
        $(".markdown-body ul").$(byText("Soft assertions")).click();

        // check if there open the page we need and if there is a sample code for JUnit5
        $(".gh-header-title").shouldHave(text("SoftAssertions"));
        $(".markdown-body").shouldHave((text("Using JUnit5 extend test class:")));

    }

}
