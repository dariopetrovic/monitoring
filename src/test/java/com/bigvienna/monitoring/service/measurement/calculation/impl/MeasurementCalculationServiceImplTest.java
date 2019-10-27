package com.bigvienna.monitoring.service.measurement.calculation.impl;

import com.bigvienna.monitoring.model.MeasurementResults;
import com.bigvienna.monitoring.service.measurement.dataconverter.MeasurementDataConverterService;
import com.bigvienna.monitoring.service.measurement.result.MeasurementResultsService;
import com.bigvienna.monitoring.service.mock.snmp.service.MockSnmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringJUnitConfig
public class MeasurementCalculationServiceImplTest {

    private static final String ROUTER_DATA = "Router Data";
    private static final String SWITCH_DATA = "Switch Data";
    private static final String MEASUREMENT_VALUE = "123156456456465465";

    @InjectMocks
    private MeasurementCalculationServiceImpl measurementCalculationService;
    @Mock
    private MockSnmpService mockSnmpService;
    @Mock
    private MeasurementDataConverterService measurementDataConverterService;
    @Mock
    private MeasurementResultsService measurementResultsService;

    @Test
    public void fetchRouterDataFromSNMPAndSaveToMeasurementResultsTest() {

        when(mockSnmpService.getRoutersData()).thenReturn(new String());
        when(measurementDataConverterService.convertSNMPDataToMeasurementResults(anyString())).thenReturn(getTestMeasurementResults(ROUTER_DATA));

        final MeasurementResults measurementResults = measurementCalculationService.fetchRouterDataFromSNMPAndSaveToMeasurementResults();

        assertEquals(ROUTER_DATA, measurementResults.getDeviceType());
        assertEquals(MEASUREMENT_VALUE, measurementResults.getMeasurementValue());
    }

    @Test
    public void fetchSwitchDataFromSNMPAndSaveMeasurementResultsTest() {

        when(mockSnmpService.getSwitchesData()).thenReturn(new String());
        when(measurementDataConverterService.convertSNMPDataToMeasurementResults(anyString())).thenReturn(getTestMeasurementResults(SWITCH_DATA));

        final MeasurementResults measurementResults = measurementCalculationService.fetchSwitchDataFromSNMPAndSaveMeasurementResults();

        assertEquals(SWITCH_DATA, measurementResults.getDeviceType());
        assertEquals(MEASUREMENT_VALUE, measurementResults.getMeasurementValue());
    }

    @Test
    public void saveMeasurementResultsTest() {

        measurementCalculationService.saveMeasurementResults(getTestMeasurementResults(ROUTER_DATA));

        verify(measurementResultsService).save(any(MeasurementResults.class));
    }

    private MeasurementResults getTestMeasurementResults(final String deviceType) {
        final MeasurementResults measurementResults = new MeasurementResults();
        measurementResults.setDeviceType(deviceType);
        measurementResults.setMeasurementValue(MEASUREMENT_VALUE);

        return measurementResults;
    }
}