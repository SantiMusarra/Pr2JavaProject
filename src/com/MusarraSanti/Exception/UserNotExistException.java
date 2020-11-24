package com.MusarraSanti.Exception;

public class UserNotExistException extends Exception{

    private static final String ERROR_MESSAGE = "L'utente già esiste\n";
    public UserNotExistException(){ super(ERROR_MESSAGE);}
}
