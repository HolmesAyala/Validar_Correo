
package validarcorreo;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class Ejecutar {

    public Ejecutar() {
        String correo = "holmesayala@gmail.com";
        String validacion = ValidarCorreo.validar(correo);
        System.out.println(validacion);
    }
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        Ejecutar Ejecutar = new Ejecutar();
    }
*/
}
