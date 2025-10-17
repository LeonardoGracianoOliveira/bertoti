<h1> 📚 Sistema de Biblioteca (Java + SQLite) </h1>
<h2>🧾 Descrição</h2>

<p>Aplicação em Java puro, estruturada em camadas (Model, DAO, Database, Main), com persistência de dados em SQLite.
O sistema realiza operações completas de CRUD (Criar, Ler, Atualizar, Deletar) para gerenciar Usuários, Bibliotecas, Livros e Testes.
O projeto demonstra como integrar banco de dados SQLite a uma aplicação Java, utilizando o padrão DAO e gerenciamento de conexões JDBC.</p>

<h2>⚙️ Funcionalidades</h2>

<ul>
<li>✅ Criação automática do banco de dados e tabelas.</li>
<li>✅ Inserção, atualização, deleção e listagem de registros.</li>
<li>✅ Uso de PreparedStatement para segurança contra SQL Injection.</li>
<li>✅ Estrutura modular e escalável.</li>
<li>✅ Exemplo funcional de integração com o banco na classe Main.</li>
</ul>

<h2>📂 Estrutura do Projeto</h2>
<code> 
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
</code>

<h2>🧠 Tecnologias</h2>

<p>Java 17+</p>
<p>SQLite</p>
<p>Maven (para gerenciar dependências)</p>
<p>JDBC</p>

<ha2>🧩 Dependência Maven</h2>
<code>
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.44.0.0</version>
</dependency>
</code>

<h2>🚀 Como Executar</h2>

<h3>Verifique se o Maven está instalado:</h3>
<p>mvn -v</p>

<h3>Compile o projeto:</h3>
<p>mvn clean compile</p>

<h3>Execute a classe principal:</h3>
<p>mvn exec:java -Dexec.mainClass="org.example.biblioteca.Main"</p>mvn exec:java -Dexec.mainClass="org.example.biblioteca.Main"

<h3>O programa irá:</h3>
<p>Criar o arquivo biblioteca.db</p>
<p>Criar as tabelas automaticamente</p>
<p>Inserir e listar registros de exemplo no banco</p>

<h2>🧩 Exemplo de Saída</h2>
<p>Tabelas verificadas/criadas.</p>
<p>Usuario id em uso: 1 -> org.example.biblioteca.model.Usuario@1ff8b8f</p>
<p>Biblioteca criada id: 2 -> org.example.biblioteca.model.Biblioteca@64c64813</p>
<p>Livro criado id: 1 -> org.example.biblioteca.model.Livro@483bf400</p>
<p>Livros no DB:</p>
<p>org.example.biblioteca.model.Livro@326de728</p>
<p>Atualizado? true -> org.example.biblioteca.model.Livro@25618e91</p>
<p>Teste criado id: 1 -> org.example.biblioteca.model.Teste@2cfb4a64</p>

<h2>👤 Autor</h2>
<p>Desenvolvido por Leonardo Oliveira</p>
<p>📅 Projeto acadêmico para prática de integração Java + SQLite.</p>

<h1>🤖 Cliente Java para Ollama (IA Local)</h1>
<h2>🧾 Descrição</h2>

<p>Projeto em Java que se conecta ao servidor local do Ollama, permitindo enviar perguntas e receber respostas diretamente de modelos de linguagem (LLMs) como llama3, mistral, gemma, etc.</p>
<p>Demonstra como integrar Java com APIs HTTP e manipular requisições JSON para interação com uma IA local, sem depender de serviços externos.</p>

<h2>⚙️ Funcionalidades</h2>

<p>✅ Conexão HTTP direta com o servidor Ollama.</p>
<p>✅ Envio de perguntas para o modelo de linguagem.</p>
<p>✅ Recebimento e exibição da resposta no terminal.</p>
<p>✅ Estrutura modular com classes separadas para Cliente e Modelo.</p>

<h2>📂 Estrutura do Projeto</h2>
<code>
Ollama/
 ├── src/main/java/org/example/ollama/
 │    ├── client/
 │    │    └── OllamaClient.java
 │    ├── model/
 │    │    └── ChatMessage.java
 │    └── MainApp.java
 ├── pom.xml
 └── README.md
</code>

<h2>🧠 Tecnologias</h2>
<p>Java 17+</p>
<p>HTTP Client (java.net.http)</p>
<p>JSON (org.json ou Jackson)</p>
<p>Ollama (servidor local de IA)</p>

<h2>⚙️ Requisitos</h2>
<p>Instalar o Ollama:</p>
<p>👉 https://ollama.com/download</p>
<p>Baixar um modelo (exemplo): ollama pull llama3</p>
<p>Iniciar o servidor: ollama serve</p>

<h2>🚀 Como Executar</h2>
<h3>Compile o projeto:</h3>
<p>>mvn clean compile</p>

<h3>Execute:</h3>h
<p>mvn exec:java -Dexec.mainClass="org.example.ollama.MainApp"</p>

<h3>O terminal solicitará uma pergunta:</h3>
<p>Digite sua pergunta: Qual é a capital do Brasil?</p>

<h3>A IA responderá:</h3>
<p>Resposta: Brasília.</p>

<h2>🔧 Exemplo de Código</h2>
<p>String model = "llama3";</p>
<p>String pergunta = "Explique o que é Java em 1 linha.";</p>
<p>String resposta = client.chat(model, List.of(new ChatMessage("user", pergunta)));</p>
<p>System.out.println("Resposta: " + resposta);</p>

<h2>👤 Autor</h2>
<p>Desenvolvido por Leonardo Oliveira</p>
<p>🤝 Integração de IA Local + Java HTTP API</p>
