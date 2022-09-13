package com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.response;

import javax.persistence.Column;

public class OffenceCaseResponseModel {

    private Integer id;

    private String offenceType;

    private String name;

    private String date;

    public OffenceCaseResponseModel(Integer id, String offenceType, String name, String date) {
        this.id = id;
        this.offenceType = offenceType;
        this.name = name;
        this.date = date;
    }

    public OffenceCaseResponseModel() {

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

    public void setId(Integer id) {
        this.id = id;
    }
}
