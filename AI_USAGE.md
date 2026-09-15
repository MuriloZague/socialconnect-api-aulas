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
| 04/09/2026 | Aula 04 | Claude | "Gere 3 exemplos de JSONs válidos do recurso Beneficiario com nomes e CPFs fictícios para testar a rota POST no Swagger." | Copiado integralmente e colado na interface do Swagger UI para testar o salvamento no banco de dados. |
| 11/09/2026 | Aula 05 | Claude | "Como é a anotação para definir o valor padrão e tamanho da página no Pageable do Controller" | Usado para relembrar a sintaxe da anotação `@PageableDefault(size = 10, sort = "nome")` |
| 11/09/2026 | Aula 05 | Claude | "Como é a sintaxe do Java Record para instanciar um DTO a partir de uma Entity usando o construtor?" | Usado como referência do trecho de código para fazer o mapeamento manual `new BeneficiarioResponseDTO(...)` |
| 14/09/2026 | Aula 06 | Claude | "Por que a minha validação @NotBlank não está disparando no Controller mesmo com as anotações no DTO?" | Usado para diagnosticar o erro e lembrar de adicionar a anotação `@Valid` antes do `@RequestBody` na assinatura do método. |
| 14/09/2026 | Aula 06 | Claude | "Como usar o springDoc" | Usado para entender documentação. |

---

_Declaração: Ao submeter este repositório, confirmo que todo o código foi
revisado, testado e compreendido por mim._