import java.util.*;
public class teste{

 
       public static void main(String[] args){
          Scanner sc = new Scanner(System.in);
          int valor1;
          int valor2;
          boolean jacksparrow;
          jacksparrow = false;
          System.out.print("Enter an integer: ");
         int b = 3;
         int c = 2;

          if (b == c){
             System.out.println("diferente");

          }
          System.out.println("stay away from me");
 
         while (!jacksparrow){

             try{
             valor1 = sc.nextInt();
             valor2 = sc.nextInt();
             jacksparrow = true;
             }
             catch (InputMismatchException e){
             sc.next();
             System.out.print("That’s not "
             + "an integer. Try again: ");




   }
  }
 }
}