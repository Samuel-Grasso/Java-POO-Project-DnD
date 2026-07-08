import java.util.concurrent.ThreadLocalRandom;

public class Mago extends Personagem{
    public Mago(String nome, String raca, int nivel) {
        super(nome, raca, nivel);
        this.cvida = -1;
        this.carmadura = 0;
        this.cacerto = 3;
        this.cdano = 10;
        setatributos();
    }
    @Override
    public String getDescricaoAtaqueSucesso() {
        return getNome() + " lançou uma bola de fogo e causou " + ThreadLocalRandom.current().nextInt(1, dano + 1) + " de dano!";
    }

    @Override
    public String getDescricaoAtaqueFalha() {
        return getNome() + " se desconcentrou ao encantar sua magia e nao a conjurou.";
    }
}
