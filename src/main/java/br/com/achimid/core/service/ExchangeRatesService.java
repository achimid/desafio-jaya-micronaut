package br.com.achimid.core.service;

import br.com.achimid.infra.client.LayerApiClient;
import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.Cacheable;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Map;

@Slf4j
@Singleton
@AllArgsConstructor
@CacheConfig("api-layer-client")
public class ExchangeRatesService {
    private LayerApiClient layerClient;

    @Cacheable
    public Map<String, BigDecimal> getRates() {
        log.info("Fetching rates from Layer API");
        return layerClient.fetchExchangeRates().getRates();
    }

}
