 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soar_movie_review.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author MAintenant Pret
 */
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author AlexBys
 */
public class MovieRecommendation {

   
    public static List<String> movies_drama = new ArrayList<>();
    public static List<String> movies_action = new ArrayList<>();
    public static List<String> movies_comedy = new ArrayList<>();

   

 

    public static String getRandomMovie(List<String> list) {
        Random r = new Random();

        int number = r.nextInt(list.size()-1);
        return list.get(number);
       
    }
    
    
    public List<String> getDrama() {
    return movies_drama;
    }
}






//private final Scanner sc = new Scanner(System.in);/
 /*private List< String> movies_drama = new ArrayList<>() {

        private static MovieRecommendation instance;

        public static MovieRecommendation getInstance() {
            if (instance == null) {
                instance = new MovieRecommendation();
            }
            instance.movies_drama.add("Titanic");
            instance.movies_drama.add("Imitation Game");
            instance.movies_drama.add("The thine green line ");
            instance.movies_drama.add("American Hustle ");
            instance.movies_drama.add("Shawshank Redemption");
            return instance;*/
 /*  public String getmovies_drama() {
            Random r = new Random();

            int randomitem_drama = r.nextInt(movies_drama.size());
            return movies_drama.get(randomitem_drama);

        }
    };
}
 */
 /*private List< String> movies_action = new ArrayList<>() {
        {
            movies_action.add("Terminator");
            movies_action.add("James Bond");
            movies_action.add("Jason Bourne");
            movies_action.add("Bullet Train");
            movies_action.add("Top Gun");
        }
    };*/
 /*private List< String> movies_comedy = new ArrayList<>() {

    private static MovieRecommendation instance;

    public static MovieRecommendation getInstance() {
        if (instance == null) {
            instance = new MovieRecommendation();
        }
        
        instance.movies_comedy.add("Legally Blonde");
        instance.movies_comedy.add("The Truman Show");
        instance.movies_comedy.add("Jumanji");
        instance.movies_comedy.add("Intouchable");
        instance.movies_comedy.add("The Nice Guys");
        return instance;
    

    public String getmovies_comedy() {
        Random r = new Random();

        int randomitem_comedy = r.nextInt(movies_comedy.size());
        return movies_comedy.get(randomitem_comedy);
        }

    };
}*/


