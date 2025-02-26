# Authorization API
Essa API realiza o processo de autenticação do paciente

## Descrição
Essa API realiza a autenticação dos pacientes na plataforma de atendimento integrada. 

## Recursos
-   **Endpoint**:  `POST /create`
    
-   **Descrição**: Cria um novo usuário com as credenciais fornecidas.
    
-   **Corpo da Requisição**:
- {
                           "username": "nome_de_usuario",
                           "password": "senha_segura"
                         }

#### Autenticar um usuário

-   **Endpoint**:  `POST /signin`
    
-   **Descrição**: Autentica um usuário e retorna um token JWT.
    
-   **Corpo da Requisição**:
- {
  "username": "nome_de_usuario",
  "password": "senha_segura"
}

## Pré requisitos

Para executar a aplicação localmente é preciso usar :

-   Java 21
-   Maven


Utilizar fazer o comando

```
mvn clean install 

```

### Tecnologias Usadas

-   Spring Web
-   Spring JPA
-   Kafka
-  Spring Stream 
-   PostgreSQL
