
package main;

public class Conversor {
    
    String dataAss = "";
    String dataBi = "";
    
    public Conversor(){
        
    }
    
    public void toAssemble(String datos){
        //Convertir el texto normal a ensamblador, se muestran las palabras reservadas
        this.dataAss = datos;
    }
    
    public void toBinary(String datos){
        //Covertir el texto que estara en ensamblador a binario, si hay palabras reservadas
        this.dataBi = datos;
    }

    public String getDataAss() {
        return dataAss;
    }

    public String getDataBi() {
        return dataBi;
    }
    
}
