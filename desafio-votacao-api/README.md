# Desafio Votação API

API de votação para pautas, desenvolvida em **Java + Spring Boot**.  
A aplicação permite criar pautas, abrir sessões de votação, registrar votos e consultar resultados.

## Tecnologias
- Java 21
- Spring Boot 4.0.3
- Spring Data JPA
- H2 (modo persistente)
- MapStruct
- Lombok
- JUnit 5 + Mockito

## Endpoints

### Pautas
- **GET /api/v1/pautas**: Listar todas as pautas
- **GET /api/v1/pautas/{id}**: Buscar pauta por ID
- **POST /api/v1/pautas**: Criar nova pauta

### Sessões de Votação
- **POST /api/v1/sessoes/pauta/{pautaId}**: Abrir sessão de votação para uma pauta
- **GET /api/v1/sessoes/{id}**: Consultar sessão por ID
- **POST /api/v1/sessoes/encerrar/{sessaoId}**: Encerrar sessão manualmente

### Votos
- **POST /api/v1/votos/sessao/{sessaoId}**: Registrar voto
- **GET /api/v1/votos/sessao/{sessaoId}/resultado**: Consultar resultado da sessão

## Regras de negócio
- Apenas um voto por CPF por sessão.
- Sessão só aceita votos enquanto estiver aberta.
- Validação de CPF via serviço fake (ABLE_TO_VOTE / UNABLE_TO_VOTE).
- Sessões podem ter duração personalizada (mínimo 1 minuto).

## Persistência
- O banco H2 é usado em modo **persistente**, garantindo que pautas, sessões e votos **não sejam perdidos ao reiniciar a aplicação**.
- Arquivo do banco: `./data/desafio-votacao-db.mv.db`

## Versionamento da API
- Todos os endpoints estão versionados: `/api/v1/...`
- Estratégia: **versionamento via URL**, permitindo evoluções sem quebrar clientes existentes.

## CORS
- Configuração CORS habilitada para desenvolvimento com front-end React:
```properties
allowedOrigins = http://localhost:3000
allowedMethods = GET, POST, PUT, DELETE, OPTIONS
```

## Como Rodar
```bash
./mvnw clean install
./mvnw spring-boot:run
```
- API disponível em: http://localhost:8080/api/v1/

## Swagger com Documentação da API
- Swagger: http://localhost:8080/swagger-ui/index.html