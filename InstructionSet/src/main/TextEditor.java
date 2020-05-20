
package main;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.Hashtable;

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
    
    
    private NumeroLinea numeroLinea;
    
    public TextEditor(String seleccionado, String datos) {
        initComponents();
        
        //Se establecen los datos que se escribiran en el editor
        this.datos = datos;
        //Definicion de los objetos
        controlArchivo = new CrearArchivo();
        conversor = new Conversor();
        editor.setText(datos);
        leer = new AbrirArchivo();
        //Numero a las lineas
        numeroLinea = new NumeroLinea(editor);
        editorScroll.setRowHeaderView(numeroLinea);
        //Nodo
        //"seleccionado" es la ruta del archivo que se estara utilizando
        this.rutaSeleccionada = seleccionado;
        this.seleccionado.setText(seleccionado);
        this.seleccionado.setEditable(false);
        //Este metodo comprueba el campo seleccionado, y de ahi activa y desactiva botones
        comprobarSeleccionado();
        carpetaBtnEstado();
        listenerArbolCarpeta();
     
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        carpetaBTN = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        editorScroll = new javax.swing.JScrollPane();
        editor = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        seleccionado = new javax.swing.JTextField();
        panelCarpeta = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        arbolCarpeta = new javax.swing.JTree();
        btnAbrirCarpeta = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
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

        editorScroll.setViewportView(editor);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Archivo Seleccionado:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seleccionado, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(seleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCarpeta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Vacio");
        arbolCarpeta.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(arbolCarpeta);

        btnAbrirCarpeta.setText("Abrir Carpeta");
        btnAbrirCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirCarpetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCarpetaLayout = new javax.swing.GroupLayout(panelCarpeta);
        panelCarpeta.setLayout(panelCarpetaLayout);
        panelCarpetaLayout.setHorizontalGroup(
            panelCarpetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarpetaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCarpetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(btnAbrirCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelCarpetaLayout.setVerticalGroup(
            panelCarpetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCarpetaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAbrirCarpeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                        .addComponent(editorScroll)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editorScroll)
                    .addComponent(panelCarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jMenu1.setText("Archivo");

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
        jMenu2.add(convert);
        convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boolean status = conversor.toBinary(editor.getText());
                if(!status){    //Si hubo algun error lo notifica
                    JOptionPane.showMessageDialog(
                        jMenu2,
                        "Tiene un error en su codigo",
                        "ERROR.",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        convertBack.setText("Binario a Ensamblador");
        jMenu2.add(convertBack); 
        convertBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conversor.toAssembly(editor.getText());
            }
        });

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            //Se muestra la ventana para seleccionar el nombre del archivo y se le pasa por parametros los datos
            sn = new SelectName(editor.getText());
            sn.setLocationRelativeTo(null);
            sn.setVisible(true);
            dispose();    
    }//GEN-LAST:event_guardarActionPerformed
    
    //Metodo para el boton "Guardar"
    private void guardarNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarNormalActionPerformed
            //Se le pasa por parametros los datos normales y la ruta para guardarlos en el mismo archivo
            controlArchivo.crear(editor.getText(), rutaSeleccionada);
            System.out.println("archivo guardado");      
    }//GEN-LAST:event_guardarNormalActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

        reset();
    }//GEN-LAST:event_resetActionPerformed

    //Metodo para resetear todo
    public void reset(){
        seleccionado.setText("");
        editor.setText("");
        guardar.setEnabled(true);
        guardarNormal.setEnabled(false);
        convert.setSelected(false);
        rutaSeleccionada = "";
        datos = "";
    }
    
    //Metodo para el boton "Abrir"
    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        
        //Se utiliza la clase para crear la ruta en donde se abrira el archivo
        gr = new GenerarRuta(null, JFileChooser.FILES_ONLY);
        
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
            //Se establece el editor con los datos obtenidos de la lectura
            editor.setText(leer.getData());
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
           
        }else{
            
        }  
    }//GEN-LAST:event_btnAbrirCarpetaActionPerformed

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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir;
    private javax.swing.JTree arbolCarpeta;
    private javax.swing.JButton btnAbrirCarpeta;
    private javax.swing.JToggleButton carpetaBTN;
    private javax.swing.JMenuItem convert;
    private javax.swing.JMenuItem convertBack;
    private javax.swing.JTextPane editor;
    private javax.swing.JScrollPane editorScroll;
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
    private javax.swing.JPanel panelCarpeta;
    private javax.swing.JMenuItem reset;
    private javax.swing.JTextField seleccionado;
    // End of variables declaration//GEN-END:variables

}
