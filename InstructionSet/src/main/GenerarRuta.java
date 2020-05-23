
package main;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GenerarRuta {
    
    public String ruta = "";
    public String nom = "";
    public String rutaSinNom = "";
    public String nomSinRuta = "";
    private int respuesta;//Guarda la accion ralizada en la ventana en forma de entero
    private JFileChooser jf;
    private File carpetaElegida;
    
    
    public GenerarRuta(String nom, int modoSeleccion){
        this.nom = nom;
        
        jf = new JFileChooser();//Instancia para la ventana de seleccion de la ruta
        jf.setApproveButtonText("Seleccionar");//Establecer el texto que aparece en el boton
        jf.setFileSelectionMode(modoSeleccion);//Solo se leeran directorios
        
        //Si se recibe por parametros el FILES_ONLY, se mostrara en la lista de filtros los archivos con extension txt y mem
        if(modoSeleccion == JFileChooser.FILES_ONLY){
            //Creacion de los objetos tipo file filter
            FileFilter filtro1 = new FileNameExtensionFilter("Archivos MEM", "mem");
            FileFilter filtro2 = new FileNameExtensionFilter("Archivos TXT", "txt");
            //Se añaden los filtros al file chooser
            jf.addChoosableFileFilter(filtro1);
            jf.addChoosableFileFilter(filtro2);
            //Establezco como predeterminada la extension .txt (filtro2)
            jf.setFileFilter(filtro2);
        }

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
        
        for(int i = ruta.length()-1; i>=0; i--){
            if(ruta.charAt(i) != '\\' && indicadorNom == 0){
                nomSinRuta = nomSinRuta.concat(String.valueOf(ruta.charAt(i)));
            }else{
                rutaSinNom = rutaSinNom.concat(String.valueOf(ruta.charAt(i)));
                indicadorNom = 1;
                //System.out.println(rutaSinNom);
            }
        }
        nomSinRuta = invertir(nomSinRuta);
        rutaSinNom = invertir(rutaSinNom);
    }
   
    
    public String getRutaNom(){
        return ruta + "\\" + nom;
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
}
