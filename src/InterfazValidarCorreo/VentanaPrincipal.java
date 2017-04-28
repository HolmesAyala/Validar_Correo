
package InterfazValidarCorreo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class VentanaPrincipal extends JFrame{

    private JMenuBar barraPrincipal;    //  Barra principal que contiene los menus
    
    private JMenu menuPrincipal;    //  Menu principal de la barra
    
    private JMenu menuVer;  //  Menu para ver la tabla de correos validos
    
    private JMenuItem itemAyuda;    //  Item que despliega una ventana de ayuda
    
    private JMenuItem itemNosotros; //  Item que despliega una ventana de informacion
    
    private JMenuItem itemSalir;    //  Item para salir del programa
    
    private JMenuItem itemInformacion;  //  Item de informacion sobre el programa
    
    private PanelCorreo panelCorreo;    //  Panel donde se escribe el correo a validar
    
    /**
     * Constuctor de la clase VentanaPrincipal
     */
    public VentanaPrincipal() {
        configurarVentana();
    }
    
    /**
     * Configurar la ventana principal
     */
    public void configurarVentana(){
        setTitle("Validar Correo Electronico");
        setSize(850, 500);
        setLocationRelativeTo(null);
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("Iconos/VentanaPrincipal.png");
        setIconImage(icono);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setBackground(Color.WHITE);
        
        agregarElementos();
        
        setVisible(true);
    }
    
    /**
     * Agregar barra principal y panel del correo
     */
    public void agregarElementos(){
        
        agregarBarra();
        
        panelCorreo = new PanelCorreo(this);
        add(panelCorreo);
    }
    
    /**
     * Agregar la Barra principal de menus en la ventana
     */
    public void agregarBarra(){
        //  Fuente de los menus e items
        Font fuente = new Font("Calibri", Font.BOLD, 23);
        //  Instanciar la barra principal
        barraPrincipal = new JMenuBar();
        barraPrincipal.setSize(850, 30);
        //  Agregar los itemMenu al menu principal
        menuPrincipal = new JMenu("Principal");
        menuPrincipal.setFont(fuente);
        itemAyuda = new JMenuItem("Ayuda");
        itemAyuda.setIcon(new ImageIcon("Iconos/Ayuda.png"));
        itemAyuda.setFont(fuente);
        itemAyuda.addActionListener(new escucharMenu());
        itemNosotros = new JMenuItem("Nosotros");
        itemNosotros.setIcon(new ImageIcon("Iconos/Nosotros.png"));
        itemNosotros.setFont(fuente);
        itemNosotros.addActionListener(new escucharMenu());
        itemSalir = new JMenuItem("Salir");
        itemSalir.setIcon(new ImageIcon("Iconos/Salir.png"));
        itemSalir.setFont(fuente);
        itemSalir.addActionListener(new escucharMenu());
        menuPrincipal.add(itemAyuda);
        menuPrincipal.add(itemNosotros);
        menuPrincipal.add(itemSalir);
        //  Agregar el itemMenu al menu ver
        menuVer = new JMenu("Ver");
        menuVer.setFont(fuente);
        itemInformacion = new JMenuItem("Correos validos");
        itemInformacion.setIcon(new ImageIcon("Iconos/TablaCorreo.png"));
        itemInformacion.setFont(fuente);
        itemInformacion.addActionListener(new escucharMenu());
        menuVer.add(itemInformacion);
        //  Agregar los menus a la barra principal
        barraPrincipal.add(menuPrincipal);
        barraPrincipal.add(menuVer);
        //  Agregar la barra principal
        add(barraPrincipal);
    }

    /**
     * Metodo que esta a la espera de los eventos generados por los
     * menus de la barra principal
     */
    class escucharMenu implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand().equals("Correos validos")){
                panelCorreo.getDialogoTabla().setVisible(true);
            }
            else if(evento.getActionCommand().equals("Ayuda")){
                DialogoAyuda dialogoAyuda = new DialogoAyuda();
            }
            else if(evento.getActionCommand().equals("Nosotros")){
                DialogoNosotros dialogoNosotros = new DialogoNosotros();
            }
            else if(evento.getActionCommand().equals("Salir")){
                System.exit(0);
            }
        }
    
    }
    
    /**
     * Obtener el panel que solicita el correo
     * @return panelCorreo
     */
    public PanelCorreo getPanelCorreo() {
        return panelCorreo;
    }

    /**
     * Modificar el panel que solicita el correo
     * @param panelCorreo 
     */
    public void setPanelCorreo(PanelCorreo panelCorreo) {
        this.panelCorreo = panelCorreo;
    }
    
}