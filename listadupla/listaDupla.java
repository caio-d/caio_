package facuck.listadupla;

public class listaDupla {

    private noListaDupla prim;

    public listaDupla(){
        this.prim = null;
    }

    public noListaDupla getPrim(){
        return prim;
    }

    public void setPrim(noListaDupla prim){
        this.prim = prim;       
    }

    public void insere(int v){
        noListaDupla novo = new noListaDupla();
        novo.setInfo(v);
        novo.setProx(this.prim);
        novo.setAnt(null);
        if(prim != null) prim.setAnt(novo);
        this.prim = novo;
    }

    public void imprime(){
        noListaDupla tmp = this.prim;
        while(tmp != null){
            System.out.println("imprimindo: " + tmp.getInfo());
            tmp = tmp.getProx();
        }
    }

    public boolean vazio(){
        return (this.prim == null);
    }


    public noListaDupla busca(int v){
        noListaDupla tmp = this.prim;
        while (tmp != null){
            if (tmp.getInfo() == v) return tmp;
            tmp = tmp.getProx();
        }

        return null;
    }

    public void retira(int v){
        noListaDupla tmp = busca(v);
        if (tmp == null) return;

        if (prim == tmp) setPrim(tmp.getProx());
        else tmp.getAnt().setProx(tmp.getProx());
        
        if (tmp.getProx() != null) tmp.getProx().setAnt(tmp.getAnt());
    }

    public void libera(){
        noListaDupla tmp = this.prim;
        tmp.setProx(null);   
        setPrim(null);
    }

    public boolean igual(listaDupla l){
        noListaDupla aux = l.prim;
        noListaDupla aux2 = this.prim;

        while (aux != null && aux2 != null){
            if (aux.getInfo() != aux2.getInfo()) return false;
            else{
                aux = aux.getProx();
                aux2 = aux2.getProx();
            }
        }

        return true;
    }

    public listaDupla merge(listaDupla l){
        noListaDupla aux = l.prim;
        noListaDupla aux2 = this.getPrim();

        while (aux != null && aux2 != null){
            aux.setProx(aux2);
            aux = aux.getProx();
            l.prim = aux;
            l.prim = l.prim.getProx();
            aux2 = aux2.getProx();
            }
        
        return l;
    }


}