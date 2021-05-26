package com.example.demo.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lieu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nom;
    @Column
    private double longitude;
    @Column
    private double latitude;
    @OneToMany(mappedBy ="lieu", fetch = FetchType.LAZY, targetEntity = Formation.class)
    private List<Formation> formations = new ArrayList<Formation>();
    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user = new User();

    public Lieu() {
        super();
    }
    public Lieu(int id, String nom, double longitude, double latitude){
        super();
        this.id=id;
        this.nom=nom;
        this.longitude=longitude;
        this.latitude=latitude;

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
