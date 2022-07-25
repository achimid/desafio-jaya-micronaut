package test.utils;

import br.com.achimid.api.web.request.ExchangeRequest;
import br.com.achimid.api.web.response.ExchangeResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ExchangeClientUtils {
    public static final String PATH_EXCHANGE = "/api/v1/exchange";
    public static final String USER_ID = "123456";

    public static Response postExchangeBase(RequestSpecification spec, ExchangeRequest request) {
        return spec
                .when()
                .header("Content-type", "application/json")
                .and()
                .body(request)
                .log().all()
                .post(PATH_EXCHANGE);
    }

    public static ExchangeResponse postExchange(RequestSpecification spec, ExchangeRequest request) {
        return postExchangeBase(spec, request)
                .then().statusCode(201)
                .extract().response().as(ExchangeResponse.class);
    }

    public static ValidatableResponse getExchangeByUserId(RequestSpecification spec, String userId) {
        return spec
                .when()
                .log().all()
                .queryParam("userId", userId)
                .get(PATH_EXCHANGE)
                .then()
                .statusCode(200);
    }

}
