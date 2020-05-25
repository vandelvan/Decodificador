
package main;

public class Conversor {

    public String dataAsm = "";
    public String dataBin = "";

    public Conversor() {

    }

    public void toAssembly(String datos) {
        // Convertir el texto normal a ensamblador, se muestran las palabras reservadas
        this.dataAsm = datos;
    }

    public boolean toBinary(String datos) {
        // Covertir el texto que estara en ensamblador a binario, si hay palabras
        // reservadas
        String[] lineas = datos.split("\n");
        lineas = this.deleteComentarios(lineas); // eliminamos los comentarios
        datos = "";
        // Obtenemos opCode y Function de cada instruccion
        Instrucciones instruccion = new Instrucciones();
        for (String linea : lineas) {
            String[] lin;
            lin = linea.trim().split("\\s"); // Elimina espacios extra al principio o fin y separamos los espacios
            String inst = lin[0]; // lo primero es la instruccion
            String[] opFunc = instruccion.opcodeFunction(inst); // obtenemos opcode y function
            String opCode = opFunc[1];
            String function = opFunc[0];
            // Si no es una funcion valida
            if (opCode == "" && function == "")
                return false; // Error
            else if (opCode != "" && function == "") { // Si es tipo I o J
                if(opCode == "000010"){    //Si es J
                    if (lin.length > 1 && lin[1] != null) {
                        String addr = "";
                        try {
                            addr = lin[1].split("x")[1]; //0x....
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            return false;
                        }
                        //encerrado en try catch para evitar errores de conversion
                        try {
                            //si es mayor al maximo de instrucciones o no es multiplo de 4 (inicio de instrucciones)
                            if(Integer.parseInt(addr) > 512 || Integer.parseInt(addr) % 4 != 0)
                                return false;
                            addr = instruccion.intBin(Integer.parseInt(addr),2);
                        } catch (NumberFormatException e) {
                            return false;
                        }
                        String comentario = "\t//"+linea;
                        linea = opCode+addr.substring(0,2)+"\n";  //linea 1
                        linea += addr.substring(2,10)+"\n"; //linea 2
                        linea += addr.substring(10,18)+"\n";  //linea 3
                        linea += addr.substring(18,26)+comentario+"\n"; //linea 4                        
                    }
                    else
                        return false;
                }
                else{   //Es tipo I
                    if (lin.length > 3 && lin[1] != null && lin[2] != null && lin[3] != null) {
                        String rt = lin[1];
                        String rs = lin[2];
                        String immdt = lin[3];
                        rt = instruccion.memSpace(rt); // Regresa la posicion de memoria en binario
                        rs = instruccion.memSpace(rs); // Regresa la posicion de memoria en binario
                        if(rs == "" || rt == "")
                            return false;
                        try {
                            immdt = instruccion.intBin(Integer.parseInt(immdt),1);
                        } catch (NumberFormatException e) {
                            return false;
                        }
                        String comentario = "\t//"+linea;
                        linea = opCode+rs.substring(0,2)+"\n";  //linea 1
                        linea += rs.substring(2,5)+rt+"\n"; //linea 2
                        linea += immdt.substring(0,8)+"\n";  //linea 3
                        linea += immdt.substring(8, 16)+comentario+"\n"; //linea 4
                    } else
                        return false;
                }
            } else { // Es tipo R
                if (lin.length > 3 && lin[1] != null && lin[2] != null && lin[3] != null) {
                    String rd = lin[1];
                    String rs = lin[2];
                    String rt = lin[3];
                    rd = instruccion.memSpace(rd); // Regresa la posicion de memoria en binario
                    rs = instruccion.memSpace(rs); // Regresa la posicion de memoria en binario
                    rt = instruccion.memSpace(rt); // Regresa la posicion de memoria en binario
                    if(rd == "" || rs == "" || rt == "")
                        return false;
                    String shamt = "00000";
                    String comentario = "\t//"+linea;
                    linea = opCode+rs.substring(0,2)+"\n";  //linea 1
                    linea += rs.substring(2,5)+rt+"\n"; //linea 2
                    linea += rd+shamt.substring(0,3)+"\n";  //linea 3
                    linea += shamt.substring(3,5)+function+comentario+"\n"; //linea 4
                } else
                    return false;

            }
            datos += linea;
        }

        this.dataBin = datos;
        System.out.println(datos);
        return true;

    }

    public String getDataAsm() {
        return dataAsm;
    }

    public String getDataBin() {
        return dataBin;
    }

    // Funcion para ignorar los comentarios
    public String[] deleteComentarios(String[] lineas) {
        for (int i = 0; i < lineas.length; i++) {
            lineas[i] = lineas[i].split("#")[0]; // Eliminamos comentarios de cada linea
            if (lineas[i].equals("")) { // si la linea sin comentario no tiene nada
                System.arraycopy(lineas, i + 1, lineas, i, lineas.length - 1 - i); // se elimina el espacio vacio del
                                                                                   // array
                i--; // volvemos a checar el indice ahora ocupado por otro string
            }
        }
        return lineas;
    }

}
