package com.MusarraSanti.Testing;

import com.MusarraSanti.Code.Post;
import com.MusarraSanti.Exception.ExceededCharactersLimitException;

public class PostTesting {


    public static void RunTestPost1(){

        System.out.println("\n-------------------------TEST1---------------");
        Post myPost1 = null;
        try {
            myPost1 = new Post(1 , "Santi" , "Primo post del social");
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
            myPost3 = new Post( 2, "Alec" , "Questo è il secondo post del Social Network");
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

        System.out.println("\n-------------------------TEST4---------------");
        Post myPost4 = null;
        try {
            myPost4 = new Post(3, "Domenico" , "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        } catch (ExceededCharactersLimitException e) {
            System.out.println( e.getMessage());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
