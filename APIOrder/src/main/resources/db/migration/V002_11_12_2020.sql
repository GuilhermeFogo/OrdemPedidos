CREATE SEQUENCE SEQ_Cliente
	as int
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    NO CACHE;
GO

create table Cliente(
	id int default next value for SEQ_Cliente,
	name varchar(60),
	email varchar(255),
	phone varchar(20),
	
	constraint PK_Cliente primary key(id)
)