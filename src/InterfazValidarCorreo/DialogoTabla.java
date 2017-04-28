
package InterfazValidarCorreo;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class DialogoTabla extends JDialog{
    
    private JTable tablaCorreo; //  Tabla de correos validos
    
    private DefaultTableModel modelo;   //  Modelo para la tabla

    /**
     * Constructor de la clase DialogoTabla
     */
    public DialogoTabla() {
        configurarDialogo();
    }
    
    /**
     * Configurar la ventana de dialogo
     */
    public void configurarDialogo(){
        setTitle("Correos Validos");
        setSize(600, 700);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("Iconos/TablaCorreo.png");
        setIconImage(icono);
        agregarElementos();
    }
    
    /**
     * Agregar los elementos a la tabla de dialogo
     */
    public void agregarElementos(){
        
        modelo = new DefaultTableModel();
        
        modelo.addColumn("Correo");
        
        tablaCorreo = new JTable(modelo);
        
        tablaCorreo.setFont(new Font("Calibri", Font.PLAIN, 30));
        
        tablaCorreo.setRowHeight(40);
        
        tablaCorreo.setEnabled(false);
        
        JScrollPane scrollTablaCorreo = new JScrollPane(tablaCorreo);
        
        scrollTablaCorreo.setBounds(20, 20, 560, 640);
        add(scrollTablaCorreo);
    }

    /**
     * Obtener el modelo de la tabla
     * @return 
     */
    public DefaultTableModel getModelo() {
        return modelo;
    }

    /**
     * Cambiar el modelo de la tabla
     * @param modelo 
     */
    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    
}
