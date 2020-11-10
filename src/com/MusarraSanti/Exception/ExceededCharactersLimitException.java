package com.MusarraSanti.Exception;

public class ExceededCharactersLimitException extends Exception {
    private static final String ERROR_MESSAGE = "Il testo è troppo lungo";
    public ExceededCharactersLimitException(){ super(ERROR_MESSAGE);}
}
