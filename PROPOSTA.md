# Proposta de Projeto — SIAM

## 1. Identificação

- **Projeto:** SIAM — Sistema Inteligente de Auditoria Metrológica
- **Curso:** Engenharia da Computação
- **Disciplina:** Programação de Soluções Computacionais
- **Semestre:** 2026/1
- **Instituição:** Universidade São Judas Tadeu
- **Professores:** Cristiane Fidelix e Erica Lopes
- **Equipe:** Danilo Costa Bento, Letícia de Lima Silva, Leonardo Lopes Correia, José Victor Contierro e Renan dos Santos Souza

## 2. Problema e justificativa

Fiscalizações metrológicas exigem registros confiáveis, consulta a históricos e comprovação das ocorrências. Processos manuais ou fragmentados dificultam a rastreabilidade, aumentam retrabalho e tornam a análise de reincidência mais lenta.

O SIAM organiza essas informações em uma plataforma única. A evolução proposta preserva o desktop existente, centraliza os dados em uma API e permite coleta em campo por um aplicativo Kotlin, inclusive com evidências fotográficas enviadas por API.

## 3. Objetivo geral

Evoluir o MVP desktop para uma plataforma de apoio à fiscalização metrológica, com dados online, evidências rastreáveis, indicadores operacionais e futura mobilidade.

## 4. Objetivos específicos

1. Consolidar requisitos funcionais, não funcionais e regras de negócio.
2. Preservar os módulos já implementados e documentar seus limites.
3. Projetar uma API REST com autenticação, autorização e validação.
4. Migrar a persistência para banco online relacional quando a API estiver pronta.
5. Armazenar imagens em object storage gratuito ou de baixo custo, sem colocar binários no banco.
6. Desenvolver um aplicativo Kotlin para consultas e registros em campo.
7. Criar indicadores de volume, status, irregularidades e reincidência.
8. Avaliar IA/RAG como apoio, sempre com revisão e registro da fonte.

## 5. Escopo

**Incluído:** usuários e perfis, postos, bombas, fiscalizações, irregularidades, evidências, histórico, dashboard, API, análise de dados e protótipo mobile.

**Fora do primeiro incremento:** decisão automática de autuação, publicação de normas sem validação, integração com sistemas governamentais e operação offline completa. Esses itens dependem de validação jurídica, técnica e acadêmica.

## 6. Metodologia e entregas

O desenvolvimento será incremental: levantamento, modelagem, API, migração controlada, evidências, analytics, mobile e testes. Cada etapa deve ter critérios de aceite, demonstração e registro no GitHub.

Entregáveis:

- sistema desktop preservado e documentado;
- especificação de requisitos e casos de uso;
- modelo de dados e análise de indicadores;
- API REST documentada;
- banco online e storage configurados sem credenciais no código;
- protótipo ou versão inicial Android em Kotlin;
- testes, vídeo demonstrativo e apresentação.

## 7. Critérios de sucesso

- usuários autenticados acessam somente operações autorizadas;
- cada fiscalização possui autoria, data, status e histórico;
- imagens são enviadas por API e vinculadas por metadados;
- indicadores podem ser filtrados por período, local e irregularidade;
- desktop e mobile consomem contratos consistentes;
- documentação permite reproduzir o ambiente sem expor segredos.

## 8. Alinhamento com ODS

- **ODS 9:** inovação e infraestrutura digital.
- **ODS 12:** apoio ao consumo e à produção responsáveis.
- **ODS 16:** transparência, rastreabilidade e instituições eficazes.
