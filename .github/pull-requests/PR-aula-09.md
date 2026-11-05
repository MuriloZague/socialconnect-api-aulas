# PR — Aula 09: CORS para o Front-end

**Branch:** `feat/aula09-cors` → `main`
**Data:** 05/11/2026

## O que foi feito

- `CorsConfig`: libera `/api/**` para a origem `http://localhost:5173` (Vite), com os métodos `GET`, `POST`, `PUT`, `DELETE` e `PATCH`.
- `aulas/aula09.html` e `aulas/aula10.html` adicionados ao repositório, como as aulas anteriores.
- README atualizado.

O front-end está em um repositório próprio: [socialconnect-front](https://github.com/MuriloZague/socialconnect-front).

## Como testar

1. `mvn spring-boot:run`.
2. Preflight com a origem permitida → **200** com `Access-Control-Allow-Origin: http://localhost:5173`:
   ```bash
   curl -i -X OPTIONS http://localhost:8080/api/v1/beneficiarios -H "Origin: http://localhost:5173" -H "Access-Control-Request-Method: POST"
   ```
3. Repetir com `Origin: http://evil.example` → **403**.

## Checklist de Qualidade

- [x] Código compila sem erros (`mvn clean compile`)
- [x] Testes unitários passam (`mvn test -Dtest='*ServiceTest,*ValidatorTest'`)
- [ ] Testes de integração passam (precisam de Docker e não foram executados nesta entrega)
- [x] Arquitetura em camadas respeitada (Controller → Service → Repository)
- [x] DTOs separados da Entity
- [x] Injeção de dependência via construtor (sem `@Autowired` em atributo)
- [x] Commits atômicos e descritivos (Conventional Commits)
- [x] `AI_USAGE.md` atualizado

## Uso de IA

- [ ] Não usei IA nesta entrega
- [x] Usei IA — detalhes registrados no `AI_USAGE.md`

## Observações

A origem está fixa em `http://localhost:5173`, como na aula. Em produção ela precisaria vir de configuração.
