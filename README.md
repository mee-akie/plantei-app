# Plantei

## Descrição do projeto

O _Plantei_ terá como objetivo, alinhado com as ODS 3 e 12 da ONU, ensinar o usuário a criar sua própria horta dentro de
seu contexto, ao passo que conscientiza sobre educação alimentar, ensinando receitas fáceis e nutritivas a serem feitas
utilizando suas plantações. Dessa forma, o aplicativo incentiva o usuário a ter uma alimentação nutritiva e saudável .

## Docker

### Requisitos

- docker
- docker-compose

### Rodar

Subir a aplicação:

```sh
docker-compose --profile deploy up -d
```

Derrubar a aplicação:

```sh
docker-compose --profile deploy down
```

## Build da aplicação

### 1. Criar o banco de dados no Postgresql

- Requisitos: instalar o **Postgresql**.

**1.1. Usuarios Linux**

- Rode o script `configDBLinuxUsers`

**1.2. Usuarios Windows**

- Abra o shell do Postgresql (psql)
- Execute em sequencia:
  - `CREATE USER planteiadmin WITH ENCRYPTED PASSWORD 'planteiAdmin';`
  - `CREATE DATABASE plantei WITH OWNER = planteiAdmin ENCODING = 'UTF8' TABLESPACE = pg_default CONNECTION LIMIT = -1;`
  - `GRANT ALL PRIVILEGES ON DATABASE plantei TO planteiadmin;`

  ![image](https://user-images.githubusercontent.com/67126558/190192112-0a13c2c3-1277-49d5-893c-f8a32ec7ac8e.png)


### 2. Dependencias do projeto

- Requisitos: instalar o [Maven](https://maven.apache.org/download.cgi).

- Rode o comando `mvn clean install` em seu terminal dentro do diretório do projeto. Ele irá executar o
  arquivo `pom.xml`.

### 3. Subir a aplicação localmente

Executar os seguintes comandos em sequencia:

- `javac PlanteiBackendApplication.java`

- `java PlanteiBackendApplication`


## Aplicação rodando localmente
A aplicação front estará rodando em [http://localhost:80](http://localhost:80/).

O back-end estará rodando em [http://localhost:8080](http://localhost:8080/).

## Ferramentas de desenvolvimento

- Java: [Intellij](https://www.jetbrains.com/pt-br/idea/)
- Banco de dados (postgresql): [BeeKeeper Studio](https://www.beekeeperstudio.io/)
- Testar requisições: [Postman](https://www.postman.com/)
