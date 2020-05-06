/*
Clase del editor de texto
*/
package main;

import java.io.File;
import javax.swing.JFileChooser;

public class TextEditor extends javax.swing.JFrame {
    
    //SelectName es la clase que permite ponerle un nombre al archivo a guardar
    SelectName sn;
    //La cadena "rutaSeleccionada" contendra la rura seleccionada del archivo guardado o abierto
    String rutaSeleccionada = "";
    //"CrearArchivo" es la clase que crea o sobrescribe un archivo
    CrearArchivo controlArchivo;
    //"GenerarRuta" es la clase que ayuda a crear la ruta en la que se guardara el archivo
    GenerarRuta gr;
    //"AbrirArchivo" es las clase que permite abrir un archivo y leerlo para cargarlo en el editor
    AbrirArchivo leer;
    //La cadena "datos" contendra los datos que se ecribiran en el editor de texto
    String datos = "";
    //"Conversor" sera la clase para convertir archivos de binario a decimal y viceversa
    Conversor conversor;
    
    public TextEditor(String seleccionado, String datos) {
        initComponents();
        
        //Se establecen los datos que se escribiran en el editor
        this.datos = datos;
        //Definicion de los objetos
        controlArchivo = new CrearArchivo();
        conversor = new Conversor();
        editor.setText(datos);
        leer = new AbrirArchivo();
        //"seleccionado" es la ruta del archivo que se estara utilizando
        this.rutaSeleccionada = seleccionado;
        this.seleccionado.setText(seleccionado);
        this.seleccionado.setEditable(false);
        //Este metodo comprueba el campo seleccionado, y de ahi activa y desactiva botones
        comprobarSeleccionado();
     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        editor = new javax.swing.JTextArea();
        seleccionado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        convert = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        abrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        guardarNormal = new javax.swing.JMenuItem();
        reset = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        editor.setColumns(20);
        editor.setRows(5);
        jScrollPane1.setViewportView(editor);

        jLabel1.setText("Archivo Seleccionado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seleccionado)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        convert.setText("Convertir");
        convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(convert, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(convert)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo para el boton "Guardar como"
    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        
        //Si ese boton esta seleccionado significa que el texto esta convertido
        if(convert.isSelected()){
            //Por lo tanto se debera dejar nornal para guardarlo de forma normal, metodo toBinary (Dejarlo normal)
            conversor.toBinary(editor.getText());//Metodo no terminado
            //Se muestra la ventana para seleccionar el nombre del archivo y se le pasa por parametros los datos
            sn = new SelectName(conversor.getDataBi());
            //Configuracion de la ventana
            sn.setLocationRelativeTo(null);
            sn.setVisible(true);
            dispose();
        }else{//Si el boton no esta seleccionado significa que el texto esta nornal
            //Se muestra la ventana para seleccionar el nombre del archivo y se le pasa por parametros los datos
            sn = new SelectName(editor.getText());
            sn.setLocationRelativeTo(null);
            sn.setVisible(true);
            dispose();
        }
    
    }//GEN-LAST:event_guardarActionPerformed
    
    //Metodo para el boton "Guardar"
    private void guardarNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarNormalActionPerformed
        // TODO add your handling code here:
        //Si ese boton esta seleccionado significa que el texto esta convertido
        if(convert.isSelected()){
            //Por lo tanto se debera dejar nornal para guardarlo de forma normal, metodo toBinary (Dejarlo normal)
            conversor.toBinary(editor.getText());//Metodo no terminado
            //Se le pasa por parametros los datos y la ruta que ya estaria definida, ahi se realiza el guardado de cambios
            controlArchivo.crear(conversor.getDataBi(), rutaSeleccionada);
            System.out.println("archivo guardado"); 
        }else{
            //Se le pasa por parametros los datos normales y la ruta para guardarlos en el mismo archivo
            controlArchivo.crear(editor.getText(), rutaSeleccionada);
            System.out.println("archivo guardado");
        }
      
    }//GEN-LAST:event_guardarNormalActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
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
        //Reset de todo
        reset();
        
        //Comprobar si la ruta no esta vacia
        if(!gr.getRutaArchivo().equals("")){
            //Se escribe la ruta en el campo "seleccionado"
            seleccionado.setText(gr.getRutaArchivo());
            //Se llama al metodo para desactivar ciertos botones
            comprobarSeleccionado();
            
            //Se utiliza el objeto de la clase "AbrirArchivo", se utiliza su metodo "leer" y se le manda la ruta del archivo
            leer.leer(gr.getRutaArchivo());
            //Se establece el editor con los datos obtenidos de la lectura
            editor.setText(leer.getData());
            //Se guarda la ruta en la cadena, (Era para evitar un error que no recuerdo exactamente cual era :b)
            rutaSeleccionada = gr.getRutaArchivo();
            leer.datos = "";
        }
        
    }//GEN-LAST:event_abrirActionPerformed

    //Este es un listener del boton
    private void convertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertActionPerformed
        // TODO add your handling code here:
        //Si el boton esta seleccionado, significa que se a activado el conversor
        if(convert.isSelected()){
            //Se convierten los datos y se sobrescriben en el editor
            conversor.toAssemble(editor.getText());//Metodo no terminado
            editor.setText(conversor.getDataAss());
            
        }else{
            //Se convierten los datos y se sobrescriben en el editor
            conversor.toBinary(editor.getText());//Metodo no terminado
            editor.setText(conversor.getDataBi());
        }
    }//GEN-LAST:event_convertActionPerformed

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
    private javax.swing.JToggleButton convert;
    private javax.swing.JTextArea editor;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JMenuItem guardarNormal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem reset;
    private javax.swing.JTextField seleccionado;
    // End of variables declaration//GEN-END:variables

}
