package com.movie.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "movie")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 200)
    @NotNull
    @Size(min = 1, max = 200)
    private String title;

    @Column(name = "year")
    @Min(1)
    private Long year;

    @Column(length = 10000)
    @Size(min = 1, max = 10000)
    private String description;

    @Column(name = "rate")
    @Size(min = 1, max = 5)
    private Long rate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User updatingUser;

    @Column(name = "available_date")
    @Temporal(TemporalType.DATE)
    private Date availableDate;

    @Column(name = "number_of_copies")
    @Min(0)
    private Long numberOfCopies;

    @Column(name = "deleted")
    private Boolean deleted;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "movie_actor", joinColumns = {@JoinColumn(name = "movie_id")}, inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    private Set<Actor> actors = new HashSet<Actor>();

    public Movie() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public User getUpdatingUser() {
        return updatingUser;
    }

    public void setUpdatingUser(User updatingUser) {
        this.updatingUser = updatingUser;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    public Long getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Long numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", rate=" + rate +
                ", updatingUser=" + updatingUser +
                ", availableDate=" + availableDate +
                ", numberOfCopies=" + numberOfCopies +
                ", deleted=" + deleted +
                ", actors=" + actors +
                '}';
    }
}

