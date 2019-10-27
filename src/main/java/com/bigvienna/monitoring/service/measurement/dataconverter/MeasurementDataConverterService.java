package com.bigvienna.monitoring.service.measurement.dataconverter;

import com.bigvienna.monitoring.model.MeasurementResults;

/**
 * The interface Measurement results service.
 */
public interface MeasurementDataConverterService {

    /**
     * Convert snmp data to measurement results measurement results.
     *
     * @param snmpData the snmp data
     * @return the measurement results
     */
    MeasurementResults convertSNMPDataToMeasurementResults(final String snmpData);
}
