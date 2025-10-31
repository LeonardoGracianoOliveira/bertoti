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

<h2>🎲 Sistema de Campanha de RPG (Java)</h2>

<h3>🧾 Descrição</h3>
<p>Aplicação em Java puro, estruturada em camadas, representando um sistema simples de gerenciamento de campanhas de RPG.
O projeto foi desenvolvido com base em um diagrama UML completo, contendo as entidades Campanha, Jogador, Personagem e Arquetipo, e suas relações.</p>

<p>O sistema permite criar campanhas com múltiplos jogadores, associar personagens e arquétipos aos jogadores, buscar jogadores e personagens por nome e realizar testes automatizados com JUnit 5.</p>

<h3>🏗️ Estrutura do Projeto</h3>
<code>
src/
├── model/
│ ├── Campanha.java
│ ├── Jogador.java
│ ├── Personagem.java
│ ├── Arquetipo.java
│ └── Main.java
└── test/
└── CampanhaTest.java
</code>

<h3>⚙️ Funcionalidades Principais</h3>
<p>Campanha: gerencia a sessão e os jogadores. Permite buscar personagens e jogadores pelo nome.</p>
<p>Jogador: representa um participante da campanha, contendo função, nome, idade e personagens associados.</p>
<p>Personagem: define as informações do personagem, como nome, origem e aparência, e permite atribuir um arquétipo.</p>
<p>Arquetipo: representa a classe ou especialização do personagem, com pontos de vida, mana e uma descrição.</p>
<p>Main: executa o sistema e exibe as informações no console.

<h3>🚀 Como Executar o Projeto</h3>
<h4>Opção 1 — Linha de Comando:</h4>
<p>Compile os arquivos Java com o comando:</p>
<p>javac model/*.java</p>

<h4>Execute o programa principal:</h4>
<p>java model.Main</p>

<h4>Opção 2 — IntelliJ / Eclipse / VS Code:</h4>
<p>Crie um novo projeto Java.</p>
<p>Copie as pastas “model” e “test” para dentro da pasta “src”.</p>
<p>Execute a classe Main.java com o botão “Run”.</p>

<h3>🧪 Testes Automatizados (JUnit 5)</h3>
<p>Os testes estão localizados em “src/test/CampanhaTest.java”.</p>
<p>Para executá-los, basta rodar os testes diretamente pela IDE (como IntelliJ ou Eclipse) ou, se o projeto usar Maven ou Gradle, executar:</p>
<code>
  mvn test
ou
gradle test
</code>

<h3>📊 Exemplo de Saída</h3>

<code>
  === CAMPANHA ===
Nome: Sombras do Abismo
Sessão: 1
Jogadores:

Jogador: Leonardo
Função: Mestre
Idade: 28
Personagem: Darian
Origem: Reino do Norte
Aparência: Cabelos brancos
Arquetipo: Guerreiro
Vida: 100
Mana: 20
Descrição: Especialista em combate corpo a corpo

Jogador: Carla
Função: Jogador
Idade: 25
Personagem: Lyra
Origem: Floresta Élfica
Aparência: Olhos verdes
Arquetipo: Maga
Vida: 60
Mana: 100
Descrição: Usuária de magia ancestral

=== TESTES DE BUSCA ===

Buscando jogador 'Carla':
Encontrado: Carla (Jogador), Idade: 25

Buscando personagem 'Darian':
Encontrado: Darian | Origem: Reino do Norte | Aparência: Cabelos brancos | Arquetipo: Guerreiro (Vida: 100, Mana: 20)

--- Execução concluída com sucesso ---
</code>

<h3>🧠 Tecnologias Utilizadas</h3>
<p>Java 17+</p>
<p>JUnit 5</p>
<p>Programação Orientada a Objetos (POO)</p>
<p>Modelagem UML</p>

<h3>👨‍💻 Autor</h3>
<p>Leonardo Oliveira</p>
<p>Projeto desenvolvido para estudo e demonstração de arquitetura orientada a objetos em Java.</p>
