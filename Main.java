import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
/**
 *Clase Main, el cual, sirve para ejecutar el programa en conjunto con la interfaz grafica
 *@author  Malinalli Escobedo Irineo Alan Kevin Cano Tenorio
 *@version 1.0
 */


public class Main extends JFrame implements ActionListener, Serializable{

    //Atributos
    private JScrollPane barra;
    private JButton boton1, boton2, boton3, boton4, boton5, bContra, bContra2, bDes, bModSuel, bModNom, bCotContratarMAs, bCotFinalizar,    bCotContratarMas2;
    private JTextField textContrar1, textContratar2, textDespe1, textModNombre1, textModNombre2, textModSueldo1, textModSueldo2;
    private JTextField textHoras, textComision, textRolAnimador, textCantidad, textTitulo;
    private Panel panel, panelContratar, panelDespedir, panelCotizacion, panelModificarNombre, panelModificarSueldo;
    private JTextArea mostrarCatalogo;
    private static ObjectOutputStream archivo;
    String msCotizacion="";
    static ListaDeEmpleados catalogo = new ListaDeEmpleados();
    ListaDeEmpleados listaCotizacion = new ListaDeEmpleados();
    double totalCotizacion = 0;
    double cotiza = 0;
    String nombre;
    int cantidad;
    int horas;
    int comision;
    boolean bandera2;
    


