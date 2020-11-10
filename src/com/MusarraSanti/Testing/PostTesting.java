package com.MusarraSanti.Testing;

import com.MusarraSanti.Code.Post;
import com.MusarraSanti.Exception.ExceededCharactersLimitException;

public class PostTesting {


    public static void RunTestPost1(){

        //test post corretto
        Post myPost1 = null;
        try {
            myPost1 = new Post(20 , "Santi" , "Primo post del social");
        } catch (ExceededCharactersLimitException e) {
            e.getMessage();
        }
        System.out.println(myPost1.toString());

        //test post con testo più lungo di 140 caratteri
        try {
            Post myPost2 = new Post(1 , "Gianluca" , "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        } catch (ExceededCharactersLimitException e) {
            System.out.println(e.getMessage());
        }

        //test post con id negativo 
        Post myPost3 = null;
        try {
            myPost3 = new Post(-1 , "Alec" , "Ciao");
        } catch (ExceededCharactersLimitException e) {

        }
        System.out.println(myPost3.toString());
    }
}
