package listaeder1;

public class Gerenciador2 {

    public Item base;
    public int tamanho;

    public Gerenciador2(int tamanho){
        this.tamanho = tamanho;
        base = new Item(0, tamanho);
    }

    public void exibir(){
        Item aux = this.base;
        while (aux != null) {
            System.out.println(aux);
            aux = aux.proximo;
        }
    }

    public int alocar(int tamanho){
        Item aux = this.base;

        // enquanto diferente de nulo e não achei
        // achei é quando não ta ocupado e o tamanho disponivel é maior que o tamanho que eu quero alocar
        while (aux != null && !(aux.ocupado == false && aux.tamanho >= tamanho)) {
            aux = aux.proximo;
        }
        System.out.println("debug: " + aux);

        if (aux == null) return -1;
        aux.proximo = new Item(aux.inicio + tamanho, aux.tamanho - tamanho);
        aux.proximo.anterior = aux;
        aux.ocupado = true;
        aux.tamanho = tamanho;

        return aux.inicio;
    }

    public int desalocar(int inicio){




        
        return inicio;
    }


    
}