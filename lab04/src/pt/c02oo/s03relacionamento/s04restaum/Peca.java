package pt.c02oo.s03relacionamento.s04restaum;
import java.lang.Math; 

public class Peca {
	private int x, y;
	private boolean ativa;
	private char a ;
	private Tabuleiro tabuleiro;
	
	//inicializamos uma pe�a
	Peca(int x, int y, boolean ativa, char a) {
		this.tabuleiro = null;
		this.x=x;
		this.y=y;
		this.ativa=ativa;
		this.a = a;
	}
	
	//conectamos cada pe�a ao seu tabuleiro
	public void conecta(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	//descobrimos se existe uma pe�a na posi��o ou n�o
	public boolean getAtividade() {
		return ativa;
	}
	
	//mudamos a atividade de uma posi��o (ativando ou desativando uma pe�a)
	public void setAtividade(boolean ativa) {
		this.ativa = ativa;
	}
	
	//retornamos o caractere de dada posi��o
	public char getChar () {
		return a;
	}
	
	//mudamos o caractere de dada posi��o
	public void setChar (char a) {
		this.a=a;
	}
	
	//verificamos se � poss�vel realizar o movimento desejado
	public boolean podeMover (int linhaChegada, int colunaChegada) {
		//posi��o n�o faz parte da matriz
		if (linhaChegada>7 || linhaChegada < 0 || colunaChegada>7 || colunaChegada<0)
			return false;
		//posi��o n�o faz parte do tabuleiro
		else if ((linhaChegada<2 && colunaChegada<2) || (linhaChegada>4 && colunaChegada<2) || (linhaChegada<2 && colunaChegada>4) || (linhaChegada>4 && colunaChegada>4)) 
			return false;
		//caso a posi��o que se deseja ir seja na diagonal de onde se est�
		else if ((this.x != linhaChegada) && (this.y != colunaChegada))
			return false;
		//caso j� exista uma pe�a na posi��o que se deseja ir
		else if (tabuleiro.pecaAtiva(linhaChegada, colunaChegada) == true)
			return false;
		//caso a dist�ncia entre a posi��o inicial e final seja maior que 2 pe�as
		//caso n�o seja, a pe�a pode ser comida e � apagada
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
		//caso possamos mover a pe�a, mudamos a posi��o inicial e a final da pe�a
		if (podeMover(linhaChegada, colunaChegada) == true) {
			tabuleiro.mudaPecas(this.x, this.y);
			tabuleiro.mudaPecas(linhaChegada, colunaChegada);
		}
	}
}







