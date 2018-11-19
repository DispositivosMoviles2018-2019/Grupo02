package ec.edu.uce.algoritmos.clases;

import ec.edu.uce.algoritmos.interfaces.Ingresar;
import ec.edu.uce.algoritmos.pojos.Vehiculo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Metodo opciones vehiculo
 *
 * @author Marcos
 */
public class Opciones_vehiculo implements Ingresar {

    static Vehiculo vehiculo = new Vehiculo();
    static Scanner sc = new Scanner(System.in);
    private static final BufferedReader scb = new BufferedReader(new InputStreamReader(System.in));
    private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    static String placa, marca;
    static double precio;
    static Date fechaFabricacion;
    static Integer año;

    /**
     * Metodo crear
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     * @return nuevo parametro de vehiculo
     */
    @Override
    public Vehiculo crear(int num_v, Vehiculo arreglo[]) {
        Vehiculo vh = null;
        Vehiculo vj=null;
        int validador = 0, punica; //declaracion de variable para validar y para saber si la placa es unica
        String resp;
        while (validador == 0) { //mientras validador sea igual a cero se mantendra dentro del bucle hast que se ingrese un valor dentro del formato permitido 
            do {
                System.out.print("Ingrese placa del vehiculo en formato (ABC1234): ");
                placa = sc.next();
                resp = Validaciones.validarPlaca(placa); //validamos si la placa tiene el formato correcto si asi es retorna correcto
                punica = punica(arreglo, num_v, placa);
                if (punica == 1) //si placa unica es igual a 1 imprimira un mensaje de que ya existe
                {
                    System.out.println("La placa " + placa + " ya existe!!");
                }
            } while (punica == 1); //mientras placa unica sea igual a 1 se mantendra dentro del bucle
            if (resp.equals("CORRECTO")) //si respuesta es igual a correcta validador sera uno mas y se podra salir del bucle 
            {
                validador++; //validador aumenta en uno
            } else {
                System.out.println("Mensaje: " + resp); //si el formato de la placa no es el correcto se imprimira un mensaje de error
            }
        }

        /* validador = 0; //validador es igual a cero 
         while (validador == 0) { //mientras validador sea igual cero se mantendra en el bucle hasta que se ingrese un valor dentro del foramto permitido 
         System.out.print("Ingrese marca del vehiculo: ");
         marca = sc.next();
         resp = Validaciones.validarCadenaSinNumero(marca); //vemos si la marca ingresada es valida si lo es regresa correcto
         if (resp.equals("CORRECTO")) {  //si se ingreso la marca dentro del formato correcto validador aumenta y se podra salir del bucle 
         validador++;
         } else {
         System.out.println("Mensaje: " + resp);
         }
         }*/
        /*
         validador = 0; //validador es igual a cero 
         while (validador == 0) { //mientras validador sea igual cero se mantendra en el bucle hasta que se ingrese un valor dentro del foramto permitido 
         System.out.print("Ingrese el año del vehiculo : ");
         try {
         año = Integer.parseInt(scb.readLine());
         }catch(Exception e){}
         resp = Validaciones.validarAño(año); //vemos si la marca ingresada es valida si lo es regresa correcto
         if (resp.equals("CORRECTO")) {  //si se ingreso la marca dentro del formato correcto validador aumenta y se podra salir del bucle 
         validador++;
         } else {
         System.out.println("Mensaje: " + resp);
         }
         }
         */
        validador = 0;
        while (validador == 0) {
            System.out.print("Ingrese fecha de fabricacion del vehiculo en formato (AAAA-MM-DD): ");
            String fec_fabrica = sc.next();
            resp = Validaciones.validarFecha(fec_fabrica);
            if (resp.equals("CORRECTO")) {
                try {
                    fechaFabricacion = df.parse(fec_fabrica);
                } catch (ParseException ex) {
                    System.out.println("Fecha mal ingresada!!");
                }
                validador++;
            } else {
                System.out.println("Mensaje: " + resp);
            }
        }

        validador = 0;
        while (validador == 0) {
            System.out.print("Ingrese precio del vehiculo: ");
            try {
                precio = Double.parseDouble(scb.readLine());
                validador++;

            } catch (Exception e) {
                System.out.println("Formato de precio incorrecto");
            }

        }
        vh = new Vehiculo(placa, fechaFabricacion, precio);
      
        System.out.println("Se ah ingresado un nuevo vehiculo con placa " + placa);
        return vh;
        
    }

