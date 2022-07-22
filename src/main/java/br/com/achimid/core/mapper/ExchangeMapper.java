package br.com.achimid.core.mapper;

import br.com.achimid.api.web.request.ExchangeRequest;
import br.com.achimid.api.web.response.ExchangeResponse;
import br.com.achimid.core.domain.exchange.ExchangeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

import static org.mapstruct.MappingConstants.ComponentModel.JAKARTA;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = JAKARTA, imports = {LocalDateTime.class})
public interface ExchangeMapper {

    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    ExchangeEntity from(ExchangeRequest request);

    ExchangeResponse from(ExchangeEntity entity);

}
