create user leilao identified by leilao123;

grant connect, resource, dba to leilao;

connect leilao/leilao123;

create table usuario(
	codigo number(5) primary key,
	nome varchar2(50) not null,
	idade number(5) not null,
	cpf varchar2(20) not null,
	rg varchar2(15) not null,
	endereco varchar2(100) not null,
	email varchar2(80) not null,
	senha varchar2(8) not null
);
