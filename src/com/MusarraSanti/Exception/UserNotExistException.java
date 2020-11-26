package com.MusarraSanti.Exception;

public class UserNotExistException extends Exception{

    private static final String ERROR_MESSAGE = "L'utente a cui ti stai riferendo non esiste nella rete sociale \n";
    public UserNotExistException(){ super(ERROR_MESSAGE);}
}
