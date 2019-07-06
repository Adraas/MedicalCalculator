package ru.code.open.entities;

import javax.persistence.*;

@Entity
@Table(name="pacientcondition")
public class PatientCondition {
    public PatientCondition () {}


    @Column(name = "patientId")
    private long id;
    @Column(name = "patientCondition")
    private String condition;
    @Column(name = "Description")
    private String descriprion;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ManyToOne
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCondition() { return condition;}

    public void setCondition(String condition) { this.condition = condition; }

    public String getDescriprion() { return descriprion;}

    public void setDescriprion(String descriprion) { this.descriprion = descriprion; }

    @Override
    public String toString(){
        return "PatinentCondition{ " + "id = " + id + ", condition = '" + condition + '\'' + ", description = '" + descriprion + '\'' + '}';
    }

}
