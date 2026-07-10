import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Party> guilda = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        DesenhoTerminal desenhar = new DesenhoTerminal(guilda);

        boolean continuar = true;

        while (continuar) {
            desenhar.telaboasvindas();
            String teclado = sc.nextLine().trim();

            // OPÇÃO A: INICIAR O JOGO
            if (teclado.equalsIgnoreCase("a")) {

                boolean noMenuInicio = true;
                while (noMenuInicio) {
                    desenhar.limparConsole();
                    desenhar.teladeinicio(); // Mostra as opções da tela de início

                    String opcaoInicio = sc.nextLine().trim();

                    // Se na tela de início ele digitar 'A' para criar Party
                    if (opcaoInicio.equalsIgnoreCase("a")) {
                        System.out.println(" - > Digite o nome de sua Party: ");
                        String nomeparty = sc.nextLine().trim(); //nextLine para aceitar espaços no nome

                        Party party = new Party(nomeparty);
                        guilda.put(nomeparty.toLowerCase(), party); // Salva em minúsculo para facilitar busca

                        System.out.println("Party '" + nomeparty + "' criada com sucesso!");
                        System.out.println("Aperte ENTER para voltar...");
                        sc.nextLine(); // Pausa para o usuário ler a confirmação
                    }
                    else if (opcaoInicio.equalsIgnoreCase("x")) {
                        System.out.println(" - > Digite a Party que queira excluir: ");
                        String partyexcluir = sc.nextLine().trim();
                        guilda.remove(partyexcluir.toLowerCase());
                        System.out.println("Party '" + partyexcluir + "' excluida com sucesso!");
                        System.out.println("Aperte ENTER para voltar...");
                        sc.nextLine();
                    }
                    // Se na tela de início ele quiser voltar/sair para o menu de boas-vindas
                    else if (opcaoInicio.equalsIgnoreCase("s")) {
                        noMenuInicio = false; // Sai deste menu interno e volta para o menu de boas-vindas
                    }
                    else{
                        if(guilda.containsKey(opcaoInicio.toLowerCase())){
                            String nomedaparty = opcaoInicio;
                            boolean nomenuparty = true;
                            while (nomenuparty){
                                desenhar.limparConsole();
                                desenhar.teladeparty(nomedaparty.toLowerCase());
                                String opcaoparty = sc.nextLine().trim();
                                if (opcaoparty.equalsIgnoreCase("a")) {
                                    System.out.println(" - > Digite o nome do Personagem: ");
                                    String nomepersonagem = sc.nextLine().trim();
                                    System.out.println(" Raças disponíveis:");
                                    System.out.println(" - > Humano       - > Anão");
                                    System.out.println(" - > Elfo         - > Hobbit");
                                    System.out.println(" - > Ork          - > Maiar");
                                    System.out.println(" - > Digite sua raça: ");
                                    String racapersonagem = sc.nextLine().trim();
                                    System.out.println(" Classes disponíveis:");
                                    System.out.println(" - > Bárbaro      - > Guerreiro");
                                    System.out.println(" - > Patrulheiro  - > Ladino");
                                    System.out.println(" - > Mago");
                                    System.out.println(" - > Digite sua classe: ");
                                    String classepersonagem = sc.nextLine().trim();
                                    System.out.println(" - > Por fim, Qual nível seu personagem começará?");
                                    int nivelpersonagem = sc.nextInt();
                                    if (nivelpersonagem < 1 || nivelpersonagem > 20){
                                        sc.nextLine();
                                        System.err.println("O nível deve ser entre 1 e 20");
                                        System.out.println("Aperte ENTER para voltar...");
                                        sc.nextLine();
                                        break;}
                                    Personagem personagem = null; // Declarada fora para o escopo alcançar depois do switch

                                    switch (classepersonagem.toLowerCase()) {
                                        case "barbaro":
                                            personagem = new Barbaro(nomepersonagem, racapersonagem, nivelpersonagem);
                                            break;
                                        case "guerreiro":
                                            personagem = new Guerreiro(nomepersonagem, racapersonagem, nivelpersonagem);
                                            break;
                                        case "patrulheiro":
                                            personagem = new Patrulheiro(nomepersonagem, racapersonagem, nivelpersonagem);
                                            break;
                                        case "ladino":
                                            personagem = new Ladino(nomepersonagem, racapersonagem, nivelpersonagem);
                                            break;
                                        case "mago":
                                            personagem = new Mago(nomepersonagem, racapersonagem, nivelpersonagem);
                                            break;
                                        default:
                                            System.out.println("Classe inválida!");
                                            break;
                                    }

                                    // Agora você pode usar a variável à vontade aqui embaixo!
                                    if (personagem != null) {
                                        guilda.get(nomedaparty.toLowerCase()).adicionarMembro(personagem);
                                    }

                                }
                                else if (opcaoparty.equalsIgnoreCase("s")) {
                                    nomenuparty = false;
                                }
                                else if (opcaoparty.equalsIgnoreCase("x")) {
                                    System.out.println(" - > Digite o nome do Personagem que deseja excluir: ");
                                    String personagemexcluir = sc.nextLine().trim();
                                    guilda.get(nomedaparty).removerPersonagem(personagemexcluir);
                                    System.out.println("Herói '" + personagemexcluir + "' excluido com sucesso!");
                                    System.out.println("Aperte ENTER para voltar...");
                                    sc.nextLine();
                                }
                                else if (opcaoparty.equalsIgnoreCase("H")) {
                                    System.out.println(" - > Digite o nome do Personagem que deseja ver o Historico: ");
                                    String personagemhistorico = sc.nextLine().trim();
                                    Personagem personagemhist = guilda.get(nomedaparty).getPersonagem(personagemhistorico.toLowerCase());
                                    for (Personagem.Historico h : personagemhist.getHistorico()) {
                                        System.out.println(h.nome() + " - " + h.acao() + " (rolagem: " + h.dadorolado() + ", dano: " + h.danorolado() + ")");
                                    }
                                    System.out.println("Aperte ENTER para voltar...");
                                    sc.nextLine();
                                }
                                else{
                                    if (guilda.get(nomedaparty.toLowerCase()).membros.containsKey(opcaoparty.toLowerCase())){
                                        boolean nomenupersonagems = true;
                                        Personagem personagematual = guilda.get(nomedaparty).getPersonagem(opcaoparty.toLowerCase());
                                        while (nomenupersonagems) {
                                            desenhar.limparConsole();
                                            desenhar.desenharPersonagem(nomedaparty, opcaoparty.toLowerCase());
                                            String opcaopersonagems = sc.nextLine().trim();
                                            if  (opcaopersonagems.equalsIgnoreCase("atacar")) {
                                                System.out.println(" - > Digite o bonus de Armadura do inimigo: ");
                                                int dificuldade = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println(personagematual.ataque(dificuldade));
                                                System.out.println("Aperte ENTER para voltar...");
                                                sc.nextLine().trim();
                                            }
                                            else if (opcaopersonagems.equalsIgnoreCase("defender")) {
                                                System.out.println(" - > Digite O bonus de Ataque do inimigo: ");
                                                int bonusAtaque = sc.nextInt();
                                                System.out.println(" - > Digite O dano do inimigo: ");
                                                int  danoAtaque = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println(personagematual.defesa(bonusAtaque, danoAtaque));
                                                System.out.println("Aperte ENTER para voltar...");
                                                sc.nextLine();
                                            }
                                            else if (opcaopersonagems.equalsIgnoreCase("curar")) {
                                                System.out.println(" - > Digite a quantidade de Cura: ");
                                                int cura = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println(personagematual.tomarpocao(cura));
                                                System.out.println("Aperte ENTER para voltar...");
                                                sc.nextLine();
                                            }
                                            else if (opcaopersonagems.equalsIgnoreCase("subir de nivel")) {
                                                personagematual.subirdenivel();
                                                System.out.println(" - > Parabéns! Agora o nível de " + personagematual.getNome() + " é " + personagematual.getNivel());
                                                System.out.println("Aperte ENTER para voltar...");
                                                sc.nextLine();
                                            }
                                            else if (opcaopersonagems.equalsIgnoreCase("ver atributos")) {
                                                boolean nomenuatributos = true;
                                                while (nomenuatributos) {
                                                    desenhar.limparConsole();
                                                    desenhar.desenharEstatisticas(nomedaparty,  opcaoparty.toLowerCase());
                                                    String opcaoatributos = sc.nextLine().trim();
                                                    if  (opcaoatributos.equalsIgnoreCase("mudar de raca")) {
                                                        System.out.println(" - > Humano       - > Anão");
                                                        System.out.println(" - > Elfo         - > Hobbit");
                                                        System.out.println(" - > Ork          - > Maiar");
                                                        System.out.println(" - > Digite o raca que queira mudar: ");
                                                        String novaraca = sc.nextLine();
                                                        personagematual.setRaca(novaraca);
                                                        System.out.println(" - > A raça de " + personagematual.getNome() + " é " + personagematual.getRaca());
                                                        System.out.println("Aperte ENTER para voltar...");
                                                        sc.nextLine();
                                                    }
                                                    else if (opcaoatributos.equalsIgnoreCase("mudar de nome")) {
                                                        System.out.println(" - > Digite o nome que queira mudar: ");
                                                        String novonome = sc.nextLine();
                                                        personagematual.setNome(novonome);
                                                        System.out.println(" - > O nome agora é " + personagematual.getNome());
                                                        System.out.println("Aperte ENTER para voltar...");
                                                        sc.nextLine();
                                                    }
                                                    else if (opcaoatributos.equalsIgnoreCase("mudar de nivel")) {
                                                        System.out.println(" - > Digite para que nivel queira mudar: ");
                                                        int novonivel = sc.nextInt();
                                                        sc.nextLine();
                                                        personagematual.setNivel(novonivel);
                                                        System.out.println(" - > O nivel de "+ personagematual.getNome() +" agora é " + personagematual.getNivel());
                                                        System.out.println("Aperte ENTER para voltar...");
                                                        sc.nextLine();
                                                    }
                                                    else if (opcaoatributos.equalsIgnoreCase("mudar de classe")) {
                                                        System.out.println(" - > Digite para que Classe queira mudar: ");
                                                        System.out.println(" - > Bárbaro      - > Guerreiro");
                                                        System.out.println(" - > Patrulheiro  - > Ladino");
                                                        System.out.println(" - > Mago");
                                                        String novaclasse = sc.nextLine();
                                                        Personagem personagemnovo = null;
                                                        switch (novaclasse.toLowerCase()) {
                                                            case "barbaro":
                                                                personagemnovo = new Barbaro(personagematual.getNome(), personagematual.getRaca(), personagematual.getNivel());
                                                                break;
                                                            case "guerreiro":
                                                                personagemnovo = new Guerreiro(personagematual.getNome(), personagematual.getRaca(), personagematual.getNivel());
                                                                break;
                                                            case "patrulheiro":
                                                                personagemnovo = new Patrulheiro(personagematual.getNome(), personagematual.getRaca(), personagematual.getNivel());
                                                                break;
                                                            case "ladino":
                                                                personagemnovo = new Ladino(personagematual.getNome(), personagematual.getRaca(), personagematual.getNivel());
                                                                break;
                                                            case "mago":
                                                                personagemnovo = new Mago(personagematual.getNome(), personagematual.getRaca(), personagematual.getNivel());
                                                                break;
                                                            default:
                                                                System.out.println("Classe inválida!");
                                                                break;
                                                        }
                                                        guilda.get(nomedaparty).removerPersonagem(personagematual.getNome());
                                                        guilda.get(nomedaparty).adicionarMembro(personagemnovo);
                                                        personagematual = personagemnovo;
                                                        System.out.println(" - > A classe de " + personagemnovo.getNome() + " agora é " + personagemnovo.getClass().getSimpleName());
                                                        System.out.println("Aperte ENTER para voltar...");
                                                        sc.nextLine();

                                                    }
                                                    else if (opcaoatributos.equalsIgnoreCase("s")) {
                                                        nomenuatributos = false;
                                                    }

                                                }
                                            }
                                            else if (opcaopersonagems.equalsIgnoreCase("s")){
                                                nomenupersonagems = false;
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // OPÇÃO S: FECHAR O PROGRAMA COMPLETO
            else if (teclado.equalsIgnoreCase("s")) {
                System.out.println("Saindo do sistema... Até logo!");
                continuar = false; // Fecha o while principal
            }
        }
        sc.close();
    }
}