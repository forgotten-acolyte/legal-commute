package com.lawenforcement.legalcommute.composite_vehicle_offence.vehicle.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lawenforcement.legalcommute.composite_vehicle_offence.MappedVehicleOffence;
import com.lawenforcement.legalcommute.status.model.Status;
import com.lawenforcement.legalcommute.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity(name = "vehicle")
@Table(name = "Vehicle")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Vehicle {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "camera_time_captured_at")
    private Timestamp cameraTimeCapturedAt;

    @Column(name = "license_plate_number")
    private String licensePlateNumber;

    @Column(name = "is_found_match")
    private byte isFoundMatch;

    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private Status status;

    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "vehicle")
    @JsonManagedReference
    Set<MappedVehicleOffence> vehicleOffences;

}
