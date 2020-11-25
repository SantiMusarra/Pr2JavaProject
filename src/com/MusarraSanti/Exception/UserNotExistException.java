package com.MusarraSanti.Exception;

public class UserNotExistException extends Exception{

    private static final String ERROR_MESSAGE = "L'utente a cui stai ti stai riferendo non esiste \n";
    public UserNotExistException(){ super(ERROR_MESSAGE);}
}
