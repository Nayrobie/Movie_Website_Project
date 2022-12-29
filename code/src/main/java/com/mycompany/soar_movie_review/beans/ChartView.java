package com.mycompany.soar_movie_review.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.PieChartModel;
import javax.annotation.PostConstruct;
import org.primefaces.event.ItemSelectEvent;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import org.primefaces.model.charts.pie.PieChartDataSet;
import com.mycompany.soar_movie_review.database.MovieRecommendation;


/**
 *
 * @author mtnez
 */
@Named(value = "chartView")
@RequestScoped
public class ChartView {

    private PieChartModel pieModel1;


    @PostConstruct
    public void init() {

        createPieModels();

    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    private void createPieModels() {
        createPieModel1();
    }

   
        private void createPieModel1() {
        pieModel1 = new PieChartModel();
        
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
//        for (Movies f : Database.getInstance().getMovies()) {
//           
//        }
//        
        pieModel1.set("Drama", MovieRecommendation.movies_drama.size() );
        pieModel1.set("Comedy ", MovieRecommendation.movies_comedy.size());
        pieModel1.set("Action", MovieRecommendation.movies_action.size());


        pieModel1.setTitle("We have a balanced & diverse list of movies:");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(true);
        pieModel1.setSeriesColors("735CDD,B3C2F2,7E007B");
        pieModel1.setMouseoverHighlight(true);
 
    }  
}