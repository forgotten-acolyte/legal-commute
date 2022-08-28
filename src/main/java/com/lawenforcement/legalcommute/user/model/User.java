package com.lawenforcement.legalcommute.user.model;


import com.lawenforcement.legalcommute.composite_vehicle_offence.vehicle.model.Vehicle;
import lombok.*;

import javax.persistence.*;

@Entity(name = "user")
@Table(name = "Coordinator")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    //use @MapsId to make id as PK + FK
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Vehicle vehicle;

}
