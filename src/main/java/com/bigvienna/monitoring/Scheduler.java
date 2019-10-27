package com.bigvienna.monitoring;

import com.bigvienna.monitoring.service.measurement.calculation.MeasurementCalculationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("scheduler")
public class Scheduler {

    private MeasurementCalculationService measurementCalculationService;

    @Scheduled(cron = "${cronjob.routerdata.trigger.expression}")
    public void callFetchRouterDataFromSNMPAndSaveToMeasurementResults() {
        getMeasurementCalculationService().fetchRouterDataFromSNMPAndSaveToMeasurementResults();
    }

    @Scheduled(cron = "${cronjob.switchdata.trigger.expression}")
    public void callFetchSwitchDataFromSNMPAndSaveMeasurementResults() {
        getMeasurementCalculationService().fetchSwitchDataFromSNMPAndSaveMeasurementResults();
    }

    public MeasurementCalculationService getMeasurementCalculationService() {
        return measurementCalculationService;
    }

    @Resource
    public void setMeasurementCalculationService(MeasurementCalculationService measurementCalculationService) {
        this.measurementCalculationService = measurementCalculationService;
    }
}