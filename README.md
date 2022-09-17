# Plantei

## Descrição do projeto

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

## End-points

### Dados do usuário

- [GET] `/api/usuario/listar` => ira fornecer uma lista (JSON) contendo os dados de todos os usuarios existentes no banco de dados.
- [GET] `/api/usuario/{id}` => ira fornecer os dados (JSON) do usuario com o ID fornecido no path da requisicao.
- [POST] `/api/usuario/add` => ira adicionar um usuario novo, cujos dados sao enviados no body da requisicao.
- [PUT] `/api/usuario/alterarDados/{id}` => altera os dados de um usuario, cujo ID é aquele fornecido no path da requisicao.
- [DELETE] `/api/usuario/remover/{id}` => remove do banco o usuario cujo ID é fornecido no path da requisição.

