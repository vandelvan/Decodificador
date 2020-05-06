
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbrirArchivo {
    
    String rutaArch = "";
    String datos = "";
    
    public AbrirArchivo(){
        
    }
    
    public void leer(String rutaArch){
        this.rutaArch = rutaArch;
        try {
            //Instacia de Scanner para la lectura del archivo
            Scanner lectura = new Scanner(new File(rutaArch));
            //Recorrido del archivo, linea por linea
            while(lectura.hasNextLine()){
                //Se va concatenando el texto que se lee
                datos = datos + lectura.nextLine();
                //Cada pasada es una linea leida, por lo tanto le concateno un salto de linea para no perder el formato
                datos = datos + "\n";
                //System.out.println("-->" + datos);
            }
            lectura.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AbrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getData(){
        return datos;
    }
    
}
