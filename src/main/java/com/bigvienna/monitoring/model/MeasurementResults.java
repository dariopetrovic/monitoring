package com.bigvienna.monitoring.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_monitoring_results")
public class MeasurementResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "device_type")
    private String deviceType;

    @Column(name = "measurement_value")
    private String measurementValue;

    @Column(name = "measurement_date")
    private Date measurementDate;

    @Column(name = "measurement_created")
    private Date measurementCreated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(String measurementValue) {
        this.measurementValue = measurementValue;
    }

    public Date getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(Date measurementDate) {
        this.measurementDate = measurementDate;
    }

    public Date getMeasurementCreated() {
        return measurementCreated;
    }

    public void setMeasurementCreated(Date measurementCreated) {
        this.measurementCreated = measurementCreated;
    }
}
