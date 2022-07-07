package Exceptions;

public class DateFormatException extends Exception{

    public DateFormatException() {
    }
    public String errormessage(){
        return "Fecha en formato incorrecto para SQL";
    }
}

