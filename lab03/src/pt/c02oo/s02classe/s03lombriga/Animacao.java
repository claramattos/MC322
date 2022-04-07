package pt.c02oo.s02classe.s03lombriga;

public class Animacao { 
    String anima, passos;
    char[] passos2;
    AquarioLombriga lombriga; 
    int posicaoPasso, tamanhoAquario, tamanhoLombriga, posicaoCabeca;
    
    
    public Animacao (String anima) {
        this.anima = anima;
        
        //coleta as substrings caracteristicas das condicoes iniciais dentro da string de entrada e as converte em números
        String tamAquarioString = anima.substring(0, 2);
        String tamLombrigaString = anima.substring(2, 4);
        String posicaoString = anima.substring(4, 6);
        this.posicaoPasso = 0;
        passos = anima.substring(6);
        passos2 = passos.toCharArray();
        tamanhoAquario = Integer.parseInt(tamAquarioString);
        tamanhoLombriga = Integer.parseInt(tamLombrigaString);
        posicaoCabeca = Integer.parseInt(posicaoString);
        
    }
    
	void conecta(AquarioLombriga lombriga) {
		//conecta as classes Animação e AquarioLombrigo
		this.lombriga = lombriga;
	}

    public String apresenta () {
    	//apresenta a string do aquário com a lombriga
        return lombriga.apresenta();
    }
    
    public void passo () {
    	//direciona para a função com passo correspondente
        switch (passos2[posicaoPasso]) {
            case 'C': lombriga.crescer(); break;
            case 'M': lombriga.mover(); break;
            case 'V': lombriga.virar(); break;
            default: System.out.println("invalido");
        }
        posicaoPasso++;
        
    }
}