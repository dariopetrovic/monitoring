package com.bigvienna.monitoring.repository;

import com.bigvienna.monitoring.model.MeasurementResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Measurement results repository.
 */
@Repository
public interface MeasurementResultsRepository extends JpaRepository<MeasurementResults, Integer> {


    /**
     * Find by device type all ignoring case measurement results.
     *
     * @param deviceType the device type
     * @return the measurement results
     */
    MeasurementResults findByDeviceTypeAllIgnoringCase(final String deviceType);
}
