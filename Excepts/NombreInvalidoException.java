package Excepts;
/**
 * Excepción personalizada para comprobar el nombre del estudiante
 */

public class NombreInvalidoException extends Exception{
    public NombreInvalidoException(String message){
        super(message);
    }
}
