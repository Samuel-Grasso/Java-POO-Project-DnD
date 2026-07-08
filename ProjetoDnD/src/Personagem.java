public abstract class Personagem implements Combate{
    public String nome;
    public String raca;
    public int nivel;

    public Personagem(String nome, String raca, int nivel) {
        this.nome = nome;
        this.raca = raca;
        this.nivel = nivel;
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
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
