package tests.local;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;


@Tag("appiumAndroid")
@Owner("Santalova Polina")
public class AndroidTest extends TestBase {


    @BeforeEach
    void passingGettingStartedPage() {

        step("Pass page 1", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("Pass page 2", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("Pass page 3", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("Accept", () ->
                $(id("org.wikipedia.alpha:id/acceptButton")).click());

    }


    @Test
    @DisplayName("Проверка поиска")
    @Severity(SeverityLevel.NORMAL)
    void searchResultsSizeTest() {

        step("Go to search input and type search", () -> {
            $(id("org.wikipedia.alpha:id/search_container")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("JavaScript");
        });
        step("Verify search content size", () -> {
            $(id("org.wikipedia.alpha:id/search_results_display"))
                    .shouldBe(visible);
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(4));
        });

    }

    @Test
    @DisplayName("Проверка открытия статьи")
    @Severity(SeverityLevel.CRITICAL)
    void openArticleTest() {

        step("Go to search input and type search", () -> {
            $(id("org.wikipedia.alpha:id/search_container")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("javascript");
        });
        step("Go to first article on search list", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).get(0)
                    .shouldHave(text("JavaScript"));
            $$(id("org.wikipedia.alpha:id/page_list_item_description")).get(0)
                    .shouldHave(text("High-level programming language"));
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).get(0).click();
        });
        step("Verify content", () ->
                $(id("org.wikipedia.alpha:id/page_web_view"))
                    .shouldBe(visible));

    }

    @Test
    @DisplayName("Проверка закрытия объявления")
    @Severity(SeverityLevel.NORMAL)
    void closeAnnouncementTest() {

        step("Check appeared announcement", () ->
                $(id("org.wikipedia.alpha:id/view_announcement_text"))
                    .shouldHave(partialText("You can now choose what to show on your feed")));
        step("Hide announcement", () -> {
            $(id("org.wikipedia.alpha:id/view_announcement_action_negative"))
                    .shouldHave(text("GOT IT"));
            $(id("org.wikipedia.alpha:id/view_announcement_action_negative")).click();
        });
        step("Verify announcement is hidden", () ->
                $(id("org.wikipedia.alpha:id/view_announcement_text"))
                    .shouldNotBe((visible)));
    }

}




