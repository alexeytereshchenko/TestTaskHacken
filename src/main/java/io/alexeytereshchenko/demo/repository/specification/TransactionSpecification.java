package io.alexeytereshchenko.demo.repository.specification;

import io.alexeytereshchenko.demo.entity.TransactionEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class TransactionSpecification implements Specification<TransactionEntity> {
  private String search;

  @Override
  public Predicate toPredicate(Root<TransactionEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
    if (search == null || search.isEmpty()) {
      return cb.conjunction();
    }

    String likePattern = "%" + search.toLowerCase() + "%";

    return cb.or(
        cb.like(cb.lower(root.get("blockHash")), likePattern),
        cb.like(cb.lower(root.get("blockNumber")), likePattern),
        cb.like(cb.lower(root.get("chainId")), likePattern),
        cb.like(cb.lower(root.get("from")), likePattern),
        cb.like(cb.lower(root.get("gas")), likePattern),
        cb.like(cb.lower(root.get("gasPrice")), likePattern),
        cb.like(cb.lower(root.get("hash")), likePattern),
        cb.like(cb.lower(root.get("maxFeePerGas")), likePattern),
        cb.like(cb.lower(root.get("maxPriorityFeePerGas")), likePattern),
        cb.like(cb.lower(root.get("nonce")), likePattern),
        cb.like(cb.lower(root.get("r")), likePattern),
        cb.like(cb.lower(root.get("s")), likePattern),
        cb.like(cb.lower(root.get("to")), likePattern),
        cb.like(cb.lower(root.get("transactionIndex")), likePattern),
        cb.like(cb.lower(root.get("type")), likePattern),
        cb.like(cb.lower(root.get("v")), likePattern),
        cb.like(cb.lower(root.get("value")), likePattern)
    );
  }
}
