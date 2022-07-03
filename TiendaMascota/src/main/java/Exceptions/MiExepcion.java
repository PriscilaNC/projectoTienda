package Exceptions;

public class MiExepcion extends Exception{

    public MiExepcion() {
    }

    public String mensajeError(){
        return "Tipo de clase incorrecto";
    }
}
