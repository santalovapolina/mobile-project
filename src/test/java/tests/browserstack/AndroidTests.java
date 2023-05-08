package tests.browserstack;


import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;


@Tag("browserstackAndroid")
@Owner("Santalova Polina")
public class AndroidTests extends TestBase {

    @Test
    @DisplayName("Проверка поиска")
    @Severity(SeverityLevel.CRITICAL)
    void searchInputTest() {

        step("Go to search input and type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Hello");
        });
        step("Verify search content size", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                       .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Проверка открытия статьи с ошибкой")
    @Severity(SeverityLevel.MINOR)
    void openArticleWithErrorTest() {

        step("Go to search input and type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("David Bowie");
        });
        step("Go to article", () ->
                $(id("org.wikipedia.alpha:id/view_card_header_subtitle")).click());
        step("Verify article opens with error", () ->
                $(id("org.wikipedia.alpha:id/view_wiki_error_text"))
                       .shouldHave(exactText("An error occurred")));
    }

    @Test
    @DisplayName("Проверка скрытия карточки")
    @Severity(SeverityLevel.NORMAL)
    void hideNewsCardTest() {

        step("Go to news card options", () -> {
            $(id("org.wikipedia.alpha:id/view_card_header_title"))
                    .shouldHave(text("In the news"));
            $(id("org.wikipedia.alpha:id/view_list_card_header_menu")).click();
        });
        step("Hide card", () -> {
            $(id("org.wikipedia.alpha:id/title"))
                     .shouldHave(text("Hide this card"));
            $(id("org.wikipedia.alpha:id/title")).click();
                });
        step("Verify news card is hidden", () ->
            $(id("org.wikipedia.alpha:id/view_list_card_list"))
                     .shouldNotBe(visible));
    }

}
