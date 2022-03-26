package ru.sfedu.assister.lab5.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "FeedbackEntity ", schema = "localdb")
public class FeedbackEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Basic
    private String comment;

    @NonNull
    private String estimate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }


}
