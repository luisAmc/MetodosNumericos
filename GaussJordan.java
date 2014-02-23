/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Metodos;

import java.util.Scanner;

/**
 *
 * @author Luis Martinez
 */
public class GaussJordan {
    final static double[][] matrizA = {{2, 1, -1, 8}, 
                                       {-3, -1, 2, -11}, 
                                       {-2, 1, 2, -3}
                                      };
    final static double[][] matrizB = new double[15][15];
    final static double[][] matrizC = new double[20][20];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int orden, opcion;
        opcion = Integer.parseInt(menuPrincipal());
        while (opcion != 2) {
            orden = cualMatriz();
            switch (orden) {
                case 1:
                    print(matrizA);
                    resolverMatriz(matrizA, 3);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Como llegaste aqui?");
                    break;
            }
            System.out.println("");
            opcion = Integer.parseInt(menuPrincipal());
        }
    }
    
    public static String menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        do {
            opcion = "";
            System.out.println("Metodo de Gauss-Jordan\n"
                    + "1) Resolver una matriz\n"
                    + "2) Salir\n"
                    + "Ingrese su opcion:");
            opcion = sc.nextLine();
        } while ((opcion.charAt(0) != '1' || opcion.charAt(0) != '2') && opcion.length() > 1);
        return opcion;
    }
    
    public static int cualMatriz() {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        do {
            System.out.println("\nSeleccion el orden de la matriz\n"
                    + "1) 10\n"
                    + "2) 15\n"
                    + "3) 20\n"
                    + "Ingrese su opcion:");
            opcion = sc.nextLine();
        } while ((opcion.charAt(0) != '1' || opcion.charAt(0) != '2' || opcion.charAt(0) != '3') && opcion.length() > 1);
        return Integer.parseInt(opcion);
    }

    public static void resolverMatriz(double[][] matriz, int orden) {
        String[] variables = {"X1", "X2", "X3", "X4", "X5", "X6", "X7", "X8", "X9", "X10", "X11", "X12", "X13", "X14", "X15", "X16", "X17", "X18", "X19", "X20"};
        double tmp;
        long time1 = System.nanoTime();
        for (int i = 0; i < orden; i++) {
            tmp = 1 / matriz[i][i];
            for (int j = 0; j < orden; j++) {
                matriz[i][j] *= tmp;
            }
            matriz[i][orden] *= tmp;
            
            for (int j = 0; j < i; j++) {
                tmp = -1 * matriz[j][i];
                matriz[j][orden] += matriz[i][orden] * tmp;
                for (int k = 0; k < orden; k++) {
                    matriz[j][k] += tmp *matriz[i][k];
                }
            }
            for (int j = i + 1; j < orden; j++) {
                tmp = -1 * matriz[j][i];
                for (int k = 0; k < orden; k++) {
                    matriz[j][k] += tmp * matriz[i][k];
                }
                matriz[j][orden] += matriz[i][orden] * tmp;
            }
        }
        long time2 = System.nanoTime();
        System.out.println("\nLa respuesta es:");
        for (int i = 0; i < orden; i++) {
            System.out.println(variables[i] + " = " + matriz[i][orden]);
        }
        System.out.println("\nMe tarde " + (time2 - time1) + " nanosegundos en resolverlo.\n"
                + "Esto es pan comido!\n");
    }
    
    public static void print(double[][] matriz) {
        System.out.println("La matriz es original es:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print( matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
