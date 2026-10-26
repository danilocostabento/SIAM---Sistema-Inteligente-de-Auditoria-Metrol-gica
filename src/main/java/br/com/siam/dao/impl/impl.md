# Implementação dos DAOs

Implementa as interfaces DAO, consultas parametrizadas, mapeamento de resultados e transações. Falhas de persistência devem ser propagadas com contexto suficiente para a camada Service, sem expor credenciais ou SQL ao usuário.