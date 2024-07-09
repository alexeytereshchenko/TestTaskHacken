package io.alexeytereshchenko.demo.controller;

import io.alexeytereshchenko.demo.dto.TransactionDto;
import io.alexeytereshchenko.demo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransactionController {
  private final TransactionService transactionService;

  @GetMapping("/transactions")
  public Page<TransactionDto> transaction(
      @RequestParam(value = "search", required = false) String search,
      @ParameterObject Pageable pageable
  ) {
    return transactionService.getTransactions(search, pageable);
  }
}
