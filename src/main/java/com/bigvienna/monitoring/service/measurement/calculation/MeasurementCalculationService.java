package com.bigvienna.monitoring.service.measurement.calculation;

import com.bigvienna.monitoring.model.MeasurementResults;

/**
 * The interface Measurement results service.
 */
public interface MeasurementCalculationService {

    /**
     * Fetch router data from snmp and save to measurement results measurement results.
     *
     * @return the measurement results
     */
    MeasurementResults fetchRouterDataFromSNMPAndSaveToMeasurementResults();

    /**
     * Fetch switch data from snmp and save measurement results measurement results.
     *
     * @return the measurement results
     */
    MeasurementResults fetchSwitchDataFromSNMPAndSaveMeasurementResults();


    /**
     * Save measurement results measurement results.
     *
     * @param measurementResults the measurement results
     * @return the measurement results
     */
    MeasurementResults saveMeasurementResults(final MeasurementResults measurementResults);
}
