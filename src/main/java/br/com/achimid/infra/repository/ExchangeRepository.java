package br.com.achimid.infra.repository;

import br.com.achimid.core.domain.exchange.ExchangeEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeEntity, Long> {

    List<ExchangeEntity> findByUserId(String userId);

}
