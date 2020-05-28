
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static main.Main.console;

public class AbrirArchivo {
    
    private String rutaArch = "";
    public String datos = "";
    
    public AbrirArchivo(){
        console.print("AbrirArchivo inicializado");
    }
    
    public void leer(String rutaArch){
        console.print("Abriendo archivo en " + rutaArch);
        this.rutaArch = rutaArch;
        try {
            //Instacia de Scanner para la lectura del archivo
            Scanner lectura = new Scanner(new File(rutaArch));
            //Recorrido del archivo, linea por linea
            while(lectura.hasNextLine()){
                //Se va concatenando el texto que se lee
                datos = datos + lectura.nextLine();
                //Cada pasada es una linea leida, por lo tanto le concateno un salto de linea para no perder el formato
                //Cuando sea false la lectura ya no pondra un salto de linea, estaria de mas al original
                if(lectura.hasNextLine() != false){
                    datos = datos + "\n";
                    //System.out.println(lectura.hasNextLine());
                }

            }
            lectura.close();
        } catch (FileNotFoundException ex) {
            console.print("Error al abrir archivo: " + ex.getMessage());
            Logger.getLogger(AbrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public String getData(){
        return datos;
    }
    
}
