package listaeder1;

public class Item {

    public int inicio;
    public int tamanho;
    public boolean ocupado;

    public Item anterior;
    public Item proximo;

    public Item(int inicio, int tamanho){
        this.inicio = inicio;
        this.tamanho = tamanho;
        this.ocupado = false;

        this.anterior = null;
        this.proximo = null;
    }

    public String toString(){
        return "inicio: " + inicio + ", tamanho: " + tamanho + ", ocupado: " + ocupado;
    }

    
}