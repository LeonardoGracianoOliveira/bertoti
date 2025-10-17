📚 Sistema de Biblioteca (Java + SQLite)
🧾 Descrição

Aplicação em Java puro, estruturada em camadas (Model, DAO, Database, Main), com persistência de dados em SQLite.
O sistema realiza operações completas de CRUD (Criar, Ler, Atualizar, Deletar) para gerenciar Usuários, Bibliotecas, Livros e Testes.

O projeto demonstra como integrar banco de dados SQLite a uma aplicação Java, utilizando o padrão DAO e gerenciamento de conexões JDBC.

⚙️ Funcionalidades

✅ Criação automática do banco de dados e tabelas.
✅ Inserção, atualização, deleção e listagem de registros.
✅ Uso de PreparedStatement para segurança contra SQL Injection.
✅ Estrutura modular e escalável.
✅ Exemplo funcional de integração com o banco na classe Main.

📂 Estrutura do Projeto
Biblioteca/
 ├── src/main/java/org/example/biblioteca/
 │    ├── dao/
 │    │    ├── BibliotecaDao.java
 │    │    ├── LivroDao.java
 │    │    ├── TesteDao.java
 │    │    └── UsuarioDao.java
 │    ├── db/
 │    │    └── SQLiteConnectionManager.java
 │    ├── model/
 │    │    ├── Biblioteca.java
 │    │    ├── Livro.java
 │    │    ├── Teste.java
 │    │    └── Usuario.java
 │    └── Main.java
 ├── pom.xml
 ├── biblioteca.db  ← criado automaticamente
 └── README.md

🧠 Tecnologias

Java 17+

SQLite

Maven (para gerenciar dependências)

JDBC

🧩 Dependência Maven
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.44.0.0</version>
</dependency>

🚀 Como Executar

Verifique se o Maven está instalado:

mvn -v


Compile o projeto:

mvn clean compile


Execute a classe principal:

mvn exec:java -Dexec.mainClass="org.example.biblioteca.Main"


O programa irá:

Criar o arquivo biblioteca.db

Criar as tabelas automaticamente

Inserir e listar registros de exemplo no banco

🧩 Exemplo de Saída
Tabelas verificadas/criadas.
Usuario id em uso: 1 -> org.example.biblioteca.model.Usuario@1ff8b8f
Biblioteca criada id: 2 -> org.example.biblioteca.model.Biblioteca@64c64813
Livro criado id: 1 -> org.example.biblioteca.model.Livro@483bf400
Livros no DB:
org.example.biblioteca.model.Livro@326de728
Atualizado? true -> org.example.biblioteca.model.Livro@25618e91
Teste criado id: 1 -> org.example.biblioteca.model.Teste@2cfb4a64

👤 Autor

Desenvolvido por Leonardo Oliveira
📅 Projeto acadêmico para prática de integração Java + SQLite.

🤖 Ollama/README.md
🤖 Cliente Java para Ollama (IA Local)
🧾 Descrição

Projeto em Java que se conecta ao servidor local do Ollama, permitindo enviar perguntas e receber respostas diretamente de modelos de linguagem (LLMs) como llama3, mistral, gemma, etc.

Demonstra como integrar Java com APIs HTTP e manipular requisições JSON para interação com uma IA local, sem depender de serviços externos.

⚙️ Funcionalidades

✅ Conexão HTTP direta com o servidor Ollama.
✅ Envio de perguntas para o modelo de linguagem.
✅ Recebimento e exibição da resposta no terminal.
✅ Estrutura modular com classes separadas para Cliente e Modelo.

📂 Estrutura do Projeto
Ollama/
 ├── src/main/java/org/example/ollama/
 │    ├── client/
 │    │    └── OllamaClient.java
 │    ├── model/
 │    │    └── ChatMessage.java
 │    └── MainApp.java
 ├── pom.xml
 └── README.md

🧠 Tecnologias

Java 17+

HTTP Client (java.net.http)

JSON (org.json ou Jackson)

Ollama (servidor local de IA)

⚙️ Requisitos

Instalar o Ollama:
👉 https://ollama.com/download

Baixar um modelo (exemplo):

ollama pull llama3


Iniciar o servidor:

ollama serve

🚀 Como Executar

Compile o projeto:

mvn clean compile


Execute:

mvn exec:java -Dexec.mainClass="org.example.ollama.MainApp"


O terminal solicitará uma pergunta:

Digite sua pergunta: Qual é a capital do Brasil?


A IA responderá:

Resposta: Brasília.

🔧 Exemplo de Código
String model = "llama3";
String pergunta = "Explique o que é Java em 1 linha.";
String resposta = client.chat(model, List.of(new ChatMessage("user", pergunta)));
System.out.println("Resposta: " + resposta);

👤 Autor

Desenvolvido por Leonardo Oliveira
🤝 Integração de IA Local + Java HTTP API

🎲 Sistema Universal de RPG
📖 Descrição

Este projeto documenta a criação de um sistema universal de RPG, projetado para funcionar em qualquer ambientação — fantasia medieval, futurista, moderna ou pós-apocalíptica.
O sistema combina simplicidade mecânica com alta personalização.

⚙️ Estrutura do Sistema

Atributos: Físico, Agilidade, Mente, Social e Essência.

Perícias: Habilidades associadas a atributos (níveis de 0 a 5).

Recursos:

Vida = 8 + Físico

Stamina = 1 + Essência

Sanidade = Essência

Mana = 1 + Mente

Progressão: Níveis de 1 a 20, com 20 XP por nível para evoluir.

Economia: Sistema de Poder de Compra (PdC) em níveis.

Magia: Baseada em círculos (1 a 5), consumo de Mana e aprimoramentos.

Habilidades: Gerais, de Classe, Benefícios e Complicações.

📂 Estrutura de Documentos
RPG/
 ├── docs/
 │    ├── Atributos.md
 │    ├── Pericias.md
 │    ├── Niveis_e_Progressao.md
 │    ├── Sistema_de_Magia.md
 │    ├── Equipamentos.md
 │    ├── Beneficios_e_Complicacoes.md
 │    ├── Poder_de_Compra.md
 │    ├── Origens.md
 │    └── Arquitetura_do_Sistema.md
 ├── LICENSE
 └── README.md

🎯 Objetivos do Projeto

Criar uma base universal para qualquer tipo de RPG.

Oferecer mecânicas equilibradas e fáceis de adaptar.

Disponibilizar expansões temáticas (ex: Fantasia, Cyberpunk, Horror).

🧠 Conceitos-Chave

Origens: ponto de partida dos personagens, com bônus e poderes.

Sanidade: sistema leve para lidar com traumas e insanidade.

Encantamentos: aplicáveis em itens por meio de perícia Arcanismo.

Progressão narrativa: via XP, marcos ou decisão do mestre.

👤 Autor

Desenvolvido por Leonardo Oliveira
📚 Projeto em andamento — criação completa do Capítulo 1: Criação de Personagem concluída.
