package br.com.achimid.api.web.response;

import br.com.achimid.core.domain.CurrencyType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
@Builder
@Introspected
public class ExchangeResponse {

    private Long id;
    private String userId;
    private BigDecimal rate;
    private BigDecimal sourceValue;
    private BigDecimal targetValue;
    private CurrencyType sourceCurrency;
    private CurrencyType targetCurrency;

    @JsonFormat(shape = STRING)
    private LocalDateTime createdAt;

}
