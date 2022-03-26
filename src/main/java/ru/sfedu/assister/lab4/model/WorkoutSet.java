package ru.sfedu.assister.lab4.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class WorkoutSet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "exercise_set",
            joinColumns = @JoinColumn(name = "id"))
    @Column(name = "exercises")
    private Set<String> exercises =  new HashSet<>();
    private long client;

    public WorkoutSet() {
    }

    public WorkoutSet(long id, Set<String> exercises, long client) {
        this.id = id;
        this.exercises = exercises;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<String> getExercises() {
        return exercises;
    }

    public void setExercises(Set<String> exercises) {
        this.exercises = exercises;
    }

    public long getClient() {
        return client;
    }

    public void setClient(long client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutSet that = (WorkoutSet) o;
        return id == that.id && client == that.client && Objects.equals(exercises, that.exercises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exercises, client);
    }

    @Override
    public String toString() {
        return "WorkoutSet{" +
                "id=" + id +
                ", exercises=" + exercises +
                ", client=" + client +
                '}';
    }
}
