package com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "Offence")
public class Offence {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "offence_type", nullable = false)
    private String offenceType;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private String date;

    public Offence(String offenceType, String name, String date) {
        this.offenceType = offenceType;
        this.name = name;
        this.date = date;
    }

    public Offence() {

    }

    public void setOffenceType(String offenceType) {
        this.offenceType = offenceType;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public String getOffenceType() {
        return offenceType;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
