package io.alexeytereshchenko.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDto {
  private String blockHash;
  private String blockNumber;
  private String chainId;
  private String from;
  private String gas;
  private String gasPrice;
  private String hash;
  private String input;
  private String maxFeePerGas;
  private String maxPriorityFeePerGas;
  private String nonce;
  private String r;
  private String s;
  private String to;
  private String transactionIndex;
  private String type;
  private String v;
  private String value;
}