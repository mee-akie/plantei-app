# cria o usuario que usara o BD
psql postgres -c "CREATE USER planteiAdmin WITH ENCRYPTED PASSWORD 'planteiAdmin';"

# cria o BD 'plantei'
psql postgres -c "CREATE DATABASE plantei WITH
                    OWNER = planteiAdmin
                    ENCODING = 'UTF8'
                    TABLESPACE = pg_default
                    CONNECTION LIMIT = -1;"

# Da acesso total do usuario criado anteriormente no BD 'plantei'
psql postgres -c "GRANT ALL PRIVILEGES ON DATABASE plantei TO planteiAdmin;"

psql postgres -c "create table Usuario (
        ID_usuario serial PRIMARY KEY,
        nome VARCHAR (50) NOT NULL,
        email VARCHAR (30) NOT NULL,
        senha VARCHAR (15) NOT NULL,
        regiao varchar(40) not null,
        notificacoes varchar(30) not null,
        objetivo varchar(1) not null,
        area varchar(2) not null,
        iluminacao varchar(3) not null
);"


