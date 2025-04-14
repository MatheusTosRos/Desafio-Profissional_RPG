# Criação do arquivo completo .md com o conteúdo para download

file_path = '/mnt/data/rpg_crud_routes.md'

markdown_content = """
# 🧙‍♂️ Guia Brabo das Rotas - RPG CRUD

Bem-vindo ao mundo mágico do seu sistema de RPG! Aqui você vai aprender como usar **cada rota** com carinho, suor e um toque de magia 🪄✨

---

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
