CREATE TABLE IF NOT EXISTS authors (
  author_id BIGINT PRIMARY KEY,
  name      VARCHAR(256) NOT NULL,
  birthdate DATE         NOT NULL
);

CREATE TABLE IF NOT EXISTS books (
  id             VARCHAR(256) PRIMARY KEY,
  isdn           VARCHAR(64)  NOT NULL,
  title          VARCHAR(256) NOT NULL,
  author_id      BIGINT       NOT NULL,
  publisher_name VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS publishers (
  id      VARCHAR(256) PRIMARY KEY,
  name    VARCHAR(256) NOT NULL,
  address VARCHAR(256) NOT NULL
);
