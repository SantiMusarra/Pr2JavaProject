package com.MusarraSanti.Exception;

public class ExceededCharactersLimitException extends Exception {
    private static final String ERROR_MESSAGE = "Il testo del post che stai provando a creare è troppo lungo\n";
    public ExceededCharactersLimitException(){ super(ERROR_MESSAGE);}
}
