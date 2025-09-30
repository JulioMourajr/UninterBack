Collecting workspace information# Gerenciador de Tarefas API

API RESTful para gerenciamento de tarefas e alunos desenvolvida com Spring Boot.

## 📋 Descrição

Este projeto acadêmico é uma API REST que permite gerenciar tarefas e alunos através de endpoints HTTP. A aplicação utiliza Spring Boot, JPA/Hibernate para persistência de dados e MySQL como banco de dados.

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **MySQL 8.0**
- **Lombok**
- **Maven**

## 📦 Pré-requisitos

- Java 17 ou superior
- Docker
- Maven (ou usar o wrapper incluído no projeto)

## 🚀 Como executar o projeto

### 1. Subir o banco de dados MySQL com Docker

Execute o comando abaixo para criar e iniciar um container MySQL:

```bash
docker run --name mysql-tarefas \
-e MYSQL_ROOT_PASSWORD=123456 \
-e MYSQL_DATABASE=db_tarefas \
-p 3306:3306 \
-d mysql:8.0
```

### 2. Executar a aplicação

No diretório raiz do projeto, execute:

```bash
# Usando o Maven Wrapper (recomendado)
./mvnw spring-boot:run

# Ou usando Maven diretamente
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 📚 Endpoints da API

### Tarefas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/tarefas` | Lista todas as tarefas |
| GET | `/api/tarefas/{id}` | Busca tarefa por ID |
| POST | `/api/tarefas` | Cria nova tarefa |
| PUT | `/api/tarefas/{id}` | Atualiza tarefa existente |
| DELETE | `/api/tarefas/{id}` | Remove tarefa |

### Alunos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/aluno` | Lista todos os alunos |
| GET | `/api/aluno/{id}` | Busca aluno por ID |
| POST | `/api/aluno` | Cria novo aluno |
| PUT | `/api/aluno/{id}` | Atualiza aluno existente |
| DELETE | `/api/aluno/{id}` | Remove aluno |

## 📝 Exemplos de uso

### Criar uma tarefa

```json
POST /api/tarefas
Content-Type: application/json

{
  "nome": "Estudar Spring Boot",
  "dataEntrega": "2024-12-31",
  "responsavel": "João Silva"
}
```

### Criar um aluno

```json
POST /api/aluno
Content-Type: application/json

{
  "nome": "Maria Santos",
  "ru": "12345678"
}
```

## 🗄️ Estrutura do Banco de Dados

### Tabela: tarefa
- `id` (BIGINT, AUTO_INCREMENT, PRIMARY KEY)
- `nome` (VARCHAR, NOT NULL)
- `data_entrega` (DATE, NOT NULL)
- `responsavel` (VARCHAR, NOT NULL)

### Tabela: aluno
- `id` (BIGINT, AUTO_INCREMENT, PRIMARY KEY)
- `nome` (VARCHAR, NOT NULL)
- `ru` (VARCHAR, NOT NULL, UNIQUE)

## ⚙️ Configurações

As configurações da aplicação estão no arquivo `application.properties`:

- **Banco de dados**: MySQL na porta 3306
- **Usuário**: root
- **Senha**: 123456
- **Database**: db_tarefas

## 🧪 Testes

Para executar os testes:

```bash
./mvnw test
```

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/example/tarefas/gerenciador_tarefas_api/
│   │       ├── controller/          # Controllers REST
│   │       ├── model/               # Entidades JPA
│   │       ├── repository/          # Repositórios JPA
│   │       └── GerenciadorTarefasApiApplication.java
│   └── resources/
│       └── application.properties   # Configurações da aplicação
└── test/
    └── java/                        # Testes unitários
```

## 👥 Contribuição

Este é um projeto acadêmico. Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request