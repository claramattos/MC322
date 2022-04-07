package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

	  //iniciamos o toolkit
      public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
            
      
      for (int i=0;i<lombrigas.length;i++) {
    	  //criamos uma nova animacao e uma nova lombriga com as condicoes dadas
    	 Animacao desenho = new Animacao(lombrigas[i]);
    	 AquarioLombriga lombriga = new AquarioLombriga (desenho.tamanhoAquario, desenho.tamanhoLombriga, desenho.posicaoCabeca);
    	 //conectamos as duas classes e apresentamos a lombriga em suas condições iniciais
    	 desenho.conecta(lombriga);
    	 desenho.apresenta();
    	 tk.gravaPasso("=====");
    	 //enquanto ainda tiverem passos para serem lidos, animamos a lombriga
    	 while(desenho.posicaoPasso != desenho.passos2.length) {
    		 tk.gravaPasso(desenho.apresenta());
    		 desenho.passo();
    	 }
    	 
      }
      
      tk.stop();
   }

}
