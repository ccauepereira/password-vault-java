# password-vault-java
> Gerenciador de senhas seguro desenvolvido em Java POO, com proteção por senha mestra, gerador de senhas fortes e avaliação automática de segurança.

[![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/)
[![Status](https://img.shields.io/badge/Status-Active-success?style=for-the-badge)]()
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)]()

---

## 📋 Sobre

Cofre de senhas em Java POO puro, inspirado em gerenciadores profissionais como LastPass e Bitwarden. O projeto implementa os fundamentos de proteção de credenciais, geração de senhas fortes e análise de força.

Primeiro projeto da minha trajetória em **DevSecOps** e **Cibersegurança**.

---

## ⚡ Funcionalidades

- 🔒 **Cofre Protegido** — senha mestra com sistema de 3 tentativas
- 📝 **Gestão de Credenciais** — cadastro manual ou com senha gerada
- 🎲 **Gerador de Senhas** — customizável, com PINs e senhas memoráveis
- 📊 **Análise de Segurança** — avaliação automática de força (0-100)
- 🔍 **Busca e Ordenação** — por site (alfabético) ou força (decrescente)
- ⚠️ **Auditoria** — identifica senhas fracas no cofre

---

## 🛠️ Tecnologias

- **Java 17+**
- **POO** (Encapsulamento, Composição, Sobrecarga, Métodos Estáticos)
- **IntelliJ IDEA**
- **Git/GitHub**

---

## 🏗️ Arquitetura
password-vault-java/
└── src/
└── v1poo/
├── Crendecial.java      → Modelo de credencial
├── CofreSenhas.java     → Gerenciador do cofre
├── GeradorSenhas.java   → Utilitário de geração
└── Cofre.java       → Interface principal (main)

### Classes

**`Crendecial`** — Representa uma credencial individual (site, usuário, senha) com avaliação automática de força.

**`CofreSenhas`** — Gerencia até 100 credenciais via composição. Implementa bloqueio/desbloqueio, ordenação (bubble sort) e busca.

**`GeradorSenhas`** — Classe utilitária estática para geração de senhas aleatórias, PINs e senhas memoráveis.

**`Cofre`** — Interface CLI com menu interativo de 10 opções.

---

## 🚀 Como Executar

```bash
# Clone o repositório
git clone https://github.com/ccauepereira/password-vault-java.git
cd password-vault-java/src

# Compile
javac v1poo/*.java

# Execute
java v1poo.Cofre
```

---

## 🎓 Conceitos Aplicados

### POO
- ✅ Encapsulamento (atributos privados + getters/setters)
- ✅ Composição (`CofreSenhas` TEM várias `Crendecial`)
- ✅ Sobrecarga de Construtores
- ✅ Métodos e Atributos Estáticos
- ✅ Sobrescrita de `toString()`

### Algoritmos
- ✅ Bubble Sort (ordenação)
- ✅ Busca Linear (busca por site)
- ✅ Análise de String caractere a caractere

### Segurança
- ✅ Validação de força multi-fator
- ✅ Sistema de tentativas limitadas
- ✅ Geração aleatória controlada

---

## 🗺️ Roadmap

- [x] **v1.0** — Java POO Puro
- [ ] **v2.0** — Migração para Spring Boot + REST API
- [ ] **v3.0** — Criptografia AES-256 + Hash BCrypt
- [ ] **v4.0** — Frontend Web (React) + Dashboard

---

## 👨‍💻 Autor

**Cauê Cavalcante Pereira**

Estudante de Ciência da Computação e Técnico em Informática no IFCE Maracanaú.  
Foco em desenvolvimento Java e Cibersegurança.

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/ccauepereira)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/cauecpereira)

---

## 📜 Licença

MIT License — sinta-se livre para usar e modificar.

---

<div align="center">

⭐ **Se esse projeto te ajudou, deixe uma estrela!**

</div>
