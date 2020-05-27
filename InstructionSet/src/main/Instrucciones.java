package main;

public class Instrucciones {

    public Instrucciones() {

    }

    public String[] opcodeFunction(String inst) {
        String opFunc[] = { "", "" };
        switch (inst.toUpperCase()) { // comparamos en mayusculas para evitar errores con case
            case "ADD":
                opFunc[0] = "100000"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "ADDU":
                opFunc[0] = "100001"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "SUB":
                opFunc[0] = "100010"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "SUBU":
                opFunc[0] = "100011"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "MUL":
                opFunc[0] = "000010"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "DIV":
                opFunc[0] = "011010"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "MOD":
                opFunc[0] = "011011"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "OR":
                opFunc[0] = "100101"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "NOR":
                opFunc[0] = "100111"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "AND":
                opFunc[0] = "100100"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "XOR":
                opFunc[0] = "100110"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "NOP":
                opFunc[0] = "000000"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "SLT":
                opFunc[0] = "101010"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "SLTU":
                opFunc[0] = "101011"; // Function
                opFunc[1] = "000000"; // OpCode
                break;
            case "BITSWAP":
                opFunc[0] = "100000"; // Function
                opFunc[1] = "011111"; // OpCode
                break;
            case "J":
                opFunc[0] = ""; // Function
                opFunc[1] = "000010"; // OpCode
                break;
            case "ADDI":
                opFunc[0] = ""; // Function
                opFunc[1] = "001000"; // OpCode
                break;
            case "ADDIU":
                opFunc[0] = ""; // Function
                opFunc[1] = "001001"; // OpCode
                break;
            case "ANDI":
                opFunc[0] = ""; // Function
                opFunc[1] = "001100"; // OpCode
                break;
            case "ORI":
                opFunc[0] = ""; // Function
                opFunc[1] = "001101"; // OpCode
                break;
            case "XORI":
                opFunc[0] = ""; // Function
                opFunc[1] = "001110"; // OpCode
                break;
            case "SLTI":
                opFunc[0] = ""; // Function
                opFunc[1] = "001010"; // OpCode
                break;
            case "SLTIU":
                opFunc[0] = ""; // Function
                opFunc[1] = "001011"; // OpCode
                break;
            case "B":
                opFunc[0] = ""; // Function
                opFunc[1] = "000011"; // OpCode
                break;
            case "BEQ":
                opFunc[0] = ""; // Function
                opFunc[1] = "000100"; // OpCode
                break;
            case "BNE":
                opFunc[0] = ""; // Function
                opFunc[1] = "000101"; // OpCode
                break;
            case "BGEZ":
                opFunc[0] = ""; // Function
                opFunc[1] = "000001"; // OpCode
                break;
            case "LUI":
                opFunc[0] = ""; // Function
                opFunc[1] = "001111"; // OpCode
                break;
            case "LW":
                opFunc[0] = ""; // Function
                opFunc[1] = "100011"; // OpCode
                break;
            case "SW":
                opFunc[0] = ""; // Function
                opFunc[1] = "101011"; // OpCode
                break;
            default:
                break;
        }
        return opFunc;
    }

