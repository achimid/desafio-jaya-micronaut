package br.com.achimid.api.web.controller;

import br.com.achimid.api.web.controller.doc.ExchangeControllerDoc;
import br.com.achimid.api.web.request.ExchangeRequest;
import br.com.achimid.api.web.response.ExchangeResponse;
import br.com.achimid.core.mapper.ExchangeMapper;
import br.com.achimid.core.service.ExchangeService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.of;

@Slf4j
@Controller("/api/v1/exchange")
public class ExchangeController implements ExchangeControllerDoc {

    @Inject private ExchangeMapper exchangeMapper;
    @Inject private ExchangeService exchangeService;

    @Post
    public HttpResponse<ExchangeResponse> create(@Valid final ExchangeRequest request) {
        log.info("Receiving exchange request");

        return of(request)
                .map(exchangeMapper::from)
                .map(exchangeService::create)
                .map(exchangeMapper::from)
                .map(HttpResponse::created)
                .orElseThrow();
    }

    @Get
    public List<ExchangeResponse> list(@QueryValue final String userId) {
        return exchangeService.findByUserId(userId).stream()
                .map(exchangeMapper::from)
                .collect(Collectors.toList());
    }

}
