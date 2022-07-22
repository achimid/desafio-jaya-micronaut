package br.com.achimid.core.domain.exchange;

import br.com.achimid.core.domain.CurrencyType;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Introspected
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ExchangeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String userId;

    @Column
    @NotNull
    private BigDecimal rate;

    @Column
    @NotNull
    private BigDecimal sourceValue;

    @Column
    @NotNull
    private BigDecimal targetValue;

    @Column
    @NotNull
    @Enumerated
    private CurrencyType sourceCurrency;

    @Column
    @NotNull
    @Enumerated
    private CurrencyType targetCurrency;

    @Column
    @NotNull
    private LocalDateTime createdAt;

}
