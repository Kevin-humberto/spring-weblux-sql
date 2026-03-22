DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS product;

CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    dni CHAR(8) NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    state CHAR(1) NOT NULL DEFAULT 'A'
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    code VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    category VARCHAR(100),
    state CHAR(1) NOT NULL DEFAULT 'A',
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);