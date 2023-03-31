package helpers;


import config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;

import static helpers.CustomListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
    public static String getVideoUrl(String sessionId) {

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic(config.getLogin(), config.getPassword())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
