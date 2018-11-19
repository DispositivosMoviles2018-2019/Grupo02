package ec.edu.uce.algoritmos.clases;

import java.text.SimpleDateFormat;

/**
 * Metodo validaciones
 *
 * @author Marcos
 */
public class Validaciones {

    /**
     * Metodo Validarplaca
     *
     * @param placa variable
     * @return placa validada
     */
    public static String validarPlaca(String placa) {
        try {
            String respuesta = "CORRECTO";
            if (placa == null) {
                respuesta = "El número de placa no puede ser nulo";
            } else if (placa.trim().length() == 7) {
                Integer.parseInt(placa.substring(3, 7));
                String texto = placa.substring(0, 3);
                if (!texto.matches("([A-Z]|\\s)+")) {
                    respuesta = "Los tres primero dígitos deben ser letras mayusculas";
                }
            } else {
                respuesta = "La placa debe tener 7 digitos";
            }
            return respuesta;
        } catch (Exception e) {
            return "Error de formato";
        }
    }

    /**
     * metodo validarcadenassin numero
     *
     * @param cadena variable
     * @return String validado
     */
    public static String validarCadenaSinNumero(String cadena) {
        if (cadena == null) {
            return "La marca no puede ser nulo";
        } else if (!cadena.matches("([a-z]|[A-Z]|\\s)+")) {
            return "La marca no debe contener números ni caracteres especiales";
        }

        return "CORRECTO";
    }

    /**
     * Metodo validar año
     *
     * @param año variable
     * @return año validado
     */
    public static String validarAño(Integer año) {
        if (año == null) {
            return "El valor no puede ser nulo";
        } else {
            try {
                if (año < 1500 || año > 2015) {
                    return "El año debe estar entre 1500 y 2015";
                }
            } catch (Exception e) {
                return "El valor no es numérico";
            }
        }
        return "CORRECTO";
    }

    /**
     * Metodo validar fecha
     *
     * @param cadena variable
     * @return fecha validada
     */
    public static String validarFecha(String cadena) {
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD");
        if (cadena == null) {
            return "El valor no puede ser nulo";
        } else {
            try {
                String fecha[] = cadena.split("-");
                int año = Integer.parseInt(fecha[0]);
                int mes = Integer.parseInt(fecha[1]);
                int dia = Integer.parseInt(fecha[2]);
                if (año < 1000 || año > 2013) {
                    return "El año debe ser mayor a 1000 y menor a 2013";
                }
                if (mes < 1 || mes > 12) {
                    return "El mes debe estar entre 1 y 12";
                }
                if (dia < 1 || dia > 30) {
                    return "El día debe estar entre 1 y 30";
                }
            } catch (Exception exc) {
                return "El formato no es correcto";
            }
        }
        return "CORRECTO";
    }

    //validador para el si o no
    /**
     * Metodo validar si o no
     *
     * @param sn variable
     * @return validado si o no
     */
    public static int validarSN(String sn) {
        int sno = 0;
        if (sn.equals("si")) {
            sno = 1;
            return sno;
        } else {
            if (sn.equals("no")) {
                sno = 2;
            } else {
                System.out.println("Formato incorrecto ingrese si o no!!");
            }
        }
        return sno;
    }

}
