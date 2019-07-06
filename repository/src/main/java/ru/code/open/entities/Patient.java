package ru.code.open.entities;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="patient")
public class Patient {
    public Patient () {}


    @Column(name = "patientId")
    private Long id;
    @Column(name = "patientName")
    private String name;
    @Column(name = "patientSurname")
    private String surname;
    @Column(name = "patientPatronymic")
    private String patronymic;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @OneToMany(mappedBy = "patient", cascade=CascadeType.ALL, orphanRemoval=true)
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getPatronymic() { return patronymic; }

    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    @Override
    public String toString(){
        return "Patinent{ " + "id = " + id + ", name = '" + name + '\'' + ", surname = '" + surname + '\'' + ", patronymic = '" + patronymic + '\'' + '}';
    }
}
