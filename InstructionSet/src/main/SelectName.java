package main;

import java.util.Calendar;
import javax.swing.JFileChooser;


public class SelectName extends javax.swing.JFrame {

    //Nombre del archivo
    String nombre = "";
    //Datos a guardar
    String datos= "";
    //Ruta para guardar el archivo
    String ruta = "";
    //Clase para crear la ruta
    GenerarRuta gr;
    //Clase para obtener fecha y hora, si no se le pone nobre se pondra una dependiedo la hora (Lo cambiare a fecha)
    Calendar calendario;
    //Clase para crear el archivo
    CrearArchivo ca;
    //Clase principal del editor, se cargaran de nuevo la clase con el archivo guardado y seleccionado
    TextEditor te;

    public SelectName(String datos) {
        initComponents();
        calendario = Calendar.getInstance();
        ca = new CrearArchivo();
        //Se reciben los datos, es una forma se mantenerlos al mometo de cambiar de ventana, asi no se pierden
        this.datos = datos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameFile = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        listaTipos = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        ok = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nombre del archivo:");

        listaTipos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".txt", ".mem" }));

        jLabel2.setText("Tipo de archivo:");

        ok.setText("Aceptar");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ok)
                        .addGap(0, 87, Short.MAX_VALUE))
                    .addComponent(listaTipos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameFile))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ok)
                    .addComponent(cancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        
        //Se tome el nombre escrito en el campo
        nombre = nameFile.getText();
        //Si no se pone nombre se coloca uno por defaul, usando el horario (Cambiar a fecha)
        if(nombre.equals("")){
            nombre = "Sin_Nombre_" + calendario.get(Calendar.HOUR_OF_DAY) + calendario.get(Calendar.MINUTE) + calendario.get(Calendar.SECOND);
        }
        //Ahora se crea la ruta para guardar el archivo
        gr = new GenerarRuta(nombre, JFileChooser.DIRECTORIES_ONLY);
        //Se le concatena la extencion del archivo, .txt o .mem
        ruta = gr.getRutaNom() + listaTipos.getSelectedItem();
        System.out.println(ruta);
        //Se crea el archivo, se manda por paramentros los datos y la ruta, a la clase de CrearArchivo
        ca.crear(datos, ruta);
        //Metodo para mostrar una nueva ventana del editor, con el archivo que se guardo seleccionado
        ventanaEditor();
    }//GEN-LAST:event_okActionPerformed

    //Si se presiona el boton cancelar
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        ventanaEditor();
    }//GEN-LAST:event_cancelarActionPerformed
    //Si se cierra la venta
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaEditor();
    }//GEN-LAST:event_formWindowClosing

    //Nueva ventana del editor
    public void ventanaEditor(){
        dispose();
        //Se define el objeto y se le mada la ruta y los datos guardados
        te = new TextEditor(ruta, datos);
        te.setLocationRelativeTo(null);
        te.setVisible(true);
    }
    
    
    public String getNombre(){
        return nombre;
    }
    
    public String getRuta(){
        return ruta;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox listaTipos;
    private javax.swing.JTextField nameFile;
    private javax.swing.JButton ok;
    // End of variables declaration//GEN-END:variables
}
