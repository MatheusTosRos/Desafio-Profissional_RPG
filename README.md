# 🧙‍♂️ Sistema de Gerenciamento de RPG

Este projeto é um sistema CRUD para gerenciar **Personagens** e **Itens Mágicos** de um jogo de RPG. A aplicação foi desenvolvida com **Java + Spring Boot**, aplicando os conceitos de **Programação Orientada a Objetos**.

## ✅ Requisitos Funcionais

- Criar/Listar/Buscar/Remover personagens.
- Criar/Listar/Buscar itens mágicos.
- Associar itens mágicos aos personagens.
- Listar e remover itens de um personagem.
- Buscar amuleto de um personagem.
- Validações específicas para cada tipo de item.

---

## 📦 Tecnologias

- Java 17+
- Spring Boot
- Maven
- JPA / Hibernate
- H2 Database (memória)
- REST API

---

## 🚀 Como Executar

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/seu-repo.git
cd seu-repo
```

2. **Rode o projeto com Maven:**

```bash
./mvnw spring-boot:run
```

3. A aplicação iniciará em:

```
http://localhost:8080
```

---

## 📬 Endpoints

### 📁 Personagens

| Método | Rota                         | Descrição                              |
|--------|------------------------------|----------------------------------------|
| POST   | `/personagens`               | Criar um novo personagem               |
| GET    | `/personagens`               | Listar todos os personagens            |
| GET    | `/personagens/{id}`          | Buscar personagem por ID               |
| PUT    | `/personagens/{id}/nomeAventureiro` | Atualizar nome aventureiro     |
| DELETE | `/personagens/{id}`          | Remover personagem                     |
| POST   | `/personagens/{id}/item`     | Adicionar item mágico ao personagem    |
| DELETE | `/personagens/{id}/item/{itemId}` | Remover item mágico do personagem |
| GET    | `/personagens/{id}/itens`    | Listar todos os itens do personagem    |
| GET    | `/personagens/{id}/amuleto`  | Buscar o amuleto do personagem         |

### ✨ Itens Mágicos

| Método | Rota         | Descrição                   |
|--------|--------------|-----------------------------|
| POST   | `/itens`     | Criar um novo item mágico   |
| GET    | `/itens`     | Listar todos os itens       |
| GET    | `/itens/{id}`| Buscar item mágico por ID   |

---

## ⚙️ Regras de Negócio

### Personagem

- Deve ter exatamente 10 pontos distribuídos entre **forçaBase** e **defesaBase**.
- Pode ter **vários itens mágicos**, mas apenas **1 amuleto**.

### Item Mágico

- Tipos permitidos: `ARMA`, `ARMADURA`, `AMULETO`.
- Força e Defesa devem ser **> 0** e **<= 10**.
- Armas devem ter **defesa = 0**.
- Armaduras devem ter **força = 0**.
- Amuletos podem ter força e defesa, mas um personagem pode ter **apenas 1**.

---

## 🛠 Exemplo de JSON

### Criar Personagem

```json
{
  "nome": "Arthur",
  "nomeAventureiro": "Rei da Espada",
  "classe": "GUERREIRO",
  "forcaBase": 6,
  "defesaBase": 4
}
```

### Criar Item Mágico

```json
{
  "nome": "Espada Flamejante",
  "tipo": "ARMA",
  "forca": 7,
  "defesa": 0
}
```

---

## 🗂 Autor

- Nome: Matheus Toscano Rossini
- Curso: Engenharia de Software – UniCesumar
- Atividade: CRUD de RPG

---

## ⚠️ Observações

- Esta aplicação não deve ser usada com auxílio de ferramentas de IA para avaliação.
- O repositório deve ser individual e público.
