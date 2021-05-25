package listaeder1;

public class GerenciadorDeMemoria {

    memoria prim;
    memoria ult;
    long tamanhoMemoria = 0;
    long identificadorbase = 0;
    long identificador = 0;

    // configurando o tamanho da memoria apenas alterando o valor dela
    // o limite não pode passar essa variável
    public void configurar(long tamanhoMemoria){
        this.tamanhoMemoria = tamanhoMemoria;
    }

    /* aqui ele cria uma novo espaço na memória e o espaço dela é multiplicado por mais 0,2 pra dar espaço pra crescer
    se n puder alocar retorna 0, verifica se é vazio pra definir o ultimo espaço
    ai faz tudo ali pra lista funcionar, ai a quantidade é subtraida da memoria total 
    o identificador base manda um identificador pra cada espaço de memoria na lista
    e ela tem valor absoludo, uma vez q o identificador numero 1 foi apagado nunca vai existir outro com o numero 1
    como teu programa deve fazer tudo com base nos retornos confio que vai funcionar
    */
    public long alocar(long quantidade){
        memoria novo = new memoria(quantidade);
        quantidade += quantidade*0.2;
        if(tamanhoMemoria < quantidade){
            return 0;
        }

        if (this.vazio()) ult = novo;
        novo.limite = quantidade;
        novo.prox = prim;
        novo.ant = null;
        if(prim != null) prim.ant = novo;
        prim = novo;
        this.tamanhoMemoria -= quantidade;
        identificadorbase++;
        novo.identificador = identificadorbase;

        return novo.identificador;
    }

    // aqui é um programa de auxilio pra remover, ele busca o valor q eu quero
    public memoria busca(long v){
        memoria tmp = this.prim;
        while (tmp != null){
            if (tmp.identificador == v) return tmp;
            tmp = tmp.prox;
        }

        return null;
    }

    /* aqui faz toda a coisa pra remover o espaço de memoria da lista
    ai o valor q foi liberado soma pra totalidade da memoria livre
    e retorna o identificador pra fins academicos
    */
    public long desalocar(long identificador){
        memoria tmp = busca(identificador); 
        if (tmp == null) return 0;
        if (prim == tmp) prim = tmp.prox;
        else tmp.ant.prox = tmp.prox;
        if (tmp.prox != null) tmp.prox.ant = tmp.ant;
        tamanhoMemoria += tmp.limite;
        return tmp.identificador;
    }

    // aqui ele vai e pega todos os valores de limite e soma pra ter a base da memoria ocupada
    public long memoriaOcupada(long identificador){
        long ocupada = 0;
        memoria tmp = this.prim;
        while(tmp != null){
            ocupada += tmp.limite;
            tmp = tmp.prox;
        }

        return ocupada;
    }

    //aqui ele pega o tamanho da memoria q já ta no modo de memoria livre pq ela é acessada livremente
    public long memoriaLivre(long identificador){
        return tamanhoMemoria;
    }

    //outro metodo auxiliar pra verificar se a memoria ta vazia
    public boolean vazio(){
        return (this.prim == null);
    }
}