-- CRIACAO DAS TABELAS
create table Usuario(
	id serial primary key,
	nome varchar(50) not null,
	email varchar(30) unique not null,
	senha varchar(20) not null,
	endereco varchar(60),
	notificacoes boolean,
	area varchar(7) check(area in ('PEQUENO', 'MEDIO', 'GRANDE', 'NULO')),
	iluminacao varchar(4) check(iluminacao in ('1', '2', '3', '4', '5', 'NULO'))
);

create table Planta(
	id serial primary key,
	nome varchar(40) not null,
	beneficio varchar(200),
	area_recomendada varchar(7) check(area_recomendada in ('PEQUENO', 'MEDIO', 'GRANDE', 'NULO')),
	regiao_ideal varchar(30) not null,
	iluminacao_ideal int not null,
	qtd_agua int not null,
	freq_regar int not null,
	tempo_colheita int not null,
	freq_adubagem int not null,
	modo_de_plantar varchar(1000)
);

create table planta_do_usuario (
	id serial primary key,
  nome_plantacao varchar(100) not null,
	idade_planta date not null,
	tempo_sem_regar timestamp not null,
	tipo_vaso varchar(15) check(tipo_vaso in ('VASO_PLASTICO', 'GARRAFA_PET', 'VASO_CERAMICA', 'CANTEIRO')),
	id_planta int not null,
	id_usuario int not null,
	foreign key(id_planta) references planta(id),
	foreign key(id_usuario) references usuario(id)
);

create table lista_favoritos(
	id_usuario int not null,
	id_planta int not null,
	foreign key(id_usuario) references usuario(id),
	foreign key(id_planta) references planta(id)
);

create table Comida(
	id serial primary key,
	nome varchar(50) not null,
	id_planta int,
  foreign key(id_planta) references planta(id)
);


-- POPULACAO DO BANCO
-- Tabela Usuario
insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Abigail', 'abigail@gg.com', '123', 'rua augusta do faro', 'true', 'PEQUENO', '5');
insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Robert', 'roro@gg.com', '123abc', 'rua monte cristo', 'false', 'MEDIO', 'NULO');
insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Eduardo', 'ed@gg.com', '123abcdef', 'rua fagundes', 'false', 'GRANDE', '1');
insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Cleber', 'Clebs@gg.com', '321cc', 'rua ponte da mata', 'true', 'MEDIO', '2');
insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Jessica', 'jess@gg.com', 'j1e2s3s', 'rua euclidas', 'true', 'MEDIO', '3');
insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Carla', 'Carla@gg.com', 'cakk123', 'rua monte feudor', 'false', 'PEQUENO', '4');
insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Heitor', 'hhtor@gg.com', 'htoht', 'rua sapopemba', 'false', 'GRANDE', 'NULO');
insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Rodrigo', 'rods@gg.com', 'rodrod123', 'rua rod cristo', 'false', 'NULO', '3');
insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Aline', 'line@gg.com', 'lili123', 'rua ermes XII', 'false', 'PEQUENO', '2');
insert into usuario (nome, email, senha, endereco, notificacoes, area, iluminacao) values('Pedro', 'ppdro@gg.com', '123321', 'rua piracicaba', 'true', 'GRANDE', '1');

-- Tabela Planta
insert into Planta (nome,beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar)
			values ('alecrim','vitamina x', 'MEDIO', 'umido', 3, 30, 2, 20, 3, 'plantar com cuidado');
insert into Planta (nome,beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar) 
			values ('gira-sol','vitamina f', 'PEQUENO', 'arejado', 4, 33, 1, 22, 5, 'plantar com cuidado');
insert into Planta (nome,beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar) 
			values ('hortela','acalmante', 'GRANDE', 'umido', 1, 20, 3, 20, 2, 'plantar em lugar arejado');
insert into Planta (nome,beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar) 
			values ('tomate','vitamina c', 'GRANDE', 'quente', 5, 25, 2, 30, 3, 'plantar longe do sol');
insert into Planta (nome,beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar) 
			values ('manjerição','estimula hemacias', 'PEQUENO', 'umido', 1, 200, 3, 25, 4, 'plantar perto de um lugar umido');
insert into Planta (nome,beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar) 
			values ('pimenta','vitamina a', 'PEQUENO', 'seco', 2, 70, 1, 15, 3, 'plantar com adubo de qualidade');
insert into Planta (nome,beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar) 
			values ('alface','fonte de fibras', 'MEDIO', 'umido', 3, 120, 2, 20, 2, 'plantar longe do sol');
insert into Planta (nome,beneficio, area_recomendada, regiao_ideal, iluminacao_ideal, qtd_agua, freq_regar, tempo_colheita, freq_adubagem, modo_de_plantar) 
			values ('salsinha','fonte de calcio', 'GRANDE', 'umido', 1, 20, 3, 40, 2, 'plantar com cuidado');

