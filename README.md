# Java-POO-Project-DnD
# Sistema de Guilda RPG — Simulador de Combate por Turnos

## 📖 Sobre o Projeto

Este projeto é um sistema de gerenciamento e simulação de combate para RPG de mesa, desenvolvido em **Java**, executado via terminal (linha de comando). O sistema permite criar **Parties** (grupos de aventureiros), adicionar **Personagens** de diferentes raças e classes a essas parties, e simular ações de combate (ataque, defesa, cura e evolução de nível) com resultados baseados em rolagens aleatórias, no estilo de sistemas como D&D.

## 🎓 Intuito Acadêmico

Este projeto foi desenvolvido como exercício prático de **Programação Orientada a Objetos (POO)** em Java, com o objetivo de aplicar e consolidar os seguintes conceitos:

- **Abstração e Herança**: a classe abstrata `Personagem` centraliza atributos e comportamentos comuns (vida, armadura, dano, acerto), enquanto subclasses como `Barbaro`, `Guerreiro`, `Patrulheiro`, `Ladino` e `Mago` especializam esses valores conforme a classe do personagem.
- **Interfaces**: a interface `Combate` define o contrato de ações (`ataque`, `defesa`, `tomarpocao`) que toda classe de personagem deve implementar, garantindo polimorfismo entre os diferentes tipos de personagem.
- **Polimorfismo**: métodos como `getDescricaoAtaqueSucesso` e `getDescricaoAtaqueFalha` podem ser sobrescritos por cada subclasse para personalizar as mensagens de combate.
- **Encapsulamento**: uso de getters e setters para controlar o acesso e a modificação de atributos como nome, raça, nível e vida.
- **Records (Java 16+)**: uso do tipo `record` para representar de forma imutável o histórico de ações de combate (`Historico`), demonstrando um recurso mais moderno da linguagem.
- **Coleções (Collections Framework)**: uso de `HashMap` para armazenar e organizar Parties e Personagens, permitindo buscas eficientes por nome.
- **Entrada de dados via terminal**: uso da classe `Scanner` para construir um sistema de menus interativos e navegáveis.

O foco do projeto é  demonstrar domínio de estruturação de classes, herança, interfaces e boas práticas de organização de código em um cenário prático e lúdico.

## ⚙️ Funcionalidades

- **Gerenciamento de Guilda**: criação e exclusão de múltiplas Parties.
- **Gerenciamento de Personagens**: criação e exclusão de personagens dentro de cada Party, com escolha de nome, raça, classe e nível inicial.
- **Raças disponíveis**: Humano, Anão, Elfo, Hobbit, Ork, Maiar — cada uma com modificadores próprios de vida e armadura.
- **Classes disponíveis**: Bárbaro, Guerreiro, Patrulheiro, Ladino, Mago — cada uma com modificadores próprios de dano, acerto e armadura.
- **Simulação de combate**:
  - **Atacar**: rola um dado de ataque contra uma dificuldade informada.
  - **Defender**: rola a defesa contra um ataque inimigo, com dano calculado.
  - **Curar**: recupera pontos de vida via poção.
  - **Subir de nível**: evolui o personagem e recalcula seus atributos.
- **Visualização de atributos**: consulta de raça, classe, nível e vida atual de cada personagem, com opção de editar esses dados diretamente pelo menu.

## 🕹️ Como Executar

1. Certifique-se de ter o **JDK 16 ou superior** instalado (necessário para suporte a `records`).
2. Compile o projeto:
   ```bash
   javac *.java
   ```
3. Execute a classe principal:
   ```bash
   java Main
   ```
4. Navegue pelos menus digitando as letras/opções indicadas em cada tela.

## 🗂️ Estrutura do Projeto

- `Main.java` — ponto de entrada do programa e controle dos menus de navegação.
- `DesenhoTerminal.java` — responsável por desenhar as telas e menus no terminal.
- `Party.java` — representa um grupo de personagens (guilda).
- `Personagem.java` — classe abstrata com os atributos e comportamentos comuns a todos os personagens.
- `Combate.java` — interface que define as ações de combate.
- `Barbaro.java`, `Guerreiro.java`, `Patrulheiro.java`, `Ladino.java`, `Mago.java` — subclasses de `Personagem`, cada uma com seus próprios modificadores de atributos.

## 📌 Observações

Este é um projeto acadêmico em desenvolvimento contínuo, criado com fins de aprendizado. Sugestões de melhoria e boas práticas são bem-vindas.
