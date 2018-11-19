package ec.edu.uce.algoritmos.clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Metodos Menus
 *
 * @author Marcos
 */
public class Menus {

    private static final BufferedReader ar = new BufferedReader(new InputStreamReader(System.in));
    private static int numero, numero_ordenar, numero_bus, numero_edit; //inicializacion de las variables

    /**
     * Metodo menu principal
     *
     * @return Menu principal
     * @throws IOException
     */
    public static int menup() throws IOException {  // menu principal
        System.out.println("\n******** MENU ***********");
        System.out.println("  1. INSERTAR DATOS ");
        System.out.println("  2. ORDENACION     ");
        System.out.println("  3. BUSQUEDA");
        System.out.println("  4. EJ. ALG.VORACES");
        System.out.println("  5. EJ. ALG.VUELTA ATRAS");
        System.out.println("  6. SALIR ");;
        System.out.print("*****************************");
        do {
            try {    //codigo que puede presentar un error al momento de ingreso
                System.out.print("\n Elija una opcion: ");
                numero = Integer.parseInt(ar.readLine());      //lectura de una opcion del menu principal
                if (numero > 6 || numero < 1) //si el numero no se encuentra dentro del rango 1-6 se imprimira un mensaje
                {
                    System.out.println("Error ingreso de opcion!!");
                }
            } catch (NumberFormatException entero) {  //si existe un error en lectura o ingreso no se ejecutara el try
                System.out.println("Error ingreso de opcion!!"); //si hubo un error dentro del try se imprimira un mensaje de error
                numero = 0; //numero sera cero para que vuelva ah entrar al bucle ya que si se ingresa un numero valido y luego una letra queda guardado el numero y se saldra del bucle con esto evitamos eso 
            }
        } while (numero > 6 || numero < 1); //mientras numero no se encuentre dentro del rango 1-6 se mantendra el bucle hasta que se ingrese un numero valido
        return numero; //retorna un numero valido         
    }

    /**
     * Metodo menu
     *
     * @return menu de la primera opcion
     * @throws IOException
     */
    public static int menu() throws IOException {  // menu principal
        System.out.println("\n******** MENU ********");
        System.out.println("  1. CREAR AUTO ");
        System.out.println("  2. EDITAR AUTO   ");
        System.out.println("  3. BORRAR AUTO");
        System.out.println("  4. LISTAR AUTO ");
        System.out.println("  5. REGRESAR ");
        System.out.print("**********************");
        do {
            try {    //codigo que puede presentar un error al momento de ingreso
                System.out.print("\n Elija una opcion: ");
                numero = Integer.parseInt(ar.readLine());      //lectura de una opcion del menu principal
                if (numero > 5 || numero < 1) //si el numero no se encuentra dentro del rango 1-6 se imprimira un mensaje
                {
                    System.out.println("Error ingreso de opcion!!");
                }
            } catch (NumberFormatException entero) {  //si existe un error en lectura o ingreso no se ejecutara el try
                System.out.println("Error ingreso de opcion!!"); //si hubo un error dentro del try se imprimira un mensaje de error
                numero = 0; //numero sera cero para que vuelva ah entrar al bucle ya que si se ingresa un numero valido y luego una letra queda guardado el numero y se saldra del bucle con esto evitamos eso 
            }
        } while (numero > 5 || numero < 1); //mientras numero no se encuentre dentro del rango 1-6 se mantendra el bucle hasta que se ingrese un numero valido
        return numero; //retorna un numero valido         
    }

    /**
     * Metodo menuEditar
     *
     * @return menu de la primera opcion del submenu(menu)
     * @throws IOException
     */
    public static int menuEditar() throws IOException { //menu de opciones a editar en un vehiculo
        System.out.println("\n********* EDITAR *********");
        System.out.println("  1. PLACA ");
        System.out.println("  2. MARCA   ");
        System.out.println("  3. AÑO");
        System.out.println("  4. FECHA DE FABRICACION ");
        System.out.println("  5. PRECIO ");
        System.out.println("  6. REGRESAR ");
        System.out.println("**************************");
        do {
            try {  //codigo que puede presentar un error al momento de ingreso
                System.out.print("\n Elija una opcion: ");
                numero_edit = Integer.parseInt(ar.readLine());  //lectura de una opcion a editar
                if (numero_edit < 1 || numero_edit > 6) //si el numero no se encuentra dentro del rango 1-8 se imprimira un mensaje
                {
                    System.out.println("Error ingreso de opcion!!");
                }
            } catch (NumberFormatException entero) {       //si existe un error en lectura o ingreso no se ejecutara el try
                System.out.println("Error ingreso de opcion!!");       //si hubo un error dentro del try se imprimira un mensaje de error
                numero_edit = 0;      //numero sera cero para que vuelva ah entrar al bucle ya que si se ingresa un numero valido y luego una letra queda guardado el numero y se saldra del bucle con esto evitamos eso
            }
        } while (numero_edit < 1 || numero_edit > 6);     //mientras numero no se encuentre dentro del rango 1-8 se mantendra el bucle hasta que se ingrese un numero valido
        return numero_edit;        //retorna un numero valido
    }

