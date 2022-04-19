package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {
	public static void main(String[] args) {
		//executamos o jogo
	   AppRestaUm.executaJogo(null, null);
   }

   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
	   //inicializamos as variáveis
	  int linhaPartida, colunaPartida, linhaChegada, colunaChegada;
	  char board[][] = {
    		  {' ', ' ', 'P', 'P', 'P', ' ', ' '},
    		  {' ', ' ', 'P', 'P', 'P', ' ', ' '},
    		  {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
    		  {'P', 'P', 'P', '-', 'P', 'P', 'P'},
    		  {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
    		  {' ', ' ', 'P', 'P', 'P', ' ', ' '},
    		  {' ', ' ', 'P', 'P', 'P', ' ', ' '}
      };
	  
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
      
      tk.writeBoard("Tabuleiro inicial", board);
      
      //inicializamos o tabuleiro e o conectamos às suas peças
	  Tabuleiro tabuleiro = new Tabuleiro(board);
	  tabuleiro.conectaPeca(tabuleiro);
	   
	  for (int i = 0;i<commands.length;i++) {
		   //armazenamos a sour e e o target
		   //aqui, como as posições começam em 0 em uma matriz, a linha corresponderá ao seu valor numérico menos 1
		   linhaPartida = Character.getNumericValue(commands[i].charAt(1))-1;
		   linhaChegada = Character.getNumericValue(commands[i].charAt(4))-1;
		   //aqui, como o caracter 'a' tem número 97 na tabela ASCII, encontramos o número das colunas fazendo a seguinte conta:
		   colunaPartida = (int)(commands[i].charAt(0))-97;
		   colunaChegada = (int)(commands[i].charAt(3))-97;
		   
		   //realizamos o movimento desejado (se possível)
		   tabuleiro.movimentaPeca(linhaPartida, colunaPartida, linhaChegada, colunaChegada);
		   
		   //o tabuleiro é impresso
		   tk.writeBoard("source: " + commands[i].substring(0,2) + ";" + " target: " + commands[i].substring(3), tabuleiro.getTabuleiroChar());
	   }
	   
      tk.stop();
   }

}