    /**
     * Metodo editar
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     */
    @Override
    public void editar(int num_v, Vehiculo arreglo[]) {
        listar(num_v, arreglo);//impresion de los vehiculos dentro del arreglo 
        int numAuto, opcion = 8, validado = 0; //declaracion de las variables a utilizar
        while (validado == 0) {
            System.out.print("\nIngrese placa del vehiculo a editar en el formato (ABC1234): ");
            String placab = sc.next();
            numAuto = posicion(arreglo, num_v, placab);
            String respb = Validaciones.validarPlaca(placab);
            if (respb.equals("CORRECTO")) {
                validado++;
            } else {
                System.out.println("Mensaje: " + respb);
            }
            do {
                if (numAuto != -1) {
                    try {
                        opcion = Menus.menuEditar();
                    } catch (IOException ex) {
                        System.out.println("Falla al editar!!");
                    }
                    Integer validador = 0;
                    String resp;
                    switch (opcion) {
                        case 1:
                            validador = 0;
                            while (validador == 0) {
                                int punica;
                                do {
                                    System.out.print("Ingrese nueva placa del vehiculo en formato (ABC1234): ");
                                    placa = sc.next();
                                    resp = Validaciones.validarPlaca(placa);
                                    punica = punica(arreglo, num_v, placa);
                                    if (punica == 1) {
                                        System.out.println("La placa " + placa + " ya existe!!");
                                    }
                                } while (punica == 1);
                                if (resp.equals("CORRECTO")) {
                                    validador++;
                                    arreglo[numAuto].setPlaca(placa);
                                } else {
                                    System.out.println("Mensaje: " + resp);
                                }
                            }
                            break;
                        /*case 2:
                         validador = 0;
                         while (validador == 0) {
                         System.out.print("Ingrese nueva marca del vehiculo: ");
                         marca = sc.next();
                         resp = Validaciones.validarCadenaSinNumero(marca);
                         if (resp.equals("CORRECTO")) {
                         validador++;
                         arreglo[numAuto].setMarca(marca);
                         } else {
                         System.out.println("Mensaje: " + resp);
                         }
                         }
                         break;
                                
                         case 3:
                         System.out.print("Ingrese nuevo año del vehiculo: ");
                         año = sc.nextInt();
                         arreglo[numAuto].setAño(año);
                         break;
                         */
                        case 2:
                            while (validador == 0) {
                                System.out.print("Ingrese fecha de fabricacion del vehiculo en formato aaaa-MM-dd: ");
                                String fec_fabrica = sc.next();
                                resp = Validaciones.validarFecha(fec_fabrica);
                                if (resp.equals("CORRECTO")) {
                                    try {
                                        fechaFabricacion = df.parse(fec_fabrica);
                                    } catch (ParseException ex) {
                                        System.out.println("Fecha de fabricacion fallida!!");
                                    }
                                    validador++;
                                    arreglo[numAuto].setFec_fabricacion(fechaFabricacion);
                                } else {
                                    System.out.println("Mensaje: " + resp);
                                }
                            }
                            break;
                        case 3:
                            validador = 0;
                            while (validador == 0) {
                                System.out.print("Ingrese nuevo precio del vehiculo: ");
                                try {
                                    precio = Double.parseDouble(scb.readLine());
                                    validador++;
                                    arreglo[numAuto].setPrecio(precio);
                                } catch (Exception e) {
                                    System.out.println("Formato de precio incorrecto");
                                }
                            }
                            break;
                    }
                } else {
                    System.out.println("No se puede editar el vehiculo con placa " + placab);
                }
            } while (opcion != 4);
        }
    }

