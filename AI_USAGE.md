# Registro de Uso de IA Generativa

> **Política da disciplina:** O uso de IA generativa é permitido como
> assistente. O discente é **integralmente responsável** por testar, auditar e
> defender todo o código entregue, independentemente de como foi gerado.

## Instruções

Para cada aula ou entrega, registre abaixo:
- **Data**
- **Ferramenta** (ChatGPT, Copilot, Claude, etc.)
- **Prompt(s) utilizado(s)** (resumo ou cópia)
- **O que foi feito com a saída** (copiado integralmente, adaptado, usado como referência, descartado)

---

## Registro

| Data | Aula | Ferramenta | Prompt (resumo) | Uso da saída |
|------|------|------------|-----------------|--------------|
| 04/09/2026 | Aula 03 | Claude | "Preencha o modelo de pull request (`.github/pull_request_template.md`) com as mudanças desta entrega" | Descrição do PR `.github/pull-requests/PR-aula-03.md` gerada integralmente pelo Claude a partir das mudanças da entrega; revisada por mim. |
| 04/09/2026 | Aula 04 | Claude | "Gere 3 exemplos de JSONs válidos do recurso Beneficiario com nomes e CPFs fictícios para testar a rota POST no Swagger." | Copiado integralmente e colado na interface do Swagger UI para testar o salvamento no banco de dados. |
| 04/09/2026 | Aula 04 | Claude | "Organize minhas respostas da atividade em um arquivo Markdown bem estruturado" | Usado para a modelagem e estilização do `atividade-aula-04.md`: a IA pegou as minhas respostas da atividade e criou o arquivo `.md` (títulos, tabelas, checklist e blocos de código). |
| 04/09/2026 | Aula 04 | Claude | "Preencha o modelo de pull request (`.github/pull_request_template.md`) com as mudanças desta entrega" | Descrição do PR `.github/pull-requests/PR-aula-04.md` gerada integralmente pelo Claude a partir das mudanças da entrega; revisada por mim. |
| 11/09/2026 | Aula 05 | Claude | "Como é a anotação para definir o valor padrão e tamanho da página no Pageable do Controller" | Usado para relembrar a sintaxe da anotação `@PageableDefault(size = 10, sort = "nome")` |
| 11/09/2026 | Aula 05 | Claude | "Como é a sintaxe do Java Record para instanciar um DTO a partir de uma Entity usando o construtor?" | Usado como referência do trecho de código para fazer o mapeamento manual `new BeneficiarioResponseDTO(...)` |
| 11/09/2026 | Aula 05 | Claude | "Preencha o modelo de pull request (`.github/pull_request_template.md`) com as mudanças desta entrega" | Descrição do PR `.github/pull-requests/PR-aula-05.md` gerada integralmente pelo Claude a partir das mudanças da entrega; revisada por mim. |
| 14/09/2026 | Aula 06 | Claude | "Por que a minha validação @NotBlank não está disparando no Controller mesmo com as anotações no DTO?" | Usado para diagnosticar o erro e lembrar de adicionar a anotação `@Valid` antes do `@RequestBody` na assinatura do método. |
| 14/09/2026 | Aula 06 | Claude | "Como usar o springDoc" | Usado para entender documentação. |
| 14/09/2026 | Aula 06 | Claude | "Organize minhas respostas da atividade em um arquivo Markdown bem estruturado" | Usado para a modelagem e estilização do `atividade-aula-06.md`: a IA pegou as minhas respostas da atividade e criou o arquivo `.md` (títulos, tabelas, checklist e blocos de código). |
| 14/09/2026 | Aula 06 | Claude | "Preencha o modelo de pull request (`.github/pull_request_template.md`) com as mudanças desta entrega" | Descrição do PR `.github/pull-requests/PR-aula-06.md` gerada integralmente pelo Claude a partir das mudanças da entrega; revisada por mim. |
| 25/09/2026 | Aula 07 | Claude | "Como funciona a anotação @Testcontainers e a declaração estática do PostgreSQLContainer no JUnit 5?" | Usado como referência para compreender o ciclo de vida do contentor Docker durante a execução dos teste. |
| 25/09/2026 | Aula 07 | ChatGPT | "Tenho a lógica do teste pronta, mas estou na dúvida em qual bloco (Arrange ou Act) deve ficar a chamada do assertThrows para exceções. Como estruturar?" | Usado para entender como aplicar o padrão AAA corretamente quando o teste espera que uma exceção seja lançada. |
| 25/09/2026 | Aula 07 | Claude | "Como posso usar o Mockito.verify() no bloco ASSERT para garantir que o método save() do repositório foi chamado exatamente 1 vez?" | Adaptado para estruturar a verificação de comportamento dos mocks na etapa de Assert. |
| 25/09/2026 | Aula 07 | Claude | "Organize minhas respostas da atividade em um arquivo Markdown bem estruturado" | Usado para a modelagem e estilização do `atividade-aula-07.md`: a IA pegou as minhas respostas da atividade e criou o arquivo `.md` (títulos, tabelas, checklist e blocos de código). |
| 25/09/2026 | Aula 07 | Claude | "Preencha o modelo de pull request (`.github/pull_request_template.md`) com as mudanças desta entrega" | Descrição do PR `.github/pull-requests/PR-aula-07.md` gerada integralmente pelo Claude a partir das mudanças da entrega; revisada por mim. |
| 25/09/2026 | Correção GET beneficiários (pós Aula 07) | Claude | "O professor mandou uma correção da busca por beneficiários (GET) pelo Swagger, não entendi o que significa" | Usado para entender o problema do `Pageable` no Swagger UI e o código enviado pelo professor. A aplicação do código do professor e o tratamento 400 para ordenação por campo inexistente também foram feitos com o Claude e revisados por mim. |
| 25/09/2026 | Correção GET beneficiários (pós Aula 07) | Claude | "Preencha o modelo de pull request (`.github/pull_request_template.md`) com as mudanças desta entrega" | Descrição do PR `.github/pull-requests/PR-fix-busca-beneficiarios-swagger.md` gerada integralmente pelo Claude a partir das mudanças da entrega; revisada por mim. |
| 02/10/2026 | Avaliação A1 | Claude | "Crie um migration v4 para a entidade produtos do projeto" | Claude criou e preencheu a migration 4 ("V4__create_produtos_table.sql"), revisado por mim |
| 02/10/2026 | Avaliação A1 | Claude | "Preencha as mensagens de erro do produto para mim" | Claude preencheu as mensagens de erros e validações da entity de produto para mim |
| 02/10/2026 | Avaliação A1 | Claude | "Por que o meu endpoint POST está retornando 500 em vez de 409 quando o banco acusa erro de unddade no nome do produto?" | Usado para entender como capturar a exceção de integridade no @RestControllerAdvice e retornar o status HTTP 409 Conflict correto com Problem Details |
| 02/10/2026 | Avaliação A1 | Claude | "Qual o código HTTP correto para retornar em regras de negócio violadas quando a requisição está bem formatada mas não pode ser processada (ex: estoque negativo)?" | Usado para confirmar a aplicação do status HTTP 422 Unprocessable Entity. |
| 02/10/2026 | Avaliação A1 | Claude | "Preencha os modelos README, pull request da av1 e adicione os novos tópicos no AI_USAGE.md de acordo como pedido na av1" | Claude alterou e preencheu as docs em md. |

---

## Declaração de Uso de IA (A1)

### Ferramentas utilizadas:
- [x] ChatGPT / Claude / Gemini
- [ ] Copilot / Codeium
- [ ] Nenhuma

### Como utilizei:
- Usei IA para escrever o migration sql.
- Usei IA para escrever os erros da entity de Produtos do projeto.
- Usei IA para atualizar o README e preencher a descrição do PR.
- Usei IA para tirar dúvidas sobre um erro de requisicao 409.

### O que eu entendo 100%:
- A lógica de validação de estoque negativo (validação customizada `@EstoqueNaoNegativo` no DTO + checagem no service) e por que ela retorna 422 e não 400.
- A regra de nome único (409) e o cálculo de `estoqueBaixo` no mapeamento para o DTO de resposta.

### O que precisei estudar mais:
- Como o `GlobalExceptionHandler` identifica qual anotação de Bean Validation falhou (`FieldError.getCode()`) para trocar o status de 400 para 422.

---

_Declaração: Ao submeter este repositório, confirmo que todo o código foi
revisado, testado e compreendido por mim._