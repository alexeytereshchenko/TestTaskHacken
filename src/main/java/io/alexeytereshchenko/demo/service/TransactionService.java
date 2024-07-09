package io.alexeytereshchenko.demo.service;

import io.alexeytereshchenko.demo.dto.TransactionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {
  Page<TransactionDto> getTransactions(String search, Pageable pageable);
}
