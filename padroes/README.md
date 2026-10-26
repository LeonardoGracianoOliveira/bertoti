# 🎬 Minhas Contribuições - CineMindAi

Este documento detalha as minhas contribuições pessoais para o desenvolvimento do **CineMindAi**, um agente inteligente de recomendação de filmes construído com **Spring AI** e **Ollama**. O meu foco principal no projeto foi a concepção, desenvolvimento e validação de toda a interface gráfica do usuário.

## 💻 O que eu desenvolvi

*   **Desenvolvimento do Front-End:** Criei a interface desktop do projeto utilizando Java Swing.
*   **Caixa de Envio de Mensagens:** Implementei o campo de texto na parte inferior da tela e o botão "Enviar" estilizado para que o usuário possa interagir e enviar prompts ao agente de IA.
*   **Sugestões de Perguntas:** Adicionei botões interativos logo acima da caixa de texto com sugestões predefinidas (como "Filmes de ficção científica para pensar", "Algo parecido com Interestelar" e "Uma comédia leve para hoje") para guiar o usuário na descoberta inicial de filmes.
*   **Barra Lateral de Histórico (Sidebar):** Desenvolvi a barra lateral esquerda escura que contém o botão principal de "Nova conversa" e a listagem de "Suas conversas", permitindo o gerenciamento e a visualização do histórico de interações. O sistema permite abrir conversas anteriores ou iniciar uma nova diretamente por este menu.
*   **Testes de UI/UX:** Realizei testes visuais práticos para verificar o funcionamento da interface gráfica e garantir a usabilidade do sistema.
*   **Correções e Atualizações:** Implementei melhorias contínuas, ajustes visuais e correções de bugs identificados durante a fase de validação da interface.

## 🖼️ Interface Desenvolvida

# **Chat Vazio**
<p align="center">
  <img src="TelasCineMindAi/Chat Vazio.png" alt="Descrição da imagem" width="600px">
</p>

# **Primeira Conversa**
<p align="center">
  <img src="TelasCineMindAi/Primeira Conversa.png" alt="Descrição da imagem" width="600px">
</p>

# **Chat com Historico**
<p align="center">
  <img src="TelasCineMindAi/Chat com Historico.png" alt="Descrição da imagem" width="600px">
</p>

# **Com duas Conversas**
<p align="center">
  <img src="TelasCineMindAi/Com duas Conversas.png" alt="Descrição da imagem" width="600px">
</p>

<br>

O layout entregue apresenta uma interface moderna com tema escuro, contendo a marca "CINEMIND" no topo esquerdo, um indicador de status ("Agente conectado") no canto superior direito e uma área central limpa focada na conversação com o usuário.

## 🚀 Como testar a minha contribuição

Para visualizar e testar a interface gráfica em Java Swing que eu construí, é necessário primeiro ter o Ollama rodando localmente e o backend Spring Boot iniciado. 

Em seguida, abra um novo terminal na raiz da pasta do projeto e execute o seguinte comando:

```bash
./mvnw compile exec:java -Dexec.mainClass=br.com.fatec.cinemindai.ui.CineMindSwingApplication
```

*Nota: No ambiente Windows, utilize `mvnw.cmd` no lugar de `./mvnw`.*

A janela da aplicação será aberta. Por padrão, a interface está configurada para consumir a API local em `http://localhost:8080`; caso precise apontar para outra URL, basta definir a propriedade Java `-Dcinemind.api=http://servidor:8080` ao rodar o comando.
