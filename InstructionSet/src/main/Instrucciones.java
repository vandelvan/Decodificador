package main;

public class Instrucciones {

    public Instrucciones(){

    }

    public String[] opcodeFunction(String inst){
        String opFunc[] = {"",""};
        switch (inst) {
            case "add":
            case "ADD":
                opFunc[0] = "100000";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "addu":
            case "ADDU":
                opFunc[0] = "100001";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "sub":
            case "SUB":
                opFunc[0] = "100010";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "subu":
            case "SUBU":
                opFunc[0] = "100011";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "mul":
            case "MUL":
                opFunc[0] = "000010";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "div":
            case "DIV":
                opFunc[0] = "011010";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "mod":
            case "MOD":
                opFunc[0] = "011011";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "or":
            case "OR":
                opFunc[0] = "100101";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "nor":
            case "NOR":
                opFunc[0] = "100111";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "and":
            case "AND":
                opFunc[0] = "100100";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "xor":
            case "XOR":
                opFunc[0] = "100110";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "nop":
            case "NOP":
                opFunc[0] = "000000";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "slt":
            case "SLT":
                opFunc[0] = "101010";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "sltu":
            case "SLTU":
                opFunc[0] = "101011";   //Function
                opFunc[1] = "000000";   //OpCode
                return opFunc;
            case "bitswap":
            case "BITSWAP":
                opFunc[0] = "100000";   //Function
                opFunc[1] = "011111";   //OpCode
                return opFunc;
            case "j":
            case "J":
                opFunc[0] = "";   //Function
                opFunc[1] = "000010";   //OpCode
                return opFunc;
            case "addi":
            case "ADDI":
                opFunc[0] = "";   //Function
                opFunc[1] = "001000";   //OpCode
                return opFunc;
            case "addiu":
            case "ADDIU":
                opFunc[0] = "";   //Function
                opFunc[1] = "001001";   //OpCode
                return opFunc;
            case "andi":
            case "ANDI":
                opFunc[0] = "";   //Function
                opFunc[1] = "001100";   //OpCode
                return opFunc;
            case "ori":
            case "ORI":
                opFunc[0] = "";   //Function
                opFunc[1] = "001101";   //OpCode
                return opFunc;
            case "xori":
            case "XORI":
                opFunc[0] = "";   //Function
                opFunc[1] = "001110";   //OpCode
                return opFunc;
            case "slti":
            case "SLTI":
                opFunc[0] = "";   //Function
                opFunc[1] = "001010";   //OpCode
                return opFunc;
            case "sltiu":
            case "SLTIU":
                opFunc[0] = "";   //Function
                opFunc[1] = "001011";   //OpCode
                return opFunc;
            case "b":
            case "B":
                opFunc[0] = "";   //Function
                opFunc[1] = "000011";   //OpCode
                return opFunc;
            case "beq":
            case "BEQ":
                opFunc[0] = "";   //Function
                opFunc[1] = "000100";   //OpCode
                return opFunc;
            case "bne":
            case "BNE":
                opFunc[0] = "";   //Function
                opFunc[1] = "000101";   //OpCode
                return opFunc;
            case "bgez":
            case "BGEZ":
                opFunc[0] = "";   //Function
                opFunc[1] = "000001";   //OpCode
                return opFunc;
            case "lui":
            case "LUI":
                opFunc[0] = "";   //Function
                opFunc[1] = "001111";   //OpCode
                return opFunc;
            case "lw":
            case "LW":
                opFunc[0] = "";   //Function
                opFunc[1] = "100011";   //OpCode
                return opFunc;
            case "sw":
            case "SW":
                opFunc[0] = "";   //Function
                opFunc[1] = "101011";   //OpCode
                return opFunc;
            default:
                return opFunc;
        }
    }
    
}