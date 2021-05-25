package facuck.listadupla;

public class noListaDupla {

    private noListaDupla prox;
    private noListaDupla ant;
	private int info;

	public noListaDupla getProx(){
		return prox;
	}
	
	public void setProx(noListaDupla prox){
		this.prox = prox;
	}

	public noListaDupla getAnt(){
		return ant;
	}

	public void setAnt(noListaDupla ant){
		this.ant = ant;
	}
	
	public int getInfo(){
		return info;
	}

	public void setInfo(int info){
		this.info = info;
	}

	public String toString(){
		return getInfo() + " ";
	}
	
}