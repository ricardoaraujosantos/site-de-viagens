create database agencia_viajar;
use agencia_viajar;

CREATE TABLE usuario (
id_usuario INT PRIMARY KEY auto_increment,
nome VARCHAR(50),
senha VARCHAR(50),
endereco VARCHAR(50)
);

CREATE TABLE compra (
id_compra INT PRIMARY KEY auto_increment,
data_compra DATE,
valor_compra DECIMAL(6),
id_usuario INT,
FOREIGN KEY(id_usuario) REFERENCES usuario (id_usuario)
);

CREATE TABLE passagem (
id_passagem INT PRIMARY KEY auto_increment,
destino VARCHAR(50),
nome_empresa VARCHAR(50),
valor_passagem DECIMAL(6),
data_passagem DATE,
embarque VARCHAR(50)
);

CREATE TABLE hospedagem (
id_hospedagem INT PRIMARY KEY auto_increment,
nome_empresa VARCHAR(50),
endereco VARCHAR(50),
valor_diaria DECIMAL(6),
tipo_diaria varchar(30),
data_hospedagem DATE
);

CREATE TABLE item_hospedagem (
qtd_itens INT,
valor_itens DECIMAL(6),
id_hospedagem iNT,
id_compra INT,
FOREIGN KEY(id_hospedagem) REFERENCES hospedagem (id_hospedagem),
FOREIGN KEY(id_compra) REFERENCES compra (id_compra)
);

CREATE TABLE item_passagem (
qtd_itens INT,
valor_itens DECIMAL(6),
id_passagem INT,
id_compra INT,
FOREIGN KEY(id_passagem) REFERENCES passagem (id_passagem),
FOREIGN KEY(id_compra) REFERENCES compra (id_compra)
);


