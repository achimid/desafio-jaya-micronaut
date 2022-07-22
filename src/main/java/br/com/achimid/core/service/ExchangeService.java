package br.com.achimid.core.service;

import br.com.achimid.core.domain.exchange.ExchangeEntity;
import br.com.achimid.infra.repository.ExchangeRepository;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static java.math.RoundingMode.HALF_EVEN;
import static java.util.Optional.of;

@Slf4j
@Singleton
@AllArgsConstructor
public class ExchangeService {

    private ExchangeRepository exchangeRepository;
    private ExchangeCalculator exchangeCalculator;
    private ExchangeRatesService exchangeRatesService;

    public List<ExchangeEntity> findByUserId(final String userId) {
        return exchangeRepository.findByUserId(userId);
    }

    public ExchangeEntity create(final ExchangeEntity exchange) {
        log.info("Creating new exchange transaction");

         final var exchangeCalculated = of(exchange)
                .map(this::getCurrencyRate)
                .map(rate -> exchangeCalculator.calculate(exchange, rate))
                .map(exchangeRepository::save)
                .orElseThrow();

         log.info("Exchange calculated. exchange={}", exchangeCalculated);

         return exchangeCalculated;
    }

    private BigDecimal getCurrencyRate(final ExchangeEntity exchange) {
        final var rates = exchangeRatesService.getRates();
        final var targetRate = rates.get(exchange.getTargetCurrency().name());
        final var sourceRate = rates.get(exchange.getSourceCurrency().name());

        Objects.requireNonNull(targetRate);
        Objects.requireNonNull(sourceRate);

        return sourceRate.divide(targetRate, HALF_EVEN);
    }

}
