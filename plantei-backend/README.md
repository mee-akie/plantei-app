# Plantei Backend

## End-points

API disponível em [localhost:8080](localhost:8080)

### Dados do usuário

- [GET] `/api/usuario/listar`
  - **Descricao:** Ira fornecer uma lista (JSON) contendo os dados de todos os usuarios existentes no banco de dados.
  - **Exemplo de uso:**
  
    ![image](https://user-images.githubusercontent.com/67126558/204162581-ea3bc16a-b85b-46f7-a816-753a2f4e7810.png)

    - Resposta:
      ```
        [
          {
              "id": 1,
              "email": "abigail@gg.com",
              "nome": "Abigail",
              "senha": "123",
              "endereco": "rua augusta do faro",
              "notificacoes": true,
              "area": "PEQUENO",
              "iluminacao": "5"
          },
          {
              "id": 2,
              "email": "roro@gg.com",
              "nome": "Robert",
              "senha": "123abc",
              "endereco": "rua monte cristo",
              "notificacoes": false,
              "area": "MEDIO",
              "iluminacao": "NULO"
          }
        ]
      
      ```

- [GET] `/api/usuario/{id}`
  - **Descricao:** Ira fornecer os dados (JSON) do usuario com o ID fornecido no path da requisicao.
  - **Exemplo de uso:**

    ![image](https://user-images.githubusercontent.com/67126558/204162677-ae885f94-b1d4-4781-8af5-3659f4b94edd.png)
    
    - Resposta:
      ```
       {
          "id": 2,
          "email": "roro@gg.com",
          "nome": "Robert",
          "senha": "123abc",
          "endereco": "rua monte cristo",
          "notificacoes": false,
          "area": "MEDIO",
          "iluminacao": "NULO"
      }
      ```

- [POST] `/api/usuario/add`
  - **Descricao:** Ira adicionar um usuario novo, cujos dados sao enviados no body da requisicao.
  - **Exemplo de uso:**

    ![image](https://user-images.githubusercontent.com/67126558/204162847-b9987cf4-a208-428d-9c5a-26635129478c.png)

    - Resposta: [200 OK]
      ```
      {
        "id": 11,
        "email": "fakeUser01@gmail.com",
        "nome": "FakeUser01",
        "senha": "123",
        "endereco": "rua sla",
        "notificacoes": true,
        "area": "GRANDE",
        "iluminacao": "4"
      }
      ```
 
- [PUT] `/api/usuario/alterarDados/{id}`
  - **Descricao:** Altera os dados de um usuario, cujo ID é aquele fornecido no path da requisicao.
  - **Exemplo de uso:**
  
    ![image](https://user-images.githubusercontent.com/67126558/204281034-0c0de788-5b11-417b-9b1c-d516e2e0fdc2.png)

    - Resposta: [200 OK]
      ```
      {
        "id": 1,
        "email": "fakeUser06@gmail.com",
        "nome": "FakeUser06",
        "senha": "senhaaaaaaaaaa",
        "endereco": "aaaaaa",
        "notificacoes": false,
        "area": "PEQUENO",
        "iluminacao": "2"
      }
      ```

- [DELETE] `/api/usuario/remover/{id}`
  - **Descricao:** Remove do banco o usuario cujo ID é fornecido no path da requisição.
  - **Exemplo de uso:**
    
    ![image](https://user-images.githubusercontent.com/67126558/204162926-b981bc89-b87f-4c1d-9e04-023da70ebdf8.png)
    
    - Resposta: [200 OK]

### Dados da planta

- [GET] `/api/planta/listar`
  - **Descricao:** Ira fornecer uma lista (JSON) contendo os dados de todas as plantas existentes no banco de dados.
  - **Exemplo de uso:**
  
    ![image](https://user-images.githubusercontent.com/67126558/204281603-d79cadf2-1559-4497-9013-adedf02a8001.png)

    - Resposta:
      ```
      [
        {
            "id": 1,
            "nome": "alecrim",
            "beneficio": "vitamina x",
            "area_recomendada": "MEDIO",
            "regiao_ideal": "umido",
            "iluminacao_ideal": 3,
            "qtd_agua": 30,
            "freq_regar": 2,
            "tempo_colheita": 20,
            "freq_adubagem": 3,
            "modo_de_plantar": "plantar com cuidado"
        },
        {
            "id": 2,
            "nome": "gira-sol",
            "beneficio": "vitamina f",
            "area_recomendada": "PEQUENO",
            "regiao_ideal": "arejado",
            "iluminacao_ideal": 4,
            "qtd_agua": 33,
            "freq_regar": 1,
            "tempo_colheita": 22,
            "freq_adubagem": 5,
            "modo_de_plantar": "plantar com cuidado"
        }
      ]
      ```

- [GET] `/api/planta/{id}`
  - **Descricao:** Ira fornecer os dados (JSON) da planta com o ID fornecido no path da requisicao.
  - **Exemplo de uso:**
  
    ![image](https://user-images.githubusercontent.com/67126558/204282037-ed1c9147-e88f-4e01-a2e4-9b21f0001259.png)
   
   - Resposta:
      ```
      {
        "id": 2,
        "nome": "gira-sol",
        "beneficio": "vitamina f",
        "area_recomendada": "PEQUENO",
        "regiao_ideal": "arejado",
        "iluminacao_ideal": 4,
        "qtd_agua": 33,
        "freq_regar": 1,
        "tempo_colheita": 22,
        "freq_adubagem": 5,
        "modo_de_plantar": "plantar com cuidado"
      }
      ```

- [POST] `/api/planta/add`
  - **Descricao:** Ira adicionar uma planta nova, cujos dados sao enviados no body da requisicao.
  - **Exemplo de uso:**
 
    ![image](https://user-images.githubusercontent.com/67126558/204282895-1faf3b89-86d5-4b8f-9806-9b0470719fe4.png)

   - Resposta: [200 OK]
      ```
      {
        "id": 9,
        "nome": "PlantaFake01",
        "beneficio": "vitamina c",
        "area_recomendada": "PEQUENO",
        "regiao_ideal": "arejado",
        "iluminacao_ideal": 4,
        "qtd_agua": 33,
        "freq_regar": 1,
        "tempo_colheita": 22,
        "freq_adubagem": 5,
        "modo_de_plantar": "plantar com cuidado"
      }
      ```

- [PUT] `/api/planta/alterarDados/{id}`
  - **Descricao:** Altera os dados de uma planta, cujo ID é aquele fornecido no path da requisicao.
  - **Exemplo de uso:**

    ![image](https://user-images.githubusercontent.com/67126558/204283292-3a2dc1e4-e47d-4864-b7e7-ee82a5ac4048.png)

   - Resposta: [200 OK]
      ```
      {
        "id": 4,
        "nome": "PlantaMudouNome",
        "beneficio": "vitamina a",
        "area_recomendada": "PEQUENO",
        "regiao_ideal": "arejado",
        "iluminacao_ideal": 4,
        "qtd_agua": 33,
        "freq_regar": 1,
        "tempo_colheita": 22,
        "freq_adubagem": 5,
        "modo_de_plantar": "plantar com cuidado"
      }
      ```

- [DELETE] `/api/planta/remover/{id}`
  - **Descricao:** Remove do banco a planta cujo ID é fornecido no path da requisição.
  - **Exemplo de uso:**

    ![image](https://user-images.githubusercontent.com/67126558/204283737-4c445d83-8d14-453f-9968-12f654859783.png)

    - Resposta: [200 OK]

### Dados da planta do usuario

- [GET] `/api/plantaDoUsuario/listar/{idUsuario}`
  - **Descricao:** Ira fornecer uma lista (JSON) contendo os dados de todas as plantas
    de um usuario especifico do banco de dados.
  - **Exemplo de uso:**
  
    ![image](https://user-images.githubusercontent.com/67126558/198034454-d9ecc74e-13eb-4764-ac5e-6812dc6c30e1.png)
  
    - Resposta:
      ```
        [
          {
              "id": 2,
              "nome": "plantacao de cenoura da Maria",
              "idade_planta": "2022-01-03",
              "tempo_sem_regar": "2022-02-23 16:12:12",
              "tipo_vaso": "VASO_PLASTICO",
              "planta": {
                  "id": 1,
                  "nome": "carnivora",
                  "beneficio": "bom",
                  "area_recomendada": "MEDIO",
                  "regiao_ideal": "umido",
                  "iluminacao_ideal": 3,
                  "qtd_agua": 30,
                  "freq_regar": 2,
                  "tempo_colheita": 20,
                  "freq_adubagem": 3,
                  "modo_de_plantar": "plantar com cuidado"
              },
              "usuario": {
                  "id": 2,
                  "email": "roro@gg.com",
                  "nome": "Robert",
                  "senha": "123abc",
                  "endereco": "rua monte cristo",
                  "notificacoes": false,
                  "area": "MEDIO",
                  "iluminacao": 1
              }
          },
          {
              "id": 3,
              "nome": "plantacao de beterraba da Maria",
              "idade_planta": "2020-10-12",
              "tempo_sem_regar": "2022-03-22 12:43:02",
              "tipo_vaso": "CANTEIRO",
              "planta": {
                  "id": 3,
                  "nome": "hortela",
                  "beneficio": "bom",
                  "area_recomendada": "GRANDE",
                  "regiao_ideal": "umido",
                  "iluminacao_ideal": 1,
                  "qtd_agua": 20,
                  "freq_regar": 3,
                  "tempo_colheita": 20,
                  "freq_adubagem": 2,
                  "modo_de_plantar": "plantar com cuidado"
              },
              "usuario": {
                  "id": 2,
                  "email": "roro@gg.com",
                  "nome": "Robert",
                  "senha": "123abc",
                  "endereco": "rua monte cristo",
                  "notificacoes": false,
                  "area": "MEDIO",
                  "iluminacao": 1
              }
          }
      ]

      ```

- [GET] `/api/plantaDoUsuario/{id}`
  - **Descricao:** Ira fornecer os dados (JSON) da planta de um usuario com o ID fornecido no path
    da requisicao. OBS: o ID nao se refere ao ID da planta ou do usuario, e sim o ID da tupla da tabela "planta_do_usuario".
  - **Exemplo de uso:**
  
    ![image](https://user-images.githubusercontent.com/67126558/198035692-410084a9-b9e7-4149-881e-9ecd4b413280.png)

    - Resposta:
      ```
        {
          "id": 1,
          "nome": "plantacao de cenoura da Maria",
          "idade_planta": "2022-02-11",
          "tempo_sem_regar": "2022-03-21 09:12:02",
          "tipo_vaso": "CANTEIRO",
          "planta": {
              "id": 2,
              "nome": "gira-sol",
              "beneficio": "bom",
              "area_recomendada": "PEQUENO",
              "regiao_ideal": "umido",
              "iluminacao_ideal": 4,
              "qtd_agua": 33,
              "freq_regar": 1,
              "tempo_colheita": 22,
              "freq_adubagem": 5,
              "modo_de_plantar": "plantar com cuidado"
          },
          "usuario": {
              "id": 1,
              "email": "abigail@gg.com",
              "nome": "Abigail",
              "senha": "123",
              "endereco": "rua augusta do faro",
              "notificacoes": true,
              "area": "PEQUENO",
              "iluminacao": 5
          }
        }

      ```


- [POST] `/api/plantaDoUsuario/add`
  - **Descricao:** Ira adicionar uma planta nova de um usuario, cujos dados sao enviados no body da
    requisicao.
  - **Exemplo de uso:**
  
    ![image](https://user-images.githubusercontent.com/67126558/198063376-ab899fa0-1645-437d-a7f9-3fba8d3e6fc4.png)


    - Resposta: [200 OK]
      ```
        {
            "id": 4,
            "nome": "plantacao de cenoura do Pedro",
            "idade_planta": "2022-02-12",
            "tempo_sem_regar": "2022-03-21 09:12:02",
            "tipo_vaso": "CANTEIRO",
            "planta": {
                "id": 2,
                "nome": "gira-sol",
                "beneficio": "bom",
                "area_recomendada": "PEQUENO",
                "regiao_ideal": "umido",
                "iluminacao_ideal": 4,
                "qtd_agua": 33,
                "freq_regar": 1,
                "tempo_colheita": 22,
                "freq_adubagem": 5,
                "modo_de_plantar": "plantar com cuidado"
            },
            "usuario": {
                "id": 2,
                "email": "roro@gg.com",
                "nome": "Robert",
                "senha": "123abc",
                "endereco": "rua monte cristo",
                "notificacoes": false,
                "area": "MEDIO",
                "iluminacao": 1
            }
        }
      ```

- [PUT] `/api/plantaDoUsuario/alterarDados/{id}`
  - **Descricao:** Altera os dados de uma planta do usuario, cujo ID é aquele fornecido no path da requisicao.
  - **Exemplo de uso:**
  
    ![image](https://user-images.githubusercontent.com/67126558/198062541-04f330fa-0d64-4753-85a8-4d5cc0f18c99.png)
  
    - Resposta: [200 OK]
      ```
        {
            "id": 1,
            "nome": "plantacao de cenoura da Maria",
            "idade_planta": "2022-02-12",
            "tempo_sem_regar": "2022-03-21 09:12:02",
            "tipo_vaso": "CANTEIRO",
            "planta": {
                "id": 2,
                "nome": "gira-sol",
                "beneficio": "bom",
                "area_recomendada": "PEQUENO",
                "regiao_ideal": "umido",
                "iluminacao_ideal": 4,
                "qtd_agua": 33,
                "freq_regar": 1,
                "tempo_colheita": 22,
                "freq_adubagem": 5,
                "modo_de_plantar": "plantar com cuidado"
            },
            "usuario": {
                "id": 1,
                "email": "abigail@gg.com",
                "nome": "Abigail",
                "senha": "123",
                "endereco": "rua augusta do faro",
                "notificacoes": true,
                "area": "PEQUENO",
                "iluminacao": 5
            }
        }
      ```

- [DELETE] `/api/plantaDoUsuario/remover/{id}`
  - **Descricao:** Remove do banco a planta de um usuario cujo ID é fornecido no path da requisição.
  - **Exemplo de uso:**
  
    ![image](https://user-images.githubusercontent.com/67126558/198047042-880bc53f-c8b3-4b38-9308-7db70c005e9e.png)

  
  - Resposta: [200 OK]

### Dados das listas de favoritos

- [GET] `/api/listaFavoritos/listar`
  - **Descricao:** Ira fornecer uma lista (JSON) contendo os dados de todas as listas de favoritos de plantas
    dos usuarios do banco de dados.
  - **Exemplo de uso:**

- [GET] `/api/listaFavoritos/{id}`
  - **Descricao:** 
  - **Exemplo de uso:**

- [POST] `/api/listaFavoritos/add`
  - **Descricao:** 
  - **Exemplo de uso:**

- [DELETE] `/api/listaFavoritos/remover`
  - **Descricao:** 
  - **Exemplo de uso:**

### Dados das comidas

- [GET] `/api/comida/listar/planta/{idPlanta}`
  - **Descricao:**
  - **Exemplo de uso:**

- [GET] `/api/comida/listar/{nome}`
  - **Descricao:** 
  - **Exemplo de uso:**

- [POST] `/api/comida/add`
  - **Descricao:** 
  - **Exemplo de uso:**

- [DELETE] `/api/comida/remover/{nome}`
  - **Descricao:** 
  - **Exemplo de uso:**
