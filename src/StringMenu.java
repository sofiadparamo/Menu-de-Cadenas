/*

#Created by SweetSofiMC. MIT License

*/



import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class StringMenu {
    //Colores para la consola
    private static String format[]={"\033[0m","\u001B[1m","\033[31m","\033[32m","\033[33m","\033[34m","\033[35m","\033[36m"};
    //variables y objetos globales
    private static Scanner leer = new Scanner(System.in);
    private static int cont;
    private static String nombres[];

    //Método main
    public static void main(String[] args) throws IOException {
        //Variables y objetos locales
        Random ran = new Random();
        int tam;
        int opc;

        //Deshabilitar colores para consolas no aptas
        System.out.print("¿Estás usando terminal Unix? (S/N): ");
        String unix = leer.nextLine();
        unix = unix.toUpperCase();

        if(unix.equals("N")) {
            System.out.println("Mostrando texto sin formato:");
            for (int i = 0; i < 8; i++)
                format[i] = "";
        }
        //Generar arreglo global
        tam = ran.nextInt(6)+5;
        nombres = new String[tam];
        System.out.println(format[6]+"El arregló tendrá "+tam+" espacios disponibles.");
        //Núcleo del programa
        do{
            System.out.println(format[1]+format[7]+"\tMenú"+format[0]);
            System.out.print(format[3]+"1. Ingresar Cadena\n2. Mostrar Arreglo\n3. Ver Tamaño\n4. Borrar Cadena\n5. Salir"+format[4]+format[1]+"\n\nIngresa Opción: ");
            opc=leer.nextInt();
            switch (opc){
                case 1:
                    ingresar();
                    break;
                case 2:
                    mostrar();
                    break;
                case 3:
                    tamano(tam);
                    break;
                case 4:
                    eliminar();
            }
        }while(opc!=5);
    }
    //Método para ingresar cadena
    private static void ingresar(){
        if (cont<nombres.length) {
            System.out.print(format[5]+"Ingresa la cadena: ");
            nombres[cont] = leer.next();
            cont++;
        } else {
            System.out.println(format[2]+format[1]+"El arreglo ya está lleno");
        }

    }
    //Método para mostrar cadena
    private static void mostrar() throws IOException {
        if (cont!=0) {
            int i = 0;
            System.out.print(format[6] + "\n\n[");
            do {
                System.out.print(nombres[i]);
                if (i < cont - 1)
                    System.out.print(", ");
                i++;
            } while (i < cont);
            //Formato y espera
            System.out.print("]\n\n" + format[0]);
            System.out.print(format[7]+"Pulse Intro para continuar...");
            System.in.read();
            System.out.println("\n\n");
        } else {
            System.out.println(format[2]+format[1]+"No hay nada para mostrar");
        }
    }
    //Método de tamaño
    private static void tamano(int tam) throws IOException{
        int local = nombres.length-cont;
        System.out.println(format[3]+"\n\nTamaño de arreglo: "+tam+"\nCeldas ocupadas: "+cont+"\nCeldas libres: "+local+"\n\n");
        System.out.print(format[7]+"Presiona Intro para continuar...");
        System.in.read();
    }

    private static void eliminar(){
        if (cont>0) {
            cont--;
            System.out.println("\n"+format[2]+"Se ha eliminado la cadena "+nombres[cont]+".\n");
        }
        else
            System.out.println(format[2]+format[1]+"No hay nada para eliminar.");
    }

}
