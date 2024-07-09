package io.alexeytereshchenko.demo.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.alexeytereshchenko.demo.dto.TransactionDto;
import io.alexeytereshchenko.demo.entity.TransactionEntity;
import io.alexeytereshchenko.demo.mapper.TransactionMapper;
import io.alexeytereshchenko.demo.repository.TransactionRepository;
import io.alexeytereshchenko.demo.service.TransactionPuller;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TransactionPullerImpl implements TransactionPuller {
  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;
  private final TransactionRepository transactionRepository;
  private final TransactionMapper transactionMapper;

  @Value("${infura.project.id}")
  private String projectId;

  @PostConstruct
  @Override
  public void generate() {
    String url = "https://mainnet.infura.io/v3/" + projectId;
    String requestPayload = """
         {
             "jsonrpc": "2.0",
             "method": "eth_getBlockByNumber",
             "params": [
                 "latest",
                 true
             ],
             "id": 1
         }
        """;

    String response = restTemplate.postForObject(url, requestPayload, String.class);
    List<TransactionDto> transactions = parseTransactions(response);
    List<TransactionEntity> transactionEntities = transactions.stream()
        .map(transactionMapper::toEntity)
        .toList();
    transactionRepository.saveAll(transactionEntities);
  }

  private List<TransactionDto> parseTransactions(String response) {
    try {
      JsonNode rootNode = objectMapper.readTree(response);
      JsonNode resultNode = rootNode.get("result");
      JsonNode transactionsNode = resultNode.get("transactions");

      return objectMapper.treeToValue(transactionsNode, new TypeReference<List<TransactionDto>>() {
      });
    } catch (Exception e) {
      throw new RuntimeException("Error parsing transactions: %s".formatted(e.getMessage()), e);
    }
  }
}
