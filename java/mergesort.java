import java.util.Arrays;
public class mergesort{


    public static void main(String[] args){
        int v[] = {2, 323, 131, 22, 17, 99, 64};
        int w[] = new int[v.length];
        mergeSorty(v, w, 0, v.length-1);
        System.out.println(Arrays.toString(v));

    }

    private static void mergeSorty(int[] v, int[] w, int inicio, int fim) {
        if(inicio < fim){
            int meio = (inicio+fim) / 2;
            mergeSorty(v, w, inicio, meio);
            mergeSorty(v, w, meio+1, fim);
            intercalar(v, w, inicio, meio, fim);
        }

    }

    private static void intercalar(int[] v, int[] w, int inicio, int meio, int fim) {
        for(int k = inicio; k <= fim; k++) w[k] = v[k];
        
        int i = inicio;
        int j = meio + 1;         
        
        for(int k = inicio; k <= fim; k++){
            if(i > meio) v[k] = w[j++];
            else if (j > fim) v[k] = w[i++];
            else if (w[i] < w[j]) v[k] = w[i++];
            else v[k] = w[j++];

        }

    }

}