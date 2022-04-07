package pt.c02oo.s02classe.s03lombriga;

public class Animacao { 
    String anima;
    AquarioLombriga lombriga; 
    int posicaoPasso = 6;
    
    public Animacao (String anima) {
        this.anima = anima;
        
        String tamAquarioString = anima.substring(0, 2);
        String tamLombrigaString = anima.substring(2, 4);
        String posicaoString = anima.substring(4, 6);
        this.posicaoPasso = 6;
        
        int tamanhoAquario = Integer.parseInt(tamAquarioString);
        int tamanhoLombriga = Integer.parseInt(tamLombrigaString);
        int posicaoCabeca = Integer.parseInt(posicaoString);
        
        this.lombriga = new AquarioLombriga (tamanhoAquario, tamanhoLombriga, posicaoCabeca);
    }
    
    public String apresenta (AquarioLombriga lombriga) {
        return lombriga.aquario;
    }
    
    public void passo (AquarioLombriga lombriga) {
        switch (anima.charAt(posicaoPasso)) {
            case 'C': lombriga.crescer(lombriga); break;
            case 'M': lombriga.mover(lombriga); break;
            case 'V': lombriga.virar(lombriga); break;
            default: System.out.println("invalido");
        }
        posicaoPasso++;
        
    }
}