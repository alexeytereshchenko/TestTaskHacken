package io.alexeytereshchenko.demo.service.impl;

import io.alexeytereshchenko.demo.dto.TransactionDto;
import io.alexeytereshchenko.demo.mapper.TransactionMapper;
import io.alexeytereshchenko.demo.repository.TransactionRepository;
import io.alexeytereshchenko.demo.repository.specification.TransactionSpecification;
import io.alexeytereshchenko.demo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultTransactionService implements TransactionService {
  private final TransactionRepository transactionRepository;
  private final TransactionMapper transactionMapper;

  @Override
  public Page<TransactionDto> getTransactions(String search, Pageable pageable) {
    TransactionSpecification searchSpecification = new TransactionSpecification(search);
    return transactionRepository.findAll(searchSpecification, pageable)
        .map(transactionMapper::toDto);
  }
}
