import java.util.Arrays;
public class bubblesort{

    public static void main(String[] args){
        int[] v = {55, 35, 34, 12, 12, 24, 66, 1, 99, 0, 96, 75, 85, 72, 91};
        bolha(v);
        System.out.println(Arrays.toString(v));
    }

    private static void bolha(int[] v) {
        for(int ultimo = v.length-1; ultimo > 0; ultimo--){
            for(int i = 0; i < ultimo; i++){
                if(v[i] > v[i+1]){
                trocar(v, i, i+1);
                }
            }
        }
    }

    private static void trocar(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }


}