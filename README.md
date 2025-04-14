# 🧙‍♂️ Guia Brabo das Rotas - RPG CRUD

Bem-vindo ao mundo mágico do seu sistema de RPG! Aqui você vai aprender como usar **cada rota** com carinho, suor e um toque de magia 🪄✨

## 🎲 Personagens

### ➕ Criar personagem
`POST /personagens`

📦 Exemplo de body:
```json
{ 
  "nome": "João da Espada", 
  "nomeAventureiro": "Espadachim das Trevas", 
  "classe": "GUERREIRO", 
  "forcaBase": 6, 
  "defesaBase": 4 
}
```

Lembrete: forçaBase + defesaBase tem que ser **10** certinho!

### 📋 Listar todos os personagens
`GET /personagens`

### 🔍 Buscar personagem por ID
`GET /personagens/{id}` Ex: `GET /personagens/1`

### ✏️ Atualizar nome aventureiro
`PUT /personagens/{id}/nomeAventureiro`

📦 Body (string simples):
```
"Novo Nome Aventureiro"
```

Ex: `"O Implacável"`

### ❌ Remover personagem
`DELETE /personagens/{id}` Ex: `DELETE /personagens/1`

### ✨ Buscar amuleto de um personagem
`GET /personagens/{id}/amuleto` Ex: `GET /personagens/1/amuleto`

### 🎒 Listar itens de um personagem
`GET /personagens/{id}/itens` Ex: `GET /personagens/1/itens`

### ➕ Adicionar item ao personagem
`PUT /personagens/{id}/item?idItem={idItem}` Ex: `PUT /personagens/1/item?idItem=3`

⚠️ Regras mágicas:
* Só pode **1 amuleto** por personagem!
* O item precisa existir!

### ❌ Remover item do personagem
`DELETE /personagens/{id}/item?idItem={idItem}` Ex: `DELETE /personagens/1/item?idItem=3`

## 🪄 Itens Mágicos

### ➕ Criar item mágico
`POST /itens`

📦 Exemplo de body:
```json
{ 
  "nome": "Espada Flamejante", 
  "tipo": "ARMA", 
  "forca": 10, 
  "defesa": 0 
}
```

⚠️ Regras:
* ARMA = defesa **obrigatoriamente 0**
* ARMADURA = força **obrigatoriamente 0**
* AMULETO = pode ter os dois
* Nenhum item pode ter força **e** defesa **0**
* Máximo de 10 por atributo

### 📋 Listar todos os itens
`GET /itens`

### 🔍 Buscar item por ID
`GET /itens/{id}` Ex: `GET /itens/2`

## 💡 Dica Final
Use o Postman com carinho, escolha o método certo (GET, POST, PUT, DELETE) e **lembre de colocar o** `Content-Type: application/json` quando for mandar corpo na requisição 🙌
