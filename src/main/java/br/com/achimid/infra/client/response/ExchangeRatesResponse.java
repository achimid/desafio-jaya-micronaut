package br.com.achimid.infra.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRatesResponse {

    private Boolean success;
    private long timestamp;
    private String base;
    private Date date;
    private Map<String, BigDecimal> rates;

}