    // Funcion para obtener el espacio en memoria señalado en biario
    public String memSpace(String mem) {
        String space = "";
        mem = mem.split(",")[0];
        switch (mem) {
            case "$zero":
            case "$0":
                space = "00000"; // Espacio en memoria (binario)
                break;
            case "$at":
            case "$1":
                space = "00001"; // Espacio en memoria (binario)
                break;
            case "$v0":
            case "$2":
                space = "00010"; // Espacio en memoria (binario)
                break;
            case "$v1":
            case "$3":
                space = "00011"; // Espacio en memoria (binario)
                break;
            case "$a0":
            case "$4":
                space = "00100"; // Espacio en memoria (binario)
                break;
            case "$a1":
            case "$5":
                space = "00101"; // Espacio en memoria (binario)
                break;
            case "$a2":
            case "$6":
                space = "00110"; // Espacio en memoria (binario)
                break;
            case "$a3":
            case "$7":
                space = "00111"; // Espacio en memoria (binario)
                break;
            case "$t0":
            case "$8":
                space = "01000"; // Espacio en memoria (binario)
                break;
            case "$t1":
            case "$9":
                space = "01001"; // Espacio en memoria (binario)
                break;
            case "$t2":
            case "$10":
                space = "01010"; // Espacio en memoria (binario)
                break;
            case "$t3":
            case "$11":
                space = "01011"; // Espacio en memoria (binario)
                break;
            case "$t4":
            case "$12":
                space = "01100"; // Espacio en memoria (binario)
                break;
            case "$t5":
            case "$13":
                space = "01101"; // Espacio en memoria (binario)
                break;
            case "$t6":
            case "$14":
                space = "01110"; // Espacio en memoria (binario)
                break;
            case "$t7":
            case "$15":
                space = "01111"; // Espacio en memoria (binario)
                break;
            case "$s0":
            case "$16":
                space = "10000"; // Espacio en memoria (binario)
                break;
            case "$s1":
            case "$17":
                space = "10001"; // Espacio en memoria (binario)
                break;
            case "$s2":
            case "$18":
                space = "10010"; // Espacio en memoria (binario)
                break;
            case "$s3":
            case "$19":
                space = "10011"; // Espacio en memoria (binario)
                break;
            case "$s4":
            case "$20":
                space = "10100"; // Espacio en memoria (binario)
                break;
            case "$s5":
            case "$21":
                space = "10101"; // Espacio en memoria (binario)
                break;
            case "$s6":
            case "$22":
                space = "10110"; // Espacio en memoria (binario)
                break;
            case "$s7":
            case "$23":
                space = "10111"; // Espacio en memoria (binario)
                break;
            case "$t8":
            case "$24":
                space = "11000"; // Espacio en memoria (binario)
                break;
            case "$t9":
            case "$25":
                space = "11001"; // Espacio en memoria (binario)
                break;
            case "$k0":
            case "$26":
                space = "11010"; // Espacio en memoria (binario)
                break;
            case "$k1":
            case "$27":
                space = "11011"; // Espacio en memoria (binario)
                break;
            case "$gp":
            case "$28":
                space = "11100"; // Espacio en memoria (binario)
                break;
            case "$sp":
            case "$29":
                space = "11101"; // Espacio en memoria (binario)
                break;
            case "$fp":
            case "$30":
                space = "11110"; // Espacio en memoria (binario)
                break;
            case "$ra":
            case "$31":
                space = "11111"; // Espacio en memoria (binario)
                break;
            default:
                break;
        }
        return space;
    }

    //metodo para obtener instrucciones en base a su function de ser tipo R
    public String getInstR(String function) {
        String inst = "";
        switch(function){
            case "100000":
                inst = "ADD";
                break;
            case "100001":
                inst = "ADDU";
                break;
            case "100010":
                inst = "SUB";
                break;
            case "100011":
                inst = "SUBU";
                break;
            case "000010":
                inst = "MUL";
                break;
            case "011010":
                inst = "DIV";
                break;
            case "011011":
                inst = "MOD";
                break;
            case "100101":
                inst = "OR";
                break;
            case "100111":
                inst = "NOR";
                break;
            case "100100":
                inst = "AND";
                break;
            case "100110":
                inst = "XOR";
                break;
            case "000000":
                inst = "NOP";
                break;
            case "101010":
                inst = "SLT";
                break;
            case "101011":
                inst = "SLTU";
                break;
            default:
                break;
        }
        return inst;
    }

