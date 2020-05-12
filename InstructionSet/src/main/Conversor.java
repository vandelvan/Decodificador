
package main;


public class Conversor {
    
    public String dataAsm = "";
    public String dataBin = "";
    
    public Conversor(){
        
    }
    
    public void toAssembly(String datos){
        //Convertir el texto normal a ensamblador, se muestran las palabras reservadas
        this.dataAsm = datos;
    }
    
    public void toBinary(String datos){
        //Covertir el texto que estara en ensamblador a binario, si hay palabras reservadas
        String[] lineas = datos.split("\n");
        lineas = this.deleteComentarios(lineas);    //eliminamos los comentarios
        for (String string : lineas) {
            System.out.println(string);
        }
        
        this.dataBin = datos;
    }

    public String getDataAsm() {
        return dataAsm;
    }

    public String getDataBin() {
        return dataBin;
    }

    //Funcion para ignorar los comentarios
    public String[] deleteComentarios(String[] lineas) {
        for (int i = 0; i < lineas.length; i++) {
            lineas[i] = lineas[i].split(";")[0];    //Eliminamos comentarios de cada linea
            if(lineas[i].equals("")){   //si la linea sin comentario no tiene nada
                System.arraycopy(lineas, i + 1, lineas, i, lineas.length - 1 - i);  //se elimina el espacio vacio del array
                i--;    //volvemos a checar el indice ahora ocupado por otro string
            }
        }
        return lineas;
    }
    
}
