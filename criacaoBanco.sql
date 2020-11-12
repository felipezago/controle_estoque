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

CREATE TABLE venda(
	id_venda INT PRIMARY KEY AUTO_INCREMENT,
    data_venda DATE,
    valorTotal DOUBLE,
    id_cli INT,
    CONSTRAINT fk_itcli FOREIGN KEY (id_cli) REFERENCES cliente(id_cliente)
);

ALTER TABLE venda ADD CONSTRAINT fk_cli FOREIGN KEY (id_cli) REFERENCES cliente(id_cliente);

	update produto set nome_produto= 'nfisdufds' where id_produto= 4;

update itens_venda set id_produto= 2 where id_itv= 3;

ALTER TABLE venda ADD COLUMN id_cli int not null;

alter table itens_venda add column cod_interno_itv int not null;

ALTER TABLE venda add constraint fk_itvenda foreign key (id_itv) references itens_venda(id_itv);

alter table itens_venda add column status_itv varchar(1) not null;

select cod_interno_itv, produto.nome_produto, status_itv, produto.preco_produto, quantidade_produtos_itv, valorTotal from itens_venda inner join produto on produto.id_produto= itens_venda.id_produto;

ALTER TABLE itens_venda add column id_venda int;

ALTER TABLE itens_venda ADD CONSTRAINT fk_venda FOREIGN KEY (id_venda) REFERENCES venda(id_venda);

select * from produto
;
update itens_venda set id_venda= 4 where status_itv= 'A';

select * from venda;

update itens_venda set valorParcial= (select preco_produto from produto where id_produto= 3 )* quantidade_produtos_itv where id_itv= 35;

update itens_venda set quantidade_produtos_itv= 1 where id_itv= 35;

update itens_venda set quantidade_produtos_itv = quantidade_produtos_itv - 1 where id_itv= 47;

update produto set estoque_produto= 5 where id_produto =3;

update produto set estoque_produto= estoque_produto + 1 where id_produto= 5;

alter table itens_venda	 add column servico varchar(100);

alter table itens_venda add column prodserv varchar(1);


 SELECT venda.id_venda, controleestoque.venda.data_venda,
	controleestoque.cliente.nome_cliente,
	controleestoque.cliente.cpfcnpj_cliente,
	controleestoque.venda.`valorTotal`,
	controleestoque.venda.data_venda,
	controleestoque.itens_venda.`valorParcial`,
	controleestoque.produto.nome_produto,
	controleestoque.itens_venda.servico
FROM controleestoque.itens_venda
	INNER JOIN controleestoque.venda ON 
	 controleestoque.itens_venda.id_venda = controleestoque.venda.id_venda 
	INNER JOIN controleestoque.cliente ON 
	 controleestoque.venda.id_cli = controleestoque.cliente.id_cliente 
	INNER JOIN controleestoque.produto ON 
	 controleestoque.itens_venda.id_produto = controleestoque.produto.id_produto;
     


select prodserv, id_itv, status_itv, quantidade_produtos_itv, servico,
valorParcial from itens_venda where status_itv= 'A' and prodserv= 'S';


select * from itens_venda;

truncate itens_venda

delete from produto

alter table produto drop column produto_estoque int default null;

drop table fabricante;

alter table produto add column prodserv varchar(1);

select  produto.id_produto, id_itv, produto.nome_produto, status_itv, produto.preco_produto, quantidade_produtos_itv, 
valorParcial from itens_venda inner join produto on produto.id_produto= itens_venda.id_produto  where status_itv= 'A' and produto.prodserv= 'S';

SELECT venda.id_venda, controleestoque.cliente.nome_cliente,
	controleestoque.produto.nome_produto,
	controleestoque.produto.preco_produto,
	controleestoque.venda.`valorTotal`,
	controleestoque.itens_venda.`valorParcial`,
	controleestoque.itens_venda.quantidade_produtos_itv,
	controleestoque.cliente.cpfcnpj_cliente,
	controleestoque.cliente.contato_cliente
FROM controleestoque.itens_venda
	INNER JOIN controleestoque.produto ON 
	 controleestoque.itens_venda.id_produto = controleestoque.produto.id_produto 
	INNER JOIN controleestoque.venda ON 
	 controleestoque.itens_venda.id_venda = controleestoque.venda.id_venda 
	INNER JOIN controleestoque.cliente ON 
	 controleestoque.venda.id_cli = controleestoque.cliente.id_cliente
     where controleestoque.itens_venda.id_venda= 26
     
     select * from itens_venda inner join produto on
     itens_venda.id_produto= produto.id_produto
     inner join venda on venda.id_venda = itens_venda.id_venda
     inner join cliente on cliente.id_cliente= venda.id_cli
     where venda.id_venda= 18
     
     select * from vendA
     
     select * from itens_venda where id_venda= 24
