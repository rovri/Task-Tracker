# Task Tracker CLI

Task Tracker é um projeto simples para gerenciar e acompanhar suas tarefas diretamente do terminal. Ele permite adicionar, atualizar e excluir tarefas, além de marcar seu status como "a fazer", "em progresso" ou "concluído".

## 📌 Funcionalidades

- Adicionar, atualizar e excluir tarefas
- Marcar tarefas como "em progresso" ou "concluído"
- Listar todas as tarefas ou filtrar por status
- Armazenamento de tarefas em um arquivo JSON

## 🚀 Instalação e Uso

1. Baixe o arquivo ZIP na seção [Releases](#) e extraia os arquivos.
2. Abra um terminal na pasta extraída.
3. Utilize os comandos abaixo para interagir com o Task Tracker CLI.

## 🛠️ Comandos

### Adicionar uma nova tarefa:
```sh
task-cli add "Comprar mantimentos"
```
✅ Saída esperada:
```
Tarefa adicionada com sucesso (ID: 1)
```

### Atualizar uma tarefa existente:
```sh
task-cli update {id} "Nova descrição da tarefa"
```
✅ Exemplo:
```sh
task-cli update 1 "Comprar mantimentos e preparar o jantar"
```

### Excluir uma tarefa:
```sh
task-cli delete {id}
```
✅ Exemplo:
```sh
task-cli delete 1
```

### Marcar uma tarefa como "em progresso":
```sh
task-cli mark-in-progress {id}
```

### Marcar uma tarefa como "concluída":
```sh
task-cli mark-done {id}
```

### Listar todas as tarefas:
```sh
task-cli list
```

### Listar tarefas por status:
```sh
task-cli list done       # Exibe apenas as concluídas
task-cli list todo       # Exibe apenas as pendentes
task-cli list in-progress # Exibe apenas as em progresso
```

## 📂 Estrutura do Arquivo JSON
As tarefas são armazenadas em um arquivo `tasks.json` localizado no diretório atual. Cada tarefa segue a estrutura:
```json
{
  "id": 1,
  "description": "Comprar mantimentos",
  "status": "0", // Pode ser 0 = "todo", 1 = "in-progress" ou 2 = "done"
  "createdAt": "2025-02-27T12:00:00Z",
  "updatedAt": "2025-02-27T12:00:00Z"
}
```

## ⚠️ Tratamento de Erros
O programa verifica possíveis erros, como:
- IDs inválidos
- Tentativa de atualizar ou excluir tarefas inexistentes
- Comandos incorretos ou mal formatados

Caso um erro ocorra, uma mensagem explicativa será exibida no terminal.

