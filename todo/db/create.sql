drop database if exists Locadora;

create database Locadora;

use Locadora;

create table Studio(
    id bigint not null auto_increment,
    cnpj varchar(18) not null,
    empresa varchar(256) not null,
    primary key (id)
);

create table Filme(
    id bigint not null auto_increment,
    nome varchar(256) not null,
    diretor varchar(256) not null,
    ano integer not null,
    preco float not null,
    studio_id bigint not null,
    primary key (id),
    foreign key (studio_id) references Studio(id)
);

insert into Studio(cnpj, empresa) values  ('55.789.390/0008-99', 'Warner Bros');

insert into Studio(cnpj, empresa) values ('71.150.470/0001-40', 'Sony Pictures');

insert into Studio(cnpj, empresa) values ('32.106.536/0001-82', 'Walter Disney');

insert into Studio(cnpj, empresa) values ('84.326.021/0002-21', 'Ghibli Movies');

insert into Filme(nome, diretor, ano, preco, studio_id) values ('Divertidamente', 'Peter Docter', 2015, 20.99, 3);

insert into Filme(nome, diretor, ano, preco, studio_id) values  ('Harry Potter', 'Chris Columbus', 2001, 35.64, 1);

insert into Filme(nome, diretor, ano, preco, studio_id) values ('Homem Aranha 2', 'Sami Rami', 2004, 67.85, 2);

insert into Filme(nome, diretor, ano, preco, studio_id) values ('Viagem de Chihiro', 'Hayao Miyazaki', 2003, 50.00, 4);
