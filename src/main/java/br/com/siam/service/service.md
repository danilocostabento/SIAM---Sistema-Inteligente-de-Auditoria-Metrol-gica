# Camada Service

Centraliza regras de negócio, validações, autorização contextual e transações. É a camada compartilhada pelos controllers atuais e pela futura API REST.

Casos como vínculo de evidência, exclusão lógica e alteração de fiscalização devem ser implementados aqui, não duplicados em cada interface.