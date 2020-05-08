/*
* Anthony Esteven Sandoval Marquez
* Programa que separa cada una de las palabras de una cadena
* 08/05/2020
*/
package Main;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        
        //Cadena de ejemplo
        String cadena = ("Hola como estan todos\nEspero que bien\nok");
        //Areglo para guardar las palabras cuando las separe
        ArrayList<String> palabras = new ArrayList<String>();
        //Esta variable sirve para guardar cada una de las palabras que se encuentres
        String palabra = "";
       
        //Impresion de la cadena
        System.out.println(cadena);
        System.out.println("\n");
        
        //Recorrido de la cadena
        for(int i = 0; i < cadena.length(); i++){
            //Si hay un espacio significa que se a completado una palabra, tambien en el caso de un salto de linea
            //Si hay un espacio alprincipio se tomaria como una palabra, por lo tanto la "pabalara" no debe de estar vacia
            if((cadena.charAt(i) == ' ' || cadena.charAt(i) == '\n') && !palabra.equals("")){
                //Añado palabra al arreglo
                palabras.add(palabra);
                //Reseteo la palabra, pues ya la guarde
                palabra = "";
            }else{//Mientras no halla un espacio o salto de linea se estaran concatenando los caracteres en "palabra"
                palabra = palabra.concat(String.valueOf(cadena.charAt(i)));
                //Siempre la ultima palabra no se guarda, pues se termina de leer el caracter y ya no se añade
                //Para esto añado la ultima palabra cuando el indice de la cadena esta hasta el ultimo caracter
                if(i == cadena.length()-1){//Ultimo caracter
                    //Añado la ultima palabra
                    palabras.add(palabra);
                    palabra = "";
                }
            }
        }
        //Impresion de las palabras que añadi al arreglo
        for(String elemento: palabras)
            System.out.println(elemento);
         
    } 
}