    /**
     * Metodo menuordenar
     *
     * @return opcion de ordenacion
     * @throws IOException
     */
    public static int menuOrdenar() throws IOException { //menu de opciones a ordenar un vehiculo
        System.out.println("\n****** ORDENACION ******");
        System.out.println("  1. ITERATIVA ");
        System.out.println("  2. RECURSIVA   ");
        System.out.println("  3. REGRESAR ");
        System.out.println("**************************");
        do {
            try {  //codigo que puede presentar un error al momento de ingreso
                System.out.print("\n Elija una opcion: ");
                numero_ordenar = Integer.parseInt(ar.readLine());  //lectura de una opcion a ordenar
                if (numero_ordenar < 1 || numero_ordenar > 3) //si el numero no se encuentra dentro del rango 1-8 se imprimira un mensaje
                {
                    System.out.println("Error ingreso de opcion!!");
                }
            } catch (NumberFormatException entero) {       //si existe un error en lectura o ingreso no se ejecutara el try
                System.out.println("Error ingreso de opcion!!");       //si hubo un error dentro del try se imprimira un mensaje de error
                numero_ordenar = 0;      //numero sera cero para que vuelva ah entrar al bucle ya que si se ingresa un numero valido y luego una letra queda guardado el numero y se saldra del bucle con esto evitamos eso
            }
        } while (numero_ordenar < 1 || numero_ordenar > 3);     //mientras numero no se encuentre dentro del rango 1-8 se mantendra el bucle hasta que se ingrese un numero valido
        return numero_ordenar;        //retorna un numero valido
    }

    /**
     * Menu Orden iterativo
     *
     * @return opcion del menu orden iterativo
     * @throws IOException
     */
    public static int menuOrdenariterativos() throws IOException { //menu de opciones a ordenar un vehiculo
        System.out.println("\n**** ORDEN ITERATIVO*****");
        System.out.println("  1. BURBUJA ");
        System.out.println("  2. INSERCION   ");
        System.out.println("  3. SELECCION");
        System.out.println("  4. SHELLSORT");
        System.out.println("  5. REGRESAR ");
        System.out.println("**************************");
        do {
            try {  //codigo que puede presentar un error al momento de ingreso
                System.out.print("\n Elija una opcion: ");
                numero_ordenar = Integer.parseInt(ar.readLine());  //lectura de una opcion a ordenar
                if (numero_ordenar < 1 || numero_ordenar > 5) //si el numero no se encuentra dentro del rango 1-8 se imprimira un mensaje
                {
                    System.out.println("Error ingreso de opcion!!");
                }
            } catch (NumberFormatException entero) {       //si existe un error en lectura o ingreso no se ejecutara el try
                System.out.println("Error ingreso de opcion!!");       //si hubo un error dentro del try se imprimira un mensaje de error
                numero_ordenar = 0;      //numero sera cero para que vuelva ah entrar al bucle ya que si se ingresa un numero valido y luego una letra queda guardado el numero y se saldra del bucle con esto evitamos eso
            }
        } while (numero_ordenar < 1 || numero_ordenar > 5);     //mientras numero no se encuentre dentro del rango 1-8 se mantendra el bucle hasta que se ingrese un numero valido
        return numero_ordenar;        //retorna un numero valido
    }

