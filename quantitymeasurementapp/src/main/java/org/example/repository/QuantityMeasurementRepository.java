package repository;

import entity.QuantityMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface QuantityMeasurementRepository extends JpaRepository<QuantityMeasurementEntity, Long> {
	
}