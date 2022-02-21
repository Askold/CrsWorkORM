package ru.sfedu.assister.lab1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "WORKOUT", schema = "localdb")
public class WorkoutEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "feedback", nullable = true)
    private Long feedback;
    @Basic
    @Column(name = "type", nullable = true, length = 20)
    private String type;
    @Basic
    @Column(name = "client", nullable = true)
    private Long client;
    @Basic
    @Column(name = "trainer", nullable = true)
    private Long trainer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getFeedback() {
        return feedback;
    }

    public void setFeedback(Long feedback) {
        this.feedback = feedback;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Long getTrainer() {
        return trainer;
    }

    public void setTrainer(Long trainer) {
        this.trainer = trainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkoutEntity that = (WorkoutEntity) o;

        if (id != that.id) return false;
        if (feedback != null ? !feedback.equals(that.feedback) : that.feedback != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (trainer != null ? !trainer.equals(that.trainer) : that.trainer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (feedback != null ? feedback.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (trainer != null ? trainer.hashCode() : 0);
        return result;
    }
}
