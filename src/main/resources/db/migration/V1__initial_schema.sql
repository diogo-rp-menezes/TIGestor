CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(100) NOT NULL UNIQUE,
    nome VARCHAR(150) NOT NULL,
    papel VARCHAR(50),
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE machines (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    hostname VARCHAR(100) NOT NULL,
    ip VARCHAR(45),
    data_coleta DATETIME,
    status VARCHAR(20),
    json_raw TEXT
);

CREATE TABLE access_logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(100),
    metodo VARCHAR(50),
    sucesso BOOLEAN,
    datahora DATETIME
);

CREATE TABLE assets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patrimonio VARCHAR(50) NOT NULL,
    tipo VARCHAR(50),
    localizacao VARCHAR(100),
    responsavel VARCHAR(100)
);
