package com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinitions;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateOffenceCaseRequestModel {
    //name idNumber phone licensePlateNumber area offenceType
     private String name;
     private byte idNumber;
     private String phone;
     private String licensePlateNumber;

     private OFFENCE_TYPE offence_type;

     private enum OFFENCE_TYPE{
                STOLEN,
                WANTED,
                EXPIRED_LICENSE,
                OTHER
    }
}
