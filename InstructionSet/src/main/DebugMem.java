
package main;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static main.Main.console;

public class DebugMem {
    
    String [][] memoria = new String [32][2], datos = new String [1024][2];
    String currCode;
    JTable jTable2, tablaDatos;
    /**
     * Creates new form MemDebug
     */
    public DebugMem(String Code, JTable tabla, JTable tablaDatos) {
        this.currCode = Code;
        this.jTable2 = tabla;
        this.tablaDatos = tablaDatos;
        try {
            procesarCodigo();
            ingresarMemoria();
        } catch (Exception e) {
        console.print("Fallo la depuracion, " + e.getMessage());
        }
        
    }
    
    
    private void procesarCodigo()
    {
        
        for (int i = 0;i<32;i++)
        {
            memoria[i][0] = "$"+i;
            memoria[i][1] = "00000000000000000000000000000000";
        }
        for (int i = 0;i<1024;i++)
        {
            datos[i][0] = "$"+i;
            datos[i][1] = "x";
        }
        
        // Covertir el texto que estara en ensamblador a binario, si hay palabras
        // reservadas
        
        console.print("Empezando debuggeo\n"); 
        String[] lineas = currCode.split("\n");
        Conversor delCom = new Conversor();
        lineas = delCom.deleteComentarios(lineas,1); // eliminamos los comentarios
        //datos = "";
        // Obtenemos opCode y Function de cada instruccion
        console.print("Entrando a obtencion de opcodes, lineas " + lineas.length);
        Instrucciones instruccion = new Instrucciones();
        for (String linea : lineas) {
            String[] lin;
            lin = linea.trim().split("\\s"); // Elimina espacios extra al principio o fin y separamos los espacios
            console.print("Empezando debuggeo de linea "+linea);
            String inst = lin[0]; // lo primero es la instruccion
            String[] opFunc = instruccion.opcodeFunction(inst); // obtenemos opcode y function
            String opCode = opFunc[1];
            String function = opFunc[0];
            // Si no es una funcion valida
            if (opCode == "" && function == "")
            {
                console.print("Me mori");
                return; // Erro
            }
            else if (opCode != "" && function == "") { // Si es tipo I o J
                if(opCode == "000010"){
                    console.print("Instruccion tipo J");
                    return;
                }
                else{   //Es tipo I
                    console.print("Instruccion tipo I");
                    if (lin.length > 3 && lin[1] != null && lin[2] != null && lin[3] != null) {
                        String rt = lin[1];
                        String rs = lin[2];
                        String immdt = lin[3];
                        rt = instruccion.memSpace(rt); // Regresa la posicion de memoria en binario
                        rs = instruccion.memSpace(rs); // Regresa la posicion de memoria en binario
                        int source, target, inm, res;
                        if(rs == "" || rt == "")
                        {
                            console.print("RT o RS estan vacias");
                            return;
                        }
                        try {
                            immdt = instruccion.intBin(Integer.parseInt(immdt),1);
                            inm = Integer.parseInt(immdt, 2);
                            source = Integer.parseInt(rs, 2);
                            target = Integer.parseInt(rt, 2);
                            source = Integer.parseInt(memoria[source][1], 2);
                        } catch (NumberFormatException e) {
                            console.print("Fallo la conversion, " + e.getMessage());
                            return;
                        }
                        
                        switch(opCode)
                        {
                            case "001001":
                            case "001000":
                            {
                                console.print("Instruccion ADDI");
                                memoria[target][1]=transformarBin(source+inm);
                                break;
                            }
                            case "001100":
                            {
                                memoria[target][1]=transformarBin(source&inm);
                                break;
                            }
                            case "001101":
                            {
                                memoria[target][1]=transformarBin(source|inm);
                                break;
                            }
                            case "001110":
                            {
                                memoria[target][1]=transformarBin(source^inm);
                                break;
                            }
                            case "001011":
                            case "001010":
                            {
                                memoria[target][1]=transformarBin(source>inm ? 1 : 0);
                                break;
                            }
                            case "100011":
                            {
                                
                                console.print("Instruccion LW");
                                try {
                                memoria[target][1]=transformarBin(Integer.parseInt(datos[source+inm][1],2));
                                }
                                catch (NumberFormatException e) {
                                    console.print("Fallo la conversion, " + e.getMessage());
                                return;
                                }
                                break;
                            }
                            case "101011":
                            {
                                
                                console.print("Instruccion SW");
                                try {
                                datos[source+inm][1]=transformarBin(Integer.parseInt(memoria[target][1],2));
                                }
                                catch (NumberFormatException e) {
                                    console.print("Fallo la conversion, " + e.getMessage());
                                return;
                                }
                                break;
                            }
                        }
                        /*String comentario = "\t//"+linea;
                        linea = opCode+rs.substring(0,2)+"\n";  //linea 1
                        linea += rs.substring(2,5)+rt+"\n"; //linea 2
                        linea += immdt.substring(0,8)+"\n";  //linea 3
                        linea += immdt.substring(8, 16)+comentario+"\n"; //linea 4*/
                    } else
                        return;
                }
            } else { // Es tipo R
                console.print("Instruccion TipoR");
                if (lin.length > 3 && lin[1] != null && lin[2] != null && lin[3] != null) {
                    console.print("Intruccion valida");
                    String rd = lin[1];
                    String rs = lin[2];
                    String rt = lin[3];
                    rd = instruccion.memSpace(rd); // Regresa la posicion de memoria en binario
                    rs = instruccion.memSpace(rs); // Regresa la posicion de memoria en binario
                    rt = instruccion.memSpace(rt); // Regresa la posicion de memoria en binario
                    if(rd == "" || rs == "" || rt == "")
                        return;
                    
                    int op1, op2, target, inm, res;
                    try {
                            op1 = Integer.parseInt(rt, 2);
                            op2 = Integer.parseInt(rs, 2);
                            target = Integer.parseInt(rd, 2);
                            op1 = Integer.parseInt(memoria[op1][1], 2);
                            op2 = Integer.parseInt(memoria[op2][1], 2);
                        } catch (NumberFormatException e) {
                            console.print("Fallo la conversion, " + e.getMessage());
                            return;
                        }
                    switch(function)
                        {
                            case "100000":
                            case "100001":
                            {
                                memoria[target][1]=transformarBin(op1+op2);
                                break;
                            }
                            case "100011":
                            case "100010":
                            {
                                memoria[target][1]=transformarBin(op1-op2);
                                break;
                            }
                            case "000010":
                            {
                                memoria[target][1]=transformarBin(op1*op2);
                                break;
                            }
                            case "011010":
                            {
                                memoria[target][1]=transformarBin(op1/op2);
                                break;
                            }
                            case "011011":
                            {
                                memoria[target][1]=transformarBin(op1%op2);
                                break;
                            }
                            case "100101":
                            {
                                memoria[target][1]=transformarBin(op1|op2);
                                break;
                            }
                            case "100111":
                            {
                                memoria[target][1]=transformarBin(~(op1|op2));
                                break;
                            }
                            case "100100":
                            {
                                memoria[target][1]=transformarBin(op1&op2);
                                break;
                            }
                            case "100110":
                            {
                                memoria[target][1]=transformarBin(op1^op2);
                                break;
                            }
                            case "101011":
                            case "101010":
                            {
                                memoria[target][1]=transformarBin(op1>op2 ? 1 : 0);
                                break;
                            }
                        }
                } else
                    return;
            }
        }

        //TODO
    }
    