      /**
    * Crea un archivo para guardar el catalogo
    * @param el nombre dem archivo a crear
    * @param el contenido a escribir en el archivo 
    */
    public static void crearArchivo(String nombre, String contenido){
        File archivo = new File(nombre);

        try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close();
        }catch(FileNotFoundException e){
            e.printStackTrace(System.out);
        }
    }

     /**
    * Crea un archivo para gursar los datos del programa
    * @param el nombre dem archivo a crear
    * @param el contenido a escribir en el archivo 
    */
    public static void guardarDatos(ListaDeEmpleados catalogo){
        try{
            archivo = new ObjectOutputStream(new FileOutputStream("Catalogo/guardarDatos.txt"));
            archivo.writeObject(catalogo);
            archivo.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

     /**
    * Crea un archivo para cargar los datos del programa
    * @param el nombre dem archivo a crear
    * @param el contenido a escribir en el archivo 
    */
    public static void reestablecerDatos(){
        try{
            ObjectInputStream archivoNIce = new ObjectInputStream(new FileInputStream("Catalogo/guardarDatos.txt"));
            catalogo =(ListaDeEmpleados)archivoNIce.readObject();
            System.out.println(catalogo);
            archivoNIce.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


   


   
     /**
     *Metodo constructor de la interfaz 
    *
    */ 
    Main(){
        String Payasos = "Payasos";
        String Malabaristas = "Malabaristas";
        catalogo.agregarEmpleadoNuevo(Payasos, 100);
        catalogo.agregarEmpleado(Payasos);
        catalogo.agregarEmpleado(Payasos);
        catalogo.agregarEmpleadoNuevo(Malabaristas, 200);
        catalogo.agregarEmpleado(Malabaristas);

        setDefaultCloseOperation(EXIT_ON_CLOSE); //El programa se cierra al poner la x
        iniciarComponetes();
        muestraCatalogo();
        actualizarCatalogo();
        crearArchivo("Catalogo/Catalogo.txt", catalogo.muestra2());

    }

    /**
    * Metodo para actualizar el catalogo 
    * 
    */
     public void actualizarCatalogo() {
        msCotizacion = catalogo.muestra2();  
        mostrarCatalogo.setText(msCotizacion);  
    }
    
     /**
    * Metodo que muestra el catalogo 
    * 
    */
    public void muestraCatalogo(){
        mostrarCatalogo = new JTextArea(msCotizacion);
        mostrarCatalogo.setEditable(false);
        mostrarCatalogo.setBounds(0, 460, 800, 800);
        mostrarCatalogo.setFont(new Font("arial", Font.HANGING_BASELINE, 15));
        panel.add(mostrarCatalogo);
        pack();
    }


    /**
    * Metodo para iniciar los componentes de la interfaz 
    * 
    */
    public void iniciarComponetes(){
        
        //PANEL PRINCIPAL
        panel = new Panel();
        panel.setVisible(true);
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 1200);
        this.getContentPane().add(panel);
        panel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Evento Espectacular", SwingConstants.CENTER);
        titulo.setBounds(0, 0, 800, 100);
        titulo.setFont(new Font("Yellow Style", Font.HANGING_BASELINE, 60)); 
        titulo.setBackground(Color.gray);
        panel.add(titulo);

      
        

        //Botones
        boton1 = new JButton("Contratar");
        boton1.setBounds(325, 120, 150, 40);
        boton1.setBackground(Color.white);
        ImageIcon Main = new ImageIcon("WhatsApp Image 2023-11-29 at 11.08.13 PM.jpeg");
        boton1.setIcon(new ImageIcon(Main.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton1.setBorder(null);
        panel.add(boton1);
        boton1.addActionListener(this); 

        boton2 = new JButton("Despedir");
        boton2.setBounds(325, 180, 150, 40);
        boton2.setBackground(Color.white);
        ImageIcon des = new ImageIcon("WhatsApp Image 2023-11-29 at 11.18.31 PM.jpeg");
        boton2.setIcon(new ImageIcon(des.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setBorder(null);
        panel.add(boton2);
        boton2.addActionListener(this);

        boton3 = new JButton("Cambiar Nombre");
        boton3.setBounds(325, 240, 150, 40);
        boton3.setBackground(Color.white);
        ImageIcon cm = new ImageIcon("WhatsApp Image 2023-11-29 at 11.18.31 PM (1).jpeg");
        boton3.setIcon(new ImageIcon(cm.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_SMOOTH)));
        boton3.setBorder(null);
        panel.add(boton3);
        boton3.addActionListener(this);

        boton4 = new JButton("Cambiar Sueldo");
        boton4.setBounds(325, 300, 150, 40);
        boton4.setBackground(Color.white);
        ImageIcon cs = new ImageIcon("WhatsApp Image 2023-11-29 at 11.18.31 PM (2).jpeg");
        boton4.setIcon(new ImageIcon(cs.getImage().getScaledInstance(boton4.getWidth(), boton4.getHeight(), Image.SCALE_SMOOTH)));
        boton4.setBorder(null);
        panel.add(boton4);
        boton4.addActionListener(this);

        boton5 = new JButton(" Hacer Cotizacion");
        boton5.setBounds(325, 360, 150, 40);
        boton5.setBackground(Color.white);
        ImageIcon hc = new ImageIcon("WhatsApp Image 2023-11-29 at 11.18.31 PM (3).jpeg");
        boton5.setIcon(new ImageIcon(hc.getImage().getScaledInstance(boton5.getWidth(), boton5.getHeight(), Image.SCALE_SMOOTH)));
        boton5.setBorder(null);
        panel.add(boton5);
        boton5.addActionListener(this);




        //CONTRATAR
        panelContratar = new Panel();
        panelContratar.setLayout(null); 
        panelContratar.setVisible(false);
        panelContratar.setBackground(Color.WHITE);
        panelContratar.setBounds(0, 0, 800, 1200);
        this.getContentPane().add(panelContratar);

        //Etiquetas
        JLabel a = new JLabel("Contratar Empleado", SwingConstants.CENTER);
        a.setBounds(0, 0, 800, 100);
        a.setBackground(Color.white);
        a.setOpaque(true);
        a.setFont(new Font("Yellow Style", Font.HANGING_BASELINE, 50)); 
        panelContratar.add(a);

       JLabel re = new JLabel("Ingrese el rol del Empleado");
        re.setBounds(40, 190, 600, 45);
        re.setFont(new Font("WEEKLY PLANNER", Font.HANGING_BASELINE, 30)); 
        panelContratar.add(re);

        JLabel s = new JLabel("Ingrese el sueldo del Empleado");
        s.setBounds(40, 380, 600, 40);
        s.setFont(new Font("WEEKLY PLANNER", Font.HANGING_BASELINE, 30)); 
        panelContratar.add(s);

        //Cuadros de texto
        textContrar1 = new JTextField();
        textContrar1.setBounds(40, 250, 720, 60);
        panelContratar.add(textContrar1);

        textContratar2 = new JTextField();
        textContratar2.setBounds(40, 450, 720, 60);
        textContratar2.setEditable(false);
        panelContratar.add(textContratar2);

        //Botoones
        bContra = new JButton("Continuar");
        bContra.setBounds(350, 600, 100, 50);
        panelContratar.add(bContra);
        bContra.addActionListener(this);

        bContra2 = new JButton("Continuar");
        bContra2.setBounds(350, 600, 100, 50);
        bContra2.setVisible(false);
        panelContratar.add(bContra2);
        bContra2.addActionListener(this);






        //DESPEDIR EMPLEADO
        panelDespedir = new Panel();
        panelDespedir.setLayout(null);
        panelDespedir.setVisible(false);
        panelDespedir.setBounds(0, 0, 800, 1200);
        panelDespedir.setBackground(Color.WHITE);
        this.getContentPane().add(panelDespedir);

        JLabel d = new JLabel("Despedir Empleado", SwingConstants.CENTER);
        d.setBounds(0, 0, 800, 100);
        d.setBackground(Color.white);
        d.setOpaque(true);
        d.setFont(new Font("Yellow Style", Font.HANGING_BASELINE, 50)); 
        panelDespedir.add(d);

        JLabel rold = new JLabel("Ingrese el Rol del Empleado ha despedir");
        rold.setBounds(40, 180, 600, 40);
        rold.setFont(new Font("WEEKLY PLANNER", Font.HANGING_BASELINE, 30)); 
        panelDespedir.add(rold);

        //Cuadros de texto
        textDespe1 = new JTextField();
        textDespe1.setBounds(40, 250, 720, 60);
        panelDespedir.add(textDespe1);

         bDes = new JButton("Continuar");
        bDes.setBounds(350, 400, 100, 50);
        panelDespedir.add(bDes);
        bDes.addActionListener(this);





        //  MODIFIAR NOMBRE
        panelModificarNombre = new Panel();
        panelModificarNombre.setLayout(null);
        panelModificarNombre.setVisible(false);
        panelModificarNombre.setBackground(Color.WHITE);
        panelModificarNombre.setBounds(0, 0, 800, 1200);
        this.getContentPane().add(panelModificarNombre);
        
        //Etiquetas
        JLabel m = new JLabel("Modificar Nombre", SwingConstants.CENTER);
        m.setBounds(0, 0, 800, 100);
        m.setBackground(Color.white);
        m.setOpaque(true);
        m.setFont(new Font("Yellow Style", Font.HANGING_BASELINE, 50)); 
        panelModificarNombre.add(m);

        JLabel rolMod = new JLabel("Ingrese el Rol del Empleado ha modificar");
        rolMod.setBounds(40, 180, 700, 40);
        rolMod.setFont(new Font("WEEKLY PLANNER", Font.HANGING_BASELINE, 30)); 
        //rolMod.setForeground(Color.PINK);
        panelModificarNombre.add(rolMod);

        JLabel n = new JLabel("Ingrese el nuevo nombre para el rol");
        n.setBounds(40, 380, 600, 50);
        n.setFont(new Font("WEEKLY PLANNER", Font.HANGING_BASELINE, 30));
        //n.setForeground(Color.PINK); 
        panelModificarNombre.add(n);

        //Cuadros de texto
        textModNombre1 = new JTextField();
        textModNombre1.setBounds(40, 250, 720, 60);
        panelModificarNombre.add(textModNombre1);

        textModNombre2 = new JTextField();
        textModNombre2.setBounds(40, 450, 720, 60);
        panelModificarNombre.add(textModNombre2);

        //Botoones
        bModNom = new JButton("Continuar");
        bModNom.setBounds(350, 600, 100, 50);
        panelModificarNombre.add(bModNom);
        bModNom.addActionListener(this);






        //MODIFICAR SUELDO
        panelModificarSueldo = new Panel();
        panelModificarSueldo.setLayout(null);
        panelModificarSueldo.setVisible(false);
        panelModificarSueldo.setBounds(0, 0, 800, 1200);
        panelModificarSueldo.setBackground(Color.WHITE);
        this.getContentPane().add(panelModificarSueldo);


        //Etiquetas
        JLabel ms = new JLabel("Modificar Sueldo del  Empleado", SwingConstants.CENTER);
        ms.setBounds(0, 0, 800, 100);
        ms.setBackground(Color.white);
        ms.setOpaque(true);
        ms.setFont(new Font("Yellow Style", Font.HANGING_BASELINE, 50)); 
        panelModificarSueldo.add(ms);

        JLabel rolSueldo = new JLabel("Ingrese el Rol del Empleado", SwingConstants.CENTER);
        rolSueldo.setBounds(40, 180, 600, 40);
        rolSueldo.setFont(new Font("WEEKLY PLANNER", Font.HANGING_BASELINE, 30)); 
        panelModificarSueldo.add(rolSueldo);

        JLabel ns = new JLabel("Ingrese el sueldo del Empleado", SwingConstants.CENTER);
        ns.setBounds(40, 380, 600, 40);
        ns.setFont(new Font("WEEKLY PLANNER", Font.HANGING_BASELINE, 30)); 
        panelModificarSueldo.add(ns);

        //Cuadros de texto
        textModSueldo1 = new JTextField();
        textModSueldo1.setBounds(40, 250, 720, 60);
        panelModificarSueldo.add(textModSueldo1);

        textModSueldo2 = new JTextField();
        textModSueldo2.setBounds(40, 450, 720, 60);
        panelModificarSueldo.add(textModSueldo2);

        //Botoones
        bModSuel = new JButton("Continuar");
        bModSuel.setBounds(350, 600, 100, 50);
        panelModificarSueldo.add(bModSuel);
        bModSuel.addActionListener(this);




        //HACER COTIZACION
        panelCotizacion = new Panel();
        panelCotizacion.setLayout(null);
        panelCotizacion.setVisible(false);
        panelCotizacion.setBounds(0, 0, 800, 1200);
        panelCotizacion.setBackground(Color.white);
        this.getContentPane().add(panelCotizacion);

        //barrita
        barra = new JScrollPane(panelCotizacion);
        barra.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        barra.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        barra.getVerticalScrollBar().setUnitIncrement(100);
        barra.getVerticalScrollBar().setBlockIncrement(30);
        add(barra);


        //Etiquetas
        JLabel coti = new JLabel("Cotizacion", SwingConstants.CENTER);
        coti.setBounds(0, 0, 800, 100);
        coti.setBackground(Color.white);
        coti.setOpaque(true);
        coti.setFont(new Font("Yellow Style", Font.HANGING_BASELINE, 50)); 
        panelCotizacion.add(coti);

        JLabel tituloC = new JLabel("Ingrese el nombre de la Cotizacion");
        tituloC.setBounds(40, 100, 600, 40);
        tituloC.setFont(new Font("WEEKLY PLANNER", Font.HANGING_BASELINE, 20)); 
        panelCotizacion.add(tituloC);

        JLabel t = new JLabel("Ingrese las horas que durara el evento");
        t.setBounds(40, 200, 600, 40);
        t.setFont(new Font("WEEKLY PLANNER", Font.HANGING_BASELINE, 20)); 
        panelCotizacion.add(t);

        JLabel comi = new JLabel("Ingrese la comision");
        comi.setBounds(40, 300, 600, 40);
        comi.setFont(new Font("WEEKLY PLANNER", Font.HANGING_BASELINE, 20)); 
        panelCotizacion.add(comi);

        JLabel rolA = new JLabel("Ingresa un rol de animador a contratar");
        rolA.setBounds(40, 450, 600, 40);
        rolA.setFont(new Font("WEEKLY PLANNER", Font.HANGING_BASELINE, 20)); 
        panelCotizacion.add(rolA);

        JLabel rolCant = new JLabel("Cantidad de Animadores a contratar ");
        rolCant.setBounds(40, 600, 600, 40);
        rolCant.setFont(new Font("WEEKLY PLANNER", Font.HANGING_BASELINE, 20)); 
        panelCotizacion.add(rolCant);
    
        JLabel contratarMas = new JLabel("¿Te gustaria contratar otro rol? ", SwingConstants.CENTER);
        contratarMas.setBounds(40, 750, 600, 40);
        contratarMas.setFont(new Font("WEEKLY PLANNER", Font.HANGING_BASELINE, 20)); 
        panelCotizacion.add(contratarMas);
    
        //Cuadros de texto

        textTitulo = new JTextField();
        textTitulo.setBounds(40, 150, 720, 40);
        panelCotizacion.add(textTitulo);
        
        textHoras = new JTextField();
        textHoras.setBounds(40, 250, 720, 40);
        panelCotizacion.add(textHoras);
        textComision = new JTextField();
        textComision.setBounds(40, 350, 720, 40);
        panelCotizacion.add(textComision);

        textRolAnimador= new JTextField();
        textRolAnimador.setBounds(40, 500, 720, 40);
        panelCotizacion.add(textRolAnimador);

        textCantidad= new JTextField();
        textCantidad.setBounds(40, 650, 720, 40);
        panelCotizacion.add(textCantidad);

        //Botones
        bCotContratarMAs = new JButton("Contratar mas 1");
        bCotContratarMAs.setBounds(160, 850, 150, 50);
        panelCotizacion.add(bCotContratarMAs);
        bCotContratarMAs.addActionListener(this);

        bCotFinalizar = new JButton("Finalizar");
        bCotFinalizar.setBounds(480, 850, 150, 50);
        panelCotizacion.add(bCotFinalizar);
        bCotFinalizar.addActionListener(this);


        bCotContratarMas2 = new JButton("Contratar maas 2");
        bCotContratarMas2.setBounds(160, 850, 150, 50);
        panelCotizacion.add (bCotContratarMas2);
        bCotContratarMas2.addActionListener(this);
    }

        public void contratarMas(){
            try{
                cotiza = 0;
                if(textTitulo.getText().equals("") || textComision.getText().equals("") || textHoras.getText().equals("") || textCantidad.getText().equals("") || textRolAnimador.getText().equals("")) throw new Exception("Te falto algun dato");
                //esto es en caso de que ingresen horas negativas
                horas = Integer.parseInt(textHoras.getText());
                comision = Integer.parseInt(textComision.getText());
                cantidad = Integer.parseInt(textCantidad.getText());
                if((horas <=0.0) || (comision < 0.0 || cantidad <= 0.0))
                    throw new Exception( "No puedes ingresar cantidades negativas, o ninguna");
                if(!catalogo.contiene(textRolAnimador.getText())){
                        throw new Exception("No puedes agregar este empleado a la cotizacion porque no existe en tu lista de empleados.");
                }
                cotiza = catalogo.cotizacion(textRolAnimador.getText(), cantidad, horas, comision, listaCotizacion);
                bandera2 = listaCotizacion.modificar(textRolAnimador.getText(), cantidad, catalogo.sueldoPorHora(textRolAnimador.getText()) , horas, listaCotizacion, catalogo.Cantidad(textRolAnimador.getText()));
                totalCotizacion += cotiza;
                if(!bandera2) throw new Exception("No tienes suficientes empleados");                  
            }catch(Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                        textComision.setText("");
                        textHoras.setText("");
                        textTitulo.setText("");
                        panel.setVisible(true);
                        panelCotizacion.setVisible(false);
                        listaCotizacion.limpia();
                }finally {
                        cotiza = 0;
                        textCantidad.setText("");
                        textRolAnimador.setText("");
                        textComision.setEditable(true);
                        textHoras.setEditable(true);
                        textTitulo.setEditable(true);
                }
        }

     /**
    * Metodo para darle acciones a cada opcion y boton 
    * En este metodo, se pone todo lo necesario para que la interfaz funcione
    * 
    */
        public void actionPerformed(ActionEvent e) {
            panelContratar.setVisible(false);
            panelDespedir.setVisible(false);
            panelModificarNombre.setVisible(false);
            panelModificarSueldo.setVisible(false);
            panelCotizacion.setVisible(false);

            //Panel Principal
            if(e.getSource() == boton1){ 
                panel.setVisible(false);
                panelContratar.setVisible(true);
            }else if(e.getSource() == boton2){
                panel.setVisible(false);
                panelDespedir.setVisible(true);
            }else if(e.getSource()== boton3){
                 panel.setVisible(false);
                 panelModificarNombre.setVisible(true);
            }else if(e.getSource()== boton4){
                 panel.setVisible(false);
                 panelModificarSueldo.setVisible(true);
            }else if(e.getSource()== boton5){
                if(catalogo.esVacia())JOptionPane.showMessageDialog(null, "No puedes hacer una cotizacion porque no tienes empleados", "ERROR", JOptionPane.ERROR_MESSAGE);
            else{
                  panel.setVisible(false);
                  panelCotizacion.setVisible(true);
            }
            }
            
           //Contratar Empleados
            else if(e.getSource()== bContra){
                textContratar2.setEditable(false);
                try{
                    if(!catalogo.contiene(textContrar1.getText())) {
                        if(textContrar1.getText().equals("")){
                            throw new Exception("Te falto algun dato");
                        }else{
                            textContratar2.setEditable(true);
                            panelContratar.setVisible(true);
                            bContra2.setVisible(true);
                            bContra.setVisible(false);
                            textContrar1.setEditable(false);
                        }
                    }else{
                        textContratar2.setEditable(false);
                        catalogo.agregarEmpleado(textContrar1.getText());
                        actualizarCatalogo();
                        panelContratar.setVisible(false);
                        panel.setVisible(true);
                        textContrar1.setText("");
                        JOptionPane.showMessageDialog(null, "Catalogo modificado");
                    }
                }catch(Exception ex){
                     JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    panelContratar.setVisible(false);
                    panel.setVisible(true);
                } 

            }  else if(e.getSource()==bContra2){
               
                    try{
                        if(textContratar2.getText().equals("")) throw new Exception("Te falto algun dato");

                        double sueldo = Double.parseDouble(textContratar2.getText());
                        catalogo.agregarEmpleadoNuevo(textContrar1.getText(), sueldo);
                        actualizarCatalogo();
                        panelContratar.setVisible(false);
                        panel.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Catalogo modificado");
                    }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Solo puedes pagar en cantidades numericas", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }catch(Exception ex){
                     JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        panelContratar.setVisible(false);
                        panel.setVisible(true);
                        textContratar2.setEditable(false);
                        bContra2.setVisible(false);
                        bContra.setVisible(true);
                        textContrar1.setText("");
                        textContrar1.setEditable(true);
                        textContratar2.setText("");
                    }
                       
            //DESPEDIR EMPLEADOS      
            } else if(e.getSource()== bDes){
                try{
                    if(textDespe1.getText().equals("")) throw new Exception("Te falto algun dato");
                    if(!(catalogo.contiene(textDespe1.getText()))) throw new Exception("Empleado inexistente");
                    catalogo.eliminarEmpleado(textDespe1.getText());
                    actualizarCatalogo();
                    JOptionPane.showMessageDialog(null, "Catalogo modificado");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }finally {
                    panel.setVisible(true);
                    panelDespedir.setVisible(false);
                    textDespe1.setText("");
                }

            //MODIFICAR EL NOMBRE
            } else if(e.getSource()== bModNom){
                
                try{
                    if(textModNombre2.getText().equals("")) throw new Exception("Te falto algun dato");
                    if (!(catalogo.contiene(textModNombre1.getText()))) {
                        throw new Exception("Empleado inexistente");
                    }
                    catalogo.mRol(textModNombre1.getText(), textModNombre2.getText());
                    actualizarCatalogo();
                    JOptionPane.showMessageDialog(null, "Catalogo modificado");
                }catch(Exception ex){
                     JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                } finally {
                    panel.setVisible(true);
                    panelModificarSueldo.setVisible(false);
                    textModNombre1.setText("");
                    textModNombre2.setText("");
                }
            //MODIFICAR EL SUELDO
            } else if(e.getSource()== bModSuel){
                try{
                    if(textModSueldo2.getText().equals("") || textModSueldo1.getText().equals("")) throw new Exception("Te falto algun dato");
                    if (!(catalogo.contiene(textModSueldo1.getText()))) {
                        throw new Exception("Empleado inexistente");
                    }
                    double sueldo = Double.parseDouble(textModSueldo2.getText());
                    if(sueldo < 0) throw new Exception("No puedes colocar sueldos menores a 0");
                    catalogo.mSueldo(textModSueldo1.getText(), sueldo);
                    actualizarCatalogo();
                    JOptionPane.showMessageDialog(null, "Catalogo modificado");
                } catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Solo puedes pagar en cantidades numericas", "ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                } finally {
                    panel.setVisible(true);
                    panelModificarSueldo.setVisible(false);
                    textModSueldo1.setText("");
                    textModSueldo2.setText("");
                }
            //COTIZACION
            } else if(e.getSource()== bCotFinalizar){      
                    contratarMas();
                    if(!textTitulo.getText().equals("") && !textComision.getText().equals("") && !textHoras.getText().equals("") && !textCantidad.getText().equals("") && !textRolAnimador.getText().equals("") && !(horas <=0.0) && !(comision < 0.0 && !(cantidad <= 0.0 ) && catalogo.contiene(textRolAnimador.getText()) && bandera2)){
                        System.err.println(horas);
                        String cotizacioooon = listaCotizacion.muestra2() + "Duracion del evento: "+horas+ " Comision:"+comision+" La cotización total del evento es:"  + totalCotizacion;
                        JOptionPane.showMessageDialog(null, cotizacioooon);
                        crearArchivo("Cotizaciones/"+nombre+".txt", cotizacioooon);
                    }
                    textComision.setEditable(true);
                    textHoras.setEditable(true);
                    textTitulo.setEditable(true);
                    textComision.setText("");
                    textHoras.setText("");
                    textCantidad.setText("");
                    textRolAnimador.setText("");
                    textTitulo.setText("");
                    panel.setVisible(true);
                    panelCotizacion.setVisible(false);
                    totalCotizacion = 0;
                    listaCotizacion.limpia();
                    textComision.setEditable(true);
                    textHoras.setEditable(true);
                    textTitulo.setEditable(true);
                    nombre = textTitulo.getText();
                    textComision.setEditable(true);
                    textHoras.setEditable(true);             
            }else if (e.getSource() == bCotContratarMAs){
                    contratarMas(); 
                    textComision.setEditable(false);
                    textHoras.setEditable(false);
                    textTitulo.setEditable(false);
                    panelCotizacion.setVisible(true);
                    bCotFinalizar.setVisible(true);
                    bCotContratarMAs.setVisible(false);
                    bCotContratarMas2.setVisible(true);
                    panel.setVisible(false);
                    panelCotizacion.setVisible(true);               
            }else if(e.getSource() == bCotContratarMas2){
                    contratarMas();
                    textHoras.setEditable(false);
                    textTitulo.setEditable(false);
                    textComision.setEditable(false);
                    panelCotizacion.setVisible(true);
                    bCotFinalizar.setVisible(true);
                    bCotContratarMAs.setVisible(true);
                    bCotContratarMas2.setVisible(false);                 
            }
    }

      /**
    * Metodo principal
    * @param arreglo por defecto de java
    */
    public static void main(String[] args) {
        Main n = new Main();
         
        reestablecerDatos();
        n.actualizarCatalogo();
        crearArchivo("Catalogo/Catalogo.txt", catalogo.muestra2());

        n.setBounds(0, 0, 800, 1200);
        n.setLocationRelativeTo(null); 
        n.setVisible(true);
        n.setResizable(false);
        n.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                guardarDatos(catalogo);
            }
        });
    }
}
