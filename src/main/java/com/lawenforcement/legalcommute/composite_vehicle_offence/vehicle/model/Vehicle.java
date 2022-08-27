package com.lawenforcement.legalcommute.composite_vehicle_offence.vehicle.model;

import com.lawenforcement.legalcommute.composite_vehicle_offence.MappedVehicleOffence;
import com.lawenforcement.legalcommute.status.model.Status;
import com.lawenforcement.legalcommute.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "Vehicle")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle_id", nullable = false)
    private Long vehicleId;

    @Column(name = "camera_time_captured_at")
    private Timestamp cameraTimeCapturedAt;

    @Column(name = "license_plate_number")
    private String licensePlateNumber;

    @Column(name = "is_found_match")
    private byte isFoundMatch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @OneToMany(mappedBy = "vehicle",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;

    @OneToMany(mappedBy = "vehicle")
    Set<MappedVehicleOffence> vehicleOffences;
}
