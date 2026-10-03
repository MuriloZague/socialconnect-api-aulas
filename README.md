# SocialConnect API

> API RESTful de gestão para instituições sociais (ONGs, bancos de alimentos,
> CRAS, abrigos). Conecta doadores, voluntários e beneficiários.

**Disciplina:** ITE005 — Tópicos Especiais em Sistemas para Internet III
**Stack:** Java 21 · Spring Boot 4.1.1 · JPA · H2 (dev) · PostgreSQL (prod)

---

## Como Rodar

### Pré-requisitos

- JDK 21 LTS ([Adoptium](https://adoptium.net/))
- Maven 3.9+ (ou use o wrapper: `./mvnw`)
- IDE: IntelliJ IDEA (recomendado) ou VS Code

### Passos

```bash
# 1. Clone o repositório
git clone <url-do-repo>
cd socialconnect-api

# 2. Compile o projeto
mvn clean compile

# 3. Rode a aplicação
mvn spring-boot:run
```

### Endereços úteis (com a aplicação rodando)

| Recurso | URL |
|---------|-----|
| Swagger UI | http://localhost:8080/swagger-ui.html |
| OpenAPI (JSON) | http://localhost:8080/api-docs |
| Console H2 | http://localhost:8080/h2-console (JDBC URL `jdbc:h2:mem:socialconnectdb`, usuário `sa`, sem senha) |

### Testes

```bash
# Todos os testes (os de integração exigem Docker rodando, usam PostgreSQL 17 via Testcontainers)
mvn clean test

# Só os testes unitários (sem Docker)
mvn test -Dtest='*ServiceTest,*ValidatorTest'
```

---

## Estrutura do Projeto

Cada módulo segue a arquitetura em camadas `controller → service → repository`:

```
src/main/java/br/com/socialconnect/api/
├── beneficiarios/   # controller, dto, model, repository, service
├── doacoes/         # controller, dto, model, repository, service
├── doadores/        # model, repository
├── produtos/        # controller, dto, model, repository, service (Avaliação A1)
├── config/          # i18n e serialização de Page
├── exception/       # GlobalExceptionHandler + Problem Details (RFC 7807)
└── validation/      # validações customizadas (@CPF, @DataNaoFutura, @EstoqueNaoNegativo)

src/main/resources/db/migration/   # migrations Flyway (V1 a V4)
```

---

## Endpoints Principais

Todos os erros são devolvidos no formato **Problem Details (RFC 7807)**.

### Produtos — `/api/v1/produtos` (Avaliação A1)

| Método | Rota | Descrição | Respostas |
|--------|------|-----------|-----------|
| GET | `/api/v1/produtos?page=0&size=10&sort=nome,asc&nome=arroz&categoria=ALIMENTO` | Lista paginada; filtros opcionais `nome` (parcial) e `categoria` | 200, 400 |
| GET | `/api/v1/produtos/{id_produto}` | Busca por ID | 200, 404 |
| POST | `/api/v1/produtos` | Cadastra produto (`Location` no cabeçalho) | 201, 400, 409, 422 |
| PUT | `/api/v1/produtos/{id_produto}` | Atualização total | 200, 400, 404, 409, 422 |
| DELETE | `/api/v1/produtos/{id_produto}` | Remove produto | 204, 404 |

Regras de negócio:

- **Estoque não negativo:** `estoqueAtual < 0` → **422 Unprocessable Entity**.
- **Nome único** (sem diferenciar maiúsculas/minúsculas) → **409 Conflict**.
- **Alerta de estoque baixo:** a resposta traz `estoqueBaixo = true` quando `estoqueAtual < estoqueMinimo`.

Exemplo de corpo para `POST`/`PUT`:

```json
{
  "nome": "Arroz 5kg",
  "categoria": "ALIMENTO",
  "estoqueAtual": 3,
  "estoqueMinimo": 10,
  "unidadeMedida": "unidade"
}
```

Categorias: `ALIMENTO`, `ROUPA`, `HIGIENE`, `OUTROS`.

### Beneficiários — `/api/v1/beneficiarios`

`GET` (paginado, filtros `nome` e `cpf`), `GET /{idBeneficiario}`, `POST`, `PUT /{idBeneficiario}`, `PATCH /{idBeneficiario}`, `DELETE /{idBeneficiario}`.

### Doações — `/api/v1/doacoes`

`GET` (paginado, filtros `dataInicio`, `dataFim` e `tipo`), `GET /{idDoacao}`, `POST`, `PUT /{idDoacao}`, `PATCH /{idDoacao}`, `DELETE /{idDoacao}`.

---

## Uso de IA

O registro de uso de IA generativa está em [`AI_USAGE.md`](AI_USAGE.md).
