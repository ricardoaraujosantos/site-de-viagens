create database agencia_viajar;
use agencia_viajar;

CREATE TABLE permissao (
id_permissao INTEGER PRIMARY KEY auto_increment,
tipo VARCHAR(20)
);

CREATE TABLE usuario (
id_usuario INTEGER PRIMARY KEY auto_increment,
nome VARCHAR(50),
senha VARCHAR(50),
email VARCHAR(50),
endereco VARCHAR(50),
id_permissao INTEGER,
FOREIGN KEY(id_permissao) REFERENCES permissao (id_permissao)
);

CREATE TABLE compra (
id_compra INTEGER PRIMARY KEY auto_increment,
valor_compra DECIMAL(6),
data_compra DATE,
id_usuario INTEGER,
FOREIGN KEY(id_usuario) REFERENCES usuario (id_usuario)
);

CREATE TABLE passagem (
id_passagem INTEGER PRIMARY KEY auto_increment,
empresa VARCHAR(50),
embarque VARCHAR(50),
desembarque VARCHAR(50),
valor_passagem DECIMAL(6),
data_passagem DATE
);

CREATE TABLE hospedagem (
id_hospedagem INTEGER PRIMARY KEY auto_increment,
empresa VARCHAR(50),
endereco VARCHAR(50),
valor_diaria DECIMAL(6),
data_hospedagem DATE
);

CREATE TABLE item_passagem (
qtd_item DECIMAL(6),
valor_item DECIMAL(6),
id_passagem INTEGER,
id_compra INTEGER,
FOREIGN KEY(id_passagem) REFERENCES passagem (id_passagem),
FOREIGN KEY(id_compra) REFERENCES compra (id_compra)
);

CREATE TABLE item_hospedagem (
valor_item DECIMAL(6),
qtd_item DECIMAL(6),
id_hospedagem INTEGER,
id_compra INTEGER,
FOREIGN KEY(id_hospedagem) REFERENCES hospedagem (id_hospedagem),
FOREIGN KEY(id_compra) REFERENCES compra (id_compra)
);

ALTER TABLE hospedagem add imagem varchar(70);
