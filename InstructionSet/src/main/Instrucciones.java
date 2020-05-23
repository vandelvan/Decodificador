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
                return opFunc;
            case "ADDU":
                opFunc[0] = "100001"; // Function
                opFunc[1] = "000000"; // OpCode
                return opFunc;
            case "SUB":
                opFunc[0] = "100010"; // Function
                opFunc[1] = "000000"; // OpCode
                return opFunc;
            case "SUBU":
                opFunc[0] = "100011"; // Function
                opFunc[1] = "000000"; // OpCode
                return opFunc;
            case "MUL":
                opFunc[0] = "000010"; // Function
                opFunc[1] = "000000"; // OpCode
                return opFunc;
            case "DIV":
                opFunc[0] = "011010"; // Function
                opFunc[1] = "000000"; // OpCode
                return opFunc;
            case "MOD":
                opFunc[0] = "011011"; // Function
                opFunc[1] = "000000"; // OpCode
                return opFunc;
            case "OR":
                opFunc[0] = "100101"; // Function
                opFunc[1] = "000000"; // OpCode
                return opFunc;
            case "NOR":
                opFunc[0] = "100111"; // Function
                opFunc[1] = "000000"; // OpCode
                return opFunc;
            case "AND":
                opFunc[0] = "100100"; // Function
                opFunc[1] = "000000"; // OpCode
                return opFunc;
            case "XOR":
                opFunc[0] = "100110"; // Function
                opFunc[1] = "000000"; // OpCode
                return opFunc;
            case "NOP":
                opFunc[0] = "000000"; // Function
                opFunc[1] = "000000"; // OpCode
                return opFunc;
            case "SLT":
                opFunc[0] = "101010"; // Function
                opFunc[1] = "000000"; // OpCode
                return opFunc;
            case "SLTU":
                opFunc[0] = "101011"; // Function
                opFunc[1] = "000000"; // OpCode
                return opFunc;
            case "BITSWAP":
                opFunc[0] = "100000"; // Function
                opFunc[1] = "011111"; // OpCode
                return opFunc;
            case "J":
                opFunc[0] = ""; // Function
                opFunc[1] = "000010"; // OpCode
                return opFunc;
            case "ADDI":
                opFunc[0] = ""; // Function
                opFunc[1] = "001000"; // OpCode
                return opFunc;
            case "ADDIU":
                opFunc[0] = ""; // Function
                opFunc[1] = "001001"; // OpCode
                return opFunc;
            case "ANDI":
                opFunc[0] = ""; // Function
                opFunc[1] = "001100"; // OpCode
                return opFunc;
            case "ORI":
                opFunc[0] = ""; // Function
                opFunc[1] = "001101"; // OpCode
                return opFunc;
            case "XORI":
                opFunc[0] = ""; // Function
                opFunc[1] = "001110"; // OpCode
                return opFunc;
            case "SLTI":
                opFunc[0] = ""; // Function
                opFunc[1] = "001010"; // OpCode
                return opFunc;
            case "SLTIU":
                opFunc[0] = ""; // Function
                opFunc[1] = "001011"; // OpCode
                return opFunc;
            case "B":
                opFunc[0] = ""; // Function
                opFunc[1] = "000011"; // OpCode
                return opFunc;
            case "BEQ":
                opFunc[0] = ""; // Function
                opFunc[1] = "000100"; // OpCode
                return opFunc;
            case "BNE":
                opFunc[0] = ""; // Function
                opFunc[1] = "000101"; // OpCode
                return opFunc;
            case "BGEZ":
                opFunc[0] = ""; // Function
                opFunc[1] = "000001"; // OpCode
                return opFunc;
            case "LUI":
                opFunc[0] = ""; // Function
                opFunc[1] = "001111"; // OpCode
                return opFunc;
            case "LW":
                opFunc[0] = ""; // Function
                opFunc[1] = "100011"; // OpCode
                return opFunc;
            case "SW":
                opFunc[0] = ""; // Function
                opFunc[1] = "101011"; // OpCode
                return opFunc;
            default:
                return opFunc;
        }
    }

    // Funcion para obtener el espacio en memoria señalado en biario
    public String memSpace(String mem) {
        String space = "";
        mem = mem.split(",")[0];
        switch (mem) {
            case "$zero":
            case "$0":
                space = "00000"; // Espacio en memoria (binario)
                return space;
            case "$at":
            case "$1":
                space = "00001"; // Espacio en memoria (binario)
                return space;
            case "$v0":
            case "$2":
                space = "00010"; // Espacio en memoria (binario)
                return space;
            case "$v1":
            case "$3":
                space = "00011"; // Espacio en memoria (binario)
                return space;
            case "$a0":
            case "$4":
                space = "00100"; // Espacio en memoria (binario)
                return space;
            case "$a1":
            case "$5":
                space = "00101"; // Espacio en memoria (binario)
                return space;
            case "$a2":
            case "$6":
                space = "00110"; // Espacio en memoria (binario)
                return space;
            case "$a3":
            case "$7":
                space = "00111"; // Espacio en memoria (binario)
                return space;
            case "$t0":
            case "$8":
                space = "01000"; // Espacio en memoria (binario)
                return space;
            case "$t1":
            case "$9":
                space = "01001"; // Espacio en memoria (binario)
                return space;
            case "$t2":
            case "$10":
                space = "01010"; // Espacio en memoria (binario)
                return space;
            case "$t3":
            case "$11":
                space = "01011"; // Espacio en memoria (binario)
                return space;
            case "$t4":
            case "$12":
                space = "01100"; // Espacio en memoria (binario)
                return space;
            case "$t5":
            case "$13":
                space = "01101"; // Espacio en memoria (binario)
                return space;
            case "$t6":
            case "$14":
                space = "01110"; // Espacio en memoria (binario)
                return space;
            case "$t7":
            case "$15":
                space = "01111"; // Espacio en memoria (binario)
                return space;
            case "$s0":
            case "$16":
                space = "10000"; // Espacio en memoria (binario)
                return space;
            case "$s1":
            case "$17":
                space = "10001"; // Espacio en memoria (binario)
                return space;
            case "$s2":
            case "$18":
                space = "10010"; // Espacio en memoria (binario)
                return space;
            case "$s3":
            case "$19":
                space = "10011"; // Espacio en memoria (binario)
                return space;
            case "$s4":
            case "$20":
                space = "10100"; // Espacio en memoria (binario)
                return space;
            case "$s5":
            case "$21":
                space = "10101"; // Espacio en memoria (binario)
                return space;
            case "$s6":
            case "$22":
                space = "10110"; // Espacio en memoria (binario)
                return space;
            case "$s7":
            case "$23":
                space = "10111"; // Espacio en memoria (binario)
                return space;
            case "$t8":
            case "$24":
                space = "11000"; // Espacio en memoria (binario)
                return space;
            case "$t9":
            case "$25":
                space = "11001"; // Espacio en memoria (binario)
                return space;
            case "$k0":
            case "$26":
                space = "11010"; // Espacio en memoria (binario)
                return space;
            case "$k1":
            case "$27":
                space = "11011"; // Espacio en memoria (binario)
                return space;
            case "$gp":
            case "$28":
                space = "11100"; // Espacio en memoria (binario)
                return space;
            case "$sp":
            case "$29":
                space = "11101"; // Espacio en memoria (binario)
                return space;
            case "$fp":
            case "$30":
                space = "11110"; // Espacio en memoria (binario)
                return space;
            case "$ra":
            case "$31":
                space = "11111"; // Espacio en memoria (binario)
                return space;
            default:
                return space;
        }
    }

    public String intBin(int num)
    {
        String bin = String.format("%16s",
                Integer.toBinaryString(0xFFFF & num)).replaceAll(" ", "0");
        return bin;
        
    }

}