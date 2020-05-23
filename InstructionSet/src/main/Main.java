
package main;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JTabbedPane;

public class Main {
    public static void main(String[] args) {
        ArrayList<Component> componentes = new ArrayList<Component>();
        ArrayList<String> nombs = new ArrayList<String>();
        Hashtable<String, String> rutasPestanas = new Hashtable<>();
        rutasPestanas.put("Archivo", "No Guardado");
        
        TextEditor te = new TextEditor("", "", componentes, nombs, 0, "Archivo", rutasPestanas);
        te.setLocationRelativeTo(null);
        te.setVisible(true);
        
    }
}
