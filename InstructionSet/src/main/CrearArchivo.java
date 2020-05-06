
package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class CrearArchivo {
    
    File f;
    FileWriter fW;
    PrintWriter pW;
    BufferedWriter bw;
    
    public CrearArchivo(){

    }
    
    public void crear(String datos, String ruta){
        /*f = new File("./../" + nomArch);*/
        f = new File(ruta);
        
        if(!f.exists()){
    
            try {
                f.createNewFile();
                fW = new FileWriter(f, true);
                pW = new PrintWriter(fW);
                
                //Escritura
                pW.println(datos);
                
                fW.close();
                pW.close();
                
            } catch (IOException ex) {
                Logger.getLogger(CrearArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                fW = new FileWriter(f, true);
                pW = new PrintWriter(fW);
                bw = new BufferedWriter(new FileWriter(f));
                
                //Escritura
                bw.write("");
                pW.println(datos);
                
                fW.close();
                pW.close();
                bw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(CrearArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
