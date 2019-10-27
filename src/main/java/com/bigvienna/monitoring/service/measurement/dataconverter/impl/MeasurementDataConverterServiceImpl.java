package com.bigvienna.monitoring.service.measurement.dataconverter.impl;

import com.bigvienna.monitoring.model.MeasurementResults;
import com.bigvienna.monitoring.service.measurement.dataconverter.MeasurementDataConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service("measurementDataConverterService")
public class MeasurementDataConverterServiceImpl implements MeasurementDataConverterService {

    private static final String COMMA = ",";
    private static final Logger logger = LoggerFactory.getLogger(MeasurementDataConverterServiceImpl.class);

    @Override
    public MeasurementResults convertSNMPDataToMeasurementResults(String snmpData) {
        final MeasurementResults measurementResults = new MeasurementResults();

        Optional.ofNullable(snmpData).ifPresent(data -> parseMeasurementsAndReturnMeasurementResults(measurementResults, data));

        return measurementResults;
    }

    private void parseMeasurementsAndReturnMeasurementResults(final MeasurementResults measurementResults, final String snmpData) {
        // Let assume that here we have some heavy logic for parsing
        try {
            String[] snmpDataArray = snmpData.split(COMMA);

            Optional.ofNullable(snmpDataArray[0]).ifPresent(measurementResults::setDeviceType);
            Optional.ofNullable(snmpDataArray[1]).ifPresent(measurementResults::setMeasurementValue);
            Optional.ofNullable(snmpDataArray[2]).ifPresent(measurementDate -> measurementResults.setMeasurementDate(parseDateFromStringValue(measurementDate)));
            measurementResults.setMeasurementCreated(new Date());

        } catch (IllegalArgumentException e) {
            logger.error("Illegal Argument Exception occurrs: {} ", snmpData, e);
        }
    }

    private Date parseDateFromStringValue(final String dateString) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            logger.error("Parsing Exception occurs: {} ", dateString, e);
        }
        return date;
    }
}