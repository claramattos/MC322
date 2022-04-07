package pt.c02oo.s02classe.s03lombriga;


public class AquarioLombriga { 
    int tamanhoAquario, tamanhoLombriga, posicaoCabeca, posicaoRabo, esquerda;
    String aquario;
    
    public AquarioLombriga (int tamanhoAquario, int tamanhoLombriga, int posicaoCabeca) {
        this.tamanhoAquario = tamanhoAquario;
        this.aquario = "";
        
       
        if (posicaoCabeca <= tamanhoAquario)
            this.posicaoCabeca = posicaoCabeca;
        else
            this.posicaoCabeca = 1;
        
        if (tamanhoLombriga + posicaoCabeca - 1 > this.tamanhoAquario)
            this.tamanhoLombriga = this.tamanhoAquario - this.posicaoCabeca + 1;
        else 
            this.tamanhoLombriga = tamanhoLombriga;
        
        this.posicaoRabo = this.posicaoCabeca + this.tamanhoLombriga-1;
        this.esquerda = 1;
        
        for (int i=1; i<=this.tamanhoAquario;i++) {
            if (i == this.posicaoCabeca)
                this.aquario = this.aquario + "O";
            else if (i>=this.posicaoCabeca && i <=this.posicaoRabo)
                this.aquario += "@";
            else
                this.aquario = this.aquario + "#";  
        }
    }
    
    public void crescer(AquarioLombriga lombriga) {
        if (lombriga.esquerda == 1 && lombriga.posicaoRabo!=lombriga.tamanhoAquario) {
            lombriga.aquario = lombriga.aquario.substring(0,lombriga.posicaoRabo) + "@" + lombriga.aquario.substring(lombriga.posicaoRabo+1);
            lombriga.posicaoRabo +=1;
            lombriga.tamanhoLombriga++;
        }
        else if (lombriga.esquerda == 0 && lombriga.posicaoRabo != 1) {
            lombriga.aquario = lombriga.aquario.substring(0,lombriga.posicaoRabo-2) + "@" + lombriga.aquario.substring (lombriga.posicaoRabo-1);
            lombriga.posicaoRabo -=1;
            lombriga.tamanhoLombriga++;
        }
    }
    
    public void mover (AquarioLombriga lombriga) {
        if (lombriga.esquerda == 0 && lombriga.posicaoCabeca != lombriga.tamanhoAquario) {
            lombriga.aquario = "#" + lombriga.aquario.substring(0, lombriga.tamanhoAquario-1);
            lombriga.posicaoCabeca +=1;
            lombriga.posicaoRabo +=1;
        }
        else if (lombriga.esquerda == 1 && lombriga.posicaoCabeca != 1) {
            lombriga.aquario = lombriga.aquario.substring (1) + "#";
            lombriga.posicaoCabeca -=1;
            lombriga.posicaoRabo -=1;
        }
        else if (lombriga.esquerda == 0 && lombriga.posicaoCabeca == lombriga.tamanhoAquario) {
            lombriga.aquario = lombriga.aquario.substring(0,lombriga.posicaoRabo-1) + "O" + lombriga.aquario.substring(lombriga.posicaoRabo-1, lombriga.posicaoCabeca-1) + "@";
            int aux = lombriga.posicaoCabeca;
            lombriga.posicaoCabeca = lombriga.posicaoRabo;
            lombriga.posicaoRabo = aux;
            lombriga.esquerda = 1;
            
        }
        else if (lombriga.esquerda == 1 && lombriga.posicaoCabeca == 1) {
            lombriga.aquario = lombriga.aquario.substring (1, lombriga.posicaoRabo) + "O" + lombriga.aquario.substring(lombriga.posicaoRabo);
            int aux = lombriga.posicaoCabeca;
            lombriga.posicaoCabeca = lombriga.posicaoRabo;
            lombriga.posicaoRabo = aux;
            lombriga.esquerda = 0;
        }
    }
    
    
    public void virar (AquarioLombriga lombriga) {
        if (lombriga.esquerda == 0) {
            lombriga.aquario = lombriga.aquario.substring(0, lombriga.posicaoRabo-1) + "O" + lombriga.aquario.substring(lombriga.posicaoRabo -1, lombriga.posicaoCabeca) + lombriga.aquario.substring(lombriga.posicaoCabeca+1);
            int aux = lombriga.posicaoCabeca;
            lombriga.posicaoCabeca = lombriga.posicaoRabo;
            lombriga.posicaoRabo = aux;
            lombriga.esquerda = 1;
        }
        else if (lombriga.esquerda == 1) {
            lombriga.aquario = lombriga.aquario.substring(0, lombriga.posicaoCabeca-1) + lombriga.aquario.substring (lombriga.posicaoCabeca, lombriga.posicaoRabo) + "O" + lombriga.aquario.substring(lombriga.posicaoRabo);
            int aux = lombriga.posicaoCabeca;
            lombriga.posicaoCabeca = lombriga.posicaoRabo;
            lombriga.posicaoRabo = aux;
            lombriga.esquerda = 0;
        }
    }
    
    public String apresenta(AquarioLombriga lombriga) {
        return lombriga.aquario;
    } 
}

