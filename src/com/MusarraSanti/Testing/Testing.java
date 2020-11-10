package com.MusarraSanti.Testing;

import com.MusarraSanti.Code.Post;

public class Testing {

    public static void RunTestPost(){

        System.out.println("\n---------------------TEST POST 1---------------------");
        try{
            Post myPost1 = new Post(1 , "Santi" , "Primo post del social");
            System.out.println(myPost1.toString());
        }
        catch(Exception e){  //Gestisco le eccezioni ExceededCharactersLimitException e IllegalArgumentException
            System.out.println(e.getMessage());
        }

        System.out.println("\n---------------------TEST POST 2---------------------");
        try{
            Post myPost2 = new Post(2 , "Gianluca" , "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println(myPost2.toString());
        }
        catch(Exception e){  //Gestisco le eccezioni ExceededCharactersLimitException e IllegalArgumentException
            System.out.println(e.getMessage());
        }

        System.out.println("\n---------------------TEST POST 3---------------------");
        try{
            Post myPost3 = new Post(3 , "Alec" , "Questo è il secondo post");
            myPost3.addLike("Santi");
            myPost3.addLike("Gianluca");
            myPost3.addLike("Gianluca");
            System.out.println(myPost3.toString());
        }
        catch(Exception e){  //Gestisco le eccezioni ExceededCharactersLimitException e IllegalArgumentException
            System.out.println(e.getMessage());
        }

        System.out.println("\n---------------------TEST POST 4---------------------");
        try{
            Post myPost2 = new Post(-1 , "Domenica" , "Questo è il terzo post ");
            System.out.println(myPost2.toString());
        }
        catch(Exception e){  //Gestisco le eccezioni ExceededCharactersLimitException e IllegalArgumentException
            System.out.println(e.getMessage());
        }

    }
}
