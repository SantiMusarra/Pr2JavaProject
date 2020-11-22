package com.MusarraSanti.Testing;

import com.MusarraSanti.Code.Post;
import com.MusarraSanti.Code.SocialNetwork;

public class Testing {



    public static void RunTestMicroBlog(){

        System.out.println("\n---------------------TEST MicroBlog---------------------");

        SocialNetwork MicroBlog = new SocialNetwork("MicroBlog");

        System.out.println("\n---------------------TEST MicroBlog Creazione Utenti---------------------");
        //CREAZIONE UTENTI
        String utente1 = "Santi";
        MicroBlog.createUser(utente1);
        String utente2 = "Giacomo";
        MicroBlog.createUser(utente2);
        String utente3 = "Luca";
        MicroBlog.createUser(utente3);
        String utente4 = "Domenico";
        MicroBlog.createUser(utente4);
        String utente5 = "Matteo";
        MicroBlog.createUser(utente5);
        String utente6 = "Salvo";
        MicroBlog.createUser(utente6);

        System.out.println("\n---------------------TEST MicroBlog Creazione Post---------------------");
        //CREAZIONE DEI POST DA PARTE DELL'UTENZA
        Post post1 = MicroBlog.createPost(utente1 ,"Hollywood, Hollywood, guarda che cielo blu avevo dei problemi, adesso non ce li ho più");

        Post post2 = MicroBlog.createPost(utente2 , "Blu dipinto di blu");

        Post post3 = MicroBlog.createPost(utente3 , "Questo testo sarà troppo lungo per entrare in un post xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        Post post4 = MicroBlog.createPost(utente4 , "La formula 1 mi piace un casino");

        System.out.println("\n---------------------TEST MicroBlog Aggiunta Like ai Post---------------------");
        // AGGIUNTA LIKE AI POST

        MicroBlog.addLikeToPost(post4 , utente1);
        MicroBlog.addLikeToPost(post4 , utente2);
        MicroBlog.addLikeToPost(post4 , utente5);
        MicroBlog.addLikeToPost(post4 , utente6);

        MicroBlog.addLikeToPost(post1 , utente3);
        MicroBlog.addLikeToPost(post1 , utente1);

        System.out.println("\n---------------------TEST MicroBlog Metodo WrittenBy---------------------");
        System.out.println(MicroBlog.writtenBy(utente4));
        System.out.println(MicroBlog.writtenBy(utente1));

    }
}
