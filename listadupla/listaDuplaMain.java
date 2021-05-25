package facuck.listadupla;

public class listaDuplaMain {

    public static void main(String[] args){

        listaDupla l = new listaDupla();
        listaDupla l2 = new listaDupla();
        listaDupla l3 = new listaDupla();

        l.insere(2);
        l.insere(3);
        l.insere(4);
        l.insere(9);
        l.insere(10);
        l.insere(200);
    
        l.retira(4);

        l.imprime();
        System.out.println("buscando: " + l.busca(2));
        System.out.println("vazio? = " + l.vazio());

        l2.insere(2);
        l2.insere(3);
        l2.insere(4);
        l2.insere(922);
        l2.insere(10);
        l2.insere(200);
    
        l2.retira(4);

        
        l3.insere(4);
        l3.insere(9);
        l3.insere(10);
        l3.insere(200);
    
        
        System.out.println("a lista l é igual a lista l2??? " + l.igual(l2));
        System.out.println("a lista l2 é igual a lista l3??? " + l2.igual(l3));

        System.out.println("liberando...");
        l.libera();

        l.imprime();
        System.out.println("é vazio? = " + l.vazio());

        listaDupla l4 = l.merge(l2);
        l4.imprime();
    }
    
}