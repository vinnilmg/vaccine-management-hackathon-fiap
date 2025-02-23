# 🚀 **MS-USUÁRIOS**

**Ms-Usuários**, um microserviço  para gerenciamento de usuários(titulares e dependentes) e movimentação vacinal (histórico vacinal).

---

## 🛠️ **Tecnologias Utilizadas**

- **Spring Boot 3.3.4**
- **Java 17**
- **Spring Cloud 2023.0.3**
- **Spring Data JPA**
- **Spring Validation**
- **Spring Web**
- **Lombok**
- **ModelMapper**
- **SpringDoc OpenAPI**
- **PostgreSQL**

---

## 🌟 **Funcionalidades**

### 👤 **Usuários (Pacientes : TITULAR E DEPENDENTE)**
- ✅ **Cadastrar usuário**
- ✅ **Atualizar usuário**
- ✅ **Consultar usuário (titular)**
- ✅ **Cadastrar dependente** (Um titular pode ter até 10 dependentes)
- ✅ **Atualizar dependente**
- ✅ **Consultar dependentes de um usuário**

### 💉 **Movimentação Vacina(Histórico Vacinal)**
- ✅ **Cadastrar vacina manualmente**
- ✅ **Validar se vacina existe**
- ✅ **Atualizar uma vacina**
- ✅ **Listar histórico de vacina**
- ✅ **Consultar histórico do dependente por ID do titular**

---

## 📋 **Requisitos**

- **Java 17**
- **Maven**
- **Banco de dados PostgreSQL**

### **📚 Documentação da API**
A documentação da API está disponível através do SpringDoc OpenAPI. Após iniciar o servidor, acesse:

🔗 http://localhost:8082/swagger-ui.html
---
