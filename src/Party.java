import java.util.HashMap;
import java.util.Map;

public class Party {
    public String nomeDoGrupo;
    //mapeia o nome do personagem (String) para o Objeto Personagem
    public Map<String, Personagem> membros = new HashMap<>();

    public Party(String nomeDoGrupo) {
        this.nomeDoGrupo = nomeDoGrupo;
    }

    // O metodo insere o personagem no mapa usando o nome dele em minúsculo como chave.
    public void adicionarMembro(Personagem p) {
        membros.put(p.getNome().toLowerCase(), p);
    }

    // Retorna o personagem buscando pelo nome dele
    public Personagem getPersonagem(String nomePersonagem) {
        return membros.get(nomePersonagem.toLowerCase());
    }
    public Personagem removerPersonagem(String nomePersonagem) {
        return membros.remove(nomePersonagem.toLowerCase());
    }

    public void listarMembros() {
        if (membros.isEmpty()) {
            System.out.println("Este grupo está vazio!");
            return;
        }
        for (Personagem p : membros.values()) { // .values() pega direto os objetos
            System.out.println(" - > " + p.getNome() + " (" + p.getClass().getSimpleName() + " Nv." + p.nivel + ")");
        }
    }

    public String getNomeDoGrupo() { return nomeDoGrupo; }
}