import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
public abstract class Personagem implements Combate {
    public String nome;
    public String raca;
    public int nivel;
    protected ArrayList<Historico> historico = new ArrayList<>();
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
    //ao iniciar define dependendo da raça os atributos vida e armadura base, os outros serão bonus de classe
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
            this.vidabase = (cvida + 12);
            this.vida = nivel * vidabase;
            this.armadura = nivel + (carmadura - 4);
        } else if (raca.equals("Elfo")) {
            this.vidabase = (cvida + 8);
            this.vida = nivel * vidabase;
            this.armadura = nivel + (carmadura + 2);
        }
        else if (raca.equals("Ork")) {
            this.vidabase = (cvida + 14);
            this.vida = nivel * vidabase;
            this.armadura = nivel + (carmadura - 2);
        }
        this.dano = nivel * cdano;
        this.acerto = nivel + cacerto;
    }

    public void subirdenivel() {
        if (nivel + 1 > 20){ System.err.println("O personagem ja está no seu nível máximo!"); //caso o nivel do personagem for 20, imprime uma mensagem de erro
        }
        else { //senao aumenta o nivel e atualiza seus atributos
            nivel = nivel + 1;
            atualizaratributos();
        }
    }

    private void atualizaratributos() {
        this.dano = 1 + dano + cdano;
        this.vida = vida + vidabase;
        this.armadura = 1 + armadura;
        this.acerto = 1 + acerto;
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
        if (dificuldade < 1) {
            return "Erro: A dificuldade do ataque não pode ser menor que 1!";
        }
        int rolagem = ThreadLocalRandom.current().nextInt(1, 21) + acerto;
        if (rolagem >= dificuldade) {
            int danorolado = ThreadLocalRandom.current().nextInt(1, dano + 1);
            Historico reg = new Historico(getNome(), "Atacou com Sucesso", rolagem, danorolado);
            historico.add(reg);
            return getDescricaoAtaqueSucesso(danorolado);
        }
        else {
            Historico reg = new Historico(getNome(), "Fracassou o Ataque", rolagem, 0);
            historico.add(reg);
            return getDescricaoAtaqueFalha();
        }
    }
    @Override
    public String defesa(int acertoinimigo, int danoinimigo) {
        if (danoinimigo < 1 || acertoinimigo < 1) {
            return "Erro: O acerto e dano do ataque não pode ser menor que 1!";
        }
        int rolagem = ThreadLocalRandom.current().nextInt(1, 21) + acertoinimigo;
        if (rolagem >= armadura) {
            int danorolado = ThreadLocalRandom.current().nextInt(1, danoinimigo + 1);
            vida = vida - danorolado;
            Historico reg = new Historico(getNome(), "Foi Atacado", rolagem, danorolado);
            historico.add(reg);
            return "O inimigo desferiu " + danorolado + " de dano em " + getNome() + ".";
        }
        else {
            Historico reg = new Historico(getNome(), "Desviou do Ataque", rolagem, 0);
            historico.add(reg);
            return getNome() + " desviou do golpe inimigo.";
        }
    }
    @Override
    public String tomarpocao(int pontosrecuperados){ //rola um "dado" para a quantidade de vida recuperada
        int pontosrolados = ThreadLocalRandom.current().nextInt(1, pontosrecuperados + 1);
        if (vida + pontosrolados > nivel * vidabase) { //se a vida recuperada for maior que a vida maxima, retorna o personagem a vida maxima
            vida = nivel * vidabase;
        }
        else {
            vida = vida + pontosrolados; //senao recupera a vida
        }
        return getNome() + " tomou uma poção de vida e recuperou " + pontosrolados + ".";
    }
    // Métodos padrão caso a classe filha não queira customizar
    public String getDescricaoAtaqueSucesso(int danorolado) {
        return getNome() + " acertou o golpe causando " + danorolado + " de dano.";
    }

    public String getDescricaoAtaqueFalha() {
        return getNome() + " errou o golpe.";
    }
    public String getestatisticas(){
        return "Raça -> " + raca + "\n" + "Classe -> " + getClass().getSimpleName() + "\n" + "Nivel -> " + nivel + "\n" + "Vida -> " + vida;
    }
    public record Historico(String nome, String acao, int dadorolado, int danorolado){ } //cria um historico acessavel das rolagens do jogo
    public ArrayList<Historico> getHistorico() {
        return historico;
    }
}
