package Exercises.hospitalDatabase04;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "_04_visitations")
public class Visitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_of_visit", nullable = false)
    private LocalDate dateOfVisit;

    private String comments;

    @ManyToOne
    private Patient patient;

    public Visitation() {
    }

    public Visitation(LocalDate dateOfVisit, String comments) {
        this.dateOfVisit = dateOfVisit;
        this.comments = comments;
    }

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
