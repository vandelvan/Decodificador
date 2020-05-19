
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
        //Obtenemos opCode y Function de cada instruccion
        Instrucciones instruccion = new Instrucciones();
        for (String linea : lineas) {
            System.out.println(linea);
            String inst = linea.split(" ")[0];
            System.out.println(inst);
            String[] opFunc = instruccion.opcodeFunction(inst);
            //Si no es una funcion valida
            if(opFunc[0] == "" && opFunc[1] == "")
                return;
            String opCode = opFunc[1];
            String function = opFunc[0];
            System.out.println(opCode);
            System.out.println(function);
            System.out.println("- - - - - - - - - - -");
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
            lineas[i] = lineas[i].split("#")[0];    //Eliminamos comentarios de cada linea
            if(lineas[i].equals("")){   //si la linea sin comentario no tiene nada
                System.arraycopy(lineas, i + 1, lineas, i, lineas.length - 1 - i);  //se elimina el espacio vacio del array
                i--;    //volvemos a checar el indice ahora ocupado por otro string
            }
        }
        return lineas;
    }
    
}
