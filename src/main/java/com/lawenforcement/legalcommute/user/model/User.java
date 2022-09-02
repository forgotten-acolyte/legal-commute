package com.lawenforcement.legalcommute.user.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lawenforcement.legalcommute.composite_vehicle_offence.vehicle.model.Vehicle;
import lombok.*;

import javax.persistence.*;

@Entity(name = "user")
@Table(name = "Coordinator")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    @JsonBackReference
    private Vehicle vehicle;

}
