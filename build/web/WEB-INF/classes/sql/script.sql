drop database if exists aula;
create database aula;

use aula;

create table cliente(
    codcliente  integer         auto_increment      primary key,
    nome        varchar(50)     not null,
    email       varchar(35)     not null
);

create table endereco(
    codendereco integer         auto_increment      primary key,
    logradouro  varchar(50)     not null,
    cidade      varchar(50)     not null,
    estado      varchar(35)     not null,
    codcliente  integer         not null            unique,
    foreign key (codcliente) references cliente (codcliente)
);

desc cliente;
desc endereco;
