public class Guerreiro extends Personagem{
    public Guerreiro(String nome, String raca, int nivel) {
        super(nome, raca, nivel);
        this.cvida = 1;
        this.carmadura = 1;
        this.cacerto = 2;
        this.cdano = 8;
        setatributos();
    }


}
