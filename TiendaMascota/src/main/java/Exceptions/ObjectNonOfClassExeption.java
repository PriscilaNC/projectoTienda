package Exceptions;

public class ObjectNonOfClassExeption extends Exception{

    public ObjectNonOfClassExeption() {
    }

    public String mensajeError(){
        return "Objeto pertenece a otra clase";
    }
}


//todo actualizar