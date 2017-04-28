
package InterfazValidarCorreo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import validarcorreo.ValidarCorreo;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class PanelCorreo extends JPanel{
    
    private JLabel labelCorreo; //  Etiqueta para el correo
    
    private JTextField  textoCorreo;    //  Caja de texto para el correo
    
    private JTextArea areaErrores;  //  Area que muestra los errores del correo
    
    private VentanaPrincipal ventanaPrincipa;   //  Objeto de la calse VentanaPrincipal
    
    private DialogoTabla dialogoTabla;  //  Objeto de la clase DialogoTabla
    
    private JLabel imagenValidar;   //  Imagen para saber si el correo es valido o no ó si ya esta registrado

    /**
     * Constructor de la Clase PanelCorreo
     * @param ventanaPrincipa 
     */
    public PanelCorreo(VentanaPrincipal ventanaPrincipa) {
        this.ventanaPrincipa = ventanaPrincipa;
        this.dialogoTabla = new DialogoTabla();
        
        configurarPanel();
        
        agregarElementos();
    }
    
    /**
     * Metodo que configura el panel
     */
    public void configurarPanel(){
        setLayout(null);
        setBounds(10, 40, 830, 550);
        setBackground(Color.WHITE);
    }
    
    /**
     * Metodo que agrega los elementos al panel
     */
    public void agregarElementos(){
        
        Font fuente = new Font("Calibri", Font.ITALIC, 30);
        
        imagenValidar = new JLabel();
        imagenValidar.setBounds(560, 130, 300, 50);
        imagenValidar.setFont(new Font("Calibri", Font.ITALIC, 25));
        add(imagenValidar);
        
        labelCorreo = new JLabel("Correo:");
        labelCorreo.setFont(fuente);
        labelCorreo.setBounds(50, 87, 100, 30);
        add(labelCorreo);
        
        textoCorreo = new JTextField(20);
        textoCorreo.setBounds(50, 137, 500, 40);
        textoCorreo.setForeground(new Color(0, 0, 0, 255));
        textoCorreo.setFont(fuente);
        Document documentoCorreo = textoCorreo.getDocument();
        documentoCorreo.addDocumentListener(new escucharTexto());
        add(textoCorreo);

        areaErrores = new JTextArea();
        areaErrores.setForeground(new Color(206, 12, 12, 200));
        areaErrores.setEditable(false);
        areaErrores.setBounds(50, 197, 500, 300);
        areaErrores.setFont(fuente);
        areaErrores.setBackground(Color.WHITE);
        add(areaErrores);
    }

    /**
     * Clase que espera los eventos del texto de correo
     */
    class escucharTexto implements DocumentListener{
        @Override
        public void insertUpdate(DocumentEvent evento) {
            validarCorreo();
        }

        @Override
        public void removeUpdate(DocumentEvent evento) {
            validarCorreo();
        }

        @Override
        public void changedUpdate(DocumentEvent evento) {

        }
    }
    
    /**
     * Metodo que agrega el texto de validaciones y las imagenes para saber siel correo es valido
     */
    private void validarCorreo(){
        if(textoCorreo.getText().trim().length() > 4){
                areaErrores.setText(ValidarCorreo.validar(textoCorreo.getText().trim()));
                if(areaErrores.getText().equals("correcto")){
                    if(validarCorreoRepetido()){
                        String correo[] = {textoCorreo.getText().trim()};
                        ventanaPrincipa.getPanelCorreo().getDialogoTabla().getModelo().addRow(correo);
                        imagenValidar.setIcon(new ImageIcon("Iconos/CorreoValido.png"));
                        imagenValidar.setText("Correcto");
                        areaErrores.setText("");
                    }
                    else{
                        imagenValidar.setIcon(new ImageIcon("Iconos/CorreoRegistrado.png"));
                        imagenValidar.setText("Ya esta registrado");
                        areaErrores.setText("");
                    }
                }
                else{
                    imagenValidar.setIcon(new ImageIcon("Iconos/CorreoNoValido.png"));
                    imagenValidar.setText("Incorrecto");
                }
            }
            else{
                areaErrores.setText("");
                imagenValidar.setIcon(new ImageIcon());
                imagenValidar.setText("");
            }
    }
    
    /**
     * Metodo que valida si el correo ya esta registrado
     * @return 
     */
    public boolean validarCorreoRepetido(){
        for(int i = 0; i < ventanaPrincipa.getPanelCorreo().getDialogoTabla().getModelo().getRowCount(); i++){
            if(ventanaPrincipa.getPanelCorreo().getDialogoTabla().getModelo().getValueAt(i, 0).equals(textoCorreo.getText().trim())){
                return false;
            }
        }
        return true;
    }

    /**
     * Obtener el dialogo de la tabla de correos
     * @return 
     */
    public DialogoTabla getDialogoTabla() {
        return dialogoTabla;
    }

    /**
     * Cambiar el dialogo de la tabla de correos
     * @param dialogoTabla 
     */
    public void setDialogoTabla(DialogoTabla dialogoTabla) {
        this.dialogoTabla = dialogoTabla;
    }
    
}
