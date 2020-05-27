
package main;

import java.io.File;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalFileChooserUI;

public class GenerarRuta {
    
    String ruta = "";
    String nom = "";
    String ext = "";
    String rutaSinNom = "";
    String nomSinRuta = "";
    int respuesta;//Guarda la accion ralizada en la ventana en forma de entero
    JFileChooser jf;
    File carpetaElegida;
    boolean indicadorRuta = false;
    
    //Variables para acceder al combobox del filechooser
    JPanel p1;
    JPanel p2;
    JComboBox extensiones;
    FileNameExtensionFilter extension;
    JTextField tf;
    
    public GenerarRuta(){
        
        
    }
    
    public void crearRuta(int modoSeleccion, boolean rutaConExt){
        
        jf = new JFileChooser();//Instancia para la ventana de seleccion de la ruta
        jf.setApproveButtonText("Seleccionar");//Establecer el texto que aparece en el boton
        jf.setFileSelectionMode(modoSeleccion);//Solo se leeran directorios
        
        //Si se recibe por parametros el FILES_ONLY, se mostrara en la lista de filtros los archivos con extension txt y mem
        if(modoSeleccion == JFileChooser.FILES_ONLY){
            //Creacion de los objetos tipo file filter
            FileFilter filtro1 = new FileNameExtensionFilter(".mem", "mem");
            FileFilter filtro2 = new FileNameExtensionFilter(".txt", "txt");
            FileFilter filtro3 = new FileNameExtensionFilter(".asm", "asm");
            //Se añaden los filtros al file chooser
            jf.addChoosableFileFilter(filtro1);
            jf.addChoosableFileFilter(filtro2);
            jf.addChoosableFileFilter(filtro3);
            //Establezco como predeterminada la extension .txt (filtro2)
            jf.setFileFilter(filtro2);
            
        }
        
        //Cuando quiera abrir un archivo se desactivara el textfield del jFileChooser
        if(rutaConExt == true){
            p1 = (JPanel) jf.getComponent(3);
            p2 = (JPanel) p1.getComponent(0);
            tf = (JTextField) p2.getComponent(1);
            tf.setEditable(false);
            System.out.println("Bolean");
        }
        
        respuesta = jf.showOpenDialog(jf);//Aqui se establece la opcion elegida, en entero
        
        //Comprobacion de la variable respuesta, se comprueban valores enteros
        if(respuesta == JFileChooser.APPROVE_OPTION){
            carpetaElegida = jf.getSelectedFile();
            ruta = carpetaElegida.getPath();
            
            if(rutaConExt != true){
                //Todo esto para llegar a la ubucacion del combobox en el filechooser, y asi obtener la extencion seleccionada
                p1 = (JPanel) jf.getComponent(3);
                p2 = (JPanel) p1.getComponent(2);
                extensiones =(JComboBox)p2.getComponent(1);
                System.out.println(extensiones.getSelectedItem());
                if(extensiones.getSelectedIndex() != 0){
                    extension = (FileNameExtensionFilter) extensiones.getSelectedItem();
                    ext = extension.getDescription();
                    System.out.println(extension.getDescription()); 
                }else{
                    ext = ".txt";
                }
            }else{
                ext="";
            }

            indicadorRuta = true;
             
        }else if(respuesta == JFileChooser.CANCEL_OPTION){
            System.out.println("Se cancelo el guardado");
            indicadorRuta = false;
        }else{
            System.out.println("Error en guardado");
            indicadorRuta = false;
        }
        
    }
    
    
    private String invertir(String cadena){
        String invertida = "";
        for(int i = cadena.length()-1; i >= 0; i--){
            invertida = invertida.concat(String.valueOf(cadena.charAt(i)));
        } 
        return invertida;
    }
    
    //Obtener nombre ya agregado de la ruta
    public void separarNomRuta(){
        int indicadorNom = 0;
        String rutaE = ruta + ext;
        
        for(int i = rutaE.length()-1; i>=0; i--){
            if(rutaE.charAt(i) != '\\' && indicadorNom == 0){
                nomSinRuta = nomSinRuta.concat(String.valueOf(rutaE.charAt(i)));
            }else{
                rutaSinNom = rutaSinNom.concat(String.valueOf(rutaE.charAt(i)));
                indicadorNom = 1;
                //System.out.println(rutaSinNom);
            }
        }
        nomSinRuta = invertir(nomSinRuta);
        rutaSinNom = invertir(rutaSinNom);
    }
   
    public void resetRutas(){
        
        this.ruta = "";
        this.nom = "";
        this.ext = "";
        this.rutaSinNom = "";
        this.nomSinRuta = "";
    }
    
    public String getRutaArchivo(){
        return ruta;
    }
    
    public String getNomSinRuta(){
        return nomSinRuta;
    }
    
    public String getRutaSinNom(){
        return rutaSinNom;
    }
    
    public String getRutaExt(){
        
        return ruta + ext;
    }
    
    public boolean getIndicadorRuta(){
        return indicadorRuta;
    }
}
