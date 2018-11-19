package ec.edu.uce.algoritmos.clases;

import java.util.Scanner;

/**
 * Metodo login
 *
 * @author Marcos
 */
public class Login {

    private static String usuario, contraseña;     // variables a utilizar
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Metodo inUsuario que sirve para ingresar al programa
     */
    public static void inUsuario() {
        boolean acceso = false;

        do {
            System.out.println("** INGRESO AL SISTEMA **");
            System.out.print("  Usuario: ");
            usuario = sc.nextLine();                      //lectura de usuario
            System.out.print("  Contraseña: ");
            contraseña = sc.nextLine();                   //lectura de contraseña
            System.out.println("************************");
            if (usuario.equals("marcos") && contraseña.equals("alcivar")) //comparacion de usuario y contraseña
            {
                acceso = true; //si el usuario y contraseña es correcto el acceso es verdadero y se saldra del bucle
            } else {
                System.out.println("Ingrese datos correctos\n");

            }
        } while (acceso == false);    //mientras no se ingrese el nombre y usuario correcto permanecera en el bucle 
    }

}
