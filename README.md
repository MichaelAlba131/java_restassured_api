# 🚀 Projeto Java Selenium + BDD + Page Objects

Este repositório contém um projeto de testes automatizados desenvolvido para validar os endpoints de uma API de produtos de maquiagem, garantindo a confiabilidade das funcionalidades principais e a integridade dos dados fornecidos.
Os testes abrangem buscas, filtros por marca e validação de informações detalhadas dos produtos.

Pronto para execuções locais ou em CI/CD via <strong>GitHub Actions</strong>!
<br />
<br />

## 🚀 Tecnologias utilizadas

- **Java 17** ☕
- **IntelliJ IDEA Ultimate** 🧠
- **JUnit 5** 🧪
- (BDD) 🥒 **Cucumber**
- **RestAssured** 🌐
- **Maven** (gestão de dependências) 📦
  <br />

## 📑 Funcionalidades testadas

- 🔎 Busca de todos os produtos disponíveis
- 💄 Filtro de batons por marca (ex: Covergirl)
- 🆔 Validação de campo específico por ID do produto
- 🔄 Testes dinâmicos para combinações personalizadas de filtros
  <br />

## 💉 Injeção de dependências e suporte a múltiplas threads

Para garantir a isolação dos cenários, suportando execução paralela/multithread no Cucumber, utilizamos injeção de dependências baseada em construtor, combinada ao uso de classes de contexto (`ScenarioContext`).  
Assim, cada thread de execução de testes manipula seu próprio contexto, evitando interferências.
<br />
<br />

## 💻 Como executar

Clone o repositório:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```
<br />

## ✨ Exemplos de uso dos endpoints testados

Buscar todos os produtos:
```bash

curl -X GET "http://makeup-api.herokuapp.com/api/v1/products.json"
```

Filtrar batons da marca Covergirl:
```bash
curl -X GET "http://makeup-api.herokuapp.com/api/v1/products?brand=covergirl&type=lipstick"
```
<br />

## 🔀 Branches e Execução de Testes

### 🌱 main
Esta branch contém a configuração **padrão** do projeto, com o Test Runner tradicional do Cucumber.
Os cenários são executados **de forma sequencial** (um após o outro).

### ⚡ parallel_tests_api
Nesta branch, os testes estão configurados para **execução paralela dos cenários**!
O paralelismo é ativado pelo arquivo em `src/test/resources`, permitindo rodar múltiplos cenários ao mesmo tempo e acelerando os testes. `junit-platform.properties`

<br />
<br />


Contribuições e sugestões são sempre bem-vindas!
Fique à vontade para abrir issues ou pull requests 🤝

## Licença
Copyright (c) 2025 Michael Alba.
Todos os direitos reservados.