    //metodo para obtener instrucciones en base a su function de ser tipo I/J o BITSWAP
    String getInstIJ(String opCode){
        String inst = "";
        switch(opCode)
        {
            case "011111":
                inst = "BITSWAP";
                break;
            case "000010":
                inst = "J";
                break;
            case "001000":
                inst = "ADDI";
                break;
            case "001001":
                inst = "ADDIU";
                break;
            case "001100":
                inst = "ANDI";
                break;
            case "001101":
                inst = "ORI";
                break;
            case "001110":
                inst = "XORI";
                break;
            case "001010":
                inst = "SLTI";
                break;
            case "001011":
                inst = "SLTIU";
                break;
            case "000011":
                inst = "B";
                break;
            case "000100":
                inst = "BEQ";
                break;
            case "000101":
                inst = "BNE";
                break;
            case "000001":
                inst = "BGEZ";
                break;
            case "001111":
                inst = "LUI";
                break;
            case "100011":
                inst = "LW";
                break;
            case "101011":
                inst = "SW";
                break;
            default:
                break;
        }
        return inst;
    }

    // Funcion para obtener el espacio en memoria señalado en biario
    public String memSpaceToString(String mem, Boolean last) {
        String space = "";
        switch (mem) {
            case "00000":
                space = "$zero"; // Espacio en memoria (string)
                break;
            case "00001":
                space = "$at"; // Espacio en memoria (string)
                break;
            case "00010":
                space = "$v0"; // Espacio en memoria (string)
                break;
            case "00011":
                space = "$v1"; // Espacio en memoria (string)
                break;
            case "00100":
                space = "$a0"; // Espacio en memoria (string)
                break;
            case "00101":
                space = "$a1"; // Espacio en memoria (string)
                break;
            case "00110":
                space = "$a2"; // Espacio en memoria (string)
                break;
            case "00111":
                space = "$a3"; // Espacio en memoria (string)
                break;
            case "01000":
                space = "$t0"; // Espacio en memoria (string)
                break;
            case "01001":
                space = "$t1"; // Espacio en memoria (string)
                break;
            case "01010":
                space = "$t2"; // Espacio en memoria (string)
                break;
            case "01011":
                space = "$t3"; // Espacio en memoria (string)
                break;
            case "01100":
                space = "$t4"; // Espacio en memoria (string)
                break;
            case "01101":
                space = "$t5"; // Espacio en memoria (string)
                break;
            case "01110":
                space = "$t6"; // Espacio en memoria (string)
                break;
            case "01111":
                space = "$t7"; // Espacio en memoria (string)
                break;
            case "10000":
                space = "$s0"; // Espacio en memoria (string)
                break;
            case "10001":
                space = "$s1"; // Espacio en memoria (string)
                break;
            case "10010":
                space = "$s2"; // Espacio en memoria (string)
                break;
            case "10011":
                space = "$s3"; // Espacio en memoria (string)
                break;
            case "10100":
                space = "$s4"; // Espacio en memoria (string)
                break;
            case "10101":
                space = "$s5"; // Espacio en memoria (string)
                break;
            case "10110":
                space = "$s6"; // Espacio en memoria (string)
                break;
            case "10111":
                space = "$s7"; // Espacio en memoria (string)
                break;
            case "11000":
                space = "$t8"; // Espacio en memoria (string)
                break;
            case "11001":
                space = "$t9"; // Espacio en memoria (string)
                break;
            case "11010":
                space = "$k0"; // Espacio en memoria (string)
                break;
            case "11011":
                space = "$k1"; // Espacio en memoria (string)
                break;
            case "11100":
                space = "$gp"; // Espacio en memoria (string)
                break;
            case "11101":
                space = "$sp"; // Espacio en memoria (string)
                break;
            case "11110":
                space = "$fp"; // Espacio en memoria (string)
                break;
            case "11111":
                space = "$31"; // Espacio en memoria (string)
                break;
            default:
                break;
        }
        if(!last)   //si no es la ultima posicion necesitada, se agrega ,
            space += ",";
        return space;
    }

    //Metodo para convertir enteros a binarios
    public String intBin(int num, int type)
    {
        String bin = "";
        if(type == 1)   //tipo I
            bin = String.format("%16s",
                Integer.toBinaryString(0xFFFF & num)).replaceAll(" ", "0");
        else if(type == 2)  //tipo J
            bin = String.format("%26s",
                Integer.toBinaryString(0xFFFF & num)).replaceAll(" ", "0");
        return bin;
        
    }

}