    /**
     * Metodo eliminar
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     * @return elimina el elemento seleccionado
     */
    @Override
    public int eliminar(int num_v, Vehiculo arreglo[]) {
        int vb = 0;
        int validador = 0;
        listar(num_v, arreglo);

        while (validador == 0) {
            System.out.print("\nIngrese placa de vehiculo a borrar en formato (ABC1234): ");
            String placab = sc.next();
            String resp = Validaciones.validarPlaca(placab);
            if (resp.equals("CORRECTO")) {
                validador++;
                int pos = posicion(arreglo, num_v, placab);
                if (pos != -1) { //si se encontro el vehiculo se jecutara el proceso de borrado
                    int sno = 0;
                    do {
                        System.out.print("Realmente desea borrar el vehiculo con placa " + placab + " (si/no): ");   //opcion para saber si sera o no borrado el vehiculo
                        String sn = sc.next();
                        sno = Validaciones.validarSN(sn); //validacion si se ingreso si o no
                        if (sno == 1) { //si desea borrar el vehiculo se jecutara hacerlo 
                            arreglo[pos] = null;
                            compactar(arreglo, num_v, pos);
                            System.out.println("Se ah borrado el vehiculo con placa: " + placab);
                            vb++;
                        }
                        if (sno == 2) {
                            System.out.println("El vehiculo con placa " + placab + " no sera borrado"); //mensaje que no sera borrado el vehiculo
                        }
                    } while (sno == 0);
                } else {        //si no se encontro el vehiculo se presentara un mensaje
                    System.out.println("El vehiculo con placa " + placab + " no existe");
                }
            } else {
                System.out.println("Mensaje: " + resp);
            }
        }

        return vb;
    }

    /**
     * Metodo impresion
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     */
    @Override
    public void listar(int num_v, Vehiculo arreglo[]) {
        System.out.println("                                      ***** Lista de vehiculos *****");
        System.out.print("\nVehiculo\tPRECIO\t\tPLACA\t\tFECHAFABRICACION\n");
        for (int i = 0; i < num_v; i++) {
            System.out.println("" + (i + 1) + arreglo[i]);
        }
    }

//METODOS ADICIONALES
    /**
     * Metodo punica
     *
     * @param arreglo Estructura que se va a ordenar
     * @param cont contador
     * @param placa variable de tipo string
     * @return no se pueden repetir dos placas iguales
     */
    public static int punica(Vehiculo arreglo[], int cont, String placa) {
        int punica = 0;
        for (int i = 0; i < cont; i++) {
            if (arreglo[i].getPlaca().equals(placa)) {
                punica = 1;
            }
        }
        return punica;
    }

    /**
     * Metodo Vehiculo
     *
     * @param vehiculos arreglo vehiculo
     * @param cont contador
     * @param placa variable de tipo String
     * @return posicion en la que se encuentra el vehiculo
     */
    public static int posicion(Vehiculo vehiculos[], int cont, String placa) {
        int i;
        for (i = 0; i < cont; i++) {
            if (placa.equals(vehiculos[i].getPlaca())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Metodo compactar
     *
     * @param vehiculos arreglo vehiculo
     * @param cont contador
     * @param pos posicion del objeto
     */
    public static void compactar(Vehiculo vehiculos[], int cont, int pos) {
        if (pos != cont - 1) {
            for (int i = pos; i < cont - 1; i++) {
                vehiculos[i] = vehiculos[i + 1];
            }
            vehiculos[cont - 1] = null;
        }
    }
     public void precarga(){
        
        Vehiculo precarga = new Vehiculo("ASD785",new Date(),200.50);
        //colecUsuarios = new HashMap<>();
        
        
        
    }

}
