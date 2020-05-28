
package main;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JTabbedPane;

public class Main {
    
    public static Consola console;
    
    public static void main(String[] args) {

        console = new Consola();
        console.setVisible(true);
        console.setLocationRelativeTo(null);
        console.print("Consola Inicializada");
        TextEditor te = new TextEditor();
        te.setLocationRelativeTo(null);
        te.setVisible(true);
        console.print("Editor de Texto inicializado");
        
    }
}
