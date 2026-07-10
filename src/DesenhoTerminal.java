import java.util.HashMap;

public class DesenhoTerminal {
    public HashMap<String, Party> parties;
    public DesenhoTerminal(HashMap<String, Party> parties) {
        this.parties = parties;

    }
    public void telaboasvindas(){
        // Desenhando uma caixa de menu bonita usando caracteres de borda
        System.out.println("┌────────────────────────────────────────┐");
        System.out.println("|                                        |");
        System.out.println("│      Bem vindo(a) ao Sistema de        │");
        System.out.println("|      Gerenciamento de Parties para     |");
        System.out.println("|                   D&D                  |");
        System.out.println("|          Digite A para Iniciar         |");
        System.out.println("|          Digite S para Sair            |");
        System.out.println("| Projeto de POO do Aluno Samuel Grasso  |");
        System.out.println("└────────────────────────────────────────┘");
    }
    public void teladeinicio(){
        // Desenhando uma caixa de menu bonita usando caracteres de borda
        System.out.println("┌────────────────────────────────────────┐");
        System.out.println("│         GERENCIE SUAS PARTIES          │");
        System.out.println("|────────────────────────────────────────|");
        if (parties.isEmpty()){
            System.out.println("| - > Nenhuma Party Cadastrada ainda...  |");
            System.out.println("|                                        |");
            System.out.println("| Digite A para cadastrar uma nova Party |");
            System.out.println("| Digite S para sair                     |");
        }
        else{
            for (String nome : parties.keySet()){
                System.out.printf("│ - > %-34s │\n", parties.get(nome).getNomeDoGrupo());
            }
            System.out.println("| Digite o nome para ver sua Party       |");

            System.out.println("| Digite A para cadastrar uma nova Party |");
            System.out.println("| Digite X para excluir uma Party        |");
            System.out.println("| Digite S para sair                     |");
        }
        System.out.println("└────────────────────────────────────────┘");
    }
    public void teladeparty(String party){
        System.out.println("┌────────────────────────────────────────┐");
         System.out.printf("│           %-28s │\n", party);
        System.out.println("└────────────────────────────────────────┘");
        parties.get(party).listarMembros();
        if (parties.get(party).membros.isEmpty()) {
            System.out.println("┌────────────────────────────────────────┐");
            System.out.printf("│ - >Digite 'A' para Cadastrar novo Herói│\n");
             System.out.printf("│ - >Digite 'S' para sair                │\n");
            System.out.println("└────────────────────────────────────────┘");
        }
        else {
            System.out.println("┌────────────────────────────────────────┐");
             System.out.printf("│ - >Digite o Herói que queira acessar   │\n");
            System.out.printf("│ - >Digite 'A' para Cadastrar novo Herói│\n");
            System.out.println("│ - >Digite 'X' para excluir Herói       │");
            System.out.println("│ - >Digite 'H' ver Historico do Herói   │");
            System.out.printf("│ - >Digite 'S' para sair                │\n");
            System.out.println("└────────────────────────────────────────┘");
        }
    }
    public void limparConsole() {
        // \033[H move o cursor para o topo esquerdo
        // \033[2J limpa a tela inteira a partir dali
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

    }
    public void desenharPersonagem(String party, String nome) {

        System.out.println("┌────────────────────────────────────────┐");
         System.out.printf("│                %-23s │\n", parties.get(party).membros.get(nome).getNome());
        System.out.println("┌────────────────────────────────────────┐");
         System.out.printf("│    Digite o que você quer fazer        │\n");
        System.out.println("│ - > Atacar          - > Curar          │");
        System.out.println("│ - > Defender        - > Subir de Nivel │");
        System.out.println("│ - > Ver Atributos   - > 'S' para sair  │");
        System.out.println("└────────────────────────────────────────┘");
    }
    public void desenharEstatisticas(String party, String nome){
        System.out.println("┌────────────────────────────────────────┐");
        System.out.printf("│                %-23s │\n", parties.get(party).membros.get(nome).getNome());
        System.out.println("└────────────────────────────────────────┘");
        System.out.println(parties.get(party).getPersonagem(nome).getestatisticas());
        System.out.println("┌────────────────────────────────────────┐");
        System.out.printf("│    Digite o que você quer fazer        │\n");
        System.out.println("│ - > Mudar de Raça    - > Mudar de Nome │");
        System.out.println("│ - > Mudar de Nível   - > 'S' para sair │");
        System.out.println("│ - > Mudar de Classe                    │");
        System.out.println("└────────────────────────────────────────┘");
    }
}
