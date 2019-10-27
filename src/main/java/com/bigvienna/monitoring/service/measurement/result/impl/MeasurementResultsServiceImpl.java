package com.bigvienna.monitoring.service.measurement.result.impl;

import com.bigvienna.monitoring.model.MeasurementResults;
import com.bigvienna.monitoring.repository.MeasurementResultsRepository;
import com.bigvienna.monitoring.service.measurement.result.MeasurementResultsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("measurementResultsService")
public class MeasurementResultsServiceImpl implements MeasurementResultsService {

    private MeasurementResultsRepository measurementResultsRepository;

    @Override
    public MeasurementResults save(final MeasurementResults measurementResults) {
        return getMeasurementResultsRepository().save(measurementResults);
    }

    @Override
    public void delete(MeasurementResults measurementResults) {
        // Here we can put some logic -> e.g. check if measurement result is still active ....
        getMeasurementResultsRepository().delete(measurementResults);
    }

    @Override
    public MeasurementResults getMeasurementResultByDeviceType(final String id) {
        return getMeasurementResultsRepository().findByDeviceTypeAllIgnoringCase(id);
    }

    public MeasurementResultsRepository getMeasurementResultsRepository() {
        return measurementResultsRepository;
    }

    @Resource
    public void setMeasurementResultsRepository(MeasurementResultsRepository measurementResultsRepository) {
        this.measurementResultsRepository = measurementResultsRepository;
    }
}
