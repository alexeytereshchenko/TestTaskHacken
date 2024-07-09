package io.alexeytereshchenko.demo.mapper;

import io.alexeytereshchenko.demo.dto.TransactionDto;
import io.alexeytereshchenko.demo.entity.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TransactionMapper {
  @Mapping(target = "id", ignore = true)
  TransactionEntity toEntity(TransactionDto dto);

  TransactionDto toDto(TransactionEntity entity);
}
