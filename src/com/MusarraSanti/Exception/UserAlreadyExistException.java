package com.MusarraSanti.Exception;

public class UserAlreadyExistException extends Exception {

    private static final String ERROR_MESSAGE = "L'utente è già presente nella rete sociale \n";
    public UserAlreadyExistException(){ super(ERROR_MESSAGE);  }

}
