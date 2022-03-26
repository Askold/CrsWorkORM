package ru.sfedu.assister.lab5.model;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "ExerciseEntity", schema = "localdb")
public class ExerciseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout")
    private WorkoutEntity workout;

    @NonNull
    private String name;

    @NonNull
    private Integer weight;

    @NonNull
    private Integer repetitions;

}
