package pt.c02oo.s02classe.s03lombriga;


public class AquarioLombriga { 
    int tamanhoAquario, tamanhoLombriga, posicaoCabeca, posicaoRabo, esquerda;
    String aquario;
    
    public AquarioLombriga (int tamanhoAquario, int tamanhoLombriga, int posicaoCabeca) {
        this.tamanhoAquario = tamanhoAquario;
        this.aquario = "";
        
        //estabelece as condições iniciais(tamanho do aquario, da lombriga, posicao do rabo e da cabeca)
        //e as altera, caso necessário
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
    
    public void crescer() {
    	//a lombriga cresce, caso possivel, de acordo com sua direção
        if (esquerda == 1 && posicaoRabo!=tamanhoAquario) {
            aquario = aquario.substring(0,posicaoRabo) + "@" + aquario.substring(posicaoRabo+1);
            posicaoRabo +=1;
            tamanhoLombriga++;
        }
        else if (esquerda == 0 && posicaoRabo != 1) {
            aquario = aquario.substring(0,posicaoRabo-2) + "@" + aquario.substring (posicaoRabo-1);
            posicaoRabo -=1;
            tamanhoLombriga++;
        }
    }
    
    public void mover () {
    	//caso a lombriga não precise virar, apenas se mover
        if (esquerda == 0 && posicaoCabeca != tamanhoAquario) {
            aquario = "#" + aquario.substring(0, tamanhoAquario-1);
            posicaoCabeca +=1;
            posicaoRabo +=1;
        }
        else if (esquerda == 1 && posicaoCabeca != 1) {
            aquario = aquario.substring (1) + "#";
            posicaoCabeca -=1;
            posicaoRabo -=1;
        }
        //caso a lombriga precise virar
        else if (esquerda == 0 && posicaoCabeca == tamanhoAquario) {
            aquario = aquario.substring(0,posicaoRabo-1) + "O" + aquario.substring(posicaoRabo-1, posicaoCabeca-1) + "@";
            int aux = posicaoCabeca;
            posicaoCabeca = posicaoRabo;
            posicaoRabo = aux;
            esquerda = 1;
            
        }
        else if (esquerda == 1 && posicaoCabeca == 1) {
            aquario = aquario.substring (1, posicaoRabo) + "O" + aquario.substring(posicaoRabo);
            int aux = posicaoCabeca;
            posicaoCabeca = posicaoRabo;
            posicaoRabo = aux;
            esquerda = 0;
        }
    }
    
    
    public void virar () {
    	//vira a lombriga de acordo com sua posicao, trocando o caracter da cabeca com o do rabo
        if (esquerda == 0) {
            aquario = aquario.substring(0, posicaoRabo-1) + "O" + aquario.substring(posicaoRabo -1, posicaoCabeca) + aquario.substring(posicaoCabeca+1);
            int aux = posicaoCabeca;
            posicaoCabeca = posicaoRabo;
            posicaoRabo = aux;
            esquerda = 1;
        }
        else if (esquerda == 1) {
            aquario = aquario.substring(0, posicaoCabeca-1) + aquario.substring (posicaoCabeca, posicaoRabo) + "O" + aquario.substring(posicaoRabo);
            int aux = posicaoCabeca;
            posicaoCabeca = posicaoRabo;
            posicaoRabo = aux;
            esquerda = 0;
        }
    }
    
    public String apresenta() {
    	//apresenta a string do aquário com a lombriga
        return aquario;
    } 
}

