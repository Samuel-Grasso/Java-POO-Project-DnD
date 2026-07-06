public class Guerreiro extends Personagem{
    private int vida;
    private int armadura;
    private int acerto;
    private int dano;
    public Guerreiro(String nome, String raca, int nivel){
        super(nome, raca, nivel);
        this.dano = nivel * 6;
        if (raca.equals("Humano")){
            this.vida = nivel * 10;
        }
        else if (raca.equals("Anao")){
            this.vida = nivel * 12;
        }
        else if (raca.equals("Anao")){
            this.vida = nivel * 12;
        }
        else if (raca.equals("Orc")){
            this.vida = nivel * 14;
        }
        else if (raca.equals("Elfo")){
            this.vida = nivel * 8;
        }
        this.armadura = nivel + 12;
        this.acerto = nivel + 12;
    }
    public void subirdenivel(){
        nivel++;
        atualizaratributos();
    }

    private void atualizaratributos() {
        this.dano = nivel * 6;
        this.vida = nivel * 10;
        this.armadura = nivel + 12;
    }

}
