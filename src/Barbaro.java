import java.util.concurrent.ThreadLocalRandom;

public class Barbaro extends Personagem{
    public Barbaro(String nome, String raca, int nivel){
        super(nome, raca, nivel);
        this.cvida = 3;
        this.carmadura = 0;
        this.cacerto = 1;
        this.cdano = 12;
        setatributos();
    }
    @Override
    public String getDescricaoAtaqueSucesso(int danorolado) {
        return getNome() + " furiosamente acertou seu machado e causou " + danorolado + " de dano!";
    }

    @Override
    public String getDescricaoAtaqueFalha() {
        return getNome() + " em meio a sua fúria, seu ataque foi óbvio demais e o inimigo esquivou.";
    }
}
