package com.lawenforcement.legalcommute.status.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lawenforcement.legalcommute.composite_vehicle_offence.vehicle.model.Vehicle;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "status")
@Table(name = "Status")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Status {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "status_type", nullable = false)
    private String statusType;

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Vehicle> vehicles;
}
