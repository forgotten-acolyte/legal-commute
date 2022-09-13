package com.lawenforcement.legalcommute.composite_vehicle_offence.offence.repository;

import com.lawenforcement.legalcommute.composite_vehicle_offence.offence.model.entity.Offence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffenceRepository extends CrudRepository<Offence, Integer> {
}
