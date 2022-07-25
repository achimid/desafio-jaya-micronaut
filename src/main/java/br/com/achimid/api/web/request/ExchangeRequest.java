package br.com.achimid.api.web.request;

import br.com.achimid.core.domain.CurrencyType;
import com.fasterxml.jackson.annotation.JsonAlias;
import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@Introspected
public class ExchangeRequest {

    @NotBlank(message = "The field {userId} can't be null or blank")
    private String userId;

    @JsonAlias("value")
    @NotNull(message = "The field (value, sourceValue) can't be null or blank")
    private BigDecimal sourceValue;

    @JsonAlias("from")
    @NotNull(message = "The field (from, sourceCurrency) can't be null or blank")
    private CurrencyType sourceCurrency;

    @JsonAlias("to")
    @NotNull(message = "The field (to, targetCurrency) can't be null or blank")
    private CurrencyType targetCurrency;

}
