# Suporte de TI – NRS Norte


MVP acadêmico para registro e acompanhamento de solicitações de suporte técnico do Núcleo Regional de Saúde Norte.

## Funcionalidades
- Autenticação de usuários.
- Abertura de chamados por categoria, prioridade e descrição.
- Listagem e consulta de protocolos.
- Status inicial do chamado: Aberto.
- Interface responsiva com rótulos, foco visível e mensagens textuais.

## Tecnologias
Java 17, Spring Boot, Spring Security, Spring Data JPA, Thymeleaf, H2 (padrão) e PostgreSQL (perfil opcional).

## Executar localmente
1. Instale JDK 17 ou superior e Maven.
2. Na pasta do projeto, execute `mvn spring-boot:run`.
3. Acesse http://localhost:8080.

## Usuários de demonstração
- Colaborador: `colaborador.teste` / `Teste@123`
- Técnico: `tecnico.teste` / `Tecnico@123`

As contas são apenas para demonstração local. Troque ou remova essas credenciais antes de qualquer publicação ou uso real.

## PostgreSQL
Crie um banco chamado `suporte_nrs` e execute:
`mvn spring-boot:run -Dspring-boot.run.profiles=postgres`

Configure `DB_URL`, `DB_USERNAME` e `DB_PASSWORD` como variáveis de ambiente. Não coloque senhas reais no repositório.

## Limitações desta versão
- Usuários de demonstração armazenados em memória.
- O status é criado como "Aberto"; ainda não existe fluxo de atualização por técnico.
- Não há recuperação de senha, anexos, notificações ou trilha de auditoria.
- Antes de uso institucional, implemente gestão persistente de usuários, autorização por propriedade do chamado, auditoria, política de senhas, HTTPS, backups e testes de segurança.

## Privacidade
Utilize somente dados fictícios durante demonstrações acadêmicas. Não insira informações pessoais ou dados institucionais reais.
=======
Sistema web para gerenciamento de solicitações de suporte técnico de Tecnologia da Informação do Núcleo Regional de Saúde Norte (NRS Norte).

## Objetivo

Desenvolver uma solução para centralizar o registro, a organização e o acompanhamento de chamados técnicos, proporcionando maior eficiência e transparência no atendimento aos colaboradores.

## Funcionalidades do MVP

- Autenticação de usuários.
- Abertura de chamados técnicos.
- Classificação por categoria e prioridade.
- Consulta e acompanhamento de solicitações.
- Identificação do status dos chamados.

## Tecnologias previstas

- Java
- Spring Boot
- Spring Security
- PostgreSQL
- HTML, CSS e JavaScript

## Público-alvo

Colaboradores do Núcleo Regional de Saúde Norte e profissional responsável pelo atendimento de suporte técnico.

## Objetivo de Desenvolvimento Sustentável

ODS 16 – Paz, Justiça e Instituições Eficazes, com contribuição local relacionada à meta 16.6.

## Status do projeto

Em desenvolvimento – MVP acadêmico.
