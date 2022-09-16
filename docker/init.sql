# cria o usuario que usara o BD
CREATE USER planteiAdmin WITH ENCRYPTED PASSWORD 'planteiAdmin';

# cria o BD 'plantei'
CREATE DATABASE plantei WITH
        OWNER = planteiAdmin
        ENCODING = 'UTF8'
        TABLESPACE = pg_default
        CONNECTION LIMIT = -1;

# Da acesso total do usuario criado anteriormente no BD 'plantei'
GRANT ALL PRIVILEGES ON DATABASE plantei TO planteiAdmin;

create table Usuario (
        ID_usuario serial PRIMARY KEY,
        nome VARCHAR (50) NOT NULL,
        email VARCHAR (30) NOT NULL,
        senha VARCHAR (15) NOT NULL,
        regiao varchar(40) not null,
        notificacoes varchar(30) not null,
        objetivo varchar(1) not null,
        area varchar(2) not null,
        iluminacao varchar(3) not null
);

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

create table Plantacao(
	ID_plantacao serial primary key,
	nome varchar(40) not null,
	idade_planta date not null,
	tempo_sem_regar date not null,
	tipo_vaso varchar(15) check(tipo_vaso in ('VASO_PLASTICO', 'GARRAFA_PET', 'VASO_CERAMICA', 'CANTEIRO')),
	idUsuario int not null,
	idPlanta int not null
	
);

alter table Plantacao add constraint FK_plantacao_idUsuario foreign key(idUsuario) references Usuario(ID_usuario);
alter table Plantacao add constraint FK_plantacao_idPlanta foreign key(idPlanta) references Planta(ID_planta);

create table lista_favoritos(
	ID_favoritos char(3)
);

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
	ID_comida serial primary key,
	nome varchar(50) not null,
	idPlanta int
);

alter table Comida add constraint FK_comida_idPlanta foreign key(idPlanta) references Planta(ID_planta);
