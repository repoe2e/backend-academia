# 🏋️ Backend Academia

API REST desenvolvida com **Spring Boot** para gerenciamento de alunos de uma academia. O projeto implementa um CRUD completo com validações de negócio, tratamento de exceções e documentação interativa via Swagger/OpenAPI.

---

## 🚀 Tecnologias

| Tecnologia | Versão |
|---|---|
| Java | 17 |
| Spring Boot | 4.0.6 |
| Lombok | Latest |
| SpringDoc OpenAPI (Swagger) | 2.8.8 |
| Maven | 3.x |

---

## 📁 Estrutura do Projeto

```
backend-academia/
└── src/
    └── main/
        └── java/
            └── br.com.e2etreinamentos.backend_academia/
                ├── controller/
                │   └── AlunoController.java     # Endpoints REST
                ├── dto/
                │   ├── AlunoRequest.java        # Payload de entrada
                │   └── AlunoResponse.java       # Payload de saída
                ├── exception/
                │   ├── BusinessException.java   # Exceção de negócio
                │   └── GlobalExceptionHandler.java
                ├── model/
                │   └── Aluno.java               # Entidade principal
                ├── repository/
                │   └── AlunoRepository.java     # Acesso a dados
                └── service/
                    └── AlunoService.java        # Regras de negócio
```

---

## 📋 Endpoints disponíveis

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/alunos` | Cadastra um novo aluno |
| `GET` | `/alunos` | Lista todos os alunos |
| `GET` | `/alunos/{id}` | Busca aluno por ID |
| `PUT` | `/alunos/{id}` | Atualiza dados de um aluno |
| `DELETE` | `/alunos/{id}` | Remove um aluno |

---

## ✅ Validações de negócio

O campo de cada aluno passa pelas seguintes validações antes de ser persistido:

- **Nome** — obrigatório, não pode ser vazio
- **E-mail** — obrigatório, formato válido e único no sistema
- **Idade** — obrigatória, deve ser maior que zero
- **WhatsApp** — obrigatório, não pode ser vazio

---

## 📦 Payload de exemplo

**Cadastrar aluno — `POST /alunos`**

```json
{
  "nome": "João Silva",
  "email": "joao.silva@email.com",
  "idade": 25,
  "whatsapp": "11999999999"
}
```

---

## 📄 Documentação Swagger

Com a aplicação em execução, acesse a documentação interativa pelos links abaixo:

| Interface | URL |
|---|---|
| **Swagger UI** | [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) |
| **OpenAPI JSON** | [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs) |

---

## ▶️ Como executar

**Pré-requisitos:** Java 17+ e Maven instalados.

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/backend-academia.git

# Entrar na pasta do projeto
cd backend-academia

# Executar a aplicação
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

## 🧪 Executar os testes

```bash
./mvnw test
```

---

## 👨‍💻 Autor

Desenvolvido por **E2E Treinamentos** — `br.com.e2etreinamentos`
