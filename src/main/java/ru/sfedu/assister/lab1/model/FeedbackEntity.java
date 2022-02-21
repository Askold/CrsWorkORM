package ru.sfedu.assister.lab1.model;

import javax.persistence.*;

@Entity
@Table(name = "FEEDBACK", schema = "localdb")
public class FeedbackEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "Date", nullable = true, length = 20)
    private String date;
    @Basic
    @Column(name = "Comment", nullable = true, length = 20)
    private String comment;
    @Basic
    @Column(name = "Estimate", nullable = true, length = 20)
    private String estimate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackEntity that = (FeedbackEntity) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (estimate != null ? !estimate.equals(that.estimate) : that.estimate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (estimate != null ? estimate.hashCode() : 0);
        return result;
    }
}
