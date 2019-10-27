package com.bigvienna.monitoring.service.measurement.calculation.impl;

import com.bigvienna.monitoring.model.MeasurementResults;
import com.bigvienna.monitoring.service.measurement.calculation.MeasurementCalculationService;
import com.bigvienna.monitoring.service.measurement.dataconverter.MeasurementDataConverterService;
import com.bigvienna.monitoring.service.measurement.result.MeasurementResultsService;
import com.bigvienna.monitoring.service.mock.snmp.service.MockSnmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("measurementCalculationService")
public class MeasurementCalculationServiceImpl implements MeasurementCalculationService {

    private MockSnmpService mockSnmpService;
    private MeasurementDataConverterService measurementDataConverterService;
    private MeasurementResultsService measurementResultsService;

    @Override
    public MeasurementResults fetchRouterDataFromSNMPAndSaveToMeasurementResults() {
        final String snmpData = getMockSnmpService().getRoutersData();
        final MeasurementResults measurementResults = getMeasurementDataConverterService().convertSNMPDataToMeasurementResults(snmpData);

        saveMeasurementResults(measurementResults);

        return measurementResults;
    }

    @Override
    public MeasurementResults fetchSwitchDataFromSNMPAndSaveMeasurementResults() {
        final String snmpData = getMockSnmpService().getSwitchesData();
        final MeasurementResults measurementResults = getMeasurementDataConverterService().convertSNMPDataToMeasurementResults(snmpData);

        saveMeasurementResults(measurementResults);

        return measurementResults; // return MeasurementResults as it could be used later for logging or UI preview
    }

    @Override
    public MeasurementResults saveMeasurementResults(final MeasurementResults measurementResults) {
        getMeasurementResultsService().save(measurementResults);
        return measurementResults;
    }

    public MockSnmpService getMockSnmpService() {
        return mockSnmpService;
    }

    @Resource
    public void setMockSnmpService(MockSnmpService mockSnmpService) {
        this.mockSnmpService = mockSnmpService;
    }

    public MeasurementDataConverterService getMeasurementDataConverterService() {
        return measurementDataConverterService;
    }

    @Resource
    public void setMeasurementDataConverterService(MeasurementDataConverterService measurementDataConverterService) {
        this.measurementDataConverterService = measurementDataConverterService;
    }

    public MeasurementResultsService getMeasurementResultsService() {
        return measurementResultsService;
    }

    @Resource
    public void setMeasurementResultsService(MeasurementResultsService measurementResultsService) {
        this.measurementResultsService = measurementResultsService;
    }
}
