package com.bigvienna.monitoring.repository;

import com.bigvienna.monitoring.model.MeasurementResults;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class MeasurementResultsRepositoryTest {

    private static final String DEVICE_TYPE = "device_type";
    private static final String VALUE = "value";

    @Autowired
    private MeasurementResultsRepository measurementResultsRepository;

    @Test
    void saveMeasurementResultsTest() {

        final MeasurementResults measurementResults = getMeasurementResults();

        final MeasurementResults savedMeasurementResult = measurementResultsRepository.save(measurementResults);

        assertEquals(DEVICE_TYPE, savedMeasurementResult.getDeviceType());
        assertEquals(VALUE, savedMeasurementResult.getMeasurementValue());
    }

    @Test
    void findByDeviceTypeAllIgnoringCaseTest() {

        measurementResultsRepository.save(getMeasurementResults());

        final MeasurementResults savedMeasurementResult = measurementResultsRepository.findByDeviceTypeAllIgnoringCase(DEVICE_TYPE);

        assertEquals(DEVICE_TYPE, savedMeasurementResult.getDeviceType());
        assertEquals(VALUE, savedMeasurementResult.getMeasurementValue());
    }

    private MeasurementResults getMeasurementResults() {

        final MeasurementResults measurementResults = new MeasurementResults();
        measurementResults.setMeasurementValue(VALUE);
        measurementResults.setDeviceType(DEVICE_TYPE);
        measurementResults.setMeasurementDate(new Date());

        return measurementResults;
    }
}