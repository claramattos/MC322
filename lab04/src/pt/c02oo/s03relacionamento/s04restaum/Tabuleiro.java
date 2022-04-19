package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private Peca tabuleiro[][] = new Peca[7][7];
	char board[][];
	
	//inicializamos o tabuleiro
	public Tabuleiro(char board[][]) {
		this.board = board;
		for (int x=0;x<7;x++) {
			for (int y=0;y<7;y++) {
				if ((x>=2 && x <= 4) || (y>=2 && y<=4) ) {
					this.tabuleiro[x][y] = new Peca(x,y,true,'P');
					if (x==3 && y == 3) {
						this.tabuleiro[x][y] = new Peca(x,y,false, '-');
					}
				}
				else
					this.tabuleiro[x][y] = new Peca(x,y,true, ' ');
			}
		}
	}
	
	//verificamos se existe uma peça na posição (x,y)
	public boolean pecaAtiva (int x, int y) {
		return (tabuleiro[x][y].getAtividade());
	}
	
	//atualizamos o board com as informações do tabuleiro
	public char[][] getTabuleiroChar () {
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				board[i][j] = tabuleiro[i][j].getChar();
			}
		}
		return board;
	}
	
	//caso uma peça esteja ativa, a desativamos e, caso esteja desativa, ativamos ela
	public void mudaPecas (int x, int y) {
		if (tabuleiro[x][y].getAtividade() == true) {
			tabuleiro[x][y].setAtividade(false); 
			tabuleiro[x][y].setChar('-');
		}
		else {
			tabuleiro[x][y].setAtividade(true); 
			tabuleiro[x][y].setChar('P');
		}
	}
	
	//comemos uma peça
	public void apagaPeca (int x, int y) {
		mudaPecas(x,y);
	}
	
	//caso possível, movimentamos uma peça
	public void movimentaPeca(int linhaPartida, int colunaPartida, int linhaChegada, int colunaChegada) {
		tabuleiro[linhaPartida][colunaPartida].mover(linhaChegada, colunaChegada);
	}
	
	//conectamos o tabuleiro às suas peças
	public void conectaPeca(Tabuleiro tabuleiroPeca) {
		for(int x = 0; x < 7; x++) 
			for(int y = 0; y < 7; y++) 
				tabuleiro[x][y].conecta(tabuleiroPeca);
	}
}
