package com.MusarraSanti.Testing;

import com.MusarraSanti.Code.Post;
import com.MusarraSanti.Exception.ExceededCharactersLimitException;

public class PostTesting {


    public static void RunTestPost1(){
        int id= 0;
        System.out.println("\n-------------------------TEST1---------------");
        Post myPost1 = null;
        try {
            myPost1 = new Post(id++ , "Santi" , "Primo post del social");
        } catch (ExceededCharactersLimitException e) {
            e.getMessage();
        }
        System.out.println(myPost1.toString());

        System.out.println("\n-------------------------TEST2---------------");
        Post myPost2 = null;
        try {
             myPost2 = new Post(-1, "Gianluca" , "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        } catch (ExceededCharactersLimitException e) {
            System.out.println( e.getMessage());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n-------------------------TEST3---------------");
        Post myPost3 = null;
        try {
            myPost3 = new Post( id++, "Alec" , "Questo è il secondo post del Social Network");
            myPost3.addLike("Santi");
            myPost3.addLike("Gianluca");
            myPost3.addLike("Gianluca");
            myPost3.addLike("Gianluca");
            myPost3.addLike("Gianluca");

        } catch (ExceededCharactersLimitException e) {
            System.out.println( e.getMessage());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println(myPost3.toString());
    }
}
