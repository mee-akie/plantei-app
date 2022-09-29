-- CRIACAO DAS TABELAS
create table Usuario(
	id int not null generated always as identity,
	nome varchar(50) not null,
	email varchar(30) unique not null,
	senha varchar(20) not null,
	endereco varchar(60),
	notificacoes boolean,
	area varchar(7) check(area in ('PEQUENO', 'MEDIO', 'GRANDE', 'NULO')),
	iluminacao varchar(4) check(iluminacao in ('1', '2', '3', '4', '5', 'NULO')),
  	primary key(id)
);

create table Planta(
	id int not null generated always as identity,
	nome varchar(40) not null,
  	primary key(id)
);

create table planta_do_usuario (
	id int not null generated always as identity,
	idade_planta date not null,
	tempo_sem_regar timestamp not null,
	tipo_vaso varchar(15) check(tipo_vaso in ('VASO_PLASTICO', 'GARRAFA_PET', 'VASO_CERAMICA', 'CANTEIRO')),
	id_planta int not null,
	id_usuario int not null,
  	primary key(id),
  	foreign key(id_planta) references planta(id),
  	foreign key(id_usuario) references usuario(id)
);

create table Plantacao(
	nome varchar(40) not null,
	id_usuario int not null,
	id_planta_do_usuario int not null,
	foreign key(id_usuario) references usuario(id),
  	foreign key(id_planta_do_usuario) references planta_do_usuario(id)
);

create table lista_favoritos(
	id_usuario int not null,
	id_planta int not null,
  	foreign key(id_usuario) references usuario(id),
   	foreign key(id_planta) references planta(id)
);

create table Descricao_planta(
	id int not null generated always as identity,
	beneficio varchar(200),
	area_recomendada varchar(7) check(area_recomendada in ('PEQUENO', 'MEDIO', 'GRANDE', 'NULO')),
	regiao_ideal varchar(30) not null,
	iluminacao_ideal int not null,
	qtd_agua int not null,
	freq_regar int not null,
	tempo_colheita int not null,
	freq_adubagem int not null,
	modo_de_plantar varchar(1000),
	id_planta serial unique not null,
    primary key(id),
  	foreign key(id_planta) references planta(id) on delete cascade
);

create table Comida(
	nome varchar(50) not null,
	id_planta int,
    foreign key(id_planta) references planta(id)
);


-- POPULACAO DO BANCO
insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Abigail', 'abigail@gg.com', '123', 'rua augusta do faro', 'true', 'PEQUENO', '5');
insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Robert', 'roro@gg.com', '123abc', 'rua monte cristo', 'false', 'MEDIO', '1');

insert into Planta (nome) values ('carnivora');
insert into Planta (nome) values ('gira-sol');
insert into Planta (nome) values ('hortela');
insert into Planta (nome) values ('cebolinha');

insert into planta_do_usuario (idade_planta, tempo_sem_regar, tipo_vaso, id_planta, id_usuario)
            values ('2022-02-12', '2022-03-21 09:12:02', 'GARRAFA_PET', 1, 1);
insert into planta_do_usuario (idade_planta, tempo_sem_regar, tipo_vaso, id_planta, id_usuario)
            values ('2022-01-03', '2022-02-23 13:12:12', 'VASO_PLASTICO', 1, 2);
insert into planta_do_usuario (idade_planta, tempo_sem_regar, tipo_vaso, id_planta, id_usuario)
            values ('2020-10-12', '2022-03-22 09:43:02', 'CANTEIRO', 3, 2);

insert into Plantacao (nome, id_usuario, id_planta_do_usuario) values ('meuLar', 1, 1);
insert into Plantacao (nome, id_usuario, id_planta_do_usuario) values ('plantei', 2, 2);
insert into Plantacao (nome, id_usuario, id_planta_do_usuario) values ('plantei', 2, 3);

insert into lista_favoritos (id_usuario, id_planta) values (1, 1);
insert into lista_favoritos (id_usuario, id_planta) values (1, 2);
insert into lista_favoritos (id_usuario, id_planta) values (1, 3);
insert into lista_favoritos (id_usuario, id_planta) values (2, 1);
insert into lista_favoritos (id_usuario, id_planta) values (2, 2);

insert into descricao_planta (beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar, id_planta)
            values('bom', 'MEDIO', 'umido', 3, 30, 2, 20, 3, 'plantar com cuidado', 1);
insert into descricao_planta (beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar, id_planta)
            values('bom', 'PEQUENO', 'umido', 4, 33, 1, 22, 5, 'plantar com cuidado', 2);
insert into descricao_planta (beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar, id_planta)
            values('bom', 'GRANDE', 'umido', 1, 20, 3, 20, 2, 'plantar com cuidado', 3);
insert into descricao_planta (beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar, id_planta)
            values('bom', 'GRANDE', 'umido', 1, 20, 3, 20, 2, 'plantar com cuidado', 4);

insert into comida (nome, id_planta) values ('lasanha', 1);
insert into comida (nome, id_planta) values ('polenta', 2);
insert into comida (nome, id_planta) values ('quibe', 3);
insert into comida (nome, id_planta) values ('macarrao', 1);
