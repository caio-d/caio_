package listaeder1;

public class teste {






    public static void main(String[] args){
    /*    GerenciadorDeMemoria g = new GerenciadorDeMemoria();

        g.configurar(1024);

        g.alocar(512);
        g.alocar(112);
        g.desalocar(1);
        g.alocar(512);
        g.desalocar(3);
        g.alocar(512);

        System.out.println(g.vazio());     */
       
    
        Gerenciador2 g = new Gerenciador2(10000);

        g.exibir();

   
        g.alocar(1000);

        System.out.println("pós alocação");

        g.exibir();

        g.alocar(1000);
        g.alocar(1500);

        g.exibir();

      

    }
    
}