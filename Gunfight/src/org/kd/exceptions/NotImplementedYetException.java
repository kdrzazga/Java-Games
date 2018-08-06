package org.kd.exceptions;

public class NotImplementedYetException extends RuntimeException {

    private static final String NOT_IMPLEMENTED_YET_MSG = "Not implemented yet. ";

    public NotImplementedYetException(){
        super(NOT_IMPLEMENTED_YET_MSG);
    }

    public NotImplementedYetException(String message){
        super(NOT_IMPLEMENTED_YET_MSG + message);
    }
}
