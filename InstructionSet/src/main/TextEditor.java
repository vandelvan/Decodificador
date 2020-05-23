
package main;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.Hashtable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JViewport;

public class TextEditor extends javax.swing.JFrame {
    
    private static final long serialVersionUID = 1L;
    // SelectName es la clase que permite ponerle un nombre al archivo a guardar
    private SelectName sn;
    //La cadena "rutaSeleccionada" contendra la rura seleccionada del archivo guardado o abierto
    private String rutaSeleccionada = "";
    //"CrearArchivo" es la clase que crea o sobrescribe un archivo
    private CrearArchivo controlArchivo;
    //"GenerarRuta" es la clase que ayuda a crear la ruta en la que se guardara el archivo
    private GenerarRuta gr;
    //"AbrirArchivo" es las clase que permite abrir un archivo y leerlo para cargarlo en el editor
    private AbrirArchivo leer;
    //La cadena "datos" contendra los datos que se ecribiran en el editor de texto
    private String datos = "";
    //"Conversor" sera la clase para convertir archivos de binario a decimal y viceversa
    private Conversor conversor;
    //Otro objeto de la clase "GenerarRuta", para modificar la zona de seleccion de carpeta
    private GenerarRuta rutaCarpeta;
    
    private Hashtable<String, String> datosRutas = new Hashtable<>();
    
    private String propiedadCarpeta = "";
    private File carpeta = null;
    private File archivo = null;
    private String[] archivosCarpeta;
    
    String nomArchivo = "";
    ButtonTabComponent buttonTabComponent;
    
    private NumeroLinea numeroLinea;
    JTextPane areaAux;
    JScrollPane scrollAux;
    JViewport viewAux;
    
    //Arreglos para guardar los componentes de las pestañas y sus nombres de pestaña
    ArrayList<String> nombs = new ArrayList<String>();
    ArrayList<Component> componentes = new ArrayList<Component>();
    
    public TextEditor(String seleccionado, String datos, ArrayList<Component> componentes,  ArrayList<String> nombs) {
        initComponents();
        
        //Se establecen los datos que se escribiran en el editor
        this.datos = datos;
        //Definicion de los objetos
        controlArchivo = new CrearArchivo();
        conversor = new Conversor();
        leer = new AbrirArchivo();
        
        this.componentes = componentes;
        this.nombs = nombs;
        //Funcion para establecer los componentes en el TabbedPane
        setComponents();
        
        //"seleccionado" es la ruta del archivo que se estara utilizando
        this.rutaSeleccionada = seleccionado;
        this.seleccionado.setText(seleccionado);
        this.seleccionado.setEditable(false);
        //Este metodo comprueba el campo seleccionado, y de ahi activa y desactiva botones
        comprobarSeleccionado();
        carpetaBtnEstado();
        listenerArbolCarpeta();
        listenersConversores();
    }
    
    //Establecer los  componentes a partir del arreglo recibido por parametros
    private void setComponents(){
        
        if(componentes != null){
           for(int i = 0; i < componentes.size(); i++){  
               pestanas.add(nombs.get(i), componentes.get(i));
               //Agrego los botones x para cerrar pestañas
               buttonTabComponent = new ButtonTabComponent(pestanas);
               pestanas.setTabComponentAt(pestanas.getTabCount()-1, buttonTabComponent);
            } 
        }
    }
    
