
package main;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTabbedPane;

public class Main {
    public static void main(String[] args) {
        ArrayList<Component> componentes = new ArrayList<Component>();
        ArrayList<String> nombs = new ArrayList<String>();
        
        TextEditor te = new TextEditor("", "", componentes, nombs);
        te.setLocationRelativeTo(null);
        te.setVisible(true);
        
    }
}
