package com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model;

import com.lawenforcement.legalcommute.composite_vehicle_offence.MappedVehicleOffence;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Offence")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Offence {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "offence_type", nullable = false)
    private String offenceType;

    @OneToMany(mappedBy = "offence")
    Set<MappedVehicleOffence> vehicleOffences;
}
