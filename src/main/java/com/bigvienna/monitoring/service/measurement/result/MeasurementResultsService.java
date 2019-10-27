package com.bigvienna.monitoring.service.measurement.result;

import com.bigvienna.monitoring.model.MeasurementResults;

/**
 * The interface Measurement results service.
 */
public interface MeasurementResultsService {

    /**
     * Save measurement results.
     *
     * @param measurementResults the measurement results
     * @return the measurement results
     */
    MeasurementResults save(final MeasurementResults measurementResults);

    /**
     * Delete measurement results.
     *
     * @param measurementResults the measurement results
     * @return the measurement results
     */
    void delete(final MeasurementResults measurementResults);

    /**
     * Gets measurement results by id.
     *
     * @param id the id
     * @return the measurement results by id
     */
    MeasurementResults getMeasurementResultByDeviceType(final String id);
}
