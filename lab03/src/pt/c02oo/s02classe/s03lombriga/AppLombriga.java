package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < lombrigas.length; l++)
         System.out.println(lombrigas[l]);
      
      
      for (int i=0;i<lombrigas.length;i++) {
    	 Animacao desenho = new Animacao(lombrigas[i]);
    	 AquarioLombriga lombriga = new AquarioLombriga (desenho.tamanhoAquario, desenho.tamanhoLombriga, desenho.posicaoCabeca);
    	 desenho.conecta(lombriga);
    	 desenho.apresenta();
    	 tk.gravaPasso("=====");
    	 for (i=6;i<lombrigas[i].length() + 1; i++) {
    		 desenho.passo();
    		 tk.gravaPasso(desenho.apresenta());
    	 }
      }
      tk.stop();
   }

}
