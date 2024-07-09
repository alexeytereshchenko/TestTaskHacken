CREATE TABLE transaction
(
    id                       BIGINT AUTO_INCREMENT PRIMARY KEY,
    block_hash               VARCHAR(66),
    block_number             VARCHAR(256),
    chain_id                 VARCHAR(10),
    from_address             VARCHAR(42),
    gas                      VARCHAR(256),
    gas_price                VARCHAR(256),
    hash                     VARCHAR(66),
    input                    CLOB,
    max_fee_per_gas          VARCHAR(256),
    max_priority_fee_per_gas VARCHAR(256),
    nonce                    VARCHAR(256),
    r                        VARCHAR(66),
    s                        VARCHAR(66),
    to_address               VARCHAR(42),
    transaction_index        VARCHAR(256),
    transaction_type         VARCHAR(10),
    v                        VARCHAR(10),
    transaction_value        VARCHAR(256)
);
