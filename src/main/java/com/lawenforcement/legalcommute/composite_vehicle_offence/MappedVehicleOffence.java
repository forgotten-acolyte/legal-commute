package com.lawenforcement.legalcommute.composite_vehicle_offence;


import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.Offence;
import com.lawenforcement.legalcommute.composite_vehicle_offence.vehicle.model.Vehicle;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Mapped_Vehicle_Offence")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class MappedVehicleOffence {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "offence_id")
    Offence offence;
}
