create database db_biblioteca;
use db_biblioteca;

create table tbl_login(
	id_login int primary key not null auto_increment,
    nome_usuario varchar(255) not null,
    usuario varchar(20) not null,
    senha varchar(20) not null,
	unique index(id_login)
);

create table tbl_autor(
	id_autor int primary key not null auto_increment,
    autor varchar(255) not null,
    unique index (id_autor)
);

create table tbl_editora(
	id_editora int primary key not null auto_increment,
    editora varchar(255) not null,
    unique index (id_editora)
);

create table tbl_categoria(
	id_categoria int primary key not null auto_increment,
    categoria varchar(255) not null,
    unique index(id_categoria)
);

create table tbl_livros(
	id_livro int primary key not null auto_increment,
    nome varchar(255) not null,
    numero_paginas int not null,
    edicao varchar(20) not null,
    id_autor int not null,
    id_editora int not null,
    id_categoria int not null,
    unique index (id_livro),

    constraint FK_autor_livro
    foreign key (id_autor)
    references tbl_autor (id_autor),

    constraint FK_editora_livro
    foreign key (id_editora)
    references tbl_editora (id_editora),

    constraint FK_categoria_livro
    foreign key (id_categoria)
    references tbl_categoria (id_categoria)
);