-- Tabela Planta_do_usuario
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2022-02-12', 'fazendinha', '2022-03-21 09:12:02', 'GARRAFA_PET', 1, 1);
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2022-01-03', '', '2022-02-23 13:12:12', 'VASO_PLASTICO', 2, 5);
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2020-10-12', 'lacos', '2022-03-22 09:43:02', 'CANTEIRO', 3, 4);
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2020-10-02', 'happy', '2022-03-21 09:42:02', 'GARRAFA_PET', 4, 3);
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2021-02-12', 'minha colheita', '2022-07-20 02:33:02', 'GARRAFA_PET', 5, 2);
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2019-01-20', 'fazendinha', '2022-08-02 12:43:02', 'CANTEIRO', 6, 1);
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2020-09-11', 'planta do bill', '2022-09-23 14:43:02', 'VASO_CERAMICA', 7, 10);
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2020-03-12', 'vem que tem', '2022-10-21 22:34:02', 'CANTEIRO', 8, 9);
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2020-04-01', '', '2022-06-03 18:11:02', 'VASO_CERAMICA', 3, 8);
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2020-10-12', '', '2022-03-22 19:22:02', 'CANTEIRO', 2, 7);
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2020-10-09', '', '2022-03-21 13:12:09', 'VASO_PLASTICO', 1, 6);
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2020-08-12', '', '2022-04-12 23:23:23', 'VASO_CERAMICA', 4, 5);
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2020-07-07', 'lacos', '2022-05-02 14:59:02', 'VASO_PLASTICO', 5, 4);
insert into planta_do_usuario (idade_planta, nome_plantacao, tempo_sem_regar, tipo_vaso, id_planta, id_usuario) 
            values ('2020-10-12', 'happy', '2022-09-29 19:45:02', 'VASO_CERAMICA', 6, 3);

-- Tabela Lista_favoritos
insert into lista_favoritos (id_usuario, id_planta) values (1, 1);
insert into lista_favoritos (id_usuario, id_planta) values (1, 2);
insert into lista_favoritos (id_usuario, id_planta) values (1, 3);
insert into lista_favoritos (id_usuario, id_planta) values (2, 1);
insert into lista_favoritos (id_usuario, id_planta) values (2, 2);
insert into lista_favoritos (id_usuario, id_planta) values (2, 3);
insert into lista_favoritos (id_usuario, id_planta) values (2, 4);
insert into lista_favoritos (id_usuario, id_planta) values (3, 5);
insert into lista_favoritos (id_usuario, id_planta) values (3, 6);
insert into lista_favoritos (id_usuario, id_planta) values (3, 7);
insert into lista_favoritos (id_usuario, id_planta) values (3, 8);
insert into lista_favoritos (id_usuario, id_planta) values (4, 1);
insert into lista_favoritos (id_usuario, id_planta) values (4, 2);
insert into lista_favoritos (id_usuario, id_planta) values (5, 2);
insert into lista_favoritos (id_usuario, id_planta) values (5, 3);
insert into lista_favoritos (id_usuario, id_planta) values (6, 1);
insert into lista_favoritos (id_usuario, id_planta) values (7, 2);
insert into lista_favoritos (id_usuario, id_planta) values (8, 7);
insert into lista_favoritos (id_usuario, id_planta) values (8, 8);
insert into lista_favoritos (id_usuario, id_planta) values (9, 2);
insert into lista_favoritos (id_usuario, id_planta) values (10, 2);
insert into lista_favoritos (id_usuario, id_planta) values (10, 3);
insert into lista_favoritos (id_usuario, id_planta) values (10, 4);
insert into lista_favoritos (id_usuario, id_planta) values (10, 5);
insert into lista_favoritos (id_usuario, id_planta) values (10, 6);
insert into lista_favoritos (id_usuario, id_planta) values (10, 7);
insert into lista_favoritos (id_usuario, id_planta) values (10, 8);

-- Tabela Comida
insert into comida (nome, id_planta) values ('lasanha', 1);
insert into comida (nome, id_planta) values ('polenta', 2);
insert into comida (nome, id_planta) values ('quibe', 3);
insert into comida (nome, id_planta) values ('macarrao', 1);
insert into comida (nome, id_planta) values ('macarrao', 2);
insert into comida (nome, id_planta) values ('macarrao', 3);
insert into comida (nome, id_planta) values ('macarrao', 4);
insert into comida (nome, id_planta) values ('carne assada', 5);
insert into comida (nome, id_planta) values ('carne assada', 6);
insert into comida (nome, id_planta) values ('carne assada', 7);
insert into comida (nome, id_planta) values ('quibe', 1);
insert into comida (nome, id_planta) values ('quibe', 7);
insert into comida (nome, id_planta) values ('quibe', 8);
insert into comida (nome, id_planta) values ('tutu de feijao', 8);
insert into comida (nome, id_planta) values ('tutu de feijao', 2);
insert into comida (nome, id_planta) values ('tutu de feijao', 3);
insert into comida (nome, id_planta) values ('tutu de feijao', 4);