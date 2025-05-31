# 🛒 Projeto de Testes Automatizados — API de Produtos de Maquiagem

Este repositório contém um projeto de testes automatizados desenvolvido para validar os endpoints de uma API de produtos de maquiagem, garantindo a confiabilidade das funcionalidades principais e a integridade dos dados fornecidos.
Os testes abrangem buscas, filtros por marca e validação de informações detalhadas dos produtos.

## 🚀 Tecnologias utilizadas

- **Java 17** ☕
- **IntelliJ IDEA Ultimate** 🧠
- **JUnit 5** 🧪
- (BDD) 🥒 **Cucumber**
- **RestAssured** 🌐
- **Maven** (gestão de dependências) 📦

## 📑 Funcionalidades testadas

- 🔎 Busca de todos os produtos disponíveis
- 💄 Filtro de batons por marca (ex: Covergirl)
- 🆔 Validação de campo específico por ID do produto
- 🔄 Testes dinâmicos para combinações personalizadas de filtros

## 💻 Como executar

Clone o repositório:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

## ✨ Exemplos de uso dos endpoints testados

Buscar todos os produtos:
```bash

curl -X GET "http://makeup-api.herokuapp.com/api/v1/products.json"
```

Filtrar batons da marca Covergirl:
```bash
curl -X GET "http://makeup-api.herokuapp.com/api/v1/products?brand=covergirl&type=lipstick"
```

Contribuições e sugestões são sempre bem-vindas!
Fique à vontade para abrir issues ou pull requests 🤝
