package br.com.achimid.core.domain;

import br.com.achimid.core.domain.exchange.CurrencyType;
import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class ExchangeEntity {

    private String userId;
    private BigDecimal rate;
    private BigDecimal targetValue;
    private CurrencyType sourceCurrency;
    private CurrencyType targetCurrency;
    private Date createdAt;

}
