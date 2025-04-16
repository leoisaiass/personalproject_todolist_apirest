# To-Do List API REST

Este é um projeto de uma aplicação de lista de tarefas (To-Do List) construída com Spring Boot, que oferece uma API RESTful para criar, ler, atualizar e excluir tarefas. Ele também implementa a persistência em banco de dados utilizando MySQL e é estruturado de forma a ser facilmente escalável e mantido.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para construção da aplicação backend.
- **Spring Data JPA**: Para a interação com o banco de dados.
- **H2 Database**: Usado para testes, pode ser substituído por MySQL para produção.
- **MySQL**: Banco de dados utilizado para persistência das tarefas.
- **JUnit 5**: Framework para testes unitários.
- **Mockito**: Framework de mocking utilizado para testes.
- **Flyway**: Para gerenciamento de migrações do banco de dados.

## Funcionalidades

A API oferece as seguintes funcionalidades:

- **Listar todas as tarefas**: `GET /todolist`
- **Listar tarefa por ID**: `GET /todolist/{id}`
- **Criar nova tarefa**: `POST /todolist`
- **Marcar tarefa como concluída**: `PUT /todolist/{id}`
- **Excluir tarefa**: `DELETE /todolist/{id}`

## Como Executar o Projeto

### Pré-requisitos

- **Java 21** (ou versão superior)
- **Maven** (ou outra ferramenta de build)
- **MySQL** (opcional, pode usar H2 para testes locais)

### Configuração do Banco de Dados

1. Crie um banco de dados no MySQL:
    ```sql
    CREATE DATABASE todolist_db;
    ```

2. No arquivo `application.properties`, configure a URL do banco de dados:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/todolist_db
    spring.datasource.username=root
    spring.datasource.password=your_password
    ```

3. **Flyway** será utilizado para migrar o banco de dados automaticamente.

### Rodando a Aplicação

1. Clone o repositório:
    ```bash
    git clone https://github.com/leoisaiass/personalproject_todolist_apirest.git
    cd personalproject_todolist_apirest
    ```

2. Compile o projeto:
    ```bash
    mvn clean install
    ```

3. Execute a aplicação:
    ```bash
    mvn spring-boot:run
    ```

4. A aplicação estará rodando no endereço: `http://localhost:8080`

## Testes

### Como rodar os testes

Para rodar os testes unitários:

1. Execute o comando abaixo para rodar os testes:
    ```bash
    mvn test
    ```

### Testes

O projeto inclui testes unitários utilizando JUnit 5 e Mockito, garantindo a qualidade do código e o funcionamento das funcionalidades principais, como criação, atualização e exclusão de tarefas.

## Exemplo de Uso

### Criar uma nova tarefa

**Endpoint**: `POST /todolist`

**Request body**:
```json
{
    "taskName": "Limpar a casa",
    "taskDescription": "Lavar a louça, Limpar o fogão"
}
