package br.com.achimid.core.service;

import br.com.achimid.core.domain.exchange.ExchangeEntity;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@MicronautTest
@SuppressWarnings("MethodName")
class ExchangeCalculatorTest {

    @Inject
    private ExchangeCalculator exchangeCalculator;

    @Test
    void should_calculate_source_value_with_success() {
        final var exchange = ExchangeEntity.builder().sourceValue(TEN).build();
        final var rate = new BigDecimal("1.5");

        final var calculated = exchangeCalculator.calculate(exchange, rate);

        assertEquals(valueOf(15).setScale(2), calculated.getTargetValue());
        assertEquals(rate, calculated.getRate());
    }

    @Test
    void should_calculate_with_null_exchange() {
        assertThrows(NullPointerException.class, () -> exchangeCalculator.calculate(null, null));
    }

    @Test
    void should_calculate_with_null_rate() {
        assertThrows(NullPointerException.class, () -> exchangeCalculator.calculate(ExchangeEntity.builder().build(), null));
    }

    @Test
    void should_calculate_with_null_source_value() {
        assertThrows(NullPointerException.class, () -> exchangeCalculator.calculate(ExchangeEntity.builder().build(), ZERO));
    }

}
