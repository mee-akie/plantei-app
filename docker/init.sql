CREATE USER planteiAdmin WITH ENCRYPTED PASSWORD 'planteiAdmin';

CREATE DATABASE plantei WITH
        OWNER = planteiAdmin
        ENCODING = 'UTF8'
        TABLESPACE = pg_default
        CONNECTION LIMIT = -1;

GRANT ALL PRIVILEGES ON DATABASE plantei TO planteiAdmin;

create table Usuario(
	ID_usuario serial primary key,
	nome varchar(50) not null,
	email varchar(30) not null,
	senha varchar(20) not null, 
	endereco varchar(60),
	notificacoes char(1) check(notificacoes in ('S', 'N')),
	area varchar(7) check(area in ('PEQUENO', 'MEDIO', 'GRANDE', 'NULO')),
	iluminacao varchar(4) check(iluminacao in ('1', '2', '3', '4', '5', 'NULO'))
);

create table Planta(
	ID_planta serial primary key,
	nome varchar(40) not null
);

create table planta_do_usuario (
	ID_planta_do_usuario serial primary key,
	idade_planta date not null,
	tempo_sem_regar timestamp not null,
	tipo_vaso varchar(15) check(tipo_vaso in ('VASO_PLASTICO', 'GARRAFA_PET', 'VASO_CERAMICA', 'CANTEIRO')),
	idPlanta int not null,
	idUsuario int not null
);

alter table planta_do_usuario add constraint FK_idPlanta_usuario foreign key(idPlanta) references Planta(ID_planta);
alter table planta_do_usuario add constraint FK_idUsuario_usuario foreign key(idUsuario) references Usuario(ID_usuario);


create table Plantacao(
	nome varchar(40) not null,
	idUsuario int not null,
	idPlanta_do_usuario int not null
	
);
alter table Plantacao add constraint FK_plantacao_usuario foreign key(idUsuario) references Usuario(ID_usuario);
alter table Plantacao add constraint FK_plantacao_planta foreign key(idPlanta_do_usuario) references planta_do_usuario(ID_planta_do_usuario);


create table lista_favoritos(
	idUsuario int not null,
	idPlanta int not null
);

alter table lista_favoritos add constraint FK_favorito_usuario foreign key(idUsuario) references Usuario(ID_usuario);
alter table lista_favoritos add constraint FK_favorito_planta foreign key(idPlanta) references Planta(ID_planta);



create table Descricao_planta(
	ID_descricao serial primary key,
	beneficio varchar(200),
	area_recomendada varchar(7) check(area_recomendada in ('PEQUENO', 'MEDIO', 'GRANDE', 'NULO')),
	regiao_ideal varchar(30) not null,
	iluminacao_ideal int not null,
	qtd_agua int not null,
	freq_regar int not null,
	tempo_colheita int not null,
	freq_adubagem int not null,
	modo_de_plantar varchar(1000),
	idPlanta int not null
);

alter table Descricao_planta add constraint FK_descricao_idPlanta foreign key(idPlanta) references Planta(ID_planta);

create table Comida(
	nome varchar(50) not null,
	idPlanta int
);

alter table Comida add constraint FK_comida_idPlanta foreign key(idPlanta) references Planta(ID_planta);

select * from Usuario;
select * from Planta;
select * from planta_do_usuario;
select * from Plantacao;
select * from lista_favoritos;
select * from Descricao_planta;
select * from Comida;

insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Abigail', 'abigail@gg.com', '123', 'rua augusta do faro', 'S', 'PEQUENO', '5');
insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Robert', 'roro@gg.com', '123abc', 'rua monte cristo', 'N', 'MEDIO', '1');

insert into Planta (nome) values ('carnivora');
insert into Planta (nome) values ('gira-sol');
insert into Planta (nome) values ('hortela');

insert into planta_do_usuario (idade_planta, tempo_sem_regar, tipo_vaso, idPlanta, idUsuario) 
            values ('2022-02-12', '2022-03-21 09:12:02', 'GARRAFA_PET', 1, 1);
insert into planta_do_usuario (idade_planta, tempo_sem_regar, tipo_vaso, idPlanta, idUsuario) 
            values ('2022-01-03', '2022-02-23 13:12:12', 'VASO_PLASTICO', 1, 2);
insert into planta_do_usuario (idade_planta, tempo_sem_regar, tipo_vaso, idPlanta, idUsuario) 
            values ('2020-10-12', '2022-03-22 09:43:02', 'CANTEIRO', 3, 2);

insert into Plantacao (nome, idUsuario, idPlanta_do_usuario) values ('meuLar', 1, 1);
insert into Plantacao (nome, idUsuario, idPlanta_do_usuario) values ('plantei', 2, 2);
insert into Plantacao (nome, idUsuario, idPlanta_do_usuario) values ('plantei', 2, 3);

insert into lista_favoritos (idUsuario, idPlanta) values (1, 1);
insert into lista_favoritos (idUsuario, idPlanta) values (1, 2);
insert into lista_favoritos (idUsuario, idPlanta) values (1, 3);
insert into lista_favoritos (idUsuario, idPlanta) values (2, 1);
insert into lista_favoritos (idUsuario, idPlanta) values (2, 2);

insert into descricao_planta (beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar, idPlanta)
            values('bom', 'MEDIO', 'umido', 3, 30, 2, 20, 3, 'plantar com cuidado', 1);
			
insert into descricao_planta (beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar, idPlanta)
            values('bom', 'PEQUENO', 'umido', 4, 33, 1, 22, 5, 'plantar com cuidado', 2);
			
insert into descricao_planta (beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar, idPlanta)
            values('bom', 'GRANDE', 'umido', 1, 20, 3, 20, 2, 'plantar com cuidado', 3);

insert into comida (nome, idPlanta) values ('lasanha', 1);
insert into comida (nome, idPlanta) values ('polenta', 2);
insert into comida (nome, idPlanta) values ('quibe', 3);
insert into comida (nome, idPlanta) values ('macarrao', 1);
