# Camada DAO

Define as interfaces de persistência e as operações necessárias para cada agregado. A camada DAO não deve conter regras de autorização ou lógica de apresentação.

No MVP, a implementação usa JDBC/MySQL. Na evolução, o acesso será concentrado na API e a troca de provedor deve preservar os contratos do domínio.