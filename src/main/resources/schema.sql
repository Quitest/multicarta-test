--CREATE DATABASE IF NOT EXISTS multicarta_db
--    WITH
--    OWNER = postgres
--    ENCODING = 'UTF8'
--    CONNECTION LIMIT = -1;

--COMMENT ON DATABASE multicarta_db
--    IS 'БД для тестового задания multicarta.ru';

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(255) UNIQUE,
   CONSTRAINT pk_products PRIMARY KEY (id)
);

DROP TABLE IF EXISTS payments;
CREATE TABLE payments (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(255),
   lastname VARCHAR(255),
   age INTEGER NOT NULL,
   purchase_item_id BIGINT REFERENCES products (id),
   count INTEGER NOT NULL,
--  Для amount необходимо использовать денежный тип данных money - потребует преобразований типов в коде.
   amount REAL,
   purchase_date date,
   CONSTRAINT pk_payments PRIMARY KEY (id)
);