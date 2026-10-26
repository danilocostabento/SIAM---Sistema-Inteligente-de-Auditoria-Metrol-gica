# Levantamento de requisitos

## 1. Stakeholders e escopo

| Stakeholder | Necessidade |
|---|---|
| Administrador | gerir usuários, permissões e cadastros |
| Fiscal | registrar e consultar fiscalizações e evidências |
| Gestor | acompanhar indicadores e reincidências |
| Equipe acadêmica | demonstrar processo, arquitetura e resultados |

O primeiro incremento contempla o fluxo autenticado de cadastro, fiscalização, evidência e análise. Integrações oficiais e decisões automáticas ficam fora do escopo inicial.

## 2. Requisitos funcionais

| ID | Requisito | Critério de aceite |
|---|---|---|
| RF01 | Autenticar usuários | credenciais válidas iniciam sessão; inválidas geram erro sem revelar qual campo falhou |
| RF02 | Autorizar por perfil | ADMIN gerencia usuários; FISCAL acessa somente operações permitidas |
| RF03 | Gerenciar usuários | ADMIN cria, consulta, edita e desativa usuários |
| RF04 | Gerenciar postos | usuário autorizado mantém dados e situação do posto |
| RF05 | Gerenciar bombas | usuário autorizado vincula bomba a um posto |
| RF06 | Registrar fiscalização | fiscal informa posto, bomba, data, medições, irregularidade, observações e status |
| RF07 | Consultar fiscalizações | filtros por período, posto, responsável, status e irregularidade |
| RF08 | Manter histórico | alterações registram autor, data, operação e valores relevantes |
| RF09 | Enviar evidência | API valida tipo/tamanho, armazena imagem e vincula seus metadados à fiscalização |
| RF10 | Consultar evidências | usuários autorizados visualizam miniatura, descrição, autoria e data |
| RF11 | Exibir dashboard | sistema apresenta totais, status, irregularidades e reincidência por CNPJ |
| RF12 | Exportar relatório | usuário autorizado exporta dados filtrados sem expor credenciais |
| RF13 | Consumir no mobile | aplicativo Kotlin consulta e registra dados pelos mesmos contratos da API |
| RF14 | Apoiar com IA (futuro) | sistema exibe sugestão com fonte, contexto e revisão humana obrigatória |

## 3. Requisitos não funcionais

| ID | Requisito | Meta/verificação |
|---|---|---|
| RNF01 | Segurança | senha com hash; TLS; autorização no servidor; segredos fora do repositório |
| RNF02 | Desempenho | consultas comuns respondem em até 2 s em condições de referência |
| RNF03 | Upload seguro | limite de tamanho, MIME permitido, nome gerado e validação de conteúdo |
| RNF04 | Disponibilidade | API e banco online monitoráveis; falhas comunicadas claramente |
| RNF05 | Escalabilidade | camadas separadas e API stateless para suportar desktop e mobile |
| RNF06 | Usabilidade | fluxos principais compreensíveis e mensagens de erro acionáveis |
| RNF07 | Acessibilidade | contraste, foco navegável e textos alternativos para imagens |
| RNF08 | Rastreabilidade | cada registro relevante possui autor, timestamps e identificador |
| RNF09 | Privacidade | coletar somente dados necessários e restringir informações pessoais |
| RNF10 | Portabilidade | documentação reproduz o ambiente com Java, API, banco e storage |
| RNF11 | Manutenibilidade | testes, migrations, contratos versionados e documentação atualizada |
| RNF12 | Integridade | transações preservam vínculos entre fiscalização e evidências |

## 4. Regras de negócio

- Uma bomba pertence a um posto ativo.
- Uma fiscalização deve ter responsável, bomba, data e status.
- Evidência não pode ser associada a uma fiscalização inexistente.
- Exclusão deve ser lógica quando houver histórico relacionado.
- Somente o responsável autorizado ou ADMIN pode alterar uma fiscalização.
- IA não pode substituir a decisão do fiscal nem ocultar a fonte usada.

## 5. Priorização

**MVP:** RF01–RF08 e RF11.  
**Próximo incremento:** RF09, RF10 e RF12.  
**Expansão:** RF13 e RF14.
