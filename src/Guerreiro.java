import java.util.concurrent.ThreadLocalRandom;

public class Guerreiro extends Personagem{
    public Guerreiro(String nome, String raca, int nivel) {
        super(nome, raca, nivel);
        this.cvida = 2;
        this.carmadura = 2;
        this.cacerto = 2;
        this.cdano = 8;
        setatributos();
    }
    @Override
    public String getDescricaoAtaqueSucesso(int danorolado) {
        return getNome() + " brandiu sua espada e causou " + danorolado + " de dano!";
    }

    @Override
    public String getDescricaoAtaqueFalha() {
        return getNome() + " tentou um golpe pesado com a espada, mas o inimigo esquivou.";
    }


}
