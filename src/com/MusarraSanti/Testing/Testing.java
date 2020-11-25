package com.MusarraSanti.Testing;

import com.MusarraSanti.Code.Post;
import com.MusarraSanti.Code.SocialNetwork;

public class Testing {



    public static void RunTestMicroBlog(){

        System.out.println("\n---------------------TEST MicroBlog Creazione Rete Sociale---------------------");

        SocialNetwork MicroBlog = new SocialNetwork("MicroBlog");

        System.out.println("\n---------------------TEST MicroBlog Creazione Utenti---------------------");
        //CREAZIONE UTENTI
        String utente1 = "Santi";
        String utente2 = "Giacomo";
        String utente3 = "Luca";
        String utente4 = "Domenico";
        String utente5 = "Matteo";
        String utente6 = "Matteo";

        try{
            MicroBlog.createUser(utente1);
            MicroBlog.createUser(utente2);
            MicroBlog.createUser(utente3);
            MicroBlog.createUser(utente4);
            MicroBlog.createUser(utente5);
            MicroBlog.createUser(utente6);

        }
        catch (Exception e){    //Controllo l'eccezzione UserAlreadyExist
            System.out.println(e.getMessage());
        }

        System.out.println("\n---------------------TEST MicroBlog Creazione Post all'interno della rete sociale---------------------");
        //CREAZIONE DEI POST DA PARTE DELL'UTENZA

        Post post1;
        Post post2;
        Post post3;
        Post post4;

        try{
            post1 = MicroBlog.createPost(utente1 ,"Hollywood, Hollywood, guarda che cielo blu avevo dei problemi, adesso non ce li ho più");
            System.out.println(post1.toString());
            post2 = MicroBlog.createPost(utente2 , "Blu dipinto di blu");
            System.out.println(post2.toString());
            post3 = MicroBlog.createPost(utente3 , "Questo testo sarà troppo lungo per entrare in un post xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println(post3.toString());
            post4 = MicroBlog.createPost(utente4 , "La formula 1 mi piace un casino");
            System.out.println(post4.toString());
        }
        catch (Exception e){ //Controllo le eccezzioni UserNotExistException e ExceededCharactersLimitException
            System.out.println(e.getMessage());
        }


        System.out.println("\n---------------------TEST MicroBlog Aggiunta Like ai Post---------------------");
        // AGGIUNTA LIKE AI POST

        try{
            MicroBlog.addLikeToPost(post4 , utente1);
            MicroBlog.addLikeToPost(post4 , utente2);
            MicroBlog.addLikeToPost(post4 , utente5);
            MicroBlog.addLikeToPost(post4 , utente3);

            MicroBlog.addLikeToPost(post1 , utente3);
            MicroBlog.addLikeToPost(post1 , utente1);
        }
        catch (Exception e){ //Controllo le eccezzioni UserNotExistException
            System.out.println(e.getMessage());

        }

        System.out.println("\n---------------------TEST MicroBlog Metodo WrittenBy---------------------");
        /*System.out.println(MicroBlog.writtenBy(utente4));
        System.out.println(MicroBlog.writtenBy(utente1));
        System.out.println(MicroBlog.writtenBy(utente5));*/


    }
}
