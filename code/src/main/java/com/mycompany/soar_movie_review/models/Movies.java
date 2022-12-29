/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soar_movie_review.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mtnez
 */
@Entity
@Table(name = "movies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m"),
    @NamedQuery(name = "Movies.findByMoviesId", query = "SELECT m FROM Movies m WHERE m.moviesId = :moviesId"),
    @NamedQuery(name = "Movies.findByMoviesTitle", query = "SELECT m FROM Movies m WHERE m.moviesTitle = :moviesTitle"),
    @NamedQuery(name = "Movies.findByMoviesGenre", query = "SELECT m FROM Movies m WHERE m.moviesGenre = :moviesGenre"),
    @NamedQuery(name = "Movies.findByMoviesRating", query = "SELECT m FROM Movies m WHERE m.moviesRating = :moviesRating"),
    @NamedQuery(name = "Movies.findByMoviesYear", query = "SELECT m FROM Movies m WHERE m.moviesYear = :moviesYear"),
    @NamedQuery(name = "Movies.findByMoviesSynopsis", query = "SELECT m FROM Movies m WHERE m.moviesSynopsis = :moviesSynopsis"),
    @NamedQuery(name = "Movies.findByMoviesReview", query = "SELECT m FROM Movies m WHERE m.moviesReview = :moviesReview"),
    @NamedQuery(name = "Movies.findByMoviesTime", query = "SELECT m FROM Movies m WHERE m.moviesTime = :moviesTime"),
    @NamedQuery(name = "Movies.findByMoviesUrl", query = "SELECT m FROM Movies m WHERE m.moviesUrl = :moviesUrl")})
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MOVIES_ID")
    private Integer moviesId;
    @Size(max = 2147483647)
    @Column(name = "MOVIES_TITLE")
    private String moviesTitle;
    @Size(max = 2147483647)
    @Column(name = "MOVIES_GENRE")
    private String moviesGenre;
    @Column(name = "MOVIES_RATING")
    private Integer moviesRating;
    @Column(name = "MOVIES_YEAR")
    private Integer moviesYear;
    @Size(max = 2147483647)
    @Column(name = "MOVIES_SYNOPSIS")
    private String moviesSynopsis;
    @Size(max = 2147483647)
    @Column(name = "MOVIES_REVIEW")
    private String moviesReview;
    @Size(max = 2147483647)
    @Column(name = "MOVIES_TIME")
    private String moviesTime;
    @Size(max = 2147483647)
    @Column(name = "MOVIES_URL")
    private String moviesUrl;
    @ManyToMany(mappedBy = "moviesCollection")
    private Collection<Users> usersCollection;

    public Movies() {
    }

    public Movies(Integer moviesId) {
        this.moviesId = moviesId;
    }

    public Integer getMoviesId() {
        return moviesId;
    }

    public void setMoviesId(Integer moviesId) {
        this.moviesId = moviesId;
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

    public void setMoviesGenre(String moviesGenre) {
        this.moviesGenre = moviesGenre;
    }

    public Integer getMoviesRating() {
        return moviesRating;
    }

    public void setMoviesRating(Integer moviesRating) {
        this.moviesRating = moviesRating;
    }

    public Integer getMoviesYear() {
        return moviesYear;
    }

    public void setMoviesYear(Integer moviesYear) {
        this.moviesYear = moviesYear;
    }

    public String getMoviesSynopsis() {
        return moviesSynopsis;
    }

    public void setMoviesSynopsis(String moviesSynopsis) {
        this.moviesSynopsis = moviesSynopsis;
    }

    public String getMoviesReview() {
        return moviesReview;
    }

    public void setMoviesReview(String moviesReview) {
        this.moviesReview = moviesReview;
    }

    public String getMoviesTime() {
        return moviesTime;
    }

    public void setMoviesTime(String moviesTime) {
        this.moviesTime = moviesTime;
    }

    public String getMoviesUrl() {
        return moviesUrl;
    }

    public void setMoviesUrl(String moviesUrl) {
        this.moviesUrl = moviesUrl;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moviesId != null ? moviesId.hashCode() : 0);
        return hash;
    }

    
        @Override
    public boolean equals(Object obj) {
        if (obj instanceof Movies) {
            Movies m = (Movies) obj;
            return m.toString().equals(this.toString());
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nMovie :"
                + "\nTitle : " + moviesTitle
                + "\nGenre :" + moviesGenre
                + "\nRating :" + moviesRating
                + "\nYear :" + moviesYear
                + "\nSynopsis :" + moviesSynopsis
                + "\nReview :" + moviesReview
                + "\nTime :" + moviesTime
                + "\nUrl :" + moviesUrl;
    }
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Movies)) {
//            return false;
//        }
//        Movies other = (Movies) object;
//        if ((this.moviesId == null && other.moviesId != null) || (this.moviesId != null && !this.moviesId.equals(other.moviesId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.mycompany.soar_movie_review.models.Movies[ moviesId=" + moviesId + " ]";
//    }
//    
}
