package br.com.achimid.infra.client;

import br.com.achimid.infra.client.response.ExchangeRatesResponse;
import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;


@Client("https://api.apilayer.com")
@Header(name = "apiKey", value = "wuNWlVcTi4y6m6YryL1Qt7b07whVMVcY")
public interface ApiLayerClient {

    @Get("/exchangerates_data/latest")
    ExchangeRatesResponse fetchExchangeRates();

}
