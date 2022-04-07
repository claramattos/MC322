package pt.c02oo.s02classe.s03lombriga;

public class Animacao { 
    String anima;
    AquarioLombriga lombriga; 
    int posicaoPasso = 6, tamanhoAquario, tamanhoLombriga, posicaoCabeca;
    
    public Animacao (String anima) {
        this.anima = anima;
        
        String tamAquarioString = anima.substring(0, 2);
        String tamLombrigaString = anima.substring(2, 4);
        String posicaoString = anima.substring(4, 6);
        this.posicaoPasso = 6;
        
        tamanhoAquario = Integer.parseInt(tamAquarioString);
        tamanhoLombriga = Integer.parseInt(tamLombrigaString);
        posicaoCabeca = Integer.parseInt(posicaoString);
        
    }
    
	void conecta(AquarioLombriga lombriga) {
		this.lombriga = lombriga;
	}

    public String apresenta () {
        return lombriga.apresenta();
    }
    
    public void passo () {
        switch (anima.charAt(posicaoPasso)) {
            case 'C': lombriga.crescer(); break;
            case 'M': lombriga.mover(); break;
            case 'V': lombriga.virar(); break;
            default: System.out.println("invalido");
        }
        posicaoPasso++;
        
    }
}