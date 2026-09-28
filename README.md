# API de Biblioteca

API REST em Java com Spring Boot para gerenciamento de livros: cadastro, consulta, atualização e exclusão, com validação de dados e tratamento de erros.

Projeto feito para estudo e portfólio em desenvolvimento backend com Java.

## Tecnologias

- Java 17
- Spring Boot 4.1.1 (Web, Data JPA)
- H2 Database
- Bean Validation
- Maven

## Estrutura

```
src/main/java/com/aline/apibiblioteca
├── controller
│   └── LivroController.java
├── model
│   └── Livro.java
├── repository
│   └── LivroRepository.java
├── service
│   └── LivroService.java
├── exception
│   ├── LivroNaoEncontradoException.java
│   └── LivroNaoEncontradoExceptionHandler.java
└── validation
    ├── AnoPublicacaoValido.java
    └── AnoPublicacaoValidator.java
```

## Modelo de dados

| Campo | Tipo | Descrição |
|---|---|---|
| id | Integer | Identificador único do livro |
| titulo | String | Título do livro |
| autor | String | Autor do livro |
| anoPublicacao | int | Ano de publicação |

## Como rodar

Pré-requisitos: Java 17 e Maven instalados.

```bash
git clone https://github.com/seu-usuario/api-biblioteca.git
cd api-biblioteca
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`.

## Endpoints

Base: `http://localhost:8080`

### Listar livros

`GET /livros`

```json
[
    {
        "id": 1,
        "titulo": "Dom Casmurro",
        "autor": "Machado de Assis",
        "anoPublicacao": 1899
    }
]
```

### Buscar por ID

`GET /livros/{id}`

Se não existir, retorna `404` com a mensagem `Livro não encontrado`.

### Cadastrar

`POST /livros`

```json
{
    "titulo": "Dom Casmurro",
    "autor": "Machado de Assis",
    "anoPublicacao": 1899
}
```

### Atualizar

`PUT /livros/{id}`

Mesmo corpo do cadastro, com os campos atualizados.

### Excluir

`DELETE /livros/{id}`

Remove o livro se ele existir; caso contrário, retorna `404`.

## Validações

- **Título** e **autor** são obrigatórios — se vazios, a API responde `400 Bad Request`.
- **Ano de publicação** não pode ser maior que o ano atual. A validação é dinâmica (comparada com o ano corrente), então não precisa ser atualizada manualmente a cada virada de ano.

Exemplo de erro de validação:

```json
{
    "titulo": "O título é obrigatório",
    "autor": "O autor é obrigatório",
    "anoPublicacao": "O ano de publicação não pode ser maior que o ano atual"
}
```

## Banco de dados

Usa H2 em memória — os dados são apagados a cada reinício da aplicação.

Console disponível em `http://localhost:8080/h2-console`:

```
JDBC URL: jdbc:h2:mem:biblioteca
User Name: sa
Password: (em branco)
```

## Testando

Pode ser testado com Postman, Insomnia ou o HTTP Client do IntelliJ. Exemplo:

```http
POST http://localhost:8080/livros
Content-Type: application/json

{
    "titulo": "Dom Casmurro",
    "autor": "Machado de Assis",
    "anoPublicacao": 1899
}
```

## Status

- [x] CRUD completo de livros
- [x] Persistência com H2
- [x] Validações de título, autor e ano
- [x] Tratamento de erros (livro não encontrado, validação)
- [ ] Testes automatizados
- [ ] Documentação com Swagger/OpenAPI

## Autora

Feito por **Aline** como parte dos estudos em backend com Java e Spring Boot.
