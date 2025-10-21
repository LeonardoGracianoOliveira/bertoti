<h1> ATIVIDADE 1-6</h1>

<h2>Comentário – Trecho 1:</h2>
<p>O texto diferencia engenharia de software de programação e ciência da computação, destacando que o termo “engenharia” carrega a ideia de aplicação sistemática de conhecimentos teóricos para construir algo real, assim como em outras áreas da engenharia. Apesar de criar produtos menos tangíveis, a engenharia de software precisa adotar práticas mais rigorosas, já que o software está cada vez mais presente em aspectos críticos da vida cotidiana. O trecho também aponta que, historicamente, a programação não exigia padrões tão rigorosos, mas essa realidade precisa mudar para garantir confiabilidade.</p>
<p>Diferente das demais engenharias, a engenharia de software lida com um produto intangível — o software não pode ser visto ou tocado fisicamente. Essa característica torna os processos de verificação, validação e controle de qualidade mais complexos, já que os erros não se manifestam de forma visível, mas através de comportamentos inesperados do sistema. Assim, enquanto engenheiros civis ou mecânicos trabalham com estruturas físicas sujeitas a leis materiais, o engenheiro de software atua em um domínio abstrato, onde o rigor lógico e o controle de processos substituem a observação física como forma de garantir a confiabilidade.</p>

<h2>Comentário – Trecho 2:</h2>
<p>O trecho amplia a definição de engenharia de software, mostrando que ela vai além de escrever código — envolve ferramentas, processos e práticas que garantam que o código permaneça valioso ao longo do tempo. O conceito-chave apresentado é “programação integrada ao longo do tempo”, enfatizando a necessidade de pensar na sustentabilidade, manutenção e adaptação do código durante todo o seu ciclo de vida. O texto traz três princípios essenciais para guiar essa prática:</p>

<ul>
  <li><b>Tempo e Mudança:</b> refere-se à inevitabilidade das alterações no software. O código precisa ser projetado de forma que futuras mudanças possam ser feitas com o menor impacto possível. Isso inclui boas práticas de versionamento, modularização e documentação.
</li>
  <li><b>Escala e Crescimento:</b> diz respeito à capacidade do software de se adaptar ao aumento da complexidade e à expansão da base de usuários, dados ou funcionalidades. Projetar com escalabilidade em mente é essencial para que o sistema continue eficiente e funcional mesmo sob maior demanda.</li>
  <li><b>Compensações e Custos (Trade-offs):</b> todo projeto de software exige decisões que equilibram benefícios e desvantagens. Nenhuma escolha técnica é perfeita; é preciso avaliar qual solução atende melhor aos objetivos do projeto considerando prazos, recursos e manutenção.</li>
</ul>

<h2>Execicio 3 - Três exemplos de trade-offs (compensações) em Engenharia de Software:</h2>

<h3>Performance vs. Legibilidade do Código</h3>
<ul>
  <li>Descrição: Código altamente otimizado pode ser mais rápido, mas menos compreensível e mais difícil de manter. Por outro lado, um código claro e bem estruturado pode ser mais lento em alguns casos.</li>
  <li>Impacto: Melhor performance imediata vs. manutenção facilitada no longo prazo.</li>
</ul>

<h3>Tempo de Desenvolvimento vs. Qualidade do Produto</h3>
<ul>
  <li>Descrição: Entregar rapidamente pode ser necessário para aproveitar uma oportunidade de mercado, mas isso pode significar abrir mão de testes ou refinamentos.</li>
  <li>Impacto: Lançamento rápido vs. risco de bugs e necessidade de retrabalho.</li>
</ul>

<h3>Flexibilidade vs. Custo de Implementação</h3>
<ul>
  <li>Descrição: Criar um sistema altamente flexível para suportar muitos cenários futuros aumenta o custo e a complexidade inicial. Desenvolver algo mais simples reduz custos, mas pode dificultar adaptações depois.</li>
  <li>Impacto: Investimento inicial alto para evitar mudanças futuras vs. custo menor agora com possíveis gastos maiores no futuro.</li>
</ul>

<h3>Exemplo prático:</h3>
<p>Imagine uma startup desenvolvendo um aplicativo de entregas. Se ela optar por um design de software altamente escalável e modular (para suportar expansão nacional), o custo e o tempo de desenvolvimento aumentarão. Por outro lado, se escolher uma arquitetura mais simples para lançar rapidamente na cidade local, economiza recursos e entra no mercado mais cedo — mas, ao crescer, precisará reescrever boa parte do sistema. Essa decisão representa um claro trade-off entre velocidade de entrega e escalabilidade futura.</p>

<h2>Sistema de RPG (Java)</h2>
<h3>🧾 Descrição</h3>🧾 Descrição
<p>Aplicação em Java puro, estruturada em camadas (Model e Main), simulando um sistema de RPG de mesa básico. O sistema demonstra a criação e gerenciamento de Arquétipos (classes de personagem), contendo atributos como nome, nível mínimo, custo e descrição. O projeto foca em representar conceitos fundamentais de orientação a objetos, como encapsulamento, construtores, instâncias e relacionamentos entre classes.</p>

<h3>⚙️ Funcionalidades</h3>
<ul>
  <li>✅ Criação e instância de objetos da classe Arquetipo.</li>
  <li>✅ Exemplo funcional de inicialização de personagens no Main.</li>
  <li>✅ Impressão de dados no console com informações completas do arquétipo.</li>
  <li>✅ Estrutura modular e de fácil expansão para futuras implementações (como atributos, perícias, origem etc).</li>
  <li>✅ Código totalmente orientado a objetos, seguindo boas práticas de encapsulamento.</li>
</ul>

<h3>📂 Estrutura do Projeto</h3>
<code>
  MesaRPG/
├── src/main/java/org/example/rpg/
│ ├── Arquetipo.java
  ├── Jogador.java
  ├── Personagem.java
  ├── Campanha.java
  ├── CampanhaTest.java
  ├── ArquetipoRepository.java
  └── Main.java
</code>

<h3>🧠 Tecnologias</h3>
<p>Java 17+</p>
<p>Maven (para gerenciamento do projeto e build)</p>

<h3>🚀 Como Executar</h3>
<p>Verifique se o Maven está instalado: mvn -v</p>

Compile o projeto:
mvn clean compile

Execute a classe principal:
mvn exec:java -Dexec.mainClass="org.example.rpg.Main"

O programa irá:

Criar objetos da classe Arquetipo.

Exibir as informações de cada arquétipo no console.

🧩 Exemplo de Saída
Arquetipo: Guerreiro
Nível Mínimo: 1
Custo: 5
Descrição: Combatente experiente, treinado no uso de armas e armaduras.

Arquetipo: Mago
Nível Mínimo: 1
Custo: 5
Descrição: Usuário de magia que canaliza poder através da mente e essência.

👤 Autor
Desenvolvido por Leonardo Oliveira

📅 Projeto acadêmico para prática de modelagem e orientação a objetos em Java.
