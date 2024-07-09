package io.alexeytereshchenko.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transaction")
public class TransactionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "block_hash")
  private String blockHash;

  @Column(name = "block_number")
  private String blockNumber;

  @Column(name = "chain_id")
  private String chainId;

  @Column(name = "from_address")
  private String from;

  @Column(name = "gas")
  private String gas;

  @Column(name = "gas_price")
  private String gasPrice;

  @Column(name = "hash")
  private String hash;

  @Lob
  @Column(name = "input")
  private String input;

  @Column(name = "max_fee_per_gas")
  private String maxFeePerGas;

  @Column(name = "max_priority_fee_per_gas")
  private String maxPriorityFeePerGas;

  @Column(name = "nonce")
  private String nonce;

  @Column(name = "r")
  private String r;

  @Column(name = "s")
  private String s;

  @Column(name = "to_address")
  private String to;

  @Column(name = "transaction_index")
  private String transactionIndex;

  @Column(name = "transaction_type")
  private String type;

  @Column(name = "v")
  private String v;

  @Column(name = "transaction_value")
  private String value;
}
