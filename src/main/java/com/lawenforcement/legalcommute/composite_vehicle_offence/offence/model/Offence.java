package com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lawenforcement.legalcommute.composite_vehicle_offence.MappedVehicleOffence;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Offence")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Offence {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "offence_type", nullable = false)
    private String offenceType;

    @OneToMany(mappedBy = "offence")
    @JsonManagedReference
    Set<MappedVehicleOffence> vehicleOffences;
}
