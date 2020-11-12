CREATE DATABASE controleestoque;

CREATE TABLE produto(
	id_produto INT PRIMARY KEY AUTO_INCREMENT,
    preco_produto DOUBLE NOT NULL,
	estoque_produto INTEGER NOT NULL,
    nome_produto VARCHAR(100) NOT NULL,
    prodserv VARCHAR(1)
);


CREATE TABLE veiculo(
	id_veiculo INT PRIMARY KEY AUTO_INCREMENT,
    nome_veiculo VARCHAR(100),
    placa_veiculo VARCHAR(15)

);

CREATE TABLE cliente(
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nome_cliente VARCHAR(100) NOT NULL,
    cpfcnpj_cliente VARCHAR(20) NOT NULL UNIQUE,
    contato_cliente VARCHAR(100),
    email_cliente VARCHAR(100),
    cidade_cliente VARCHAR(50),
    estado_cliente VARCHAR(20),
    id_veiculo INT,
    CONSTRAINT fk_veicli FOREIGN KEY (id_veiculo) REFERENCES veiculo(id_veiculo)
	
);

CREATE TABLE venda(
	id_venda INT PRIMARY KEY AUTO_INCREMENT,
    data_venda DATE,
    valorTotal DOUBLE,
    id_cli INT,
    CONSTRAINT fk_itcli FOREIGN KEY (id_cli) REFERENCES cliente(id_cliente)
);

CREATE TABLE itens_venda(
	id_itv INT PRIMARY KEY AUTO_INCREMENT,
    quantidade_produtos_itv INT,
    status_itv VARCHAR(1),
    valorParcial DOUBLE,
    id_produto INTEGER,
    id_venda INTEGER,
    CONSTRAINT fk_itvenda FOREIGN KEY (id_venda) REFERENCES venda(id_venda),
    CONSTRAINT fk_itvprod FOREIGN KEY (id_produto) REFERENCES produto(id_produto)

);

