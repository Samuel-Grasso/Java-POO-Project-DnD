import java.util.concurrent.ThreadLocalRandom;

public class Ladino extends Personagem {
    public Ladino(String nome, String raca, int nivel) {
        super(nome, raca, nivel);
        this.cvida = 0;
        this.carmadura = 2;
        this.cacerto = 1;
        this.cdano = 10;
        setatributos();
    }
    @Override
    public String getDescricaoAtaqueSucesso(int danorolado) {
        return getNome() + " sorrateiramente brandiu sua adaga e causou " + danorolado + " de dano!";
    }

    @Override
    public String getDescricaoAtaqueFalha() {
        return getNome() + " tentou causar um golpe surpresa, mas o inimigo descobriu.";
    }
}
