package io.alexeytereshchenko.demo.service;

import jakarta.annotation.PostConstruct;

public interface TransactionPuller {
  @PostConstruct
  void generate();
}
