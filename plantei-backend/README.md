# Plantei Backend

## End-points

### Dados do usuário

- [GET] `/api/usuario/listar` => ira fornecer uma lista (JSON) contendo os dados de todos os usuarios existentes no
  banco de dados.
- [GET] `/api/usuario/{id}` => ira fornecer os dados (JSON) do usuario com o ID fornecido no path da requisicao.
- [POST] `/api/usuario/add` => ira adicionar um usuario novo, cujos dados sao enviados no body da requisicao.
- [PUT] `/api/usuario/alterarDados/{id}` => altera os dados de um usuario, cujo ID é aquele fornecido no path da
  requisicao.
- [DELETE] `/api/usuario/remover/{id}` => remove do banco o usuario cujo ID é fornecido no path da requisição.

### Dados da planta

- [GET] `/api/planta/listar` => ira fornecer uma lista (JSON) contendo os dados de todas as plantas existentes no banco
  de dados.
- [GET] `/api/planta/{id}` => ira fornecer os dados (JSON) da planta com o ID fornecido no path da requisicao.
- [POST] `/api/planta/add` => ira adicionar uma planta nova, cujos dados sao enviados no body da requisicao.
- [PUT] `/api/planta/alterarDados/{id}` => altera os dados de uma planta, cujo ID é aquele fornecido no path da
  requisicao.
- [DELETE] `/api/planta/remover/{id}` => remove do banco a planta cujo ID é fornecido no path da requisição.

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
