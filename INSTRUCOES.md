# Guia de desenvolvimento do SIAM

## Fluxo de trabalho

1. Atualize a branch de integração:
   ```bash
   git checkout dev
   git pull origin dev
   ```
2. Crie uma branch específica:
   ```bash
   git checkout -b feature/nome-da-tarefa
   ```
3. Implemente, documente e teste a mudança.
4. Registre commits semânticos e envie a branch:
   ```bash
   git add .
   git commit -m "feat: descrição da tarefa"
   git push origin feature/nome-da-tarefa
   ```
5. Abra um Pull Request para `dev`, descrevendo requisitos atendidos, testes e impactos.

## Regras técnicas

- Não versionar senhas, tokens, URLs privadas ou arquivos `.env`.
- Toda operação da API deve validar entrada e autorização no servidor.
- Imagens devem ser enviadas ao storage por API; o banco guarda metadados, hash, tipo, tamanho e referência.
- Alterações de banco devem ter migração reproduzível e compatibilidade documentada.
- Requisitos, diagramas e critérios de aceite devem ser atualizados junto da funcionalidade.
- O desktop legado não deve ser quebrado durante a introdução da API; a migração será incremental.

## Critérios para revisão

- atende ao requisito ou caso de uso relacionado;
- mantém separação de responsabilidades;
- trata erros explicitamente;
- possui teste ou evidência de validação;
- não expõe dados pessoais além do necessário;
- atualiza a documentação afetada.

## Ambientes

Use configurações locais para desenvolvimento e variáveis de ambiente para credenciais. O provedor gratuito de banco/storage será definido na etapa de arquitetura após comparar limites, backup, autenticação, privacidade e facilidade de migração.
