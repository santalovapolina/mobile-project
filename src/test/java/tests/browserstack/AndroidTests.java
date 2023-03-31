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


public class AndroidTests extends TestBase {


    @Tag("browserstackAndroid")
    @Owner(value = "Santalova Polina")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка поиска")
    @Test
    void searchInputTest() {

        step("Go to search input and type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Hello");
        });
        step("Verify search content size", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Tag("browserstackAndroid")
    @Owner(value = "Santalova Polina")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка открытия статьи с ошибкой")
    @Test
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

    @Tag("browserstackAndroid")
    @Owner(value = "Santalova Polina")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка скрытия карточки")
    @Test
    void hideNewsCardTest() {

        step("Go to In the news card options", () -> {
            $(id("org.wikipedia.alpha:id/horizontal_scroll_list_item_text"))
                    .shouldHave(partialText("the Academy awards"));
            $(id("org.wikipedia.alpha:id/view_list_card_header_menu")).click();
        });
        step("Verify there is option to hide card", () ->
                $(id("org.wikipedia.alpha:id/title"))
                        .shouldHave(text("Hide this card")));
        step("Verify card is hidden", () -> {
            $(id("org.wikipedia.alpha:id/title")).click();
            $(id("org.wikipedia.alpha:id/horizontal_scroll_list_item_text"))
                    .shouldBe(hidden);
        });
    }

}
