import java.util.concurrent.ThreadLocalRandom;
public abstract class Personagem implements Combate {
    public String nome;
    public String raca;
    public int nivel;
    protected int vida;
    protected int vidabase;
    protected int cvida;
    protected int carmadura;
    protected int armadura;
    protected int cacerto;
    protected int acerto;
    protected int cdano;
    protected int dano;
    // variaveis a se definir nas subclasses
    // cdano, carmadura, cvida, cacerto
    // vidabase é definida por raça

    public Personagem(String nome, String raca, int nivel) {
        this.nome = nome;
        this.raca = raca;
        this.nivel = nivel;
        setatributos();
        this.dano = nivel * cdano;
        this.acerto = nivel + cacerto;
    }

    public void setatributos() {
        if (raca.equals("Humano")) {
            this.vidabase = cvida + 10;
            this.vida = nivel * vidabase;
            this.armadura = nivel + (carmadura);
        } else if (raca.equals("Anao")) {
            this.vidabase = (cvida + 12);
            this.vida = nivel * vidabase;
            this.armadura = nivel + (carmadura - 2);
        } else if (raca.equals("Hobbit")) {
            this.vidabase = (cvida + 6);
            this.vida = nivel * vidabase;
            this.armadura = nivel + (carmadura + 4);
        } else if (raca.equals("Maiar")) {
            this.vidabase = (cvida + 14);
            this.vida = nivel * vidabase;
            this.armadura = nivel + (carmadura - 4);
        } else if (raca.equals("Elfo")) {
            this.vidabase = (cvida + 8);
            this.vida = nivel * vidabase;
            this.armadura = nivel + (carmadura + 2);
        }
        this.dano = nivel * cdano;
        this.acerto = nivel + cacerto;
    }

    public void subirdenivel() {
        nivel++;
        atualizaratributos();
    }

    private void atualizaratributos() {
        this.dano = 1 + dano + cdano;
        this.vida = vida + vidabase;
        this.armadura = 1 + armadura + carmadura;
        this.acerto = 1 + acerto + cacerto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
        setatributos();
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
        setatributos();
    }

    public String getVida() {
        return vida + " de Vida";
    }

    @Override
    public String ataque(int dificuldade) {
        int rolagem = ThreadLocalRandom.current().nextInt(1, 21) + acerto;
        if (rolagem >= dificuldade) {
            return getNome() + " desferiu " + ThreadLocalRandom.current().nextInt(1, dano + 1) + " de dano.";
        }
        else {
            return getNome() + " errou seu golpe.";
        }
    }
    @Override
    public String defesa(int acertoinimigo, int danoinimigo) {
        int rolagem = ThreadLocalRandom.current().nextInt(1, 21) + acertoinimigo;
        if (rolagem >= armadura) {
            int danorolado = ThreadLocalRandom.current().nextInt(1, danoinimigo + 1);
            vida = vida - danorolado;
            return "O inimigo desferiu " + danorolado + " de dano em " + getNome() + ".";
        }
        else {
            return getNome() + " desviou do golpe inimigo.";
        }
    }
}
