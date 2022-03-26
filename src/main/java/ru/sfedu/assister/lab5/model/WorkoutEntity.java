package ru.sfedu.assister.lab5.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "WorkoutEntity", schema = "localdb")
public class WorkoutEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @OneToOne(
            fetch = FetchType.LAZY,  // ассоциация 1к1, реализованная с помощью внешнего ключа
            optional = false,
            cascade = CascadeType.ALL
    )
    @JoinColumn(unique = true)
    private FeedbackEntity feedback;

    @NonNull
    private String type;

    @OneToMany(
            mappedBy = "workout",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Set<ExerciseEntity> exercises= new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FeedbackEntity getFeedback() {
        return feedback;
    }

    public void setFeedback(FeedbackEntity feedback) {
        this.feedback = feedback;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Set<ExerciseEntity> getExercises() {
        return exercises;
    }

    public void setExercises(Set<ExerciseEntity> exercises) {
        this.exercises = exercises;
    }

}
