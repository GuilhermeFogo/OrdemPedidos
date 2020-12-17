CREATE SEQUENCE SEQ_Usuario
	as int
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    NO CACHE;
GO

create table Usuario(
	id int default next value for SEQ_Usuario ,
	name varchar(45),
	password varchar(100),
	role varchar(45),
	
	constraint pk_usuario Primary Key(id)
)


insert into Usuario(id, name, password, role) values(0,'Teste', '$2a$10$T2.WYbXnHxARLGgDWc1mpODoWWM8qQ81D9k7lv1VxrgUFk7EVPSAm', 'ADM')