package listaeder1;

public class memoria {

    public long identificador = 0;
    public long limite;
    public memoria prox;
    public memoria ant;

    // inicializo uma lista nula
    public memoria(long limite){
        this.limite = limite;
        this.prox = null;
    }

    // tostring da base
    public String toStringBase(){
        return identificador + " ";
    }

    // tostring do limite
    public String toStringLimite(){
        return limite + " ";
    }
}