import java.util.Arrays;
public class quicksort{

    public static void main(String[] args){
        int[] v = {12, 489488999, 3514, 1489, 1749, 456, 789, 123, 184, 943, 4449};
        System.out.println(Arrays.toString(v));
        quickSort(v, 0, v.length-1);
        System.out.println(Arrays.toString(v));
    }
    private static void quickSort(int[] v, int esquerda, int direita){
        if(esquerda < direita){
            int j = separar(v, esquerda, direita);
            quickSort(v, esquerda, j-1);
            quickSort(v, j+1, direita);
        }
    } 

    private static int separar(int[] v, int esquerda, int direita){
        int i = esquerda + 1;
        int j = direita;
        int pivo = v[esquerda];
        while (i <= j){
            if (v[i] <= pivo) i++;
            else if (v[j] > pivo) j--;
            else if (i <= j){
                trocar(v, i, j);
                i++;
                j--;
            }
        }
        trocar(v, esquerda, j);
        return j;

    }

    private static void trocar(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }



}