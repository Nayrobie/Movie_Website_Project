/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soar_movie_review.beans;


import com.mycompany.soar_movie_review.database.MovieRecommendation;
import com.mycompany.soar_movie_review.exceptions.DoesNotExistException;
import com.mycompany.soar_movie_review.models.Movies;
import com.mycompany.soar_movie_review.models.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author simondemont
 */
@Named(value = "moviesBean")
@SessionScoped
public class MoviesBean implements Serializable {

        @PersistenceContext(unitName = "prod")
    private EntityManager em;
    
    private String moviesTitle = "";
    private String moviesGenre = "";

    @Transactional
    public void addMovies() {
        Users user = LoginBean.getUserLoggedIn();
        try {
            Movies f = findMoviesByNameInList(moviesTitle);
            user.getMoviesCollection().add(f);
            em.merge(user);
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        this.moviesTitle = "";
    }

    @Transactional
    public void removeMoviesFromList() {
        Users user = LoginBean.getUserLoggedIn();
        try {
            if (doesMoviesExistInList(user, moviesTitle)) {
                Movies movie = findMoviesByNameInFavouritedList(user, moviesTitle);
                Collection uList = user.getMoviesCollection();
                uList.remove(movie);
                em.merge(user);
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        this.moviesTitle = "";

    }
    

    protected boolean doesMoviesExistInList(Users user, String moviesTitle) {
         try {
            return findMoviesByNameInFavouritedList(user, moviesTitle) != null;
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    private Movies findMoviesByNameInList(String moviesTitle) throws DoesNotExistException {
      Query query = em.createNamedQuery("Movies.findByMoviesTitle");
      List<Movies> movies = query.setParameter("moviesTitle", moviesTitle).getResultList();
      if (movies.size() > 0){
      return movies.get(0);
      }
        throw new DoesNotExistException("Movie " + moviesTitle + " does not exist.");
    }

    protected Movies findMoviesByNameInFavouritedList(Users user, String moviesTitle) throws DoesNotExistException {
        for (Movies movies : user.getMoviesCollection()) {
            if (movies.getMoviesTitle().equals(moviesTitle)) {
                return movies;
            }
        }
        throw new DoesNotExistException("Movie(s) " + moviesTitle + " does not exist.");
    }

            
 
    public ArrayList<Movies> getMovies() {
        Query query = em.createNamedQuery("Movies.findAll");
        return new ArrayList<>(query.getResultList());
    }

    public String getMoviesTitle() {
        return moviesTitle;
    }

    public void setMoviesTitle(String moviesTitle) {
        this.moviesTitle = moviesTitle;
        
    }
    
    public String getMoviesGenre() {
      return moviesGenre;
    }
    
    public void setMoviesGenre(String moviesGenre){
    this.moviesGenre = moviesGenre;
    }
    
    
    public void getMovieRecommendationDrama() {
        MovieRecommendation.movies_drama.add("Titanic");
        MovieRecommendation.movies_drama.add("Imitation Game");
        MovieRecommendation.movies_drama.add("The Green Mile");
        MovieRecommendation.movies_drama.add("American Hustle");
        MovieRecommendation.movies_drama.add("Shawshank Redemption");
        MovieRecommendation.movies_drama.add("The Dark Knight");
        MovieRecommendation.movies_drama.add("50 Shaedes of Grey");
        MovieRecommendation.movies_drama.add("Trainspotting");
        MovieRecommendation.movies_drama.add("Never Back Down");
        MovieRecommendation.movies_drama.add("Dirty Dancing");
        MovieRecommendation.movies_drama.add("Elite Squad");
        MovieRecommendation.movies_drama.add("The Devil's Rejects");
        MovieRecommendation.movies_drama.add("The Woman in Black");
        MovieRecommendation.movies_drama.add("Nymphomaniac: VolII");
        MovieRecommendation.movies_drama.add("Dolphin Tale");
        MovieRecommendation.movies_drama.add("Before Sunset");
        MovieRecommendation.movies_drama.add("The Eye");
        MovieRecommendation.movies_drama.add("Stake Land");
        MovieRecommendation.movies_drama.add("Sympathy for Lady Vengeance");
        MovieRecommendation.movies_drama.add("Race");
        this.moviesTitle = MovieRecommendation.getRandomMovie(MovieRecommendation.movies_drama);
    }

public void getMovieRecommendationComedy() {
        MovieRecommendation.movies_comedy.add("Legally Blonde");
        MovieRecommendation.movies_comedy.add("The Truman Show");
        MovieRecommendation.movies_comedy.add("Easy A");
        MovieRecommendation.movies_comedy.add("Intouchable");
        MovieRecommendation.movies_comedy.add("Very Bad Trip");
        MovieRecommendation.movies_comedy.add("West is West");
        MovieRecommendation.movies_comedy.add("Home Alone");
        MovieRecommendation.movies_comedy.add("Confessions of a Window Clenaner");
        MovieRecommendation.movies_comedy.add("Bring it on Again");
        MovieRecommendation.movies_comedy.add("Grown Ups");
        MovieRecommendation.movies_comedy.add("The Hangover");
        MovieRecommendation.movies_comedy.add("Ghostbusters");
        MovieRecommendation.movies_comedy.add("The Hangover Part II");
        MovieRecommendation.movies_comedy.add("Ted");
        MovieRecommendation.movies_comedy.add("We're the Millers");
        MovieRecommendation.movies_comedy.add("Diary of a Wimpy Kid");
        MovieRecommendation.movies_comedy.add("Meet the Fockers");
        MovieRecommendation.movies_comedy.add("Alvin and the Chipmunks");
        MovieRecommendation.movies_comedy.add("Shrek Forever After");
        MovieRecommendation.movies_comedy.add("Clerks");
        this.moviesTitle = MovieRecommendation.getRandomMovie(MovieRecommendation.movies_comedy);
    }

public void getMovieRecommendationAction() {
        MovieRecommendation.movies_action.add("The Lord of the Rings");
        MovieRecommendation.movies_action.add("James Bonde");
        MovieRecommendation.movies_action.add("Jason Bourne");
        MovieRecommendation.movies_action.add("The Equalizer");
        MovieRecommendation.movies_action.add("Top Gun");
        MovieRecommendation.movies_action.add("X-Men: First Class");
        MovieRecommendation.movies_action.add("The Gamers");
        MovieRecommendation.movies_action.add("Resident Evil: Afterlife");
        MovieRecommendation.movies_action.add("Deadpool");
        MovieRecommendation.movies_action.add("Guardians of the Galaxy Vol. 2");
        MovieRecommendation.movies_action.add("Avatar");
        MovieRecommendation.movies_action.add("John Wich");
        MovieRecommendation.movies_action.add("Thor: The Dark World");
        MovieRecommendation.movies_action.add("Pacific Rim");
        MovieRecommendation.movies_action.add("The Matrix");
        MovieRecommendation.movies_action.add("Jurassic World");
        MovieRecommendation.movies_action.add("The Hobbit");
        MovieRecommendation.movies_action.add("Star Wars");
        MovieRecommendation.movies_action.add("Batman");
        MovieRecommendation.movies_action.add("Spiderman");
        this.moviesTitle = MovieRecommendation.getRandomMovie(MovieRecommendation.movies_action);
    }

}
