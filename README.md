# Plantei

## Descrição

O _Plantei_ terá como objetivo, alinhado com as ODS 3 e 12 da ONU, ensinar o usuário a criar sua própria horta dentro de
seu contexto, ao passo que conscientiza sobre educação alimentar, ensinando receitas fáceis e nutritivas a serem feitas
utilizando suas plantações. Dessa forma, o aplicativo incentiva o usuário a ter uma alimentação nutritiva e saudável .

## Build da aplicação

### 1. Criar o banco de dados no Postgresql

- Requisitos: instalar o **Postgresql**.

**1.1. Usuarios Linux**

- Rode o script `configDBLinuxUsers`

**1.2. Usuarios Windows**

- Abra o shell do Postgresql (psql)
- Execute em sequencia:
    - `CREATE USER planteiAdmin WITH ENCRYPTED PASSWORD 'planteiAdmin';`
    - `CREATE DATABASE plantei WITH OWNER = planteiAdmin ENCODING = 'UTF8' TABLESPACE = pg_default CONNECTION LIMIT = -1;`
    - `GRANT ALL PRIVILEGES ON DATABASE plantei TO planteiAdmin;`
    
  ![image](https://user-images.githubusercontent.com/67126558/190192112-0a13c2c3-1277-49d5-893c-f8a32ec7ac8e.png)


### 2. Dependencias do projeto

- Requisitos: instalar o [Maven](https://maven.apache.org/download.cgi).

- Rode o comando `mvn clean install` em seu terminal dentro do diretório do projeto. Ele irá executar o
  arquivo `pom.xml`.

### 3. Subir a aplicação localmente

Executar os seguintes comandos em sequencia:

- `javac PlanteiBackendApplication.java`

- `java PlanteiBackendApplication`

A aplicação estará rodando em [http://localhost:8080](http://localhost:8080/).

## Ferramentas de desenvolvimento

- Java: _Intellij_
- Banco de dados (postgresql): _BeeKeeper Studio_
