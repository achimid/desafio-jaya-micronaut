package br.com.achimid.infra.client;

import br.com.achimid.infra.client.response.ExchangeRatesResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;


@Client("${layer-api.base-url}")
@Header(name = "${layer-api.auth.apiKey}", value = "${layer-api.auth.secret}")
public interface LayerApiClient {

    @Get("/exchangerates_data/latest")
    ExchangeRatesResponse fetchExchangeRates();

}
