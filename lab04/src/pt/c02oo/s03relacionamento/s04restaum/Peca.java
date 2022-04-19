package pt.c02oo.s03relacionamento.s04restaum;
import java.lang.Math; 

public class Peca {
	private int x, y;
	private boolean ativa;
	private char a ;
	private Tabuleiro tabuleiro;
	
	//inicializamos uma peça
	Peca(int x, int y, boolean ativa, char a) {
		this.tabuleiro = null;
		this.x=x;
		this.y=y;
		this.ativa=ativa;
		this.a = a;
	}
	
	//conectamos cada peça ao seu tabuleiro
	public void conecta(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	//descobrimos se existe uma peça na posição ou não
	public boolean getAtividade() {
		return ativa;
	}
	
	//mudamos a atividade de uma posição (ativando ou desativando uma peça)
	public void setAtividade(boolean ativa) {
		this.ativa = ativa;
	}
	
	//retornamos o caractere de dada posição
	public char getChar () {
		return a;
	}
	
	//mudamos o caractere de dada posição
	public void setChar (char a) {
		this.a=a;
	}
	
	//verificamos se é possível realizar o movimento desejado
	public boolean podeMover (int linhaChegada, int colunaChegada) {
		//posição não faz parte da matriz
		if (linhaChegada>7 || linhaChegada < 0 || colunaChegada>7 || colunaChegada<0)
			return false;
		//posição não faz parte do tabuleiro
		else if ((linhaChegada<2 && colunaChegada<2) || (linhaChegada>4 && colunaChegada<2) || (linhaChegada<2 && colunaChegada>4) || (linhaChegada>4 && colunaChegada>4)) 
			return false;
		//caso a posição que se deseja ir seja na diagonal de onde se está
		else if ((this.x != linhaChegada) && (this.y != colunaChegada))
			return false;
		//caso já exista uma peça na posição que se deseja ir
		else if (tabuleiro.pecaAtiva(linhaChegada, colunaChegada) == true)
			return false;
		//caso a distância entre a posição inicial e final seja maior que 2 peças
		//caso não seja, a peça pode ser comida e é apagada
		else if (this.x == linhaChegada) {
			if (Math.floorMod(this.y, colunaChegada)>2) 
				return false;
			else
				tabuleiro.apagaPeca(linhaChegada, (colunaChegada+this.y)/2);
		}
		else if (this.y == colunaChegada) {
			if (Math.floorMod(this.x, linhaChegada)>2)
				return false;
			else
				tabuleiro.apagaPeca((linhaChegada+this.x)/2, colunaChegada);
		}
	
		//pode ser movida
		return true;
	}
	
	public void mover(int linhaChegada, int colunaChegada) {
		//caso possamos mover a peça, mudamos a posição inicial e a final da peça
		if (podeMover(linhaChegada, colunaChegada) == true) {
			tabuleiro.mudaPecas(this.x, this.y);
			tabuleiro.mudaPecas(linhaChegada, colunaChegada);
		}
	}
}







