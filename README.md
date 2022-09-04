# Plantei

## Descrição

O _Plantei_ terá como objetivo, alinhado com as ODS 3 e 12 da ONU, ensinar o usuário a criar sua própria horta dentro de
seu contexto, ao passo que conscientiza sobre educação alimentar, ensinando receitas fáceis e nutritivas a serem feitas
utilizando suas plantações. Dessa forma, o aplicativo incentiva o usuário a ter uma alimentação nutritiva e saudável .

## Build

(será automatizado em breve)

### => Dependencias do projeto

`mvn clean install`

### => Aplicação

`javac PlanteiBackendApplication.java`

`java PlanteiBackendApplication`

A aplicação estará rodando no `localhost:8080`.

## Ferramentas de desenvolvimento

- Java: _Intellij_
- Banco de dados (postgresql): _BeeKeeper Studio_

## Rodar no docker

Rodar o comando:

```sh
make
```

Caso não tenha o comando `make` rodar os seguites comandos:

```sh
docker build --tag plantei-backend .
docker run --rm -it -p 8000:8000 plantei-backend
```
