package ru.sfedu.assister.lab3.single_table;

import javax.persistence.*;

@Entity
@DiscriminatorValue( "TrainerSingleTable" )
public class TrainerSingleTable extends UserSingleTable{
    @Basic
    private Integer experience;
    @Basic
    private Integer rating;

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public TrainerSingleTable() {
    }

    public TrainerSingleTable(long userId, String name, String surname, Integer experience, Integer rating) {
        super(userId, name, surname);
        this.experience = experience;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainerSingleTable that = (TrainerSingleTable) o;

        if (experience != null ? !experience.equals(that.experience) : that.experience != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = experience != null ? experience.hashCode() : 0;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
