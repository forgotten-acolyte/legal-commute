package com.lawenforcement.legalcommute.status.model;

import com.lawenforcement.legalcommute.composite_vehicle_offence.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Status")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Status {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_id", nullable = false)
    private Long statusId;

    @Column(name = "status_type", nullable = false)
    private String statusType;

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;
}
