
package main;

import java.io.File;
import javax.swing.JFileChooser;

public class GenerarRuta {
    
    String ruta = "";
    String nom = "";
    int respuesta;//Guarda la accion ralizada en la ventana en forma de entero
    JFileChooser jf;
    File carpetaElegida;
    
    public GenerarRuta(String nom, int modoSeleccion){
        this.nom = nom;
        jf = new JFileChooser();//Instancia para la ventana de seleccion de la ruta
        jf.setApproveButtonText("Seleccionar");//Establecer el texto que aparece en el boton
        jf.setFileSelectionMode(modoSeleccion);//Solo se leeran directorios
        
        respuesta = jf.showOpenDialog(jf);//Aqui se establece la opcion elegida, en entero
        
        //Comprobacion de la variable respuesta, se comprueban valores enteros
        if(respuesta == JFileChooser.APPROVE_OPTION){
            carpetaElegida = jf.getSelectedFile();
            ruta = carpetaElegida.getPath();
        }else if(respuesta == JFileChooser.CANCEL_OPTION){
            System.out.println("Se cancelo el guardado");
        }else{
            System.out.println("Error en guardado");
        }
    }
    
    public String getRutaNom(){
        return ruta + "\\" + nom;
    }
    
    public String getRutaArchivo(){
        return ruta;
    }
}