    /**
     * Metodo Menu ordernar recursivos
     *
     * @return Opciones del menu ordenar recursivos
     * @throws IOException
     */
    public static int menuOrdenarrecursivos() throws IOException { //menu de opciones a ordenar un vehiculo
        System.out.println("\n* ORDER RECURSIVOS*");
        System.out.println("  1. MERGESORT ");
        System.out.println("  2. QUICKSORT   ");
        System.out.println("  3. REGRESAR ");
        System.out.println("**************************");
        do {
            try {  //codigo que puede presentar un error al momento de ingreso
                System.out.print("\n Elija una opcion: ");
                numero_ordenar = Integer.parseInt(ar.readLine());  //lectura de una opcion a ordenar
                if (numero_ordenar < 1 || numero_ordenar > 3) //si el numero no se encuentra dentro del rango 1-8 se imprimira un mensaje
                {
                    System.out.println("Error ingreso de opcion!!");
                }
            } catch (NumberFormatException entero) {       //si existe un error en lectura o ingreso no se ejecutara el try
                System.out.println("Error ingreso de opcion!!");       //si hubo un error dentro del try se imprimira un mensaje de error
                numero_ordenar = 0;      //numero sera cero para que vuelva ah entrar al bucle ya que si se ingresa un numero valido y luego una letra queda guardado el numero y se saldra del bucle con esto evitamos eso
            }
        } while (numero_ordenar < 1 || numero_ordenar > 3);     //mientras numero no se encuentre dentro del rango 1-8 se mantendra el bucle hasta que se ingrese un numero valido
        return numero_ordenar;        //retorna un numero valido
    }

    /**
     * Metodo menu buscar
     *
     * @return opciones del menu buscar
     * @throws IOException
     */
    public static int menuBuscar() throws IOException { //menu de opciones a buscar 
        System.out.println("\n******* BUSQUEDA *******");
        System.out.println("  1. ITERATIVOS ");
        System.out.println("  2. RECURSIVOS ");
        System.out.println("  3. REGRESAR ");
        System.out.println("**************************");
        do {
            try {  //codigo que puede presentar un error al momento de ingreso
                System.out.print("\n Elija una opcion: ");
                numero_bus = Integer.parseInt(ar.readLine());  //lectura de una opcion a buscar
                if (numero_bus < 1 || numero_bus > 3) //si el numero no se encuentra dentro del rango 1-7 se imprimira un mensaje
                {
                    System.out.println("Error ingreso de opcion!!");
                }
            } catch (NumberFormatException entero) {        //si existe un error en lectura o ingreso no se ejecutara el try
                System.out.println("Error ingreso de opcion!!");    //si hubo un error dentro del try se imprimira un mensaje de error
                numero_bus = 0;   //numero sera cero para que vuelva ah entrar al bucle ya que si se ingresa un numero valido y luego una letra queda guardado el numero y se saldra del bucle con esto evitamos eso
            }
        } while (numero_bus < 1 || numero_bus > 3);   //mientras numero no se encuentre dentro del rango 1-7 se mantendra el bucle hasta que se ingrese un numero valido
        return numero_bus;        //retorna un numero valido
    }

    /**
     * Metodo menu buscarIterativos
     *
     * @return opciones del menu busqueda iterativa
     * @throws IOException
     */
    public static int menuBuscariterativos() throws IOException { //menu de opciones a buscar 
        System.out.println("\n** BUSQUEDA ITERATIVA **");
        System.out.println("  1. BUSQUEDA SECUENCIAL ");
        System.out.println("  2. BUSQUEDA BINARIA ");
        System.out.println("  3. REGRESAR ");
        System.out.println("**************************");
        do {
            try {  //codigo que puede presentar un error al momento de ingreso
                System.out.print("\n Elija una opcion: ");
                numero_bus = Integer.parseInt(ar.readLine());  //lectura de una opcion a buscar
                if (numero_bus < 1 || numero_bus > 3) //si el numero no se encuentra dentro del rango 1-7 se imprimira un mensaje
                {
                    System.out.println("Error ingreso de opcion!!");
                }
            } catch (NumberFormatException entero) {        //si existe un error en lectura o ingreso no se ejecutara el try
                System.out.println("Error ingreso de opcion!!");    //si hubo un error dentro del try se imprimira un mensaje de error
                numero_bus = 0;   //numero sera cero para que vuelva ah entrar al bucle ya que si se ingresa un numero valido y luego una letra queda guardado el numero y se saldra del bucle con esto evitamos eso
            }
        } while (numero_bus < 1 || numero_bus > 3);   //mientras numero no se encuentre dentro del rango 1-7 se mantendra el bucle hasta que se ingrese un numero valido
        return numero_bus;        //retorna un numero valido
    }

