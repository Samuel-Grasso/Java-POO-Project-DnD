import java.util.concurrent.ThreadLocalRandom;

public class Patrulheiro extends Personagem{
    public Patrulheiro(String nome, String raca, int nivel) {
        super(nome, raca, nivel);
        this.cvida = 1;
        this.carmadura = 3;
        this.cacerto = 3;
        this.cdano = 6;
        setatributos();
    }
    @Override
    public String getDescricaoAtaqueSucesso(int danorolado) {
        return getNome() + " lançou sua flecha certeira e causou " + danorolado + " de dano!";
    }

    @Override
    public String getDescricaoAtaqueFalha() {
        return getNome() + " tremeu ao atirar e errou o inimigo .";
    }
}
