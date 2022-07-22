package br.com.achimid.api.web.controller.doc;

import br.com.achimid.api.web.request.ExchangeRequest;
import br.com.achimid.api.web.response.ExchangeResponse;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.QueryValue;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Exchange")
public interface ExchangeControllerDoc {

    @Operation(summary = "Create a new exchange")
    HttpResponse<ExchangeResponse> create(ExchangeRequest request);

    @Operation(summary = "List all exchange transactions by userId")
    List<ExchangeResponse> list(@QueryValue String userId);
}
