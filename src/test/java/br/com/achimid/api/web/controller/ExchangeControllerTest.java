package br.com.achimid.api.web.controller;

import br.com.achimid.api.web.request.ExchangeRequest;
import br.com.achimid.core.domain.CurrencyType;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static br.com.achimid.core.domain.CurrencyType.BRL;
import static br.com.achimid.core.domain.CurrencyType.USD;
import static java.math.BigDecimal.ONE;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static test.utils.ExchangeClientUtils.*;

@MicronautTest
@SuppressWarnings("MethodName")
class ExchangeControllerTest {

    @Inject
    private RequestSpecification spec;

    @Test
    public void should_get_exchanges_transactions_without_userId() {
        spec
            .when()
            .log().all()
            .get(PATH_EXCHANGE)
                .then()
                .statusCode(400);
    }

    @Test
    public void should_get_exchanges_transactions_with_userId_empty_return() {
        getExchangeByUserId(spec, USER_ID)
                .body(containsString(""));
    }

    @Test
    public void should_create_exchange_with_invalid_body_with_error() {

        final var request = ExchangeRequest.builder()
                .userId(USER_ID)
                .sourceCurrency(BRL)
                .targetCurrency(USD)
                .build();

        postExchangeBase(spec, request).then().statusCode(400);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "BRL, BRL",
            "BRL, USD",
            "BRL, EUR",
            "BRL, JPY",

            "USD, BRL",
            "USD, USD",
            "USD, EUR",
            "USD, JPY",

            "EUR, BRL",
            "EUR, USD",
            "EUR, EUR",
            "EUR, JPY",

            "JPY, BRL",
            "JPY, USD",
            "JPY, EUR",
            "JPY, JPY",
    })
    public void should_create_exchange_with_success(CurrencyType sourceType, CurrencyType targetType) {

        final var request = ExchangeRequest.builder()
                .userId(USER_ID)
                .sourceValue(ONE)
                .sourceCurrency(sourceType)
                .targetCurrency(targetType)
                .build();

        final var response = postExchange(spec, request);


        assertNotNull(response);
        assertNotNull(response.getRate());
        assertNotNull(response.getTargetValue());
        assertEquals(sourceType, response.getSourceCurrency());
        assertEquals(targetType, response.getTargetCurrency());
        assertEquals(ONE.setScale(2), response.getSourceValue().setScale(2));
        assertEquals(USER_ID, response.getUserId());
    }

    @Test
    public void should_get_exchanges_transactions_with_userId_and_return_list() {

        final var request = ExchangeRequest.builder()
                .userId(USER_ID)
                .sourceValue(ONE)
                .sourceCurrency(BRL)
                .targetCurrency(USD)
                .build();

        postExchange(spec, request);
        postExchange(spec, request);

        final var resp = getExchangeByUserId(spec, USER_ID).extract().response().as(List.class);

        assertFalse(resp.isEmpty());
    }

}
