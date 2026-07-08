public class Main {
    public static void main(String[] args) {
        Personagem a = new Guerreiro("Gimli", "Anao", 5);
        System.out.println("Nome: " + a.getNome());
        System.out.println("Raca: " + a.getRaca());
        System.out.println("Nivel: " + a.getNivel());
        System.out.println(a.ataque(15));
        System.out.println(a.ataque(8));
        System.out.println(a.defesa(9, 6));
        System.out.println(a.getVida());
        System.out.println(a.defesa(15, 6));
        System.out.println(a.getVida());
    }
}