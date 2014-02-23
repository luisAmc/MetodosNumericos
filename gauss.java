/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

/**
 *
 * @author EDWIN NUÑEZ
 */
import java.util.Random;
import java.util.Scanner;
public class Gauss {

    /**
     * @param args the command line arguments
     */static Scanner E = new Scanner(System.in);
         static Random R = new Random();
    public static void main(String[] args) {
        // TODO code application logic here
        double [][]matriz={{2,1,-1,8},{-3,-1,2,-11},{-2,1,2,-3}};
        double [][]A = MatrizM("A");
        /*double [][]B = MatrizM("B");
        double [][]C = MatrizM("C");*/
        System.out.println("Matriz A:");
        imprimirArreglo(A);
        /*System.out.println("Matriz B:");
        imprimirArreglo(B);
        System.out.println("Matriz C:");
        imprimirArreglo(C);*/
        resolverMatriz(matriz,3);
        
    }

    public static double[][] MatrizM(String name)
    {
        System.out.println("Ingrese número de filas de la matriz " + name + ".");
        int m = E.nextInt();
        System.out.println("Ingrese número de columnas de la matriz " + name + ".");
        int n = E.nextInt();
        double [][]M = new double[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                M[i][j] = R.nextInt(9);

        return M;
    }

   public static void imprimirArreglo(double arreglo[][])
    {
        if (arreglo != null)
        for (int fila = 0; fila < arreglo.length; fila++)
        {
            System.out.print("|  ");
            for (int columna = 0; columna < arreglo[fila].length; columna++)
                System.out.print(arreglo[fila][columna] + "  ");

            System.out.print("|\n");
        }
        System.out.println();
    }
   
   public static void resolverMatriz(double[][] matriz, int orden) 
   {
        
        double tmp;
        double tmp2=0;
        long time1 = System.nanoTime();
        for (int i = 0; i < orden; i++) 
        {
            tmp = 1 / matriz[i][i];
            for (int j = 0; j < orden; j++) {
                matriz[i][j] *= tmp;
            }
            matriz[i][orden] *= tmp;
            
            for (int j=i+1; j<orden; j++ ){
                tmp=-1*matriz[j][i];
                for(int m=0; m<orden; m++)
                {
                   matriz[j][m]+=tmp*matriz[i][m];
                }
                matriz[j][orden]+=matriz[i][orden]*tmp;
            }
        }
        matriz[orden-1][orden]/=matriz[orden-1][orden-1];
       for (int i = orden-1; i > -1; i--) {
           tmp2 = 0;
           for(int j=i+1; j<orden; j++)
           {
              tmp2 += matriz[i][j]*matriz[j][orden];
           }
           matriz[i][orden]=(matriz[i][orden]-tmp2)/matriz[i][i];
       }
        long time2 = System.nanoTime();
        System.out.println("\nLa respuesta es:");
        for (int i = 0; i < orden; i++) 
        {
            System.out.println(matriz[i][orden]);
        }
            System.out.println("\nMe tarde " + (time2 - time1) + " nanosegundos en resolverlo.\n"
            + "Esto es pan comido!\n");
    }
   

}