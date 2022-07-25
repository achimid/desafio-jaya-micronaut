package br.com.achimid.core.service;

import io.micronaut.context.annotation.Requires;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static io.micronaut.core.util.StringUtils.FALSE;
import static io.micronaut.core.util.StringUtils.TRUE;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
@SuppressWarnings("MethodName")
@Requires(property = "mockito.test.enabled", defaultValue = FALSE, value = TRUE)
class ExchangeRatesServiceTest {

    @Inject
    ExchangeRatesService exchangeRatesService;

    @Test
    void should_test_rate() {
        final var rates = exchangeRatesService.getRates();

        assertNotNull(rates);
    }

}
