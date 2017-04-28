
package InterfazValidarCorreo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.Document;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class DialogoAyuda extends JDialog{
    
    private JTextArea areaAyuda;    //  Texto de ayuda

    /**
     * Constructor de la clase DialogoAyuda
     */
    public DialogoAyuda() {
        configurarDialogo();
    }
    
    /**
     * Configurar la ventana del dialogo
     */
    public void configurarDialogo(){
        setTitle("Ayuda");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("Iconos/Ayuda.png");
        setIconImage(icono);
        agregarElementos();
        
        setVisible(true);
    }
    
    /**
     * Agregar elementos a la ventana de dialogo
     */
    public void agregarElementos(){
        areaAyuda = new JTextArea();
        
        areaAyuda.setFont(new Font("Calibri", Font.PLAIN, 25));
        
        areaAyuda.setText("-----------------Validar Correo-----------------\n\n"
                                    + "El programa consiste en dos elementos:\n\n"
                                    + "1) Area para escribir y validar el correo\n"
                                    + "2) Barra de menu\n\n"
                                    + "Elementos:\n\n"
                                    + "1) Area para escribir y validar el correo\n"
                                    + "   En este espacio se encuentran tres elementos\n"
                                    + "   1.1) Caja de texto para escribir el correo\n"
                                    + "   1.2) Area de errores\n"
                                    + "   1.3) Imagenes de validacion\n\n"
                                    + " 1.1) Puede escribir un correo para validar si\n"
                                    + "      tiene el formato valido como por ejemplo:\n"
                                    + "      ejemplo@dominio.com\n"
                                    + " 1.2) En esta area van a aparecer los errores\n"
                                    + "      que pueda tener su correo mientras lo\n"
                                    + "      digita como por ejemplo:\n"
                                    + "      - No puede empezar por numero\n"
                                    + "      o caracter especial.\n"
                                    + " 1.3) Hay 3 tipos de imagen de validacion\n"
                                    + "      a) Validacion incorrecta, hasta que digite\n"
                                    + "         un correo valido.\n"
                                    + "      b) validacion correcta, el correo cumple\n"
                                    + "         el formato.\n"
                                    + "      c) validacion ya esta registrado, significa\n"
                                    + "         que el correo ya se encuentra en la tabla\n"
                                    + "         de correos validos\n\n"
                                    + "2) Barra de menu, contiene 2 elementos de menu\n"
                                    + "   - Principal\n"
                                    + "     a) Ayuda: Imformacion del programa\n"
                                    + "     b) Nosotros\n"
                                    + "     c) Salir\n"
                                    + "   - Ver\n"
                                    + "     a) Correos validos\n");
        
        areaAyuda.setEditable(false);
        areaAyuda.setBackground(Color.WHITE);
        JScrollPane scrollAreaAyuda = new JScrollPane(areaAyuda);
        scrollAreaAyuda.setBounds(10, 10, 580, 780);
        add(scrollAreaAyuda);
    }
    
}