    private String transformarBin(int Input)
    {
        String number = Integer.toBinaryString(Input);
        
        if (number.length() >= 32) {
            return number;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 32- number.length()) {
            sb.append('0');
        }
        sb.append(number);

        return sb.toString();
    }
    
    private String formatWord(String word)
    {
        String insert = " ";
        int period = 8;
        StringBuilder builder = new StringBuilder(
         word.length() + insert.length() * (word.length()/period)+1);
        int index = 0;
        String prefix = "";
        while (index < word.length())
        {
            // Don't put the insert in the very first iteration.
            // This is easier than appending it *after* each substring
            builder.append(prefix);
            prefix = insert;
            builder.append(word.substring(index, 
                Math.min(index + period, word.length())));
            index += period;
        }
        return builder.toString();
    }
    
    private void ingresarMemoria()
    {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (int i = 0;i<32;i++)
        {
            model.addRow(new Object[]{memoria[i][0], formatWord(memoria[i][1]), Integer.parseInt(memoria[i][1],2)});
        }
        
        DefaultTableModel dataMem = (DefaultTableModel) tablaDatos.getModel();
        dataMem.setRowCount(0);
        for (int i = 0;i<1024;i++)
        {
            String valDec = "", valBin="";
            try {
                if (datos[i][1] != "x")
                    valDec = Integer.toString(Integer.parseInt(datos[i][1],2));
                else
                    valDec = "x";
                valBin = formatWord(datos[i][1]);
            } catch (Exception e) {
            console.print("Error al convertir, asumiendo X, " + e.getMessage());
            valDec = "x";
            valBin = "xxxxxxxx";
            }
            dataMem.addRow(new Object[]{datos[i][0], valBin, valDec});
        }
        
    }

    
}
