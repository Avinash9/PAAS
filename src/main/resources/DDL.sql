USE accounting;

CREATE TABLE idempotencyInfo (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  accountId bigint(20) NOT NULL,
  idempotencyKey varchar(500) NOT NULL,
  requestDetails json NOT NULL,
  requestChecksum varchar(500) NOT NULL,
  requestState varchar(20) NOT NULL,
  responseDetails json NOT NULL,
  createTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updateTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY unqIdempotencyKey(idempotencyKey)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DROP TABLE IF EXISTS account;
CREATE TABLE account (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  tenantId varchar(10) NOT NULL,
  accountType varchar(20) NOT NULL,
  accountStatus tinyint(1) NOT NULL,
  ownerId varchar(100) NOT NULL,
  accountMetadata varchar(500) NOT NULL,
  version bigint(10) NOT NULL,
  createTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updateTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY unqOnwerId(ownerId),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DROP TABLE IF EXISTS accountEventLog;
CREATE TABLE accountEventLog (
  id bigint(10) NOT NULL AUTO_INCREMENT,
  accountId bigint(20) NOT NULL,
  eventDetails varchar(500) NOT NULL,
  createTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updateTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  KEY idxAccountId(accountId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DROP TABLE IF EXISTS wallet;
CREATE TABLE wallet (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  status tinyint(1) NOT NULL,
  walletType tinyint(3) NOT NULL,
  accountId bigint(20) NOT NULL,
  version bigint(10) NOT NULL,
  balanceDetails json NOT NULL,
  expiryTimestamp timestamp NOT NULL,
  createTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updateTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id, version),
  UNIQUE KEY unqAccountId(accountId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DROP TABLE IF EXISTS accountLock;
CREATE TABLE accountLock (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  accountId bigint(20) NOT NULL,
  version bigint(10) NOT NULL,
  createTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updateTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY idxAccountId(accountId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DROP TABLE IF EXISTS transientAccountingLog;
CREATE TABLE transientAccountingLog (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  transactionReference varchar(500) NOT NULL,
  accountId bigint(20) NOT NULL,
  accountingType varchar(20) NOT NULL,
  walletId bigint(20) NOT NULL,
  walletType tinyint(3) NOT NULL,
  txnType tinyint(3) NOT NULL,
  txnAmount decimal(16,2) NOT NULL,
  availableBalance decimal(16,2) NOT NULL,
  blockedInBalance decimal(16,2) NOT NULL,
  blockedOutBalance decimal(16,2) NOT NULL,
  createTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updateTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id, version)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DROP TABLE IF EXISTS accountingLog;
CREATE TABLE accountingLog (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  transactionReference varchar(500) NOT NULL,
  accountId bigint(20) NOT NULL,
  accountingType varchar(20) NOT NULL,
  walletId bigint(20) NOT NULL,
  walletType tinyint(3) NOT NULL,
  txnType tinyint(3) NOT NULL,
  txnAmount decimal(16,2) NOT NULL,
  availableBalance decimal(16,2) NOT NULL,
  blockedInBalance decimal(16,2) NOT NULL,
  blockedOutBalance decimal(16,2) NOT NULL,
  createTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updateTimestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id, version)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

########################################################################################################################################################################
########################################################################################################################################################################

BALANCE DETAILS APIS
  GET_BALANCE
  GET_BALANCE_DETAILS

MONEY MOVEMENT APIS(IDEMPOTENT)
  CREDIT
  DEBIT
  PREPARE_CREDIT
  PREPARE_DEBIT
  FINALISE
  ROLLBACK

ACCOUNT/WALLET CREATION
  CREATE ACCOUNT
  CREATE WALLET
  -- UPDATE ACCOUNT -- KYC STATUS 


FUTURE FUNCTIONALITY
  LIMITS
  SHARDING

Business APIS
  Create USER
  Modify User
  Create wallet
  User Passbook
  P2P
  P2M








