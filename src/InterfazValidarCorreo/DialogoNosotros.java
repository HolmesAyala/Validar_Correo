
package InterfazValidarCorreo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class DialogoNosotros extends JDialog{

    private JLabel vercion; //  Vercion del programa
    
    private JLabel imagen;  //  Logo de la universidad
    
    private JLabel nosotros;    //  Informacion de los integrantes
    
    /**
     * Constructor de la clase DialogoNosotros
     */
    public DialogoNosotros() {
        configurarDialogo();
    }
    
    /**
     * Configurar ventana de dialogo
     */
    public void  configurarDialogo(){
        setTitle("Sobre nosotros");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(400, 200);
        setLayout(null);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("Iconos/Nosotros.png");
        setIconImage(icono);
        agregarElementos();
        setVisible(true);
    }
    
    /**
     * Agregar elementos al panel
     */
    public void agregarElementos(){
        
        imagen = new JLabel(new ImageIcon("Imagenes/Unicundi.jpg"));
        imagen.setBounds(10, 10, 92, 145);
        add(imagen);
        
        Font fuente = new Font("Calibri", Font.BOLD, 20);
        nosotros = new JLabel("Anggy Arguello - Holmes Ayala");
        nosotros.setFont(fuente);
        nosotros.setBounds(120, 30, 300, 40);
        add(nosotros);
        
        vercion = new JLabel("Vercion 1.0");
        vercion.setFont(fuente);
        vercion.setBounds(120, 80, 200, 40);
        add(vercion);
    }
}
