package br.com.achimid.core.service;

import br.com.achimid.core.domain.exchange.ExchangeEntity;
import jakarta.inject.Singleton;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;
import static java.util.Objects.requireNonNull;

@Slf4j
@Singleton
public class ExchangeCalculator {

    public ExchangeEntity calculate(@NonNull final ExchangeEntity exchange, @NonNull final BigDecimal rate) {
        log.info("Calculating exchange values. rate={}", rate);

        final var sourceValue = requireNonNull(exchange.getSourceValue());
        final var targetValue = rate.multiply(sourceValue).setScale(2, HALF_EVEN);

        final var exchangeCalculated = exchange.toBuilder()
                .targetValue(targetValue)
                .rate(rate)
                .build();

        return exchangeCalculated;
    }

}
