CREATE SEQUENCE SEQ_Pedido
	as int
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    NO CACHE;
GO

CREATE SEQUENCE SEQ_Comentario
	as int
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    NO CACHE;
GO

create table Pedido(
	id int default next value for SEQ_Pedido,
	descricao varchar(100),
	id_cliente int,
	price int,
	status varchar(30),
	data_inicio date,
	data_fim date,
	
	constraint PK_Pedido primary key(id),
	constraint fk_Cliente_Pedido foreign key(id_cliente) references Cliente(id)
)

create table Comentario(
	id int default next value for SEQ_Comentario,
	id_pedido int,
	data date,
	description varchar(100),
	
	constraint pk_comentario primary key(id),
	constraint fk_pedidos_comentarios foreign key(id_pedido) references Pedido(id)
)