    /**
     * Metodo menu buscarrrecursivos
     *
     * @return opciones del menu de busqueda recursivos
     * @throws IOException
     */
    public static int menuBuscarrecursivos() throws IOException { //menu de opciones a buscar 
        System.out.println("\n** BUSQUEDA RECURSIVA **");
        System.out.println("  1. BUSQUEDA SECUENCIAL ");
        System.out.println("  2. BUSQUEDA BINARIA ");
        System.out.println("  3. REGRESAR ");
        System.out.println("**************************");
        do {
            try {  //codigo que puede presentar un error al momento de ingreso
                System.out.print("\n Elija una opcion: ");
                numero_bus = Integer.parseInt(ar.readLine());  //lectura de una opcion a buscar
                if (numero_bus < 1 || numero_bus > 3) //si el numero no se encuentra dentro del rango 1-7 se imprimira un mensaje
                {
                    System.out.println("Error ingreso de opcion!!");
                }
            } catch (NumberFormatException entero) {        //si existe un error en lectura o ingreso no se ejecutara el try
                System.out.println("Error ingreso de opcion!!");    //si hubo un error dentro del try se imprimira un mensaje de error
                numero_bus = 0;   //numero sera cero para que vuelva ah entrar al bucle ya que si se ingresa un numero valido y luego una letra queda guardado el numero y se saldra del bucle con esto evitamos eso
            }
        } while (numero_bus < 1 || numero_bus > 3);   //mientras numero no se encuentre dentro del rango 1-7 se mantendra el bucle hasta que se ingrese un numero valido
        return numero_bus;        //retorna un numero valido
    }

    /**
     * Metodo de menu voraces
     *
     * @return Opciones del menu Voraces
     * @throws IOException
     */
    public static int menuVoraces() throws IOException { //menu de opciones a buscar 
        System.out.println("\n** ALGORITMOS VORACES **");
        System.out.println("  1. PROBLEMA X ");
        System.out.println("  2. PROBLEMA Y ");
        System.out.println("  3. REGRESAR ");
        System.out.println("**************************");
        do {
            try {  //codigo que puede presentar un error al momento de ingreso
                System.out.print("\n Elija una opcion: ");
                numero_bus = Integer.parseInt(ar.readLine());  //lectura de una opcion a buscar
                if (numero_bus < 1 || numero_bus > 3) //si el numero no se encuentra dentro del rango 1-7 se imprimira un mensaje
                {
                    System.out.println("Error ingreso de opcion!!");
                }
            } catch (NumberFormatException entero) {        //si existe un error en lectura o ingreso no se ejecutara el try
                System.out.println("Error ingreso de opcion!!");    //si hubo un error dentro del try se imprimira un mensaje de error
                numero_bus = 0;   //numero sera cero para que vuelva ah entrar al bucle ya que si se ingresa un numero valido y luego una letra queda guardado el numero y se saldra del bucle con esto evitamos eso
            }
        } while (numero_bus < 1 || numero_bus > 3);   //mientras numero no se encuentre dentro del rango 1-7 se mantendra el bucle hasta que se ingrese un numero valido
        return numero_bus;        //retorna un numero valido
    }

    /**
     * Metodo Menu vuelta atras
     *
     * @return opciones del menu vuelta atras
     * @throws IOException
     */
    public static int menuVueltaatras() throws IOException { //menu de opciones a buscar 
        System.out.println("\n*** ALG. VUELTA ATRAS **");
        System.out.println("  1. PROBLEMA X ");
        System.out.println("  2. PROBLEMA Y ");
        System.out.println("  3. REGRESAR ");
        System.out.println("**************************");
        do {
            try {  //codigo que puede presentar un error al momento de ingreso
                System.out.print("\n Elija una opcion: ");
                numero_bus = Integer.parseInt(ar.readLine());  //lectura de una opcion a buscar
                if (numero_bus < 1 || numero_bus > 3) //si el numero no se encuentra dentro del rango 1-7 se imprimira un mensaje
                {
                    System.out.println("Error ingreso de opcion!!");
                }
            } catch (NumberFormatException entero) {        //si existe un error en lectura o ingreso no se ejecutara el try
                System.out.println("Error ingreso de opcion!!");    //si hubo un error dentro del try se imprimira un mensaje de error
                numero_bus = 0;   //numero sera cero para que vuelva ah entrar al bucle ya que si se ingresa un numero valido y luego una letra queda guardado el numero y se saldra del bucle con esto evitamos eso
            }
        } while (numero_bus < 1 || numero_bus > 3);   //mientras numero no se encuentre dentro del rango 1-7 se mantendra el bucle hasta que se ingrese un numero valido
        return numero_bus;        //retorna un numero valido
    }
}
