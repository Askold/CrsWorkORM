package ru.sfedu.assister.lab1.model;

import javax.persistence.*;

@Entity
@Table(name = "EXERCISE", schema = "localdb")
public class ExerciseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "name", nullable = true, length = 20)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = 20)
    private String description;
    @Basic
    @Column(name = "weight", nullable = true)
    private Integer weight;
    @Basic
    @Column(name = "repetitions", nullable = true)
    private Integer repetitions;
    @Basic
    @Column(name = "rounds", nullable = true)
    private Integer rounds;
    @Basic
    @Column(name = "workout", nullable = true)
    private Long workout;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Integer getRounds() {
        return rounds;
    }

    public void setRounds(Integer rounds) {
        this.rounds = rounds;
    }

    public Long getWorkout() {
        return workout;
    }

    public void setWorkout(Long workout) {
        this.workout = workout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExerciseEntity that = (ExerciseEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (repetitions != null ? !repetitions.equals(that.repetitions) : that.repetitions != null) return false;
        if (rounds != null ? !rounds.equals(that.rounds) : that.rounds != null) return false;
        if (workout != null ? !workout.equals(that.workout) : that.workout != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (repetitions != null ? repetitions.hashCode() : 0);
        result = 31 * result + (rounds != null ? rounds.hashCode() : 0);
        result = 31 * result + (workout != null ? workout.hashCode() : 0);
        return result;
    }
}