    //Funcion para obtener los nombres de las pestañas de los componentes
    private void getNames(){
        for(int i = 0; i < pestanas.getTabCount(); i++){
            nombs.add(i, pestanas.getTitleAt(i));
            System.out.println(pestanas.getTitleAt(i));
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        carpetaBTN = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        panelCarpeta = new javax.swing.JPanel();
        btnAbrirCarpeta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        arbolCarpeta = new javax.swing.JTree();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        seleccionado = new javax.swing.JTextField();
        pestanas = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        nuevo = new javax.swing.JMenuItem();
        abrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        guardarNormal = new javax.swing.JMenuItem();
        reset = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        convert = new javax.swing.JMenuItem();
        convertBack = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Decodificador");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(640, 480));

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setOpaque(false);

        carpetaBTN.setText("Carpeta");
        carpetaBTN.setFocusable(false);
        carpetaBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        carpetaBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        carpetaBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carpetaBTNActionPerformed(evt);
            }
        });
        jToolBar1.add(carpetaBTN);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelCarpeta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAbrirCarpeta.setText("Abrir Carpeta");
        btnAbrirCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirCarpetaActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Vacio");
        arbolCarpeta.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(arbolCarpeta);

        javax.swing.GroupLayout panelCarpetaLayout = new javax.swing.GroupLayout(panelCarpeta);
        panelCarpeta.setLayout(panelCarpetaLayout);
        panelCarpetaLayout.setHorizontalGroup(
            panelCarpetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCarpetaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCarpetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAbrirCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        panelCarpetaLayout.setVerticalGroup(
            panelCarpetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCarpetaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAbrirCarpeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Archivo Seleccionado:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(seleccionado)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(seleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pestanas.setToolTipText("");
        pestanas.setName(""); // NOI18N
        pestanas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pestanasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelCarpeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pestanas)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pestanas)
                    .addComponent(panelCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pestanas.getAccessibleContext().setAccessibleName("Archivo");

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jMenu1.setText("Archivo");

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jMenu1.add(nuevo);

        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        jMenu1.add(abrir);

        guardar.setText("Guardar como");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jMenu1.add(guardar);

        guardarNormal.setText("Guardar");
        guardarNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarNormalActionPerformed(evt);
            }
        });
        jMenu1.add(guardarNormal);

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jMenu1.add(reset);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Convertir");

        convert.setText("Ensamblador a Binario");
        convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertActionPerformed(evt);
            }
        });
        jMenu2.add(convert);

        convertBack.setText("Binario a Ensamblador");
        convertBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertBackActionPerformed(evt);
            }
        });
        jMenu2.add(convertBack);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo para el boton "Guardar como"
    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
            guardarComo(areaAux.getText());
    }//GEN-LAST:event_guardarActionPerformed
    
    //Metodo para el boton "Guardar"
    private void guardarNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarNormalActionPerformed
            //Se le pasa por parametros los datos normales y la ruta para guardarlos en el mismo archivo
            controlArchivo.crear(areaAux.getText(), rutaSeleccionada);
            System.out.println("archivo guardado");      
    }//GEN-LAST:event_guardarNormalActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

        reset();
    }//GEN-LAST:event_resetActionPerformed

    //Metodo para resetear todo
    public void reset(){
        seleccionado.setText("");
        guardar.setEnabled(true);
        guardarNormal.setEnabled(false);
        convert.setSelected(false);
        rutaSeleccionada = "";
        datos = "";
        pestanas.removeAll();
    }
    
    //Metodo para el boton "Abrir"
    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        
        //Se utiliza la clase para crear la ruta en donde se abrira el archivo
        gr = new GenerarRuta(null, JFileChooser.FILES_ONLY);
        gr.separarNomRuta();
        nomArchivo = gr.getNomSinRuta();
        
        abrirArchivo(gr.getRutaArchivo());
        
    }//GEN-LAST:event_abrirActionPerformed

    private void abrirArchivo(String ruta){
        
        //Comprobar si la ruta no esta vacia
        if(!ruta.equals("")){
            //Se escribe la ruta en el campo "seleccionado"
            seleccionado.setText(ruta);
            //Se llama al metodo para desactivar ciertos botones
            comprobarSeleccionado();
            
            //Se utiliza el objeto de la clase "AbrirArchivo", se utiliza su metodo "leer" y se le manda la ruta del archivo
            leer.leer(ruta);
            
            //Pestaña
            generarPestana(nomArchivo);
            
            //establezco el texto en el objeto obtenido que pertenece al TextPane
            areaAux.setText(leer.getData());
            
            //Se guarda la ruta en la cadena, (Era para evitar un error que no recuerdo exactamente cual era :b)
            rutaSeleccionada = ruta;
            leer.datos = "";
        }
        
    }
    
    
    private void convertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertActionPerformed
    }//GEN-LAST:event_convertActionPerformed

    private void carpetaBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carpetaBTNActionPerformed
        carpetaBtnEstado();
    }//GEN-LAST:event_carpetaBTNActionPerformed

    private void btnAbrirCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirCarpetaActionPerformed
        rutaCarpeta=new GenerarRuta(null, JFileChooser.DIRECTORIES_ONLY);

        if(!rutaCarpeta.getRutaArchivo().equals("")){
            datosRutas.clear();
            //Metodo que separa la ruta y el nombre del archivo
            rutaCarpeta.separarNomRuta();
            //Objeto para la raiz
            DefaultMutableTreeNode carpetaNodo = new DefaultMutableTreeNode(rutaCarpeta.getNomSinRuta());
            //Le pongo el nombre de la ruta a la raiz
            carpetaNodo.setUserObject(rutaCarpeta.getRutaSinNom());
            //Objeto file para almacenar la carpeta seleccionada y sus propiedades
            carpeta = new File(rutaCarpeta.getRutaArchivo());
            //Guardo la lista de los archivos en un arreglo de cadenas
            archivosCarpeta = carpeta.list();

            //Compruebo que el arreglo no este vacio
            if(!archivosCarpeta.equals(null)){
                //Recorro la lista de los archivos
                for(int i = 0; i < archivosCarpeta.length; i++){
                    //Creo un objeto file para comprobar si lo de la ruta es un archivo
                    archivo = new File(rutaCarpeta.getRutaArchivo() + "\\" + archivosCarpeta[i]);
                        //Compruebo si lo de la ruta es un archivo, y si es txt, mem, asm
                        if(archivo.isFile() && isTetx(archivo.getName())){
                            System.out.println(archivosCarpeta[i]);
                            //Creacion de objeto para insertar en el nodo raiz los archivos en la ruta
                            DefaultMutableTreeNode archivo = new DefaultMutableTreeNode(archivosCarpeta[i]);
                            carpetaNodo.add(archivo);
                            //Agrego los archivos al Hash table
                            datosRutas.put(archivosCarpeta[i], rutaCarpeta.getRutaArchivo() + "\\" + archivosCarpeta[i]);
                            }

                        }
                    }

                    //Modelo para el arbol y establezco la raiz
                    DefaultTreeModel modelo = new DefaultTreeModel(carpetaNodo);
                    arbolCarpeta.setModel(modelo);

                }
    }//GEN-LAST:event_btnAbrirCarpetaActionPerformed

    //Abrir pestaña nueva
    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed

            generarPestana("Archivo");
    }//GEN-LAST:event_nuevoActionPerformed

    private void convertBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_convertBackActionPerformed

    private void pestanasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pestanasMouseClicked
        
            System.out.println("Pres");
            //Obtengo el scroll de la pestaña seleccionada y lo guardo en un objeto
            scrollAux = (JScrollPane)pestanas.getSelectedComponent();
            //El viewport es lo que esta dentro del scroll, tambien lo guardo en un objeto
            viewAux = scrollAux.getViewport();
            
            //Se establece el editor con los datos obtenidos de la lectura
            //Dentro del viewport esta el textpane, lo guardo en un objeto
            areaAux = (JTextPane)viewAux.getView();
            
            System.out.println(areaAux.getText());
    }//GEN-LAST:event_pestanasMouseClicked

    
    private void generarPestana(String nom){
        
            //Pestañas
            buttonTabComponent = new ButtonTabComponent(pestanas);
            //Objetos para crear las nuevas pestañas con los numeros de lineas
            JTextPane editorNuevo = new JTextPane();
            JScrollPane scrollNuevo = new JScrollPane();
            NumeroLinea numLinea = new NumeroLinea(editorNuevo);
            scrollNuevo.setViewportView(editorNuevo);
            scrollNuevo.setRowHeaderView(numLinea);
            
            //Añado la pestaña con su nombre y panel de texto ya modificado
            pestanas.add(nom, scrollNuevo);
            //Le paso el objeto que permite cerrar las pestañas
            pestanas.setTabComponentAt(pestanas.getTabCount()-1, buttonTabComponent);
            //Selecciono la ultima pestaña seleccionada
            pestanas.setSelectedIndex(pestanas.getTabCount()-1);
     
            //Obtengo el scroll de la pestaña seleccionada y lo guardo en un objeto
            scrollAux = (JScrollPane)pestanas.getSelectedComponent();
            //El viewport es lo que esta dentro del scroll, tambien lo guardo en un objeto
            viewAux = scrollAux.getViewport();
            
            //Se establece el editor con los datos obtenidos de la lectura
            //Dentro del viewport esta el textpane, lo guardo en un objeto
            areaAux = (JTextPane)viewAux.getView();
    }
    
    //Funcion para comprobar la extencion de un archivo
    private boolean isTetx(String archivo){
        int indicador = 0;
        String extencion = "";
        String invertida = "";
        for(int i = archivo.length()-1; i >= 0; i--){
            if(archivo.charAt(i) != '.' && indicador == 0){
                extencion = extencion.concat(String.valueOf(archivo.charAt(i)));
            }else{
                indicador = 1;
            }
        }
        for(int i = extencion.length()-1; i >= 0; i--){
            invertida = invertida.concat(String.valueOf(extencion.charAt(i)));
        }
        if(invertida.equals("txt") || invertida.equals("mem") || invertida.equals("asm")){
            return true;
        }else{
            return false;
        }
    }
    
    
    //Listener para el arbol
    private void listenerArbolCarpeta(){
        
        arbolCarpeta.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) arbolCarpeta.getLastSelectedPathComponent();
                
                //Object rutaArbol = nodo.getUserObject();
                if(nodo == null){
                    return;
                }
                
                if(datosRutas.get(nodo.getUserObject()) != null){
                    System.out.println(datosRutas.get(nodo.getUserObject()));
                    nomArchivo = (String) nodo.getUserObject();
                    abrirArchivo(datosRutas.get(nodo.getUserObject()));
                }
                
                
            }
        });
    }
    
    private void carpetaBtnEstado(){
        if(carpetaBTN.isSelected()){
            System.out.println("presionado");
            panelCarpeta.setVisible(true);
        }else{
            System.out.println("No presionado");
            panelCarpeta.setVisible(false);
        }
    }
    
    //Se desactivan botones dependiendo de si el archivo es nuevo o se sobrescribe
    public void comprobarSeleccionado(){
        
        if(seleccionado.getText().equals("")){
            guardar.setEnabled(true);
            guardarNormal.setEnabled(false);
        }else{
            guardar.setEnabled(true);
            guardarNormal.setEnabled(true); 
        }
    }

    public void guardarComo(String texto)
    {
        //Se muestra la ventana para seleccionar el nombre del archivo y se le pasa por parametros los datos
        //Limpieza de arreglos para evitar que se acumulen pestañas
        componentes.clear();
        nombs.clear();
        //Lleno el arreglo de componentes con todas las "pestañas" de TabbedPane
        for(int i = 0; i < pestanas.getComponentCount()-1; i++){
            componentes.add(i, pestanas.getComponentAt(i));
        }
        //Funcion para obtener los nombres de las pestañas y guardarlos en el arreglo de nombres
        getNames();

        sn = new SelectName(texto, componentes, nombs);
        sn.setLocationRelativeTo(null);
        sn.setVisible(true);
        dispose();    
    }

    public void listenersConversores(){
        convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boolean status = conversor.toBinary(areaAux.getText());
                if(!status)
                {    //Si hubo algun error lo notifica
                    JOptionPane.showMessageDialog(
                        jMenu2,
                        "Tiene un error en su codigo",
                        "ERROR.",
                        JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    guardarComo(conversor.getDataBin());
                }
                convertActionPerformed(evt);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir;
    private javax.swing.JTree arbolCarpeta;
    private javax.swing.JButton btnAbrirCarpeta;
    private javax.swing.JToggleButton carpetaBTN;
    private javax.swing.JMenuItem convert;
    private javax.swing.JMenuItem convertBack;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JMenuItem guardarNormal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem nuevo;
    private javax.swing.JPanel panelCarpeta;
    private javax.swing.JTabbedPane pestanas;
    private javax.swing.JMenuItem reset;
    private javax.swing.JTextField seleccionado;
    // End of variables declaration//GEN-END:variables

}
