---
config:
  layout: elk
---
classDiagram
direction BT
    class Main {
	    +main(String[] args)
    }

    class DesenhoTerminal {
	    +HashMap~String, Party~ parties
	    +DesenhoTerminal(HashMap~String, Party~)
	    +telaboasvindas()
	    +teladeinicio()
	    +teladeparty(String)
	    +limparConsole()
	    +desenharPersonagem(String, String)
	    +desenharEstatisticas(String, String)
    }

    class Party {
	    +String nomeDoGrupo
	    +Map~String, Personagem~ membros
	    +Party(String)
	    +adicionarMembro(Personagem)
	    +getPersonagem(String) Personagem
	    +removerPersonagem(String) Personagem
	    +listarMembros()
	    +getNomeDoGrupo() String
    }

    class Combate {
	    +ataque(int) String
	    +defesa(int, int) String
	    +tomarpocao(int) String
    }

    class Personagem {
	    +String nome
	    +String raca
	    +int nivel
	    +ArrayList~Historico~ historico
	    +int vida
	    +int vidabase
	    +int cvida
	    +int carmadura
	    +int armadura
	    +int cacerto
	    +int acerto
	    +int cdano
	    +int dano
	    +Personagem(String, String, int)
	    +setatributos()
	    +subirdenivel()
	    +getNome() String
	    +setNome(String)
	    +getRaca() String
	    +setRaca(String)
	    +getNivel() int
	    +setNivel(int)
	    +getVida() String
	    +ataque(int) String
	    +defesa(int, int) String
	    +tomarpocao(int) String
	    +getDescricaoAtaqueSucesso(int) String
	    +getDescricaoAtaqueFalha() String
	    +getestatisticas() String
	    +getHistorico() ArrayList~Historico~
    }

    class Historico {
	    +String nome
	    +String acao
	    +int dadorolado
	    +int danorolado
    }

    class Barbaro {
	    +Barbaro(String, String, int)
	    +getDescricaoAtaqueSucesso(int) String
	    +getDescricaoAtaqueFalha() String
    }

    class Guerreiro {
	    +Guerreiro(String, String, int)
	    +getDescricaoAtaqueSucesso(int) String
	    +getDescricaoAtaqueFalha() String
    }

    class Ladino {
	    +Ladino(String, String, int)
	    +getDescricaoAtaqueSucesso(int) String
	    +getDescricaoAtaqueFalha() String
    }

    class Mago {
	    +Mago(String, String, int)
	    +getDescricaoAtaqueSucesso(int) String
	    +getDescricaoAtaqueFalha() String
    }

    class Patrulheiro {
	    +Patrulheiro(String, String, int)
	    +getDescricaoAtaqueSucesso(int) String
	    +getDescricaoAtaqueFalha() String
    }

	<<interface>> Combate
	<<abstract>> Personagem
	<<record>> Historico

    Personagem <|-- Barbaro
    Personagem <|-- Guerreiro
    Personagem <|-- Ladino
    Personagem <|-- Mago
    Personagem <|-- Patrulheiro
    Personagem ..|> Combate
    Personagem o-- Historico
    Party o-- Personagem
    DesenhoTerminal o-- Party
    Main --> DesenhoTerminal
    Main --> Party
    Main --> Personagem
