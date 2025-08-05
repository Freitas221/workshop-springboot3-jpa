# Workshop Spring + Hibernate/JPA

> Projeto exemplo de workshop para API REST usando Spring Boot, Hibernate/JPA, banco H2 em memória para testes e Docker.

---

## 🚀 Tecnologias

- Java 17+
- Spring Boot
- Hibernate / JPA
- Banco H2 (em memória)
- Docker
- Maven 

---

## 📝 Endpoints principais

| Método | Endpoint         | Descrição               |
|--------|------------------|-------------------------|
| GET    | /api/user   | Lista todos usuários    |
| GET    | /api/user/{id} | Busca usuário por ID    |
| POST   | /api/user    | Cria um novo usuário    |
| PUT    | /api/user/{id} | Atualiza usuário        |
| DELETE | /api/user/{id} | Remove usuário          |

---

## 🛠️ Como executar

### Com Docker

```bash
docker build -t workshop-springboot3-jpa .
docker run -p 8080:8080 workshop-springboot3-jpa

