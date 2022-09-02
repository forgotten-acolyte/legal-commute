package com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.request;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinitions;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOffenceCaseRequestModel implements Serializable {
     private static final long serialVersionUID = 1L;
    //name idNumber phone licensePlateNumber area offenceType
     private String name;
     private byte idNumber;
     private String phone;
     private String licensePlateNumber;
     private String offenceType;

     private String area;

    //     private OFFENCE_TYPE offence_type;
//
//    private enum OFFENCE_TYPE{
//                STOLEN,
//                WANTED,
//                EXPIRED_LICENSE,
//                OTHER
//    }

}

